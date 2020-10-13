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
package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.contentstream.operator.Operator;

/**
 * A default appearance string contains any graphics state or text state operators needed to
 * establish the graphics state parameters, such as text size and colour, for displaying the field's
 * variable text. Only operators that are allowed within text objects shall occur in this string.
 *
 * @author Stephan Gerhard
 * @author Ben Litchfield
 */
public final class PDAppearanceString
{

    private static final Log LOG = LogFactory.getLog(PDAppearanceString.class);

    private final PDVariableText parent;

    private String value;
    private final COSString defaultAppearance;

    private final PDAcroForm acroForm;
    private List<COSObjectable> widgets = new ArrayList<COSObjectable>();

    /**
     * Constructs a COSAppearance from the given field.
     *
     * @param theAcroForm the AcroForm that this field is part of.
     * @param field the field which you wish to control the appearance of
     */
    public PDAppearanceString(PDAcroForm theAcroForm, PDVariableText field)
    {
        acroForm = theAcroForm;
        parent = field;

        widgets = field.getKids();
        if (widgets == null)
        {
            widgets = new ArrayList<COSObjectable>();
            widgets.add(field.getWidget());
        }
        defaultAppearance = getDefaultAppearance();
    }

    /**
     * Returns the default appearance of a textbox. If the textbox does not have one,
     * then it will be taken from the AcroForm.
     * 
     * @return The DA element
     */
    private COSString getDefaultAppearance()
    {
        COSString dap = parent.getDefaultAppearance();
        if (dap == null)
        {
            COSArray kids = (COSArray) parent.getDictionary().getDictionaryObject(COSName.KIDS);
            if (kids != null && kids.size() > 0)
            {
                COSDictionary firstKid = (COSDictionary) kids.getObject(0);
                dap = (COSString) firstKid.getDictionaryObject(COSName.DA);
            }
            if (dap == null)
            {
                dap = (COSString) acroForm.getDictionary().getDictionaryObject(COSName.DA);
            }
        }
        return dap;
    }

    private int getQ()
    {
        int q = parent.getQ();
        if (parent.getDictionary().getDictionaryObject(COSName.Q) == null)
        {
            COSArray kids = (COSArray) parent.getDictionary().getDictionaryObject(COSName.KIDS);
            if (kids != null && kids.size() > 0)
            {
                COSDictionary firstKid = (COSDictionary) kids.getObject(0);
                COSNumber qNum = (COSNumber) firstKid.getDictionaryObject(COSName.Q);
                if (qNum != null)
                {
                    q = qNum.intValue();
                }
            }
        }
        return q;
    }

    /**
     * Extracts the original appearance stream into a list of tokens.
     *
     * @return The tokens in the original appearance stream
     */
    private List<Object> getStreamTokens(PDAppearanceStream appearanceStream) throws IOException
    {
        List<Object> tokens = new ArrayList<Object>();
        if (appearanceStream != null)
        {
            tokens = getStreamTokens(appearanceStream.getCOSStream());
        }
        return tokens;
    }

    private List<Object> getStreamTokens(COSString string) throws IOException
    {
        List<Object> tokens = new ArrayList<Object>();
        if (string != null)
        {
            ByteArrayInputStream stream = new ByteArrayInputStream(string.getBytes());
            PDFStreamParser parser = new PDFStreamParser(stream);
            parser.parse();
            tokens = parser.getTokens();
        }
        return tokens;
    }

    private List<Object> getStreamTokens(COSStream stream) throws IOException
    {
        List<Object> tokens = new ArrayList<Object>();
        if (stream != null)
        {
            PDFStreamParser parser = new PDFStreamParser(stream);
            parser.parse();
            tokens = parser.getTokens();
        }
        return tokens;
    }

    /**
     * Tests if the appearance stream already contains content.
     * 
     * @param streamTokens individual tokens within the appearance stream
     *
     * @return true if it contains any content
     */
    private boolean containsMarkedContent(List<Object> streamTokens)
    {
        return streamTokens.contains(Operator.getOperator("BMC"));
    }

    /**
     * This is the public method for setting the appearance stream.
     *
     * @param apValue the String value which the appearance should represent
     *
     * @throws IOException If there is an error creating the stream.
     */
    public void setAppearanceValue(String apValue) throws IOException
    {
        value = apValue;
        Iterator<COSObjectable> widgetIter = widgets.iterator();
        while (widgetIter.hasNext())
        {
            COSObjectable next = widgetIter.next();
            PDField field = null;
            PDAnnotationWidget widget;
            if (next instanceof PDField)
            {
                field = (PDField) next;
                widget = field.getWidget();
            }
            else
            {
                widget = (PDAnnotationWidget) next;
            }
            PDFormFieldAdditionalActions actions = null;
            if (field != null)
            {
                actions = field.getActions();
            }
            if (actions != null && actions.getF() != null
                    && widget.getDictionary().getDictionaryObject(COSName.AP) == null)
            {
                // do nothing because the field will be formatted by acrobat
                // when it is opened. See FreedomExpressions.pdf for an example of this.
            }
            else
            {
                PDAppearanceDictionary appearance = widget.getAppearance();
                if (appearance == null)
                {
                    appearance = new PDAppearanceDictionary();
                    widget.setAppearance(appearance);
                }

                PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
                // TODO support more than one appearance stream
                PDAppearanceStream appearanceStream = 
                        normalAppearance.isStream() ? normalAppearance.getAppearanceStream() : null;
                if (appearanceStream == null)
                {
                    COSStream cosStream = acroForm.getDocument().getDocument().createCOSStream();
                    appearanceStream = new PDAppearanceStream(cosStream);
                    appearanceStream.setBBox(widget.getRectangle()
                            .createRetranslatedRectangle());
                    appearance.setNormalAppearance(appearanceStream);
                }

                List<Object> tokens = getStreamTokens(appearanceStream);
                List<Object> daTokens = getStreamTokens(getDefaultAppearance());
                PDFont pdFont = getFontAndUpdateResources(tokens, appearanceStream);

                if (!containsMarkedContent(tokens))
                {
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    // BJL 9/25/2004 Must prepend existing stream
                    // because it might have operators to draw things like
                    // rectangles and such
                    ContentStreamWriter writer = new ContentStreamWriter(output);
                    writer.writeTokens(tokens);
                    output.write(" /Tx BMC\n".getBytes("ISO-8859-1"));
                    insertGeneratedAppearance(widget, output, pdFont, tokens, appearanceStream);
                    output.write(" EMC".getBytes("ISO-8859-1"));
                    writeToStream(output.toByteArray(), appearanceStream);
                }
                else
                {
                    if (tokens != null)
                    {
                        if (daTokens != null)
                        {
                            int bmcIndex = tokens.indexOf(Operator.getOperator("BMC"));
                            int emcIndex = tokens.indexOf(Operator.getOperator("EMC"));
                            if (bmcIndex != -1 && emcIndex != -1 && emcIndex == bmcIndex + 1)
                            {
                                // if the EMC immediately follows the BMC index then should
                                // insert the daTokens inbetween the two markers.
                                tokens.addAll(emcIndex, daTokens);
                            }
                        }
                        ByteArrayOutputStream output = new ByteArrayOutputStream();
                        ContentStreamWriter writer = new ContentStreamWriter(output);
                        float fontSize = calculateFontSize(pdFont,
                                appearanceStream.getBBox(), tokens, daTokens);
                        int setFontIndex = tokens.indexOf(Operator.getOperator("Tf"));
                        tokens.set(setFontIndex - 1, new COSFloat(fontSize));

                        int bmcIndex = tokens.indexOf(Operator.getOperator("BMC"));
                        int emcIndex = tokens.indexOf(Operator.getOperator("EMC"));

                        if (bmcIndex != -1)
                        {
                            writer.writeTokens(tokens, 0, bmcIndex + 1);
                        }
                        else
                        {
                            writer.writeTokens(tokens);
                        }
                        output.write("\n".getBytes("ISO-8859-1"));
                        insertGeneratedAppearance(widget, output, pdFont, tokens, appearanceStream);
                        if (emcIndex != -1)
                        {
                            writer.writeTokens(tokens, emcIndex, tokens.size());
                        }
                        writeToStream(output.toByteArray(), appearanceStream);
                    }
                    else
                    {
                        // hmm?
                    }
                }
            }
        }
    }

    private void insertGeneratedAppearance(PDAnnotationWidget fieldWidget, OutputStream output,
            PDFont pdFont, List<Object> tokens, PDAppearanceStream appearanceStream)
            throws IOException
    {
        PrintWriter printWriter = new PrintWriter(output, true);
        float fontSize = 0.0f;
        PDRectangle boundingBox = appearanceStream.getBBox();
        if (boundingBox == null)
        {
            boundingBox = fieldWidget.getRectangle().createRetranslatedRectangle();
        }
        printWriter.println("BT");
        if (defaultAppearance != null)
        {
            String daString = defaultAppearance.getString();
            PDFStreamParser daParser = new PDFStreamParser(new ByteArrayInputStream(
                    daString.getBytes("ISO-8859-1")));
            daParser.parse();
            List<Object> daTokens = daParser.getTokens();
            fontSize = calculateFontSize(pdFont, boundingBox, tokens, daTokens);
            int fontIndex = daTokens.indexOf(Operator.getOperator("Tf"));
            if (fontIndex != -1)
            {
                daTokens.set(fontIndex - 1, new COSFloat(fontSize));
            }
            ContentStreamWriter daWriter = new ContentStreamWriter(output);
            daWriter.writeTokens(daTokens);
        }

        PDRectangle borderEdge = getSmallestDrawnRectangle(boundingBox, tokens);

        // Acrobat calculates the left and right padding dependent on the offset of the border edge
        // This calculation works for forms having been generated by Acrobat.
        // Need to revisit this for forms being generated with other software.
        float paddingLeft = Math.max(2, Math.round(4 * borderEdge.getLowerLeftX()));
        float paddingRight = Math.max(2,
                Math.round(4 * (boundingBox.getUpperRightX() - borderEdge.getUpperRightX())));
        float verticalOffset = getVerticalOffset(boundingBox, pdFont, fontSize, tokens);

        // Acrobat shifts the value so it aligns to the bottom if
        // the font's caps are larger than the height of the borderEdge
        //
        // This is based on a small sample of test files and might not be generally the case.
        // The fontHeight calculation has been taken from getVerticalOffset().
        // We potentially need to revisit that calculation
        float fontHeight = boundingBox.getHeight() - verticalOffset * 2;

        if (fontHeight + 2 * borderEdge.getLowerLeftX() > borderEdge.getHeight())
        {
            verticalOffset = pdFont.getBoundingBox().getHeight() / 1000 * fontSize
                    - borderEdge.getHeight();
        }

        float leftOffset = 0f;

        // Acrobat aligns left regardless of the quadding if the text is wider than the remaining width
        float stringWidth = (pdFont.getStringWidth(value) / 1000) * fontSize;
        int q = getQ();
        if (q == PDTextField.QUADDING_LEFT
                || stringWidth > borderEdge.getWidth() - paddingLeft - paddingRight)
        {
            leftOffset = paddingLeft;
        }
        else if (q == PDTextField.QUADDING_CENTERED)
        {
            leftOffset = (boundingBox.getWidth() - stringWidth) / 2;
        }
        else if (q == PDTextField.QUADDING_RIGHT)
        {
            leftOffset = boundingBox.getWidth() - stringWidth - paddingRight;
        }
        else
        {
            // Unknown quadding value - default to left
            printWriter.println(paddingLeft + " " + verticalOffset + " Td");
            LOG.debug("Unknown justification value, defaulting to left: " + q);
        }

        printWriter.println(leftOffset + " " + verticalOffset + " Td");

        // add the value as hex string to deal with non ISO-8859-1 data values
        if (!isMultiLineValue(value) || stringWidth > borderEdge.getWidth() - paddingLeft -
                paddingRight)
        {
            printWriter.println("<" + new COSString(value).getHexString() + "> Tj");
        }
        else
        {
            String[] paragraphs = value.split("\n");
            for (int i = 0; i < paragraphs.length; i++)
            {
                boolean lastLine = i == (paragraphs.length - 1);
                String endingTag = lastLine ? "> Tj\n" : "> Tj 0 -13 Td";
                printWriter.print("<" + new COSString(paragraphs[i]).getHexString() + endingTag);
            }
        }
        printWriter.println("ET");
        printWriter.flush();
    }

    private PDFont getFontAndUpdateResources(List<Object> tokens,
            PDAppearanceStream appearanceStream) throws IOException
    {
        PDFont retval = null;
        PDResources streamResources = appearanceStream.getResources();
        PDResources formResources = acroForm.getDefaultResources();
        if (formResources != null)
        {
            if (streamResources == null)
            {
                streamResources = new PDResources();
                appearanceStream.setResources(streamResources);
            }

            COSString da = getDefaultAppearance();
            if (da != null)
            {
                String data = da.getString();
                PDFStreamParser streamParser = new PDFStreamParser(new ByteArrayInputStream(
                        data.getBytes("ISO-8859-1")));
                streamParser.parse();
                tokens = streamParser.getTokens();
            }

            int setFontIndex = tokens.indexOf(Operator.getOperator("Tf"));
            COSName cosFontName = (COSName) tokens.get(setFontIndex - 2);
            retval = streamResources.getFont(cosFontName);
            if (retval == null)
            {
                retval = formResources.getFont(cosFontName);
                streamResources.put(cosFontName, retval);
            }
        }
        return retval;
    }

    private boolean isMultiLineValue(String multiLineValue)
    {
        return (parent.isMultiline() && multiLineValue.contains("\n"));
    }

    /**
     * Writes the stream to the actual stream in the COSStream.
     *
     * @throws IOException If there is an error writing to the stream
     */
    private void writeToStream(byte[] data, PDAppearanceStream appearanceStream) throws IOException
    {
        OutputStream out = appearanceStream.getCOSStream().createUnfilteredStream();
        out.write(data);
        out.flush();
    }

    /**
     * w in an appearance stream represents the lineWidth.
     * 
     * @return the linewidth
     */
    private float getLineWidth(List<Object> tokens)
    {
        float retval = 1;
        if (tokens != null)
        {
            int btIndex = tokens.indexOf(Operator.getOperator("BT"));
            int wIndex = tokens.indexOf(Operator.getOperator("w"));
            // the w should only be used if it is before the first BT.
            if ((wIndex > 0) && (wIndex < btIndex))
            {
                retval = ((COSNumber) tokens.get(wIndex - 1)).floatValue();
            }
        }
        return retval;
    }

    private PDRectangle getSmallestDrawnRectangle(PDRectangle boundingBox, List<Object> tokens)
    {
        PDRectangle smallest = boundingBox;
        for (int i = 0; i < tokens.size(); i++)
        {
            Object next = tokens.get(i);
            if (next == Operator.getOperator("re"))
            {
                COSNumber x = (COSNumber) tokens.get(i - 4);
                COSNumber y = (COSNumber) tokens.get(i - 3);
                COSNumber width = (COSNumber) tokens.get(i - 2);
                COSNumber height = (COSNumber) tokens.get(i - 1);
                PDRectangle potentialSmallest = new PDRectangle();
                potentialSmallest.setLowerLeftX(x.floatValue());
                potentialSmallest.setLowerLeftY(y.floatValue());
                potentialSmallest.setUpperRightX(x.floatValue() + width.floatValue());
                potentialSmallest.setUpperRightY(y.floatValue() + height.floatValue());
                if (smallest == null
                        || smallest.getLowerLeftX() < potentialSmallest.getLowerLeftX()
                        || smallest.getUpperRightY() > potentialSmallest.getUpperRightY())
                {
                    smallest = potentialSmallest;
                }
            }
        }
        return smallest;
    }

    /**
     * My "not so great" method for calculating the fontsize. It does not work superb, but it
     * handles ok.
     * 
     * @return the calculated font-size
     *
     * @throws IOException If there is an error getting the font height.
     */
    private float calculateFontSize(PDFont pdFont, PDRectangle boundingBox, List<Object> tokens,
            List<Object> daTokens) throws IOException
    {
        float fontSize = 0;
        if (daTokens != null)
        {
            // daString looks like "BMC /Helv 3.4 Tf EMC"
            // use the fontsize of the default existing apperance stream
            int fontIndex = daTokens.indexOf(Operator.getOperator("Tf"));
            if (fontIndex != -1)
            {
                fontSize = ((COSNumber) daTokens.get(fontIndex - 1)).floatValue();
            }
        }

        float widthBasedFontSize = Float.MAX_VALUE;

        if (parent.doNotScroll())
        {
            // if we don't scroll then we will shrink the font to fit into the text area.
            float widthAtFontSize1 = pdFont.getStringWidth(value) / 1000.f;
            float availableWidth = getAvailableWidth(boundingBox, getLineWidth(tokens));
            widthBasedFontSize = availableWidth / widthAtFontSize1;
        }
        else if (fontSize == 0)
        {
            float lineWidth = getLineWidth(tokens);
            float height = pdFont.getFontDescriptor().getFontBoundingBox().getHeight() / 1000f;
            float availHeight = getAvailableHeight(boundingBox, lineWidth);
            fontSize = Math.min((availHeight / height), widthBasedFontSize);
        }
        return fontSize;
    }

    /**
     * Calculates where to start putting the text in the box. The positioning is not quite as
     * accurate as when Acrobat places the elements, but it works though.
     *
     * @return the sting for representing the start position of the text
     *
     * @throws IOException If there is an error calculating the text position.
     */
    private float getVerticalOffset(PDRectangle boundingBox, PDFont pdFont, float fontSize,
            List<Object> tokens) throws IOException
    {
        float lineWidth = getLineWidth(tokens);
        float verticalOffset = 0.0f;
        if (parent.isMultiline())
        {
            int rows = (int) (getAvailableHeight(boundingBox, lineWidth) / ((int) fontSize));
            verticalOffset = ((rows) * fontSize) - fontSize;
        }
        else
        {
            // BJL 9/25/2004
            // This algorithm is a little bit of black magic. It does
            // not appear to be documented anywhere. Through examining a few
            // PDF documents and the value that Acrobat places in there I
            // have determined that the below method of computing the position
            // is correct for certain documents, but maybe not all. It does
            // work f1040ez.pdf and Form_1.pdf
            PDFontDescriptor fd = pdFont.getFontDescriptor();
            float bBoxHeight = boundingBox.getHeight();
            float fontHeight = fd.getFontBoundingBox().getHeight() + 2 * fd.getDescent();
            fontHeight = (fontHeight / 1000) * fontSize;
            verticalOffset = (bBoxHeight - fontHeight) / 2;
        }
        return verticalOffset;
    }

    /**
     * calculates the available width of the box.
     * 
     * @return the calculated available width of the box
     */
    private float getAvailableWidth(PDRectangle boundingBox, float lineWidth)
    {
        return boundingBox.getWidth() - 2 * lineWidth;
    }

    /**
     * calculates the available height of the box.
     * 
     * @return the calculated available height of the box
     */
    private float getAvailableHeight(PDRectangle boundingBox, float lineWidth)
    {
        return boundingBox.getHeight() - 2 * lineWidth;
    }
}
