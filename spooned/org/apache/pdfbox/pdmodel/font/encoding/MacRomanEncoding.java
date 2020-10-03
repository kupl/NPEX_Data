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
package org.apache.pdfbox.pdmodel.font.encoding;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
/**
 * This is an interface to a text encoder.
 *
 * @author Ben Litchfield
 */
public class MacRomanEncoding extends Encoding {
    private static final int CHAR_CODE = 0;

    private static final int CHAR_NAME = 1;

    /**
     * Table of octal character codes and their corresponding names.
     */
    private static final Object[][] MAC_ROMAN_ENCODING_TABLE = new Object[][]{ new Object[]{ 0101, "A" }, new Object[]{ 0256, "AE" }, new Object[]{ 0347, "Aacute" }, new Object[]{ 0345, "Acircumflex" }, new Object[]{ 0200, "Adieresis" }, new Object[]{ 0313, "Agrave" }, new Object[]{ 0201, "Aring" }, new Object[]{ 0314, "Atilde" }, new Object[]{ 0102, "B" }, new Object[]{ 0103, "C" }, new Object[]{ 0202, "Ccedilla" }, new Object[]{ 0104, "D" }, new Object[]{ 0105, "E" }, new Object[]{ 0203, "Eacute" }, new Object[]{ 0346, "Ecircumflex" }, new Object[]{ 0350, "Edieresis" }, new Object[]{ 0351, "Egrave" }, new Object[]{ 0106, "F" }, new Object[]{ 0107, "G" }, new Object[]{ 0110, "H" }, new Object[]{ 0111, "I" }, new Object[]{ 0352, "Iacute" }, new Object[]{ 0353, "Icircumflex" }, new Object[]{ 0354, "Idieresis" }, new Object[]{ 0355, "Igrave" }, new Object[]{ 0112, "J" }, new Object[]{ 0113, "K" }, new Object[]{ 0114, "L" }, new Object[]{ 0115, "M" }, new Object[]{ 0116, "N" }, new Object[]{ 0204, "Ntilde" }, new Object[]{ 0117, "O" }, new Object[]{ 0316, "OE" }, new Object[]{ 0356, "Oacute" }, new Object[]{ 0357, "Ocircumflex" }, new Object[]{ 0205, "Odieresis" }, new Object[]{ 0361, "Ograve" }, new Object[]{ 0257, "Oslash" }, new Object[]{ 0315, "Otilde" }, new Object[]{ 0120, "P" }, new Object[]{ 0121, "Q" }, new Object[]{ 0122, "R" }, new Object[]{ 0123, "S" }, new Object[]{ 0124, "T" }, new Object[]{ 0125, "U" }, new Object[]{ 0362, "Uacute" }, new Object[]{ 0363, "Ucircumflex" }, new Object[]{ 0206, "Udieresis" }, new Object[]{ 0364, "Ugrave" }, new Object[]{ 0126, "V" }, new Object[]{ 0127, "W" }, new Object[]{ 0130, "X" }, new Object[]{ 0131, "Y" }, new Object[]{ 0331, "Ydieresis" }, new Object[]{ 0132, "Z" }, new Object[]{ 0141, "a" }, new Object[]{ 0207, "aacute" }, new Object[]{ 0211, "acircumflex" }, new Object[]{ 0253, "acute" }, new Object[]{ 0212, "adieresis" }, new Object[]{ 0276, "ae" }, new Object[]{ 0210, "agrave" }, new Object[]{ 046, "ampersand" }, new Object[]{ 0214, "aring" }, new Object[]{ 0136, "asciicircum" }, new Object[]{ 0176, "asciitilde" }, new Object[]{ 052, "asterisk" }, new Object[]{ 0100, "at" }, new Object[]{ 0213, "atilde" }, new Object[]{ 0142, "b" }, new Object[]{ 0134, "backslash" }, new Object[]{ 0174, "bar" }, new Object[]{ 0173, "braceleft" }, new Object[]{ 0175, "braceright" }, new Object[]{ 0133, "bracketleft" }, new Object[]{ 0135, "bracketright" }, new Object[]{ 0371, "breve" }, new Object[]{ 0245, "bullet" }, new Object[]{ 0143, "c" }, new Object[]{ 0377, "caron" }, new Object[]{ 0215, "ccedilla" }, new Object[]{ 0374, "cedilla" }, new Object[]{ 0242, "cent" }, new Object[]{ 0366, "circumflex" }, new Object[]{ 072, "colon" }, new Object[]{ 054, "comma" }, new Object[]{ 0251, "copyright" }, new Object[]{ 0333, "currency" }, new Object[]{ 0144, "d" }, new Object[]{ 0240, "dagger" }, new Object[]{ 0340, "daggerdbl" }, new Object[]{ 0241, "degree" }, new Object[]{ 0254, "dieresis" }, new Object[]{ 0326, "divide" }, new Object[]{ 044, "dollar" }, new Object[]{ 0372, "dotaccent" }, new Object[]{ 0365, "dotlessi" }, new Object[]{ 0145, "e" }, new Object[]{ 0216, "eacute" }, new Object[]{ 0220, "ecircumflex" }, new Object[]{ 0221, "edieresis" }, new Object[]{ 0217, "egrave" }, new Object[]{ 070, "eight" }, new Object[]{ 0311, "ellipsis" }, new Object[]{ 0321, "emdash" }, new Object[]{ 0320, "endash" }, new Object[]{ 075, "equal" }, new Object[]{ 041, "exclam" }, new Object[]{ 0301, "exclamdown" }, new Object[]{ 0146, "f" }, new Object[]{ 0336, "fi" }, new Object[]{ 065, "five" }, new Object[]{ 0337, "fl" }, new Object[]{ 0304, "florin" }, new Object[]{ 064, "four" }, new Object[]{ 0332, "fraction" }, new Object[]{ 0147, "g" }, new Object[]{ 0247, "germandbls" }, new Object[]{ 0140, "grave" }, new Object[]{ 076, "greater" }, new Object[]{ 0307, "guillemotleft" }, new Object[]{ 0310, "guillemotright" }, new Object[]{ 0334, "guilsinglleft" }, new Object[]{ 0335, "guilsinglright" }, new Object[]{ 0150, "h" }, new Object[]{ 0375, "hungarumlaut" }, new Object[]{ 055, "hyphen" }, new Object[]{ 0151, "i" }, new Object[]{ 0222, "iacute" }, new Object[]{ 0224, "icircumflex" }, new Object[]{ 0225, "idieresis" }, new Object[]{ 0223, "igrave" }, new Object[]{ 0152, "j" }, new Object[]{ 0153, "k" }, new Object[]{ 0154, "l" }, new Object[]{ 074, "less" }, new Object[]{ 0302, "logicalnot" }, new Object[]{ 0155, "m" }, new Object[]{ 0370, "macron" }, new Object[]{ 0265, "mu" }, new Object[]{ 0156, "n" }, new Object[]{ 071, "nine" }, new Object[]{ 0226, "ntilde" }, new Object[]{ 043, "numbersign" }, new Object[]{ 0157, "o" }, new Object[]{ 0227, "oacute" }, new Object[]{ 0231, "ocircumflex" }, new Object[]{ 0232, "odieresis" }, new Object[]{ 0317, "oe" }, new Object[]{ 0376, "ogonek" }, new Object[]{ 0230, "ograve" }, new Object[]{ 061, "one" }, new Object[]{ 0273, "ordfeminine" }, new Object[]{ 0274, "ordmasculine" }, new Object[]{ 0277, "oslash" }, new Object[]{ 0233, "otilde" }, new Object[]{ 0160, "p" }, new Object[]{ 0246, "paragraph" }, new Object[]{ 050, "parenleft" }, new Object[]{ 051, "parenright" }, new Object[]{ 045, "percent" }, new Object[]{ 056, "period" }, new Object[]{ 0341, "periodcentered" }, new Object[]{ 0344, "perthousand" }, new Object[]{ 053, "plus" }, new Object[]{ 0261, "plusminus" }, new Object[]{ 0161, "q" }, new Object[]{ 077, "question" }, new Object[]{ 0300, "questiondown" }, new Object[]{ 042, "quotedbl" }, new Object[]{ 0343, "quotedblbase" }, new Object[]{ 0322, "quotedblleft" }, new Object[]{ 0323, "quotedblright" }, new Object[]{ 0324, "quoteleft" }, new Object[]{ 0325, "quoteright" }, new Object[]{ 0342, "quotesinglbase" }, new Object[]{ 047, "quotesingle" }, new Object[]{ 0162, "r" }, new Object[]{ 0250, "registered" }, new Object[]{ 0373, "ring" }, new Object[]{ 0163, "s" }, new Object[]{ 0244, "section" }, new Object[]{ 073, "semicolon" }, new Object[]{ 067, "seven" }, new Object[]{ 066, "six" }, new Object[]{ 057, "slash" }, new Object[]{ 040, "space" }, new Object[]{ 0243, "sterling" }, new Object[]{ 0164, "t" }, new Object[]{ 063, "three" }, new Object[]{ 0367, "tilde" }, new Object[]{ 0252, "trademark" }, new Object[]{ 062, "two" }, new Object[]{ 0165, "u" }, new Object[]{ 0234, "uacute" }, new Object[]{ 0236, "ucircumflex" }, new Object[]{ 0237, "udieresis" }, new Object[]{ 0235, "ugrave" }, new Object[]{ 0137, "underscore" }, new Object[]{ 0166, "v" }, new Object[]{ 0167, "w" }, new Object[]{ 0170, "x" }, new Object[]{ 0171, "y" }, new Object[]{ 0330, "ydieresis" }, new Object[]{ 0264, "yen" }, new Object[]{ 0172, "z" }, new Object[]{ 060, "zero" }, // adding an additional mapping as defined in Appendix D of the pdf spec
    new Object[]{ 0312, "space" } };

    /**
     * Singleton instance of this class.
     *
     * @since Apache PDFBox 1.3.0
     */
    public static final MacRomanEncoding INSTANCE = new MacRomanEncoding();

    /**
     * Constructor.
     */
    public MacRomanEncoding() {
        for (Object[] encodingEntry : MAC_ROMAN_ENCODING_TABLE) {
            add(((Integer) (encodingEntry[CHAR_CODE])), encodingEntry[CHAR_NAME].toString());
        }
    }

    /**
     * Convert this standard java object to a COS object.
     *
     * @return The cos object that matches this Java object.
     */
    public COSBase getCOSObject() {
        return COSName.MAC_ROMAN_ENCODING;
    }
}