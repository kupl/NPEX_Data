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
package org.apache.pdfbox.examples.signature;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSTypedData;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Wraps a InputStream into a CMSProcessable object for bouncy castle.
 * It's an alternative to the CMSProcessableByteArray.
 * @author Thomas Chojecki
 */
class CMSProcessableInputStream implements CMSTypedData
{
    private InputStream in;
    private final ASN1ObjectIdentifier contentType;

    public CMSProcessableInputStream(InputStream is)
    {
        this(new ASN1ObjectIdentifier(CMSObjectIdentifiers.data.getId()), is);
    }

    public CMSProcessableInputStream(ASN1ObjectIdentifier type, InputStream is)
    {
        contentType = type;
        in = is;
    }

    public Object getContent()
    {
        return null;
    }

    public void write(OutputStream out) throws IOException, CMSException
    {
        // read the content only one time
        byte[] buffer = new byte[8 * 1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
        in.close();
    }

    @Override
    public ASN1ObjectIdentifier getContentType()
    {
        return contentType;
    }
}