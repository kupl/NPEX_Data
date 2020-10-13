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
package org.apache.pdfbox.encryption;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.PublicKeyDecryptionMaterial;
import org.apache.pdfbox.pdmodel.encryption.PublicKeyProtectionPolicy;
import org.apache.pdfbox.pdmodel.encryption.PublicKeyRecipient;
import junit.framework.TestCase;
import org.apache.pdfbox.pdmodel.encryption.PublicKeySecurityHandler;
import org.junit.Assert;

/**
 * Tests for public key encryption.
 *
 * @author <a href="mailto:ben@benlitchfield.com">Ben Litchfield</a>
 * @version $Revision: 1.3 $
 */
public class TestPublicKeyEncryption extends TestCase
{

    private AccessPermission permission1;
    private AccessPermission permission2;

    private PublicKeyRecipient recipient1;
    private PublicKeyRecipient recipient2;

    private PublicKeyDecryptionMaterial decryption1;
    private PublicKeyDecryptionMaterial decryption2;

    /**
     * Simple test document that gets encrypted by the test cases.
     */
    private PDDocument document;

    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void setUp() throws Exception 
    {
        if (Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE)
        {
            // we need strong encryption for these tests
            fail("JCE unlimited strength jurisdiction policy files are not installed");
        }
        
        permission1 = new AccessPermission();
        permission1.setCanAssembleDocument(false);
        permission1.setCanExtractContent(false);
        permission1.setCanExtractForAccessibility(true);
        permission1.setCanFillInForm(false);
        permission1.setCanModify(false);
        permission1.setCanModifyAnnotations(false);
        permission1.setCanPrint(false);
        permission1.setCanPrintDegraded(false);

        permission2 = new AccessPermission();
        permission2.setCanAssembleDocument(false);
        permission2.setCanExtractContent(false);
        permission2.setCanExtractForAccessibility(true);
        permission2.setCanFillInForm(false);
        permission2.setCanModify(false);
        permission2.setCanModifyAnnotations(false);
        permission2.setCanPrint(true); // it is true now !
        permission2.setCanPrintDegraded(false);

        recipient1 = getRecipient("test1.der", permission1);
        recipient2 = getRecipient("test2.der", permission2);

        decryption1 = getDecryptionMaterial("test1.pfx", "test1");
        decryption2 = getDecryptionMaterial("test2.pfx", "test2");

        InputStream input =
            TestPublicKeyEncryption.class.getResourceAsStream("test.pdf");
        try 
        {
            document = PDDocument.load(input);
        } 
        finally 
        {
            input.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void tearDown() throws Exception 
    {
        document.close();
    }

    /**
     * Protect a document with certificate 1 and try to open it with
     * certificate 2 and catch the exception.
     *
     * @throws Exception If there is an unexpected error during the test.
     */
    public void testProtectionError() throws Exception
    {
        PublicKeyProtectionPolicy policy = new PublicKeyProtectionPolicy();
        policy.addRecipient(recipient1);
        document.protect(policy);

        PDDocument encryptedDoc = reload(document);
        try 
        {
            Assert.assertTrue(encryptedDoc.isEncrypted());
            PublicKeySecurityHandler securityHandler
                    = (PublicKeySecurityHandler) encryptedDoc.getEncryption().getSecurityHandler();
            securityHandler.setVerbose(true);
            encryptedDoc.openProtection(decryption2);
            fail("No exception when using an incorrect decryption key");
        }
        catch (IOException ex)
        {
            String msg = ex.getMessage();
            Assert.assertTrue("not the expected exception: " + msg, 
                    msg.contains("serial-#: rid 2 vs. cert 3"));
        }
        finally 
        {
            encryptedDoc.close();
        }
    }


    /**
     * Protect a document with a public certificate and try to open it
     * with the corresponding private certificate.
     *
     * @throws Exception If there is an unexpected error during the test.
     */
    public void testProtection() throws Exception
    {
        PublicKeyProtectionPolicy policy = new PublicKeyProtectionPolicy();
        policy.addRecipient(recipient1);
        document.protect(policy);

        PDDocument encryptedDoc = reload(document);
        try 
        {
            Assert.assertTrue(encryptedDoc.isEncrypted());
            encryptedDoc.openProtection(decryption1);

            AccessPermission permission =
                encryptedDoc.getCurrentAccessPermission();
            Assert.assertFalse(permission.canAssembleDocument());
            Assert.assertFalse(permission.canExtractContent());
            Assert.assertTrue(permission.canExtractForAccessibility());
            Assert.assertFalse(permission.canFillInForm());
            Assert.assertFalse(permission.canModify());
            Assert.assertFalse(permission.canModifyAnnotations());
            Assert.assertFalse(permission.canPrint());
            Assert.assertFalse(permission.canPrintDegraded());
        } 
        finally 
        {
            encryptedDoc.close();
        }
    }


    /**
     * Protect the document for 2 recipients and try to open it.
     *
     * @throws Exception If there is an error during the test.
     */
    public void testMultipleRecipients() throws Exception
    {
        PublicKeyProtectionPolicy policy = new PublicKeyProtectionPolicy();
        policy.addRecipient(recipient1);
        policy.addRecipient(recipient2);
        document.protect(policy);

        // open first time
        PDDocument encryptedDoc1 = reload(document);
        try 
        {
            encryptedDoc1.openProtection(decryption1);

            AccessPermission permission =
                encryptedDoc1.getCurrentAccessPermission();
            Assert.assertFalse(permission.canAssembleDocument());
            Assert.assertFalse(permission.canExtractContent());
            Assert.assertTrue(permission.canExtractForAccessibility());
            Assert.assertFalse(permission.canFillInForm());
            Assert.assertFalse(permission.canModify());
            Assert.assertFalse(permission.canModifyAnnotations());
            Assert.assertFalse(permission.canPrint());
            Assert.assertFalse(permission.canPrintDegraded());
        } 
        finally 
        {
            encryptedDoc1.close();
        }

        // open second time
        PDDocument encryptedDoc2 = reload(document);
        try 
        {
            encryptedDoc2.openProtection(decryption2);

            AccessPermission permission =
                encryptedDoc2.getCurrentAccessPermission();
            Assert.assertFalse(permission.canAssembleDocument());
            Assert.assertFalse(permission.canExtractContent());
            Assert.assertTrue(permission.canExtractForAccessibility());
            Assert.assertFalse(permission.canFillInForm());
            Assert.assertFalse(permission.canModify());
            Assert.assertFalse(permission.canModifyAnnotations());
            Assert.assertTrue(permission.canPrint());
            Assert.assertFalse(permission.canPrintDegraded());
        } 
        finally 
        {
            encryptedDoc2.close();
        }
    }

    /**
     * Reloads the given document by writing it to a temporary byte array
     * and loading a fresh document from that byte array.
     *
     * @param doc input document
     * @return reloaded document
     * @throws Exception if 
     */
    private PDDocument reload(PDDocument doc) throws IOException, NoSuchAlgorithmException
    {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        doc.save(buffer);
        return PDDocument.load(new ByteArrayInputStream(buffer.toByteArray()));
    }

    /**
     * Returns a recipient specification with the given access permissions
     * and an X.509 certificate read from the given classpath resource.
     *
     * @param certificate X.509 certificate resource, relative to this class
     * @param permission access permissions
     * @return recipient specification
     * @throws Exception if the certificate could not be read
     */
    private PublicKeyRecipient getRecipient(String certificate, AccessPermission permission) throws Exception 
    {
        InputStream input = TestPublicKeyEncryption.class.getResourceAsStream(certificate);
        try 
        {
            CertificateFactory factory = CertificateFactory.getInstance("X.509");
            PublicKeyRecipient recipient = new PublicKeyRecipient();
            recipient.setPermission(permission);
            recipient.setX509(
                    (X509Certificate) factory.generateCertificate(input));
            return recipient;
        } 
        finally 
        {
            input.close();
        }
    }

    private PublicKeyDecryptionMaterial getDecryptionMaterial(String name, String password) throws Exception 
    {
        InputStream input = TestPublicKeyEncryption.class.getResourceAsStream(name);
        try 
        {
            KeyStore keystore = KeyStore.getInstance("PKCS12");
            keystore.load(input, password.toCharArray());
            return new PublicKeyDecryptionMaterial(keystore, null, password);
        } 
        finally 
        {
            input.close();
        }
    }

}
