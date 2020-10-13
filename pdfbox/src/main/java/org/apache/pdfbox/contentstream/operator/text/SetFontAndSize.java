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

package org.apache.pdfbox.contentstream.operator.text;

import java.util.List;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.font.PDFont;

/**
 * Tf: Set text font and size.
 *
 * @author Laurent Huault
 */
public class SetFontAndSize extends OperatorProcessor
{
    @Override
    public void process(Operator operator, List<COSBase> arguments) throws IOException
    {
        // there are some documents that are incorrectly structured and
        // arguments are in the wrong spot, so we will silently ignore them
        // if there are no arguments
        if(arguments.size() >= 2)
        {
            // set font and size
            COSName fontName = (COSName)arguments.get(0);
            float fontSize = ((COSNumber)arguments.get(1)).floatValue();
            context.getGraphicsState().getTextState().setFontSize(fontSize);
            PDFont font = context.getResources().getFont(fontName);
            context.getGraphicsState().getTextState().setFont(font);
        }
    }

    @Override
    public String getName()
    {
        return "Tf";
    }
}
