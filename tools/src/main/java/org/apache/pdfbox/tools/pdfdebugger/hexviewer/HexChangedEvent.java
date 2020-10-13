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

package org.apache.pdfbox.tools.pdfdebugger.hexviewer;

/**
 * @author Khyrul Bashar
 *
 * This the event class for byte value changed from the Hex pane.
 */
class HexChangedEvent
{
    private final byte newValue;
    private final int byteIndex;

    /**
     * Constructor.
     * @param newValue byte. The new byte value for the index.
     * @param byteIndex int. Index for the changed byte.
     */
    HexChangedEvent(byte newValue, int byteIndex)
    {
        this.newValue = newValue;
        this.byteIndex = byteIndex;
    }

    public byte getNewValue()
    {
        return newValue;
    }

    public int getByteIndex()
    {
        return byteIndex;
    }
}
