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
/**
 * This is the Mac OS Roman encoding, which is similar to the
 * MacRomanEncoding with the addition of 15 entries
 */
public class MacOSRomanEncoding extends MacRomanEncoding {
    private static final int CHAR_CODE = 0;

    private static final int CHAR_NAME = 1;

    /**
     * Table of octal character codes and their corresponding names
     * on top of {@link MacRomanEncoding}.
     */
    private static final Object[][] MAC_OS_ROMAN_ENCODING_TABLE = new Object[][]{ new Object[]{ 255, "notequal" }, new Object[]{ 260, "infinity" }, new Object[]{ 262, "lessequal" }, new Object[]{ 263, "greaterequal" }, new Object[]{ 266, "partialdiff" }, new Object[]{ 267, "summation" }, new Object[]{ 270, "product" }, new Object[]{ 271, "pi" }, new Object[]{ 272, "integral" }, new Object[]{ 275, "Omega" }, new Object[]{ 303, "radical" }, new Object[]{ 305, "approxequal" }, new Object[]{ 306, "Delta" }, new Object[]{ 327, "lozenge" }, new Object[]{ 333, "Euro" }, new Object[]{ 360, "apple" } };

    /**
     * Singleton instance of this class.
     *
     * @since Apache PDFBox 2.0.0
     */
    public static final MacOSRomanEncoding INSTANCE = new MacOSRomanEncoding();

    /**
     * Constructor.
     */
    public MacOSRomanEncoding() {
        super();
        // differences and additions to MacRomanEncoding
        for (Object[] encodingEntry : MAC_OS_ROMAN_ENCODING_TABLE) {
            add(((Integer) (encodingEntry[CHAR_CODE])), encodingEntry[CHAR_NAME].toString());
        }
    }

    /**
     * Convert this standard java object to a COS object.
     *
     * @return The cos object that matches this Java object.
     */
    public COSBase getCOSObject() {
        return null;
    }
}