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
package org.apache.pdfbox.cos;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
/**
 * The "PDFDocEncoding" encoding. Note that this is *not* a Type 1 font encoding, it is used only
 * within PDF "text strings".
 */
final class PDFDocEncoding {
    private static final char REPLACEMENT_CHARACTER = '�';

    private static final int[] CODE_TO_UNI;

    private static final Map<Character, Integer> UNI_TO_CODE;

    static {
        CODE_TO_UNI = new int[256];
        UNI_TO_CODE = new HashMap<Character, Integer>(256);
        // initialize with basically ISO-8859-1
        for (int i = 0; i < 256; i++) {
            set(i, ((char) (i)));
        }
        // then do all deviations (based on the table in ISO 32000-1:2008)
        // block 1
        set(0x18, '˘');// BREVE

        set(0x19, 'ˇ');// CARON

        set(0x1a, 'ˆ');// MODIFIER LETTER CIRCUMFLEX ACCENT

        set(0x1b, '˙');// DOT ABOVE

        set(0x1c, '˝');// DOUBLE ACUTE ACCENT

        set(0x1d, '˛');// OGONEK

        set(0x1e, '˚');// RING ABOVE

        set(0x1f, '˜');// SMALL TILDE

        // block 2
        set(0x7f, REPLACEMENT_CHARACTER);// undefined

        set(0x80, '•');// BULLET

        set(0x81, '†');// DAGGER

        set(0x82, '‡');// DOUBLE DAGGER

        set(0x83, '…');// HORIZONTAL ELLIPSIS

        set(0x84, '—');// EM DASH

        set(0x85, '–');// EN DASH

        set(0x86, 'ƒ');// LATIN SMALL LETTER SCRIPT F

        set(0x87, '⁄');// FRACTION SLASH (solidus)

        set(0x88, '‹');// SINGLE LEFT-POINTING ANGLE QUOTATION MARK

        set(0x89, '›');// SINGLE RIGHT-POINTING ANGLE QUOTATION MARK

        set(0x8a, '−');// MINUS SIGN

        set(0x8b, '‰');// PER MILLE SIGN

        set(0x8c, '„');// DOUBLE LOW-9 QUOTATION MARK (quotedblbase)

        set(0x8d, '“');// LEFT DOUBLE QUOTATION MARK (quotedblleft)

        set(0x8e, '”');// RIGHT DOUBLE QUOTATION MARK (quotedblright)

        set(0x8f, '‘');// LEFT SINGLE QUOTATION MARK (quoteleft)

        set(0x90, '’');// RIGHT SINGLE QUOTATION MARK (quoteright)

        set(0x91, '‚');// SINGLE LOW-9 QUOTATION MARK (quotesinglbase)

        set(0x92, '™');// TRADE MARK SIGN

        set(0x93, 'ﬁ');// LATIN SMALL LIGATURE FI

        set(0x94, 'ﬂ');// LATIN SMALL LIGATURE FL

        set(0x95, 'Ł');// LATIN CAPITAL LETTER L WITH STROKE

        set(0x96, 'Œ');// LATIN CAPITAL LIGATURE OE

        set(0x97, 'Š');// LATIN CAPITAL LETTER S WITH CARON

        set(0x98, 'Ÿ');// LATIN CAPITAL LETTER Y WITH DIAERESIS

        set(0x99, 'Ž');// LATIN CAPITAL LETTER Z WITH CARON

        set(0x9a, 'ı');// LATIN SMALL LETTER DOTLESS I

        set(0x9b, 'ł');// LATIN SMALL LETTER L WITH STROKE

        set(0x9c, 'œ');// LATIN SMALL LIGATURE OE

        set(0x9d, 'š');// LATIN SMALL LETTER S WITH CARON

        set(0x9e, 'ž');// LATIN SMALL LETTER Z WITH CARON

        set(0x9f, REPLACEMENT_CHARACTER);// undefined

        set(0xa0, '€');// EURO SIGN

        // end of deviations
    }

    private PDFDocEncoding() {
    }

    private static void set(int code, char unicode) {
        CODE_TO_UNI[code] = unicode;
        UNI_TO_CODE.put(unicode, code);
    }

    /**
     * Returns the string representation of the given PDFDocEncoded bytes.
     */
    public static String toString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            if ((b & 0xff) >= PDFDocEncoding.CODE_TO_UNI.length) {
                sb.append('?');
            } else {
                sb.append(((char) (CODE_TO_UNI[b & 0xff])));
            }
        }
        return sb.toString();
    }

    /**
     * Returns the given string encoded with PDFDocEncoding.
     */
    public static byte[] getBytes(String text) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (char c : text.toCharArray()) {
            Integer code = UNI_TO_CODE.get(c);
            if (code == null) {
                out.write(0);
            } else {
                out.write(code);
            }
        }
        return out.toByteArray();
    }

    /**
     * Returns true if the given character is available in PDFDocEncoding.
     *
     * @param character
     * 		UTF-16 character
     */
    public static boolean containsChar(char character) {
        return UNI_TO_CODE.containsKey(character);
    }
}