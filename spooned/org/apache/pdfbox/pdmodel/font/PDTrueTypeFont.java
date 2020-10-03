/* Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.pdfbox.pdmodel.font;
import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.CmapTable;
import org.apache.fontbox.ttf.GlyphData;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TTFParser;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.encoding.BuiltInEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.pdmodel.font.encoding.MacOSRomanEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.CmapTable;
import org.apache.fontbox.ttf.GlyphData;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TTFParser;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
/**
 * TrueType font.
 *
 * @author Ben Litchfield
 */
public class PDTrueTypeFont extends PDSimpleFont implements PDVectorFont {
    private static final Log LOG = LogFactory.getLog(PDTrueTypeFont.class);

    private static final int START_RANGE_F000 = 0xf000;

    private static final int START_RANGE_F100 = 0xf100;

    private static final int START_RANGE_F200 = 0xf200;

    private static final Map<String, Integer> INVERTED_MACOS_ROMAN = new HashMap<String, Integer>();

    static {
        Map<Integer, String> codeToName = MacOSRomanEncoding.INSTANCE.getCodeToNameMap();
        for (Map.Entry<Integer, String> entry : codeToName.entrySet()) {
            if (!INVERTED_MACOS_ROMAN.containsKey(entry.getValue())) {
                INVERTED_MACOS_ROMAN.put(entry.getValue(), entry.getKey());
            }
        }
    }

    /**
     * Loads a TTF to be embedded into a document as a simple font.
     *
     * <p><b>Note:</b> Simple fonts only support 256 characters. For Unicode support, use
     * {@link PDType0Font#load(PDDocument, File)} instead.</p>
     *
     * @param doc
     * 		The PDF document that will hold the embedded font.
     * @param file
     * 		A TTF file.
     * @param encoding
     * 		The PostScript encoding vector to be used for embedding.
     * @return a PDTrueTypeFont instance.
     * @throws IOException
     * 		If there is an error loading the data.
     */
    public static PDTrueTypeFont load(PDDocument doc, File file, Encoding encoding) throws IOException {
        return new PDTrueTypeFont(doc, new FileInputStream(file), encoding);
    }

    /**
     * Loads a TTF to be embedded into a document as a simple font.
     *
     * <p><b>Note:</b> Simple fonts only support 256 characters. For Unicode support, use
     * {@link PDType0Font#load(PDDocument, InputStream)} instead.</p>
     *
     * @param doc
     * 		The PDF document that will hold the embedded font.
     * @param input
     * 		A TTF file stream
     * @param encoding
     * 		The PostScript encoding vector to be used for embedding.
     * @return a PDTrueTypeFont instance.
     * @throws IOException
     * 		If there is an error loading the data.
     */
    public static PDTrueTypeFont load(PDDocument doc, InputStream input, Encoding encoding) throws IOException {
        return new PDTrueTypeFont(doc, input, encoding);
    }

    /**
     * Loads a TTF to be embedded into a document as a simple font. Only supports WinAnsiEncoding.
     *
     * @param doc
     * 		The PDF document that will hold the embedded font.
     * @param file
     * 		A TTF file.
     * @return a PDTrueTypeFont instance.
     * @throws IOException
     * 		If there is an error loading the data.
     * @deprecated Use {@link PDType0Font#load(PDDocument, File)} instead.
     */
    @Deprecated
    public static PDTrueTypeFont loadTTF(PDDocument doc, File file) throws IOException {
        return new PDTrueTypeFont(doc, new FileInputStream(file), WinAnsiEncoding.INSTANCE);
    }

    /**
     * Loads a TTF to be embedded into a document as a simple font. Only supports WinAnsiEncoding.
     *
     * @param doc
     * 		The PDF document that will hold the embedded font.
     * @param input
     * 		A TTF file stream
     * @return a PDTrueTypeFont instance.
     * @throws IOException
     * 		If there is an error loading the data.
     * @deprecated Use {@link PDType0Font#load(PDDocument, InputStream)} instead.
     */
    @Deprecated
    public static PDTrueTypeFont loadTTF(PDDocument doc, InputStream input) throws IOException {
        return new PDTrueTypeFont(doc, input, WinAnsiEncoding.INSTANCE);
    }

    private CmapSubtable cmapWinUnicode = null;

    private CmapSubtable cmapWinSymbol = null;

    private CmapSubtable cmapMacRoman = null;

    private boolean cmapInitialized = false;

    private Map<Integer, Integer> gidToCode;// for embedding


    private final TrueTypeFont ttf;

    private final boolean isEmbedded;

    private final boolean isDamaged;

    /**
     * Creates a new TrueType font from a Font dictionary.
     *
     * @param fontDictionary
     * 		The font dictionary according to the PDF specification.
     */
    public PDTrueTypeFont(COSDictionary fontDictionary) throws IOException {
        super(fontDictionary);
        TrueTypeFont ttfFont = null;
        boolean fontIsDamaged = false;
        if (getFontDescriptor() != null) {
            PDFontDescriptor fd = super.getFontDescriptor();
            PDStream ff2Stream = fd.getFontFile2();
            if (ff2Stream != null) {
                try {
                    // embedded
                    TTFParser ttfParser = new TTFParser(true);
                    ttfFont = ttfParser.parse(ff2Stream.createInputStream());
                }// TTF parser is buggy
                 catch (NullPointerException e) {
                    LOG.warn("Could not read embedded TTF for font " + getBaseFont(), e);
                    fontIsDamaged = true;
                } catch (IOException e) {
                    LOG.warn("Could not read embedded TTF for font " + getBaseFont(), e);
                    fontIsDamaged = true;
                }
            }
        }
        isEmbedded = ttfFont != null;
        isDamaged = fontIsDamaged;
        // substitute
        if (ttfFont == null) {
            FontMapping<TrueTypeFont> mapping = FontMapper.getTrueTypeFont(getBaseFont(), getFontDescriptor());
            ttfFont = mapping.getFont();
            if (mapping.isFallback()) {
                LOG.warn(((("Using fallback font '" + ttfFont) + "' for '") + getBaseFont()) + "'");
            }
        }
        ttf = ttfFont;
        readEncoding();
    }

    /**
     * Returns the PostScript name of the font.
     */
    public final String getBaseFont() {
        return dict.getNameAsString(COSName.BASE_FONT);
    }

    @Override
    protected Encoding readEncodingFromFont() throws IOException {
        if (getStandard14AFM() != null) {
            // read from AFM
            return new Type1Encoding(getStandard14AFM());
        } else {
            // non-symbolic fonts don't have a built-in encoding per se, but there encoding is
            // assumed to be StandardEncoding by the PDF spec unless an explicit Encoding is present
            // which will override this anyway
            if ((getSymbolicFlag() != null) && (!getSymbolicFlag())) {
                return StandardEncoding.INSTANCE;
            }
            // normalise the standard 14 name, e.g "Symbol,Italic" -> "Symbol"
            String standard14Name = Standard14Fonts.getMappedFontName(getName());
            // likewise, if the font is standard 14 then we know it's Standard Encoding
            if ((isStandard14() && (!standard14Name.equals("Symbol"))) && (!standard14Name.equals("ZapfDingbats"))) {
                return StandardEncoding.INSTANCE;
            }
            // synthesize an encoding, so that getEncoding() is always usable
            PostScriptTable post = ttf.getPostScript();
            Map<Integer, String> codeToName = new HashMap<Integer, String>();
            for (int code = 0; code <= 256; code++) {
                int gid = codeToGID(code);
                if (gid > 0) {
                    String name = null;
                    if (post != null) {
                        name = post.getName(gid);
                    }
                    if (name == null) {
                        // GID pseudo-name
                        name = Integer.toString(gid);
                    }
                    codeToName.put(code, name);
                }
            }
            return new BuiltInEncoding(codeToName);
        }
    }

    /**
     * Creates a new TrueType font for embedding.
     */
    private PDTrueTypeFont(PDDocument document, InputStream ttfStream, Encoding encoding) throws IOException {
        PDTrueTypeFontEmbedder embedder = new PDTrueTypeFontEmbedder(document, dict, ttfStream, encoding);
        this.encoding = encoding;
        ttf = embedder.getTrueTypeFont();
        setFontDescriptor(embedder.getFontDescriptor());
        isEmbedded = true;
        isDamaged = false;
        glyphList = GlyphList.getAdobeGlyphList();
    }

    @Override
    public int readCode(InputStream in) throws IOException {
        return in.read();
    }

    @Override
    public String getName() {
        return getBaseFont();
    }

    @Override
    public BoundingBox getBoundingBox() throws IOException {
        return ttf.getFontBBox();
    }

    @Override
    public boolean isDamaged() {
        return isDamaged;
    }

    /**
     * Returns the embedded or substituted TrueType font.
     */
    public TrueTypeFont getTrueTypeFont() {
        return ttf;
    }

    @Override
    public float getWidthFromFont(int code) throws IOException {
        int gid = codeToGID(code);
        float width = ttf.getAdvanceWidth(gid);
        float unitsPerEM = ttf.getUnitsPerEm();
        if (unitsPerEM != 1000) {
            width *= 1000.0F / unitsPerEM;
        }
        return width;
    }

    @Override
    public float getHeight(int code) throws IOException {
        int gid = codeToGID(code);
        GlyphData glyph = ttf.getGlyph().getGlyph(gid);
        if (glyph != null) {
            return glyph.getBoundingBox().getHeight();
        }
        return 0;
    }

    @Override
    protected byte[] encode(int unicode) throws IOException {
        if (getEncoding() != null) {
            if (!getEncoding().contains(getGlyphList().codePointToName(unicode))) {
                throw new IllegalArgumentException(String.format("U+%04X is not available in this font's Encoding", unicode));
            }
            String name = getGlyphList().codePointToName(unicode);
            Map<String, Integer> inverted = getInvertedEncoding();
            if (!ttf.hasGlyph(name)) {
                // try unicode name
                String uniName = getUniNameOfCodePoint(unicode);
                if (!ttf.hasGlyph(uniName)) {
                    throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", unicode, getName()));
                }
            }
            int code = inverted.get(name);
            return new byte[]{ ((byte) (code)) };
        } else {
            // use TTF font's built-in encoding
            String name = getGlyphList().codePointToName(unicode);
            if (!ttf.hasGlyph(name)) {
                throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", unicode, getName()));
            }
            int gid = ttf.nameToGID(name);
            Integer code = getGIDToCode().get(gid);
            if (code == null) {
                throw new IllegalArgumentException(String.format("U+%04X is not available in this font's Encoding", unicode));
            }
            return new byte[]{ ((byte) ((int) (code))) };
        }
    }

    /**
     * Inverts the font's code -> GID mapping. Any duplicate (GID -> code) mappings will be lost.
     */
    protected Map<Integer, Integer> getGIDToCode() throws IOException {
        if (gidToCode != null) {
            return gidToCode;
        }
        gidToCode = new HashMap<Integer, Integer>();
        for (int code = 0; code <= 255; code++) {
            int gid = codeToGID(code);
            if (!gidToCode.containsKey(gid)) {
                gidToCode.put(gid, code);
            }
        }
        return gidToCode;
    }

    @Override
    public boolean isEmbedded() {
        return isEmbedded;
    }

    @Override
    public GeneralPath getPath(int code) throws IOException {
        int gid = codeToGID(code);
        GlyphData glyph = ttf.getGlyph().getGlyph(gid);
        // some glyphs have no outlines (e.g. space, table, newline)
        if (glyph == null) {
            return new GeneralPath();
        } else {
            return glyph.getPath();
        }
    }

    @Override
    public GeneralPath getPath(String name) throws IOException {
        // handle glyph names and uniXXXX names
        int gid = ttf.nameToGID(name);
        if (gid == 0) {
            try {
                // handle GID pseudo-names
                gid = Integer.parseInt(name);
                if (gid > ttf.getNumberOfGlyphs()) {
                    gid = 0;
                }
            } catch (NumberFormatException e) {
                gid = 0;
            }
        }
        // I'm assuming .notdef paths are not drawn, as it PDFBOX-2421
        if (gid == 0) {
            return new GeneralPath();
        }
        GlyphData glyph = ttf.getGlyph().getGlyph(gid);
        if (glyph != null) {
            return glyph.getPath();
        } else {
            return new GeneralPath();
        }
    }

    @Override
    public boolean hasGlyph(String name) throws IOException {
        int gid = ttf.nameToGID(name);
        return gid != 0;
    }

    @Override
    public FontBoxFont getFontBoxFont() {
        return ttf;
    }

    @Override
    public boolean hasGlyph(int code) throws IOException {
        return codeToGID(code) != 0;
    }

    /**
     * Returns the GID for the given character code.
     *
     * @param code
     * 		character code
     * @return GID (glyph index)
     */
    public int codeToGID(int code) throws IOException {
        extractCmapTable();
        int gid = 0;
        // non-symbolic
        if (!isSymbolic()) {
            String name = encoding.getName(code);
            if (name.equals(".notdef")) {
                return 0;
            } else {
                // (3, 1) - (Windows, Unicode)
                if (cmapWinUnicode != null) {
                    String unicode = GlyphList.getAdobeGlyphList().toUnicode(name);
                    if (unicode != null) {
                        int uni = unicode.codePointAt(0);
                        gid = cmapWinUnicode.getGlyphId(uni);
                    }
                }
                // (1, 0) - (Macintosh, Roman)
                if ((gid == 0) && (cmapMacRoman != null)) {
                    Integer macCode = INVERTED_MACOS_ROMAN.get(name);
                    if (macCode != null) {
                        gid = cmapMacRoman.getGlyphId(macCode);
                    }
                }
                // 'post' table
                if (gid == 0) {
                    gid = ttf.nameToGID(name);
                }
            }
        } else // symbolic
        {
            // (3, 0) - (Windows, Symbol)
            if (cmapWinSymbol != null) {
                gid = cmapWinSymbol.getGlyphId(code);
                if ((code >= 0) && (code <= 0xff)) {
                    // the CMap may use one of the following code ranges,
                    // so that we have to add the high byte to get the
                    // mapped value
                    if (gid == 0) {
                        // F000 - F0FF
                        gid = cmapWinSymbol.getGlyphId(code + START_RANGE_F000);
                    }
                    if (gid == 0) {
                        // F100 - F1FF
                        gid = cmapWinSymbol.getGlyphId(code + START_RANGE_F100);
                    }
                    if (gid == 0) {
                        // F200 - F2FF
                        gid = cmapWinSymbol.getGlyphId(code + START_RANGE_F200);
                    }
                }
            }
            // (1, 0) - (Mac, Roman)
            if ((gid == 0) && (cmapMacRoman != null)) {
                gid = cmapMacRoman.getGlyphId(code);
            }
        }
        return gid;
    }

    /**
     * extract all useful "cmap" subtables.
     */
    private void extractCmapTable() throws IOException {
        if (cmapInitialized) {
            return;
        }
        CmapTable cmapTable = ttf.getCmap();
        if (cmapTable != null) {
            // get all relevant "cmap" subtables
            CmapSubtable[] cmaps = cmapTable.getCmaps();
            for (CmapSubtable cmap : cmaps) {
                if (CmapTable.PLATFORM_WINDOWS == cmap.getPlatformId()) {
                    if (CmapTable.ENCODING_WIN_UNICODE_BMP == cmap.getPlatformEncodingId()) {
                        cmapWinUnicode = cmap;
                    } else if (CmapTable.ENCODING_WIN_SYMBOL == cmap.getPlatformEncodingId()) {
                        cmapWinSymbol = cmap;
                    }
                } else if ((CmapTable.PLATFORM_MACINTOSH == cmap.getPlatformId()) && (CmapTable.ENCODING_MAC_ROMAN == cmap.getPlatformEncodingId())) {
                    cmapMacRoman = cmap;
                }
            }
        }
        cmapInitialized = true;
    }
}