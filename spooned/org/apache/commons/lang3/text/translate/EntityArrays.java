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
package org.apache.commons.lang3.text.translate;
/**
 * Class holding various entity data for HTML and XML - generally for use with
 * the LookupTranslator.
 * All arrays are of length [*][2].
 *
 * @author Apache Software Foundation
 * @since 3.0
 */
public class EntityArrays {
    public static String[][] ISO8859_1_ESCAPE() {
        return ISO8859_1_ESCAPE.clone();
    }

    private static final String[][] ISO8859_1_ESCAPE = new String[][]{ new String[]{ " ", "&nbsp;" }// non-breaking space
    // non-breaking space
    // non-breaking space
    , new String[]{ "¡", "&iexcl;" }// inverted exclamation mark
    // inverted exclamation mark
    // inverted exclamation mark
    , new String[]{ "¢", "&cent;" }// cent sign
    // cent sign
    // cent sign
    , new String[]{ "£", "&pound;" }// pound sign
    // pound sign
    // pound sign
    , new String[]{ "¤", "&curren;" }// currency sign
    // currency sign
    // currency sign
    , new String[]{ "¥", "&yen;" }// yen sign = yuan sign
    // yen sign = yuan sign
    // yen sign = yuan sign
    , new String[]{ "¦", "&brvbar;" }// broken bar = broken vertical bar
    // broken bar = broken vertical bar
    // broken bar = broken vertical bar
    , new String[]{ "§", "&sect;" }// section sign
    // section sign
    // section sign
    , new String[]{ "¨", "&uml;" }// diaeresis = spacing diaeresis
    // diaeresis = spacing diaeresis
    // diaeresis = spacing diaeresis
    , new String[]{ "©", "&copy;" }// � - copyright sign
    // � - copyright sign
    // � - copyright sign
    , new String[]{ "ª", "&ordf;" }// feminine ordinal indicator
    // feminine ordinal indicator
    // feminine ordinal indicator
    , new String[]{ "«", "&laquo;" }// left-pointing double angle quotation mark = left pointing guillemet
    // left-pointing double angle quotation mark = left pointing guillemet
    // left-pointing double angle quotation mark = left pointing guillemet
    , new String[]{ "¬", "&not;" }// not sign
    // not sign
    // not sign
    , new String[]{ "­", "&shy;" }// soft hyphen = discretionary hyphen
    // soft hyphen = discretionary hyphen
    // soft hyphen = discretionary hyphen
    , new String[]{ "®", "&reg;" }// � - registered trademark sign
    // � - registered trademark sign
    // � - registered trademark sign
    , new String[]{ "¯", "&macr;" }// macron = spacing macron = overline = APL overbar
    // macron = spacing macron = overline = APL overbar
    // macron = spacing macron = overline = APL overbar
    , new String[]{ "°", "&deg;" }// degree sign
    // degree sign
    // degree sign
    , new String[]{ "±", "&plusmn;" }// plus-minus sign = plus-or-minus sign
    // plus-minus sign = plus-or-minus sign
    // plus-minus sign = plus-or-minus sign
    , new String[]{ "²", "&sup2;" }// superscript two = superscript digit two = squared
    // superscript two = superscript digit two = squared
    // superscript two = superscript digit two = squared
    , new String[]{ "³", "&sup3;" }// superscript three = superscript digit three = cubed
    // superscript three = superscript digit three = cubed
    // superscript three = superscript digit three = cubed
    , new String[]{ "´", "&acute;" }// acute accent = spacing acute
    // acute accent = spacing acute
    // acute accent = spacing acute
    , new String[]{ "µ", "&micro;" }// micro sign
    // micro sign
    // micro sign
    , new String[]{ "¶", "&para;" }// pilcrow sign = paragraph sign
    // pilcrow sign = paragraph sign
    // pilcrow sign = paragraph sign
    , new String[]{ "·", "&middot;" }// middle dot = Georgian comma = Greek middle dot
    // middle dot = Georgian comma = Greek middle dot
    // middle dot = Georgian comma = Greek middle dot
    , new String[]{ "¸", "&cedil;" }// cedilla = spacing cedilla
    // cedilla = spacing cedilla
    // cedilla = spacing cedilla
    , new String[]{ "¹", "&sup1;" }// superscript one = superscript digit one
    // superscript one = superscript digit one
    // superscript one = superscript digit one
    , new String[]{ "º", "&ordm;" }// masculine ordinal indicator
    // masculine ordinal indicator
    // masculine ordinal indicator
    , new String[]{ "»", "&raquo;" }// right-pointing double angle quotation mark = right pointing guillemet
    // right-pointing double angle quotation mark = right pointing guillemet
    // right-pointing double angle quotation mark = right pointing guillemet
    , new String[]{ "¼", "&frac14;" }// vulgar fraction one quarter = fraction one quarter
    // vulgar fraction one quarter = fraction one quarter
    // vulgar fraction one quarter = fraction one quarter
    , new String[]{ "½", "&frac12;" }// vulgar fraction one half = fraction one half
    // vulgar fraction one half = fraction one half
    // vulgar fraction one half = fraction one half
    , new String[]{ "¾", "&frac34;" }// vulgar fraction three quarters = fraction three quarters
    // vulgar fraction three quarters = fraction three quarters
    // vulgar fraction three quarters = fraction three quarters
    , new String[]{ "¿", "&iquest;" }// inverted question mark = turned question mark
    // inverted question mark = turned question mark
    // inverted question mark = turned question mark
    , new String[]{ "À", "&Agrave;" }// � - uppercase A, grave accent
    // � - uppercase A, grave accent
    // � - uppercase A, grave accent
    , new String[]{ "Á", "&Aacute;" }// � - uppercase A, acute accent
    // � - uppercase A, acute accent
    // � - uppercase A, acute accent
    , new String[]{ "Â", "&Acirc;" }// � - uppercase A, circumflex accent
    // � - uppercase A, circumflex accent
    // � - uppercase A, circumflex accent
    , new String[]{ "Ã", "&Atilde;" }// � - uppercase A, tilde
    // � - uppercase A, tilde
    // � - uppercase A, tilde
    , new String[]{ "Ä", "&Auml;" }// � - uppercase A, umlaut
    // � - uppercase A, umlaut
    // � - uppercase A, umlaut
    , new String[]{ "Å", "&Aring;" }// � - uppercase A, ring
    // � - uppercase A, ring
    // � - uppercase A, ring
    , new String[]{ "Æ", "&AElig;" }// � - uppercase AE
    // � - uppercase AE
    // � - uppercase AE
    , new String[]{ "Ç", "&Ccedil;" }// � - uppercase C, cedilla
    // � - uppercase C, cedilla
    // � - uppercase C, cedilla
    , new String[]{ "È", "&Egrave;" }// � - uppercase E, grave accent
    // � - uppercase E, grave accent
    // � - uppercase E, grave accent
    , new String[]{ "É", "&Eacute;" }// � - uppercase E, acute accent
    // � - uppercase E, acute accent
    // � - uppercase E, acute accent
    , new String[]{ "Ë", "&Ecirc;" }// � - uppercase E, circumflex accent
    // � - uppercase E, circumflex accent
    // � - uppercase E, circumflex accent
    , new String[]{ "Ì", "&Euml;" }// � - uppercase E, umlaut
    // � - uppercase E, umlaut
    // � - uppercase E, umlaut
    , new String[]{ "Í", "&Igrave;" }// � - uppercase I, grave accent
    // � - uppercase I, grave accent
    // � - uppercase I, grave accent
    , new String[]{ "Î", "&Iacute;" }// � - uppercase I, acute accent
    // � - uppercase I, acute accent
    // � - uppercase I, acute accent
    , new String[]{ "Ï", "&Icirc;" }// � - uppercase I, circumflex accent
    // � - uppercase I, circumflex accent
    // � - uppercase I, circumflex accent
    , new String[]{ "Ð", "&Iuml;" }// � - uppercase I, umlaut
    // � - uppercase I, umlaut
    // � - uppercase I, umlaut
    , new String[]{ "Ñ", "&ETH;" }// � - uppercase Eth, Icelandic
    // � - uppercase Eth, Icelandic
    // � - uppercase Eth, Icelandic
    , new String[]{ "Ò", "&Ntilde;" }// � - uppercase N, tilde
    // � - uppercase N, tilde
    // � - uppercase N, tilde
    , new String[]{ "Ó", "&Ograve;" }// � - uppercase O, grave accent
    // � - uppercase O, grave accent
    // � - uppercase O, grave accent
    , new String[]{ "Ô", "&Oacute;" }// � - uppercase O, acute accent
    // � - uppercase O, acute accent
    // � - uppercase O, acute accent
    , new String[]{ "Õ", "&Ocirc;" }// � - uppercase O, circumflex accent
    // � - uppercase O, circumflex accent
    // � - uppercase O, circumflex accent
    , new String[]{ "Ö", "&Otilde;" }// � - uppercase O, tilde
    // � - uppercase O, tilde
    // � - uppercase O, tilde
    , new String[]{ "×", "&Ouml;" }// � - uppercase O, umlaut
    // � - uppercase O, umlaut
    // � - uppercase O, umlaut
    , new String[]{ "Ø", "&times;" }// multiplication sign
    // multiplication sign
    // multiplication sign
    , new String[]{ "Ù", "&Oslash;" }// � - uppercase O, slash
    // � - uppercase O, slash
    // � - uppercase O, slash
    , new String[]{ "Ú", "&Ugrave;" }// � - uppercase U, grave accent
    // � - uppercase U, grave accent
    // � - uppercase U, grave accent
    , new String[]{ "Û", "&Uacute;" }// � - uppercase U, acute accent
    // � - uppercase U, acute accent
    // � - uppercase U, acute accent
    , new String[]{ "Ü", "&Ucirc;" }// � - uppercase U, circumflex accent
    // � - uppercase U, circumflex accent
    // � - uppercase U, circumflex accent
    , new String[]{ "Ý", "&Uuml;" }// � - uppercase U, umlaut
    // � - uppercase U, umlaut
    // � - uppercase U, umlaut
    , new String[]{ "Þ", "&Yacute;" }// � - uppercase Y, acute accent
    // � - uppercase Y, acute accent
    // � - uppercase Y, acute accent
    , new String[]{ "ß", "&THORN;" }// � - uppercase THORN, Icelandic
    // � - uppercase THORN, Icelandic
    // � - uppercase THORN, Icelandic
    , new String[]{ "à", "&szlig;" }// � - lowercase sharps, German
    // � - lowercase sharps, German
    // � - lowercase sharps, German
    , new String[]{ "á", "&agrave;" }// � - lowercase a, grave accent
    // � - lowercase a, grave accent
    // � - lowercase a, grave accent
    , new String[]{ "â", "&aacute;" }// � - lowercase a, acute accent
    // � - lowercase a, acute accent
    // � - lowercase a, acute accent
    , new String[]{ "ã", "&acirc;" }// � - lowercase a, circumflex accent
    // � - lowercase a, circumflex accent
    // � - lowercase a, circumflex accent
    , new String[]{ "ä", "&atilde;" }// � - lowercase a, tilde
    // � - lowercase a, tilde
    // � - lowercase a, tilde
    , new String[]{ "å", "&auml;" }// � - lowercase a, umlaut
    // � - lowercase a, umlaut
    // � - lowercase a, umlaut
    , new String[]{ "å", "&aring;" }// � - lowercase a, ring
    // � - lowercase a, ring
    // � - lowercase a, ring
    , new String[]{ "æ", "&aelig;" }// � - lowercase ae
    // � - lowercase ae
    // � - lowercase ae
    , new String[]{ "ç", "&ccedil;" }// � - lowercase c, cedilla
    // � - lowercase c, cedilla
    // � - lowercase c, cedilla
    , new String[]{ "è", "&egrave;" }// � - lowercase e, grave accent
    // � - lowercase e, grave accent
    // � - lowercase e, grave accent
    , new String[]{ "é", "&eacute;" }// � - lowercase e, acute accent
    // � - lowercase e, acute accent
    // � - lowercase e, acute accent
    , new String[]{ "ê", "&ecirc;" }// � - lowercase e, circumflex accent
    // � - lowercase e, circumflex accent
    // � - lowercase e, circumflex accent
    , new String[]{ "ë", "&euml;" }// � - lowercase e, umlaut
    // � - lowercase e, umlaut
    // � - lowercase e, umlaut
    , new String[]{ "ì", "&igrave;" }// � - lowercase i, grave accent
    // � - lowercase i, grave accent
    // � - lowercase i, grave accent
    , new String[]{ "í", "&iacute;" }// � - lowercase i, acute accent
    // � - lowercase i, acute accent
    // � - lowercase i, acute accent
    , new String[]{ "î", "&icirc;" }// � - lowercase i, circumflex accent
    // � - lowercase i, circumflex accent
    // � - lowercase i, circumflex accent
    , new String[]{ "ï", "&iuml;" }// � - lowercase i, umlaut
    // � - lowercase i, umlaut
    // � - lowercase i, umlaut
    , new String[]{ "ð", "&eth;" }// � - lowercase eth, Icelandic
    // � - lowercase eth, Icelandic
    // � - lowercase eth, Icelandic
    , new String[]{ "ñ", "&ntilde;" }// � - lowercase n, tilde
    // � - lowercase n, tilde
    // � - lowercase n, tilde
    , new String[]{ "ó", "&ograve;" }// � - lowercase o, grave accent
    // � - lowercase o, grave accent
    // � - lowercase o, grave accent
    , new String[]{ "ó", "&oacute;" }// � - lowercase o, acute accent
    // � - lowercase o, acute accent
    // � - lowercase o, acute accent
    , new String[]{ "ô", "&ocirc;" }// � - lowercase o, circumflex accent
    // � - lowercase o, circumflex accent
    // � - lowercase o, circumflex accent
    , new String[]{ "õ", "&otilde;" }// � - lowercase o, tilde
    // � - lowercase o, tilde
    // � - lowercase o, tilde
    , new String[]{ "ö", "&ouml;" }// � - lowercase o, umlaut
    // � - lowercase o, umlaut
    // � - lowercase o, umlaut
    , new String[]{ "÷", "&divide;" }// division sign
    // division sign
    // division sign
    , new String[]{ "ø", "&oslash;" }// � - lowercase o, slash
    // � - lowercase o, slash
    // � - lowercase o, slash
    , new String[]{ "ù", "&ugrave;" }// � - lowercase u, grave accent
    // � - lowercase u, grave accent
    // � - lowercase u, grave accent
    , new String[]{ "ú", "&uacute;" }// � - lowercase u, acute accent
    // � - lowercase u, acute accent
    // � - lowercase u, acute accent
    , new String[]{ "û", "&ucirc;" }// � - lowercase u, circumflex accent
    // � - lowercase u, circumflex accent
    // � - lowercase u, circumflex accent
    , new String[]{ "ü", "&uuml;" }// � - lowercase u, umlaut
    // � - lowercase u, umlaut
    // � - lowercase u, umlaut
    , new String[]{ "ý", "&yacute;" }// � - lowercase y, acute accent
    // � - lowercase y, acute accent
    // � - lowercase y, acute accent
    , new String[]{ "þ", "&thorn;" }// � - lowercase thorn, Icelandic
    // � - lowercase thorn, Icelandic
    // � - lowercase thorn, Icelandic
    , new String[]{ "ÿ", "&yuml;" }// � - lowercase y, umlaut
    // � - lowercase y, umlaut
    // � - lowercase y, umlaut
     };

    public static String[][] ISO8859_1_UNESCAPE() {
        return ISO8859_1_UNESCAPE.clone();
    }

    private static final String[][] ISO8859_1_UNESCAPE = invert(ISO8859_1_ESCAPE);

    // http://www.w3.org/TR/REC-html40/sgml/entities.html
    public static String[][] HTML40_EXTENDED_ESCAPE() {
        return HTML40_EXTENDED_ESCAPE.clone();
    }

    private static final String[][] HTML40_EXTENDED_ESCAPE = new String[][]{ // <!-- Latin Extended-B -->
    new String[]{ "ƒ", "&fnof;" }// latin small f with hook = function= florin, U+0192 ISOtech -->
    // latin small f with hook = function= florin, U+0192 ISOtech -->
    // latin small f with hook = function= florin, U+0192 ISOtech -->
    , // <!-- Greek -->
    new String[]{ "Α", "&Alpha;" }// greek capital letter alpha, U+0391 -->
    // greek capital letter alpha, U+0391 -->
    // greek capital letter alpha, U+0391 -->
    , new String[]{ "Β", "&Beta;" }// greek capital letter beta, U+0392 -->
    // greek capital letter beta, U+0392 -->
    // greek capital letter beta, U+0392 -->
    , new String[]{ "Γ", "&Gamma;" }// greek capital letter gamma,U+0393 ISOgrk3 -->
    // greek capital letter gamma,U+0393 ISOgrk3 -->
    // greek capital letter gamma,U+0393 ISOgrk3 -->
    , new String[]{ "Δ", "&Delta;" }// greek capital letter delta,U+0394 ISOgrk3 -->
    // greek capital letter delta,U+0394 ISOgrk3 -->
    // greek capital letter delta,U+0394 ISOgrk3 -->
    , new String[]{ "Ε", "&Epsilon;" }// greek capital letter epsilon, U+0395 -->
    // greek capital letter epsilon, U+0395 -->
    // greek capital letter epsilon, U+0395 -->
    , new String[]{ "Ζ", "&Zeta;" }// greek capital letter zeta, U+0396 -->
    // greek capital letter zeta, U+0396 -->
    // greek capital letter zeta, U+0396 -->
    , new String[]{ "Η", "&Eta;" }// greek capital letter eta, U+0397 -->
    // greek capital letter eta, U+0397 -->
    // greek capital letter eta, U+0397 -->
    , new String[]{ "Θ", "&Theta;" }// greek capital letter theta,U+0398 ISOgrk3 -->
    // greek capital letter theta,U+0398 ISOgrk3 -->
    // greek capital letter theta,U+0398 ISOgrk3 -->
    , new String[]{ "Ι", "&Iota;" }// greek capital letter iota, U+0399 -->
    // greek capital letter iota, U+0399 -->
    // greek capital letter iota, U+0399 -->
    , new String[]{ "Κ", "&Kappa;" }// greek capital letter kappa, U+039A -->
    // greek capital letter kappa, U+039A -->
    // greek capital letter kappa, U+039A -->
    , new String[]{ "Λ", "&Lambda;" }// greek capital letter lambda,U+039B ISOgrk3 -->
    // greek capital letter lambda,U+039B ISOgrk3 -->
    // greek capital letter lambda,U+039B ISOgrk3 -->
    , new String[]{ "Μ", "&Mu;" }// greek capital letter mu, U+039C -->
    // greek capital letter mu, U+039C -->
    // greek capital letter mu, U+039C -->
    , new String[]{ "Ν", "&Nu;" }// greek capital letter nu, U+039D -->
    // greek capital letter nu, U+039D -->
    // greek capital letter nu, U+039D -->
    , new String[]{ "Ξ", "&Xi;" }// greek capital letter xi, U+039E ISOgrk3 -->
    // greek capital letter xi, U+039E ISOgrk3 -->
    // greek capital letter xi, U+039E ISOgrk3 -->
    , new String[]{ "Ο", "&Omicron;" }// greek capital letter omicron, U+039F -->
    // greek capital letter omicron, U+039F -->
    // greek capital letter omicron, U+039F -->
    , new String[]{ "Π", "&Pi;" }// greek capital letter pi, U+03A0 ISOgrk3 -->
    // greek capital letter pi, U+03A0 ISOgrk3 -->
    // greek capital letter pi, U+03A0 ISOgrk3 -->
    , new String[]{ "Ρ", "&Rho;" }// greek capital letter rho, U+03A1 -->
    // greek capital letter rho, U+03A1 -->
    // greek capital letter rho, U+03A1 -->
    , // <!-- there is no Sigmaf, and no U+03A2 character either -->
    new String[]{ "Σ", "&Sigma;" }// greek capital letter sigma,U+03A3 ISOgrk3 -->
    // greek capital letter sigma,U+03A3 ISOgrk3 -->
    // greek capital letter sigma,U+03A3 ISOgrk3 -->
    , new String[]{ "Τ", "&Tau;" }// greek capital letter tau, U+03A4 -->
    // greek capital letter tau, U+03A4 -->
    // greek capital letter tau, U+03A4 -->
    , new String[]{ "Υ", "&Upsilon;" }// greek capital letter upsilon,U+03A5 ISOgrk3 -->
    // greek capital letter upsilon,U+03A5 ISOgrk3 -->
    // greek capital letter upsilon,U+03A5 ISOgrk3 -->
    , new String[]{ "Φ", "&Phi;" }// greek capital letter phi,U+03A6 ISOgrk3 -->
    // greek capital letter phi,U+03A6 ISOgrk3 -->
    // greek capital letter phi,U+03A6 ISOgrk3 -->
    , new String[]{ "Χ", "&Chi;" }// greek capital letter chi, U+03A7 -->
    // greek capital letter chi, U+03A7 -->
    // greek capital letter chi, U+03A7 -->
    , new String[]{ "Ψ", "&Psi;" }// greek capital letter psi,U+03A8 ISOgrk3 -->
    // greek capital letter psi,U+03A8 ISOgrk3 -->
    // greek capital letter psi,U+03A8 ISOgrk3 -->
    , new String[]{ "Ω", "&Omega;" }// greek capital letter omega,U+03A9 ISOgrk3 -->
    // greek capital letter omega,U+03A9 ISOgrk3 -->
    // greek capital letter omega,U+03A9 ISOgrk3 -->
    , new String[]{ "α", "&alpha;" }// greek small letter alpha,U+03B1 ISOgrk3 -->
    // greek small letter alpha,U+03B1 ISOgrk3 -->
    // greek small letter alpha,U+03B1 ISOgrk3 -->
    , new String[]{ "β", "&beta;" }// greek small letter beta, U+03B2 ISOgrk3 -->
    // greek small letter beta, U+03B2 ISOgrk3 -->
    // greek small letter beta, U+03B2 ISOgrk3 -->
    , new String[]{ "γ", "&gamma;" }// greek small letter gamma,U+03B3 ISOgrk3 -->
    // greek small letter gamma,U+03B3 ISOgrk3 -->
    // greek small letter gamma,U+03B3 ISOgrk3 -->
    , new String[]{ "δ", "&delta;" }// greek small letter delta,U+03B4 ISOgrk3 -->
    // greek small letter delta,U+03B4 ISOgrk3 -->
    // greek small letter delta,U+03B4 ISOgrk3 -->
    , new String[]{ "ε", "&epsilon;" }// greek small letter epsilon,U+03B5 ISOgrk3 -->
    // greek small letter epsilon,U+03B5 ISOgrk3 -->
    // greek small letter epsilon,U+03B5 ISOgrk3 -->
    , new String[]{ "ζ", "&zeta;" }// greek small letter zeta, U+03B6 ISOgrk3 -->
    // greek small letter zeta, U+03B6 ISOgrk3 -->
    // greek small letter zeta, U+03B6 ISOgrk3 -->
    , new String[]{ "η", "&eta;" }// greek small letter eta, U+03B7 ISOgrk3 -->
    // greek small letter eta, U+03B7 ISOgrk3 -->
    // greek small letter eta, U+03B7 ISOgrk3 -->
    , new String[]{ "θ", "&theta;" }// greek small letter theta,U+03B8 ISOgrk3 -->
    // greek small letter theta,U+03B8 ISOgrk3 -->
    // greek small letter theta,U+03B8 ISOgrk3 -->
    , new String[]{ "ι", "&iota;" }// greek small letter iota, U+03B9 ISOgrk3 -->
    // greek small letter iota, U+03B9 ISOgrk3 -->
    // greek small letter iota, U+03B9 ISOgrk3 -->
    , new String[]{ "κ", "&kappa;" }// greek small letter kappa,U+03BA ISOgrk3 -->
    // greek small letter kappa,U+03BA ISOgrk3 -->
    // greek small letter kappa,U+03BA ISOgrk3 -->
    , new String[]{ "λ", "&lambda;" }// greek small letter lambda,U+03BB ISOgrk3 -->
    // greek small letter lambda,U+03BB ISOgrk3 -->
    // greek small letter lambda,U+03BB ISOgrk3 -->
    , new String[]{ "μ", "&mu;" }// greek small letter mu, U+03BC ISOgrk3 -->
    // greek small letter mu, U+03BC ISOgrk3 -->
    // greek small letter mu, U+03BC ISOgrk3 -->
    , new String[]{ "ν", "&nu;" }// greek small letter nu, U+03BD ISOgrk3 -->
    // greek small letter nu, U+03BD ISOgrk3 -->
    // greek small letter nu, U+03BD ISOgrk3 -->
    , new String[]{ "ξ", "&xi;" }// greek small letter xi, U+03BE ISOgrk3 -->
    // greek small letter xi, U+03BE ISOgrk3 -->
    // greek small letter xi, U+03BE ISOgrk3 -->
    , new String[]{ "ο", "&omicron;" }// greek small letter omicron, U+03BF NEW -->
    // greek small letter omicron, U+03BF NEW -->
    // greek small letter omicron, U+03BF NEW -->
    , new String[]{ "π", "&pi;" }// greek small letter pi, U+03C0 ISOgrk3 -->
    // greek small letter pi, U+03C0 ISOgrk3 -->
    // greek small letter pi, U+03C0 ISOgrk3 -->
    , new String[]{ "ρ", "&rho;" }// greek small letter rho, U+03C1 ISOgrk3 -->
    // greek small letter rho, U+03C1 ISOgrk3 -->
    // greek small letter rho, U+03C1 ISOgrk3 -->
    , new String[]{ "ς", "&sigmaf;" }// greek small letter final sigma,U+03C2 ISOgrk3 -->
    // greek small letter final sigma,U+03C2 ISOgrk3 -->
    // greek small letter final sigma,U+03C2 ISOgrk3 -->
    , new String[]{ "σ", "&sigma;" }// greek small letter sigma,U+03C3 ISOgrk3 -->
    // greek small letter sigma,U+03C3 ISOgrk3 -->
    // greek small letter sigma,U+03C3 ISOgrk3 -->
    , new String[]{ "τ", "&tau;" }// greek small letter tau, U+03C4 ISOgrk3 -->
    // greek small letter tau, U+03C4 ISOgrk3 -->
    // greek small letter tau, U+03C4 ISOgrk3 -->
    , new String[]{ "υ", "&upsilon;" }// greek small letter upsilon,U+03C5 ISOgrk3 -->
    // greek small letter upsilon,U+03C5 ISOgrk3 -->
    // greek small letter upsilon,U+03C5 ISOgrk3 -->
    , new String[]{ "φ", "&phi;" }// greek small letter phi, U+03C6 ISOgrk3 -->
    // greek small letter phi, U+03C6 ISOgrk3 -->
    // greek small letter phi, U+03C6 ISOgrk3 -->
    , new String[]{ "χ", "&chi;" }// greek small letter chi, U+03C7 ISOgrk3 -->
    // greek small letter chi, U+03C7 ISOgrk3 -->
    // greek small letter chi, U+03C7 ISOgrk3 -->
    , new String[]{ "ψ", "&psi;" }// greek small letter psi, U+03C8 ISOgrk3 -->
    // greek small letter psi, U+03C8 ISOgrk3 -->
    // greek small letter psi, U+03C8 ISOgrk3 -->
    , new String[]{ "ω", "&omega;" }// greek small letter omega,U+03C9 ISOgrk3 -->
    // greek small letter omega,U+03C9 ISOgrk3 -->
    // greek small letter omega,U+03C9 ISOgrk3 -->
    , new String[]{ "ϑ", "&thetasym;" }// greek small letter theta symbol,U+03D1 NEW -->
    // greek small letter theta symbol,U+03D1 NEW -->
    // greek small letter theta symbol,U+03D1 NEW -->
    , new String[]{ "ϒ", "&upsih;" }// greek upsilon with hook symbol,U+03D2 NEW -->
    // greek upsilon with hook symbol,U+03D2 NEW -->
    // greek upsilon with hook symbol,U+03D2 NEW -->
    , new String[]{ "ϖ", "&piv;" }// greek pi symbol, U+03D6 ISOgrk3 -->
    // greek pi symbol, U+03D6 ISOgrk3 -->
    // greek pi symbol, U+03D6 ISOgrk3 -->
    , // <!-- General Punctuation -->
    new String[]{ "•", "&bull;" }// bullet = black small circle,U+2022 ISOpub -->
    // bullet = black small circle,U+2022 ISOpub -->
    // bullet = black small circle,U+2022 ISOpub -->
    , // <!-- bullet is NOT the same as bullet operator, U+2219 -->
    new String[]{ "…", "&hellip;" }// horizontal ellipsis = three dot leader,U+2026 ISOpub -->
    // horizontal ellipsis = three dot leader,U+2026 ISOpub -->
    // horizontal ellipsis = three dot leader,U+2026 ISOpub -->
    , new String[]{ "′", "&prime;" }// prime = minutes = feet, U+2032 ISOtech -->
    // prime = minutes = feet, U+2032 ISOtech -->
    // prime = minutes = feet, U+2032 ISOtech -->
    , new String[]{ "″", "&Prime;" }// double prime = seconds = inches,U+2033 ISOtech -->
    // double prime = seconds = inches,U+2033 ISOtech -->
    // double prime = seconds = inches,U+2033 ISOtech -->
    , new String[]{ "‾", "&oline;" }// overline = spacing overscore,U+203E NEW -->
    // overline = spacing overscore,U+203E NEW -->
    // overline = spacing overscore,U+203E NEW -->
    , new String[]{ "⁄", "&frasl;" }// fraction slash, U+2044 NEW -->
    // fraction slash, U+2044 NEW -->
    // fraction slash, U+2044 NEW -->
    , // <!-- Letterlike Symbols -->
    new String[]{ "℘", "&weierp;" }// script capital P = power set= Weierstrass p, U+2118 ISOamso -->
    // script capital P = power set= Weierstrass p, U+2118 ISOamso -->
    // script capital P = power set= Weierstrass p, U+2118 ISOamso -->
    , new String[]{ "ℑ", "&image;" }// blackletter capital I = imaginary part,U+2111 ISOamso -->
    // blackletter capital I = imaginary part,U+2111 ISOamso -->
    // blackletter capital I = imaginary part,U+2111 ISOamso -->
    , new String[]{ "ℜ", "&real;" }// blackletter capital R = real part symbol,U+211C ISOamso -->
    // blackletter capital R = real part symbol,U+211C ISOamso -->
    // blackletter capital R = real part symbol,U+211C ISOamso -->
    , new String[]{ "™", "&trade;" }// trade mark sign, U+2122 ISOnum -->
    // trade mark sign, U+2122 ISOnum -->
    // trade mark sign, U+2122 ISOnum -->
    , new String[]{ "ℵ", "&alefsym;" }// alef symbol = first transfinite cardinal,U+2135 NEW -->
    // alef symbol = first transfinite cardinal,U+2135 NEW -->
    // alef symbol = first transfinite cardinal,U+2135 NEW -->
    , // <!-- alef symbol is NOT the same as hebrew letter alef,U+05D0 although the
    // same glyph could be used to depict both characters -->
    // <!-- Arrows -->
    new String[]{ "←", "&larr;" }// leftwards arrow, U+2190 ISOnum -->
    // leftwards arrow, U+2190 ISOnum -->
    // leftwards arrow, U+2190 ISOnum -->
    , new String[]{ "↑", "&uarr;" }// upwards arrow, U+2191 ISOnum-->
    // upwards arrow, U+2191 ISOnum-->
    // upwards arrow, U+2191 ISOnum-->
    , new String[]{ "→", "&rarr;" }// rightwards arrow, U+2192 ISOnum -->
    // rightwards arrow, U+2192 ISOnum -->
    // rightwards arrow, U+2192 ISOnum -->
    , new String[]{ "↓", "&darr;" }// downwards arrow, U+2193 ISOnum -->
    // downwards arrow, U+2193 ISOnum -->
    // downwards arrow, U+2193 ISOnum -->
    , new String[]{ "↔", "&harr;" }// left right arrow, U+2194 ISOamsa -->
    // left right arrow, U+2194 ISOamsa -->
    // left right arrow, U+2194 ISOamsa -->
    , new String[]{ "↵", "&crarr;" }// downwards arrow with corner leftwards= carriage return, U+21B5 NEW -->
    // downwards arrow with corner leftwards= carriage return, U+21B5 NEW -->
    // downwards arrow with corner leftwards= carriage return, U+21B5 NEW -->
    , new String[]{ "⇐", "&lArr;" }// leftwards double arrow, U+21D0 ISOtech -->
    // leftwards double arrow, U+21D0 ISOtech -->
    // leftwards double arrow, U+21D0 ISOtech -->
    , // <!-- ISO 10646 does not say that lArr is the same as the 'is implied by'
    // arrow but also does not have any other character for that function.
    // So ? lArr canbe used for 'is implied by' as ISOtech suggests -->
    new String[]{ "⇑", "&uArr;" }// upwards double arrow, U+21D1 ISOamsa -->
    // upwards double arrow, U+21D1 ISOamsa -->
    // upwards double arrow, U+21D1 ISOamsa -->
    , new String[]{ "⇒", "&rArr;" }// rightwards double arrow,U+21D2 ISOtech -->
    // rightwards double arrow,U+21D2 ISOtech -->
    // rightwards double arrow,U+21D2 ISOtech -->
    , // <!-- ISO 10646 does not say this is the 'implies' character but does not
    // have another character with this function so ?rArr can be used for
    // 'implies' as ISOtech suggests -->
    new String[]{ "⇓", "&dArr;" }// downwards double arrow, U+21D3 ISOamsa -->
    // downwards double arrow, U+21D3 ISOamsa -->
    // downwards double arrow, U+21D3 ISOamsa -->
    , new String[]{ "⇔", "&hArr;" }// left right double arrow,U+21D4 ISOamsa -->
    // left right double arrow,U+21D4 ISOamsa -->
    // left right double arrow,U+21D4 ISOamsa -->
    , // <!-- Mathematical Operators -->
    new String[]{ "∀", "&forall;" }// for all, U+2200 ISOtech -->
    // for all, U+2200 ISOtech -->
    // for all, U+2200 ISOtech -->
    , new String[]{ "∂", "&part;" }// partial differential, U+2202 ISOtech -->
    // partial differential, U+2202 ISOtech -->
    // partial differential, U+2202 ISOtech -->
    , new String[]{ "∃", "&exist;" }// there exists, U+2203 ISOtech -->
    // there exists, U+2203 ISOtech -->
    // there exists, U+2203 ISOtech -->
    , new String[]{ "∅", "&empty;" }// empty set = null set = diameter,U+2205 ISOamso -->
    // empty set = null set = diameter,U+2205 ISOamso -->
    // empty set = null set = diameter,U+2205 ISOamso -->
    , new String[]{ "∇", "&nabla;" }// nabla = backward difference,U+2207 ISOtech -->
    // nabla = backward difference,U+2207 ISOtech -->
    // nabla = backward difference,U+2207 ISOtech -->
    , new String[]{ "∈", "&isin;" }// element of, U+2208 ISOtech -->
    // element of, U+2208 ISOtech -->
    // element of, U+2208 ISOtech -->
    , new String[]{ "∉", "&notin;" }// not an element of, U+2209 ISOtech -->
    // not an element of, U+2209 ISOtech -->
    // not an element of, U+2209 ISOtech -->
    , new String[]{ "∋", "&ni;" }// contains as member, U+220B ISOtech -->
    // contains as member, U+220B ISOtech -->
    // contains as member, U+220B ISOtech -->
    , // <!-- should there be a more memorable name than 'ni'? -->
    new String[]{ "∏", "&prod;" }// n-ary product = product sign,U+220F ISOamsb -->
    // n-ary product = product sign,U+220F ISOamsb -->
    // n-ary product = product sign,U+220F ISOamsb -->
    , // <!-- prod is NOT the same character as U+03A0 'greek capital letter pi'
    // though the same glyph might be used for both -->
    new String[]{ "∑", "&sum;" }// n-ary summation, U+2211 ISOamsb -->
    // n-ary summation, U+2211 ISOamsb -->
    // n-ary summation, U+2211 ISOamsb -->
    , // <!-- sum is NOT the same character as U+03A3 'greek capital letter sigma'
    // though the same glyph might be used for both -->
    new String[]{ "™", "&minus;" }// minus sign, U+2212 ISOtech -->
    // minus sign, U+2212 ISOtech -->
    // minus sign, U+2212 ISOtech -->
    , new String[]{ "∗", "&lowast;" }// asterisk operator, U+2217 ISOtech -->
    // asterisk operator, U+2217 ISOtech -->
    // asterisk operator, U+2217 ISOtech -->
    , new String[]{ "√", "&radic;" }// square root = radical sign,U+221A ISOtech -->
    // square root = radical sign,U+221A ISOtech -->
    // square root = radical sign,U+221A ISOtech -->
    , new String[]{ "∝", "&prop;" }// proportional to, U+221D ISOtech -->
    // proportional to, U+221D ISOtech -->
    // proportional to, U+221D ISOtech -->
    , new String[]{ "∞", "&infin;" }// infinity, U+221E ISOtech -->
    // infinity, U+221E ISOtech -->
    // infinity, U+221E ISOtech -->
    , new String[]{ "∠", "&ang;" }// angle, U+2220 ISOamso -->
    // angle, U+2220 ISOamso -->
    // angle, U+2220 ISOamso -->
    , new String[]{ "∧", "&and;" }// logical and = wedge, U+2227 ISOtech -->
    // logical and = wedge, U+2227 ISOtech -->
    // logical and = wedge, U+2227 ISOtech -->
    , new String[]{ "∨", "&or;" }// logical or = vee, U+2228 ISOtech -->
    // logical or = vee, U+2228 ISOtech -->
    // logical or = vee, U+2228 ISOtech -->
    , new String[]{ "∩", "&cap;" }// intersection = cap, U+2229 ISOtech -->
    // intersection = cap, U+2229 ISOtech -->
    // intersection = cap, U+2229 ISOtech -->
    , new String[]{ "∪", "&cup;" }// union = cup, U+222A ISOtech -->
    // union = cup, U+222A ISOtech -->
    // union = cup, U+222A ISOtech -->
    , new String[]{ "∫", "&int;" }// integral, U+222B ISOtech -->
    // integral, U+222B ISOtech -->
    // integral, U+222B ISOtech -->
    , new String[]{ "∴", "&there4;" }// therefore, U+2234 ISOtech -->
    // therefore, U+2234 ISOtech -->
    // therefore, U+2234 ISOtech -->
    , new String[]{ "∼", "&sim;" }// tilde operator = varies with = similar to,U+223C ISOtech -->
    // tilde operator = varies with = similar to,U+223C ISOtech -->
    // tilde operator = varies with = similar to,U+223C ISOtech -->
    , // <!-- tilde operator is NOT the same character as the tilde, U+007E,although
    // the same glyph might be used to represent both -->
    new String[]{ "≅", "&cong;" }// approximately equal to, U+2245 ISOtech -->
    // approximately equal to, U+2245 ISOtech -->
    // approximately equal to, U+2245 ISOtech -->
    , new String[]{ "≈", "&asymp;" }// almost equal to = asymptotic to,U+2248 ISOamsr -->
    // almost equal to = asymptotic to,U+2248 ISOamsr -->
    // almost equal to = asymptotic to,U+2248 ISOamsr -->
    , new String[]{ "≠", "&ne;" }// not equal to, U+2260 ISOtech -->
    // not equal to, U+2260 ISOtech -->
    // not equal to, U+2260 ISOtech -->
    , new String[]{ "≡", "&equiv;" }// identical to, U+2261 ISOtech -->
    // identical to, U+2261 ISOtech -->
    // identical to, U+2261 ISOtech -->
    , new String[]{ "≤", "&le;" }// less-than or equal to, U+2264 ISOtech -->
    // less-than or equal to, U+2264 ISOtech -->
    // less-than or equal to, U+2264 ISOtech -->
    , new String[]{ "≥", "&ge;" }// greater-than or equal to,U+2265 ISOtech -->
    // greater-than or equal to,U+2265 ISOtech -->
    // greater-than or equal to,U+2265 ISOtech -->
    , new String[]{ "⊂", "&sub;" }// subset of, U+2282 ISOtech -->
    // subset of, U+2282 ISOtech -->
    // subset of, U+2282 ISOtech -->
    , new String[]{ "⊃", "&sup;" }// superset of, U+2283 ISOtech -->
    // superset of, U+2283 ISOtech -->
    // superset of, U+2283 ISOtech -->
    , // <!-- note that nsup, 'not a superset of, U+2283' is not covered by the
    // Symbol font encoding and is not included. Should it be, for symmetry?
    // It is in ISOamsn --> <!ENTITY nsub", "8836"},
    // not a subset of, U+2284 ISOamsn -->
    new String[]{ "⊆", "&sube;" }// subset of or equal to, U+2286 ISOtech -->
    // subset of or equal to, U+2286 ISOtech -->
    // subset of or equal to, U+2286 ISOtech -->
    , new String[]{ "⊇", "&supe;" }// superset of or equal to,U+2287 ISOtech -->
    // superset of or equal to,U+2287 ISOtech -->
    // superset of or equal to,U+2287 ISOtech -->
    , new String[]{ "⊕", "&oplus;" }// circled plus = direct sum,U+2295 ISOamsb -->
    // circled plus = direct sum,U+2295 ISOamsb -->
    // circled plus = direct sum,U+2295 ISOamsb -->
    , new String[]{ "⊗", "&otimes;" }// circled times = vector product,U+2297 ISOamsb -->
    // circled times = vector product,U+2297 ISOamsb -->
    // circled times = vector product,U+2297 ISOamsb -->
    , new String[]{ "⊥", "&perp;" }// up tack = orthogonal to = perpendicular,U+22A5 ISOtech -->
    // up tack = orthogonal to = perpendicular,U+22A5 ISOtech -->
    // up tack = orthogonal to = perpendicular,U+22A5 ISOtech -->
    , new String[]{ "⋅", "&sdot;" }// dot operator, U+22C5 ISOamsb -->
    // dot operator, U+22C5 ISOamsb -->
    // dot operator, U+22C5 ISOamsb -->
    , // <!-- dot operator is NOT the same character as U+00B7 middle dot -->
    // <!-- Miscellaneous Technical -->
    new String[]{ "⌈", "&lceil;" }// left ceiling = apl upstile,U+2308 ISOamsc -->
    // left ceiling = apl upstile,U+2308 ISOamsc -->
    // left ceiling = apl upstile,U+2308 ISOamsc -->
    , new String[]{ "⌉", "&rceil;" }// right ceiling, U+2309 ISOamsc -->
    // right ceiling, U+2309 ISOamsc -->
    // right ceiling, U+2309 ISOamsc -->
    , new String[]{ "⌊", "&lfloor;" }// left floor = apl downstile,U+230A ISOamsc -->
    // left floor = apl downstile,U+230A ISOamsc -->
    // left floor = apl downstile,U+230A ISOamsc -->
    , new String[]{ "⌋", "&rfloor;" }// right floor, U+230B ISOamsc -->
    // right floor, U+230B ISOamsc -->
    // right floor, U+230B ISOamsc -->
    , new String[]{ "〈", "&lang;" }// left-pointing angle bracket = bra,U+2329 ISOtech -->
    // left-pointing angle bracket = bra,U+2329 ISOtech -->
    // left-pointing angle bracket = bra,U+2329 ISOtech -->
    , // <!-- lang is NOT the same character as U+003C 'less than' or U+2039 'single left-pointing angle quotation
    // mark' -->
    new String[]{ "〉", "&rang;" }// right-pointing angle bracket = ket,U+232A ISOtech -->
    // right-pointing angle bracket = ket,U+232A ISOtech -->
    // right-pointing angle bracket = ket,U+232A ISOtech -->
    , // <!-- rang is NOT the same character as U+003E 'greater than' or U+203A
    // 'single right-pointing angle quotation mark' -->
    // <!-- Geometric Shapes -->
    new String[]{ "◊", "&loz;" }// lozenge, U+25CA ISOpub -->
    // lozenge, U+25CA ISOpub -->
    // lozenge, U+25CA ISOpub -->
    , // <!-- Miscellaneous Symbols -->
    new String[]{ "♠", "&spades;" }// black spade suit, U+2660 ISOpub -->
    // black spade suit, U+2660 ISOpub -->
    // black spade suit, U+2660 ISOpub -->
    , // <!-- black here seems to mean filled as opposed to hollow -->
    new String[]{ "♣", "&clubs;" }// black club suit = shamrock,U+2663 ISOpub -->
    // black club suit = shamrock,U+2663 ISOpub -->
    // black club suit = shamrock,U+2663 ISOpub -->
    , new String[]{ "♥", "&hearts;" }// black heart suit = valentine,U+2665 ISOpub -->
    // black heart suit = valentine,U+2665 ISOpub -->
    // black heart suit = valentine,U+2665 ISOpub -->
    , new String[]{ "♦", "&diams;" }// black diamond suit, U+2666 ISOpub -->
    // black diamond suit, U+2666 ISOpub -->
    // black diamond suit, U+2666 ISOpub -->
    , // <!-- Latin Extended-A -->
    new String[]{ "Œ", "&OElig;" }// -- latin capital ligature OE,U+0152 ISOlat2 -->
    // -- latin capital ligature OE,U+0152 ISOlat2 -->
    // -- latin capital ligature OE,U+0152 ISOlat2 -->
    , new String[]{ "œ", "&oelig;" }// -- latin small ligature oe, U+0153 ISOlat2 -->
    // -- latin small ligature oe, U+0153 ISOlat2 -->
    // -- latin small ligature oe, U+0153 ISOlat2 -->
    , // <!-- ligature is a misnomer, this is a separate character in some languages -->
    new String[]{ "Š", "&Scaron;" }// -- latin capital letter S with caron,U+0160 ISOlat2 -->
    // -- latin capital letter S with caron,U+0160 ISOlat2 -->
    // -- latin capital letter S with caron,U+0160 ISOlat2 -->
    , new String[]{ "š", "&scaron;" }// -- latin small letter s with caron,U+0161 ISOlat2 -->
    // -- latin small letter s with caron,U+0161 ISOlat2 -->
    // -- latin small letter s with caron,U+0161 ISOlat2 -->
    , new String[]{ "Ÿ", "&Yuml;" }// -- latin capital letter Y with diaeresis,U+0178 ISOlat2 -->
    // -- latin capital letter Y with diaeresis,U+0178 ISOlat2 -->
    // -- latin capital letter Y with diaeresis,U+0178 ISOlat2 -->
    , // <!-- Spacing Modifier Letters -->
    new String[]{ "ˆ", "&circ;" }// -- modifier letter circumflex accent,U+02C6 ISOpub -->
    // -- modifier letter circumflex accent,U+02C6 ISOpub -->
    // -- modifier letter circumflex accent,U+02C6 ISOpub -->
    , new String[]{ "˜", "&tilde;" }// small tilde, U+02DC ISOdia -->
    // small tilde, U+02DC ISOdia -->
    // small tilde, U+02DC ISOdia -->
    , // <!-- General Punctuation -->
    new String[]{ " ", "&ensp;" }// en space, U+2002 ISOpub -->
    // en space, U+2002 ISOpub -->
    // en space, U+2002 ISOpub -->
    , new String[]{ " ", "&emsp;" }// em space, U+2003 ISOpub -->
    // em space, U+2003 ISOpub -->
    // em space, U+2003 ISOpub -->
    , new String[]{ " ", "&thinsp;" }// thin space, U+2009 ISOpub -->
    // thin space, U+2009 ISOpub -->
    // thin space, U+2009 ISOpub -->
    , new String[]{ "‌", "&zwnj;" }// zero width non-joiner,U+200C NEW RFC 2070 -->
    // zero width non-joiner,U+200C NEW RFC 2070 -->
    // zero width non-joiner,U+200C NEW RFC 2070 -->
    , new String[]{ "‍", "&zwj;" }// zero width joiner, U+200D NEW RFC 2070 -->
    // zero width joiner, U+200D NEW RFC 2070 -->
    // zero width joiner, U+200D NEW RFC 2070 -->
    , new String[]{ "‎", "&lrm;" }// left-to-right mark, U+200E NEW RFC 2070 -->
    // left-to-right mark, U+200E NEW RFC 2070 -->
    // left-to-right mark, U+200E NEW RFC 2070 -->
    , new String[]{ "‏", "&rlm;" }// right-to-left mark, U+200F NEW RFC 2070 -->
    // right-to-left mark, U+200F NEW RFC 2070 -->
    // right-to-left mark, U+200F NEW RFC 2070 -->
    , new String[]{ "–", "&ndash;" }// en dash, U+2013 ISOpub -->
    // en dash, U+2013 ISOpub -->
    // en dash, U+2013 ISOpub -->
    , new String[]{ "—", "&mdash;" }// em dash, U+2014 ISOpub -->
    // em dash, U+2014 ISOpub -->
    // em dash, U+2014 ISOpub -->
    , new String[]{ "‘", "&lsquo;" }// left single quotation mark,U+2018 ISOnum -->
    // left single quotation mark,U+2018 ISOnum -->
    // left single quotation mark,U+2018 ISOnum -->
    , new String[]{ "’", "&rsquo;" }// right single quotation mark,U+2019 ISOnum -->
    // right single quotation mark,U+2019 ISOnum -->
    // right single quotation mark,U+2019 ISOnum -->
    , new String[]{ "‚", "&sbquo;" }// single low-9 quotation mark, U+201A NEW -->
    // single low-9 quotation mark, U+201A NEW -->
    // single low-9 quotation mark, U+201A NEW -->
    , new String[]{ "“", "&ldquo;" }// left double quotation mark,U+201C ISOnum -->
    // left double quotation mark,U+201C ISOnum -->
    // left double quotation mark,U+201C ISOnum -->
    , new String[]{ "”", "&rdquo;" }// right double quotation mark,U+201D ISOnum -->
    // right double quotation mark,U+201D ISOnum -->
    // right double quotation mark,U+201D ISOnum -->
    , new String[]{ "„", "&bdquo;" }// double low-9 quotation mark, U+201E NEW -->
    // double low-9 quotation mark, U+201E NEW -->
    // double low-9 quotation mark, U+201E NEW -->
    , new String[]{ "†", "&dagger;" }// dagger, U+2020 ISOpub -->
    // dagger, U+2020 ISOpub -->
    // dagger, U+2020 ISOpub -->
    , new String[]{ "‡", "&Dagger;" }// double dagger, U+2021 ISOpub -->
    // double dagger, U+2021 ISOpub -->
    // double dagger, U+2021 ISOpub -->
    , new String[]{ "‰", "&permil;" }// per mille sign, U+2030 ISOtech -->
    // per mille sign, U+2030 ISOtech -->
    // per mille sign, U+2030 ISOtech -->
    , new String[]{ "‹", "&lsaquo;" }// single left-pointing angle quotation mark,U+2039 ISO proposed -->
    // single left-pointing angle quotation mark,U+2039 ISO proposed -->
    // single left-pointing angle quotation mark,U+2039 ISO proposed -->
    , // <!-- lsaquo is proposed but not yet ISO standardized -->
    new String[]{ "›", "&rsaquo;" }// single right-pointing angle quotation mark,U+203A ISO proposed -->
    // single right-pointing angle quotation mark,U+203A ISO proposed -->
    // single right-pointing angle quotation mark,U+203A ISO proposed -->
    , // <!-- rsaquo is proposed but not yet ISO standardized -->
    new String[]{ "€", "&euro;" }// -- euro sign, U+20AC NEW -->
    // -- euro sign, U+20AC NEW -->
    // -- euro sign, U+20AC NEW -->
     };

    public static String[][] HTML40_EXTENDED_UNESCAPE() {
        return HTML40_EXTENDED_UNESCAPE.clone();
    }

    private static final String[][] HTML40_EXTENDED_UNESCAPE = invert(HTML40_EXTENDED_ESCAPE);

    public static String[][] BASIC_ESCAPE() {
        return BASIC_ESCAPE.clone();
    }

    private static final String[][] BASIC_ESCAPE = new String[][]{ new String[]{ "\"", "&quot;" }// " - double-quote
    // " - double-quote
    // " - double-quote
    , new String[]{ "&", "&amp;" }// & - ampersand
    // & - ampersand
    // & - ampersand
    , new String[]{ "<", "&lt;" }// < - less-than
    // < - less-than
    // < - less-than
    , new String[]{ ">", "&gt;" }// > - greater-than
    // > - greater-than
    // > - greater-than
     };

    public static String[][] BASIC_UNESCAPE() {
        return BASIC_UNESCAPE.clone();
    }

    private static final String[][] BASIC_UNESCAPE = invert(BASIC_ESCAPE);

    public static String[][] APOS_ESCAPE() {
        return APOS_ESCAPE.clone();
    }

    private static final String[][] APOS_ESCAPE = new String[][]{ new String[]{ "'", "&apos;" }// XML apostrophe
    // XML apostrophe
    // XML apostrophe
     };

    public static String[][] APOS_UNESCAPE() {
        return APOS_UNESCAPE.clone();
    }

    private static final String[][] APOS_UNESCAPE = invert(APOS_ESCAPE);

    public static String[][] JAVA_CTRL_CHARS_ESCAPE() {
        return JAVA_CTRL_CHARS_ESCAPE.clone();
    }

    private static final String[][] JAVA_CTRL_CHARS_ESCAPE = new String[][]{ new String[]{ "\b", "\\b" }, new String[]{ "\n", "\\n" }, new String[]{ "\t", "\\t" }, new String[]{ "\f", "\\f" }, new String[]{ "\r", "\\r" } };

    public static String[][] JAVA_CTRL_CHARS_UNESCAPE() {
        return JAVA_CTRL_CHARS_UNESCAPE.clone();
    }

    private static final String[][] JAVA_CTRL_CHARS_UNESCAPE = invert(JAVA_CTRL_CHARS_ESCAPE);

    /**
     * Used to invert an escape array into an unescape array
     *
     * @param array
     * 		String[][] to be inverted
     * @return String[][] inverted array
     */
    public static String[][] invert(String[][] array) {
        String[][] newarray = new String[array.length][2];
        for (int i = 0; i < array.length; i++) {
            newarray[i][0] = array[i][1];
            newarray[i][1] = array[i][0];
        }
        return newarray;
    }
}