/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.pdfbox.filter.ccitt;

/**
 * Constants for CCITT Fax Filter.
 */
final class CCITTFaxConstants
{
    /** A constant for group 3 1D encoding (ITU T.4). */
    final int COMPRESSION_GROUP3_1D = 0;

    /** A constant for group 3 2D encoding (ITU T.4). */
    final int COMPRESSION_GROUP3_2D = 1;

    /** A constant for group 4 2D encoding (ITU T.6). */
    final int COMPRESSION_GROUP4_2D = 2;

    //Format: First 8 bits: length of pattern, Second 8 bits: pattern

    /** The white terminating code words. */
    public static final short[] WHITE_TERMINATING = new short[] {
            0x0835, 0x0607, 0x0407, 0x0408, 0x040B, 0x040C, 0x040E, 0x040F,
            0x0513, 0x0514, 0x0507, 0x0508, 0x0608, 0x0603, 0x0634, 0x0635,
            0x062A, 0x062B, 0x0727, 0x070C, 0x0708, 0x0717, 0x0703, 0x0704,
            0x0728, 0x072B, 0x0713, 0x0724, 0x0718, 0x0802, 0x0803, 0x081A,
            0x081B, 0x0812, 0x0813, 0x0814, 0x0815, 0x0816, 0x0817, 0x0828,
            0x0829, 0x082A, 0x082B, 0x082C, 0x082D, 0x0804, 0x0805, 0x080A,
            0x080B, 0x0852, 0x0853, 0x0854, 0x0855, 0x0824, 0x0825, 0x0858,
            0x0859, 0x085A, 0x085B, 0x084A, 0x084B, 0x0832, 0x0833, 0x0834};

    /** The black terminating code words. */
    public static final short[] BLACK_TERMINATING = new short[] {
            0x0A37, 0x0302, 0x0203, 0x0202, 0x0303, 0x0403, 0x0402, 0x0503,
            0x0605, 0x0604, 0x0704, 0x0705, 0x0707, 0x0804, 0x0807, 0x0918,
            0x0A17, 0x0A18, 0x0A08, 0x0B67, 0x0B68, 0x0B6C, 0x0B37, 0x0B28,
            0x0B17, 0x0B18, 0x0CCA, 0x0CCB, 0x0CCC, 0x0CCD, 0x0C68, 0x0C69,
            0x0C6A, 0x0C6B, 0x0CD2, 0x0CD3, 0x0CD4, 0x0CD5, 0x0CD6, 0x0CD7,
            0x0C6C, 0x0C6D, 0x0CDA, 0x0CDB, 0x0C54, 0x0C55, 0x0C56, 0x0C57,
            0x0C64, 0x0C65, 0x0C52, 0x0C53, 0x0C24, 0x0C37, 0x0C38, 0x0C27,
            0x0C28, 0x0C58, 0x0C59, 0x0C2B, 0x0C2C, 0x0C5A, 0x0C66, 0x0C67};

    /** The white make-up code words. */
    public static final short[] WHITE_MAKE_UP = new short[] {
            0x051B, 0x0512, 0x0617, 0x0737, 0x0836, 0x0837, 0x0864, 0x0865,
            0x0868, 0x0867, 0x09CC, 0x09CD, 0x09D2, 0x09D3, 0x09D4, 0x09D5,
            0x09D6, 0x09D7, 0x09D8, 0x09D9, 0x09DA, 0x09DB, 0x0998, 0x0999,
            0x099A, 0x0618, 0x099B};

    /** The black make-up code words. */
    public static final short[] BLACK_MAKE_UP = new short[] {
            0x0A0F, 0x0CC8, 0x0CC9, 0x0C5B, 0x0C33, 0x0C34, 0x0C35, 0x0D6C,
            0x0D6D, 0x0D4A, 0x0D4B, 0x0D4C, 0x0D4D, 0x0D72, 0x0D73, 0x0D74,
            0x0D75, 0x0D76, 0x0D77, 0x0D52, 0x0D53, 0x0D54, 0x0D55, 0x0D5A,
            0x0D5B, 0x0D64, 0x0D65};

    /** The long make-up code words. */
    public static final short[] LONG_MAKE_UP = new short[] {
            0x0B08, 0x0B0C, 0x0B0D, 0x0C12, 0x0C13, 0x0C14, 0x0C15, 0x0C16,
            0x0C17, 0x0C1C, 0x0C1D, 0x0C1E, 0x0C1F};

    /** The EOL code word. */
    public static final short EOL_CODE = 0x0C01;
}
