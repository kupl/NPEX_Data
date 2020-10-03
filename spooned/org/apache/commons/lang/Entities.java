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
package org.apache.commons.lang;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * <p>Provides HTML and XML entity utilities.</p>
 *
 * @see <a href="http://hotwired.lycos.com/webmonkey/reference/special_characters/">ISO Entities</a>
 * @see <a href="http://www.w3.org/TR/REC-html32#latin1">HTML 3.2 Character Entities for ISO Latin-1</a>
 * @see <a href="http://www.w3.org/TR/REC-html40/sgml/entities.html">HTML 4.0 Character entity references</a>
 * @see <a href="http://www.w3.org/TR/html401/charset.html#h-5.3">HTML 4.01 Character References</a>
 * @see <a href="http://www.w3.org/TR/html401/charset.html#code-position">HTML 4.01 Code positions</a>
 * @author <a href="mailto:alex@purpletech.com">Alexander Day Chaffee</a>
 * @author <a href="mailto:ggregory@seagullsw.com">Gary Gregory</a>
 * @since 2.0
 * @version $Id: Entities.java 469661 2006-10-31 21:34:03Z bayard $
 */
class Entities {
    private static final String[][] BASIC_ARRAY = new String[][]{ new String[]{ "quot", "34" }// " - double-quote
    // " - double-quote
    // " - double-quote
    , new String[]{ "amp", "38" }// & - ampersand
    // & - ampersand
    // & - ampersand
    , new String[]{ "lt", "60" }// < - less-than
    // < - less-than
    // < - less-than
    , new String[]{ "gt", "62" }// > - greater-than
    // > - greater-than
    // > - greater-than
     };

    private static final String[][] APOS_ARRAY = new String[][]{ new String[]{ "apos", "39" }// XML apostrophe
    // XML apostrophe
    // XML apostrophe
     };

    // package scoped for testing
    static final String[][] ISO8859_1_ARRAY = new String[][]{ new String[]{ "nbsp", "160" }// non-breaking space
    // non-breaking space
    // non-breaking space
    , new String[]{ "iexcl", "161" }// inverted exclamation mark
    // inverted exclamation mark
    // inverted exclamation mark
    , new String[]{ "cent", "162" }// cent sign
    // cent sign
    // cent sign
    , new String[]{ "pound", "163" }// pound sign
    // pound sign
    // pound sign
    , new String[]{ "curren", "164" }// currency sign
    // currency sign
    // currency sign
    , new String[]{ "yen", "165" }// yen sign = yuan sign
    // yen sign = yuan sign
    // yen sign = yuan sign
    , new String[]{ "brvbar", "166" }// broken bar = broken vertical bar
    // broken bar = broken vertical bar
    // broken bar = broken vertical bar
    , new String[]{ "sect", "167" }// section sign
    // section sign
    // section sign
    , new String[]{ "uml", "168" }// diaeresis = spacing diaeresis
    // diaeresis = spacing diaeresis
    // diaeresis = spacing diaeresis
    , new String[]{ "copy", "169" }// � - copyright sign
    // � - copyright sign
    // � - copyright sign
    , new String[]{ "ordf", "170" }// feminine ordinal indicator
    // feminine ordinal indicator
    // feminine ordinal indicator
    , new String[]{ "laquo", "171" }// left-pointing double angle quotation mark = left pointing guillemet
    // left-pointing double angle quotation mark = left pointing guillemet
    // left-pointing double angle quotation mark = left pointing guillemet
    , new String[]{ "not", "172" }// not sign
    // not sign
    // not sign
    , new String[]{ "shy", "173" }// soft hyphen = discretionary hyphen
    // soft hyphen = discretionary hyphen
    // soft hyphen = discretionary hyphen
    , new String[]{ "reg", "174" }// � - registered trademark sign
    // � - registered trademark sign
    // � - registered trademark sign
    , new String[]{ "macr", "175" }// macron = spacing macron = overline = APL overbar
    // macron = spacing macron = overline = APL overbar
    // macron = spacing macron = overline = APL overbar
    , new String[]{ "deg", "176" }// degree sign
    // degree sign
    // degree sign
    , new String[]{ "plusmn", "177" }// plus-minus sign = plus-or-minus sign
    // plus-minus sign = plus-or-minus sign
    // plus-minus sign = plus-or-minus sign
    , new String[]{ "sup2", "178" }// superscript two = superscript digit two = squared
    // superscript two = superscript digit two = squared
    // superscript two = superscript digit two = squared
    , new String[]{ "sup3", "179" }// superscript three = superscript digit three = cubed
    // superscript three = superscript digit three = cubed
    // superscript three = superscript digit three = cubed
    , new String[]{ "acute", "180" }// acute accent = spacing acute
    // acute accent = spacing acute
    // acute accent = spacing acute
    , new String[]{ "micro", "181" }// micro sign
    // micro sign
    // micro sign
    , new String[]{ "para", "182" }// pilcrow sign = paragraph sign
    // pilcrow sign = paragraph sign
    // pilcrow sign = paragraph sign
    , new String[]{ "middot", "183" }// middle dot = Georgian comma = Greek middle dot
    // middle dot = Georgian comma = Greek middle dot
    // middle dot = Georgian comma = Greek middle dot
    , new String[]{ "cedil", "184" }// cedilla = spacing cedilla
    // cedilla = spacing cedilla
    // cedilla = spacing cedilla
    , new String[]{ "sup1", "185" }// superscript one = superscript digit one
    // superscript one = superscript digit one
    // superscript one = superscript digit one
    , new String[]{ "ordm", "186" }// masculine ordinal indicator
    // masculine ordinal indicator
    // masculine ordinal indicator
    , new String[]{ "raquo", "187" }// right-pointing double angle quotation mark = right pointing guillemet
    // right-pointing double angle quotation mark = right pointing guillemet
    // right-pointing double angle quotation mark = right pointing guillemet
    , new String[]{ "frac14", "188" }// vulgar fraction one quarter = fraction one quarter
    // vulgar fraction one quarter = fraction one quarter
    // vulgar fraction one quarter = fraction one quarter
    , new String[]{ "frac12", "189" }// vulgar fraction one half = fraction one half
    // vulgar fraction one half = fraction one half
    // vulgar fraction one half = fraction one half
    , new String[]{ "frac34", "190" }// vulgar fraction three quarters = fraction three quarters
    // vulgar fraction three quarters = fraction three quarters
    // vulgar fraction three quarters = fraction three quarters
    , new String[]{ "iquest", "191" }// inverted question mark = turned question mark
    // inverted question mark = turned question mark
    // inverted question mark = turned question mark
    , new String[]{ "Agrave", "192" }// � - uppercase A, grave accent
    // � - uppercase A, grave accent
    // � - uppercase A, grave accent
    , new String[]{ "Aacute", "193" }// � - uppercase A, acute accent
    // � - uppercase A, acute accent
    // � - uppercase A, acute accent
    , new String[]{ "Acirc", "194" }// � - uppercase A, circumflex accent
    // � - uppercase A, circumflex accent
    // � - uppercase A, circumflex accent
    , new String[]{ "Atilde", "195" }// � - uppercase A, tilde
    // � - uppercase A, tilde
    // � - uppercase A, tilde
    , new String[]{ "Auml", "196" }// � - uppercase A, umlaut
    // � - uppercase A, umlaut
    // � - uppercase A, umlaut
    , new String[]{ "Aring", "197" }// � - uppercase A, ring
    // � - uppercase A, ring
    // � - uppercase A, ring
    , new String[]{ "AElig", "198" }// � - uppercase AE
    // � - uppercase AE
    // � - uppercase AE
    , new String[]{ "Ccedil", "199" }// � - uppercase C, cedilla
    // � - uppercase C, cedilla
    // � - uppercase C, cedilla
    , new String[]{ "Egrave", "200" }// � - uppercase E, grave accent
    // � - uppercase E, grave accent
    // � - uppercase E, grave accent
    , new String[]{ "Eacute", "201" }// � - uppercase E, acute accent
    // � - uppercase E, acute accent
    // � - uppercase E, acute accent
    , new String[]{ "Ecirc", "202" }// � - uppercase E, circumflex accent
    // � - uppercase E, circumflex accent
    // � - uppercase E, circumflex accent
    , new String[]{ "Euml", "203" }// � - uppercase E, umlaut
    // � - uppercase E, umlaut
    // � - uppercase E, umlaut
    , new String[]{ "Igrave", "204" }// � - uppercase I, grave accent
    // � - uppercase I, grave accent
    // � - uppercase I, grave accent
    , new String[]{ "Iacute", "205" }// � - uppercase I, acute accent
    // � - uppercase I, acute accent
    // � - uppercase I, acute accent
    , new String[]{ "Icirc", "206" }// � - uppercase I, circumflex accent
    // � - uppercase I, circumflex accent
    // � - uppercase I, circumflex accent
    , new String[]{ "Iuml", "207" }// � - uppercase I, umlaut
    // � - uppercase I, umlaut
    // � - uppercase I, umlaut
    , new String[]{ "ETH", "208" }// � - uppercase Eth, Icelandic
    // � - uppercase Eth, Icelandic
    // � - uppercase Eth, Icelandic
    , new String[]{ "Ntilde", "209" }// � - uppercase N, tilde
    // � - uppercase N, tilde
    // � - uppercase N, tilde
    , new String[]{ "Ograve", "210" }// � - uppercase O, grave accent
    // � - uppercase O, grave accent
    // � - uppercase O, grave accent
    , new String[]{ "Oacute", "211" }// � - uppercase O, acute accent
    // � - uppercase O, acute accent
    // � - uppercase O, acute accent
    , new String[]{ "Ocirc", "212" }// � - uppercase O, circumflex accent
    // � - uppercase O, circumflex accent
    // � - uppercase O, circumflex accent
    , new String[]{ "Otilde", "213" }// � - uppercase O, tilde
    // � - uppercase O, tilde
    // � - uppercase O, tilde
    , new String[]{ "Ouml", "214" }// � - uppercase O, umlaut
    // � - uppercase O, umlaut
    // � - uppercase O, umlaut
    , new String[]{ "times", "215" }// multiplication sign
    // multiplication sign
    // multiplication sign
    , new String[]{ "Oslash", "216" }// � - uppercase O, slash
    // � - uppercase O, slash
    // � - uppercase O, slash
    , new String[]{ "Ugrave", "217" }// � - uppercase U, grave accent
    // � - uppercase U, grave accent
    // � - uppercase U, grave accent
    , new String[]{ "Uacute", "218" }// � - uppercase U, acute accent
    // � - uppercase U, acute accent
    // � - uppercase U, acute accent
    , new String[]{ "Ucirc", "219" }// � - uppercase U, circumflex accent
    // � - uppercase U, circumflex accent
    // � - uppercase U, circumflex accent
    , new String[]{ "Uuml", "220" }// � - uppercase U, umlaut
    // � - uppercase U, umlaut
    // � - uppercase U, umlaut
    , new String[]{ "Yacute", "221" }// � - uppercase Y, acute accent
    // � - uppercase Y, acute accent
    // � - uppercase Y, acute accent
    , new String[]{ "THORN", "222" }// � - uppercase THORN, Icelandic
    // � - uppercase THORN, Icelandic
    // � - uppercase THORN, Icelandic
    , new String[]{ "szlig", "223" }// � - lowercase sharps, German
    // � - lowercase sharps, German
    // � - lowercase sharps, German
    , new String[]{ "agrave", "224" }// � - lowercase a, grave accent
    // � - lowercase a, grave accent
    // � - lowercase a, grave accent
    , new String[]{ "aacute", "225" }// � - lowercase a, acute accent
    // � - lowercase a, acute accent
    // � - lowercase a, acute accent
    , new String[]{ "acirc", "226" }// � - lowercase a, circumflex accent
    // � - lowercase a, circumflex accent
    // � - lowercase a, circumflex accent
    , new String[]{ "atilde", "227" }// � - lowercase a, tilde
    // � - lowercase a, tilde
    // � - lowercase a, tilde
    , new String[]{ "auml", "228" }// � - lowercase a, umlaut
    // � - lowercase a, umlaut
    // � - lowercase a, umlaut
    , new String[]{ "aring", "229" }// � - lowercase a, ring
    // � - lowercase a, ring
    // � - lowercase a, ring
    , new String[]{ "aelig", "230" }// � - lowercase ae
    // � - lowercase ae
    // � - lowercase ae
    , new String[]{ "ccedil", "231" }// � - lowercase c, cedilla
    // � - lowercase c, cedilla
    // � - lowercase c, cedilla
    , new String[]{ "egrave", "232" }// � - lowercase e, grave accent
    // � - lowercase e, grave accent
    // � - lowercase e, grave accent
    , new String[]{ "eacute", "233" }// � - lowercase e, acute accent
    // � - lowercase e, acute accent
    // � - lowercase e, acute accent
    , new String[]{ "ecirc", "234" }// � - lowercase e, circumflex accent
    // � - lowercase e, circumflex accent
    // � - lowercase e, circumflex accent
    , new String[]{ "euml", "235" }// � - lowercase e, umlaut
    // � - lowercase e, umlaut
    // � - lowercase e, umlaut
    , new String[]{ "igrave", "236" }// � - lowercase i, grave accent
    // � - lowercase i, grave accent
    // � - lowercase i, grave accent
    , new String[]{ "iacute", "237" }// � - lowercase i, acute accent
    // � - lowercase i, acute accent
    // � - lowercase i, acute accent
    , new String[]{ "icirc", "238" }// � - lowercase i, circumflex accent
    // � - lowercase i, circumflex accent
    // � - lowercase i, circumflex accent
    , new String[]{ "iuml", "239" }// � - lowercase i, umlaut
    // � - lowercase i, umlaut
    // � - lowercase i, umlaut
    , new String[]{ "eth", "240" }// � - lowercase eth, Icelandic
    // � - lowercase eth, Icelandic
    // � - lowercase eth, Icelandic
    , new String[]{ "ntilde", "241" }// � - lowercase n, tilde
    // � - lowercase n, tilde
    // � - lowercase n, tilde
    , new String[]{ "ograve", "242" }// � - lowercase o, grave accent
    // � - lowercase o, grave accent
    // � - lowercase o, grave accent
    , new String[]{ "oacute", "243" }// � - lowercase o, acute accent
    // � - lowercase o, acute accent
    // � - lowercase o, acute accent
    , new String[]{ "ocirc", "244" }// � - lowercase o, circumflex accent
    // � - lowercase o, circumflex accent
    // � - lowercase o, circumflex accent
    , new String[]{ "otilde", "245" }// � - lowercase o, tilde
    // � - lowercase o, tilde
    // � - lowercase o, tilde
    , new String[]{ "ouml", "246" }// � - lowercase o, umlaut
    // � - lowercase o, umlaut
    // � - lowercase o, umlaut
    , new String[]{ "divide", "247" }// division sign
    // division sign
    // division sign
    , new String[]{ "oslash", "248" }// � - lowercase o, slash
    // � - lowercase o, slash
    // � - lowercase o, slash
    , new String[]{ "ugrave", "249" }// � - lowercase u, grave accent
    // � - lowercase u, grave accent
    // � - lowercase u, grave accent
    , new String[]{ "uacute", "250" }// � - lowercase u, acute accent
    // � - lowercase u, acute accent
    // � - lowercase u, acute accent
    , new String[]{ "ucirc", "251" }// � - lowercase u, circumflex accent
    // � - lowercase u, circumflex accent
    // � - lowercase u, circumflex accent
    , new String[]{ "uuml", "252" }// � - lowercase u, umlaut
    // � - lowercase u, umlaut
    // � - lowercase u, umlaut
    , new String[]{ "yacute", "253" }// � - lowercase y, acute accent
    // � - lowercase y, acute accent
    // � - lowercase y, acute accent
    , new String[]{ "thorn", "254" }// � - lowercase thorn, Icelandic
    // � - lowercase thorn, Icelandic
    // � - lowercase thorn, Icelandic
    , new String[]{ "yuml", "255" }// � - lowercase y, umlaut
    // � - lowercase y, umlaut
    // � - lowercase y, umlaut
     };

    // http://www.w3.org/TR/REC-html40/sgml/entities.html
    // package scoped for testing
    static final String[][] HTML40_ARRAY = new String[][]{ // <!-- Latin Extended-B -->
    new String[]{ "fnof", "402" }// latin small f with hook = function= florin, U+0192 ISOtech -->
    // latin small f with hook = function= florin, U+0192 ISOtech -->
    // latin small f with hook = function= florin, U+0192 ISOtech -->
    , // <!-- Greek -->
    new String[]{ "Alpha", "913" }// greek capital letter alpha, U+0391 -->
    // greek capital letter alpha, U+0391 -->
    // greek capital letter alpha, U+0391 -->
    , new String[]{ "Beta", "914" }// greek capital letter beta, U+0392 -->
    // greek capital letter beta, U+0392 -->
    // greek capital letter beta, U+0392 -->
    , new String[]{ "Gamma", "915" }// greek capital letter gamma,U+0393 ISOgrk3 -->
    // greek capital letter gamma,U+0393 ISOgrk3 -->
    // greek capital letter gamma,U+0393 ISOgrk3 -->
    , new String[]{ "Delta", "916" }// greek capital letter delta,U+0394 ISOgrk3 -->
    // greek capital letter delta,U+0394 ISOgrk3 -->
    // greek capital letter delta,U+0394 ISOgrk3 -->
    , new String[]{ "Epsilon", "917" }// greek capital letter epsilon, U+0395 -->
    // greek capital letter epsilon, U+0395 -->
    // greek capital letter epsilon, U+0395 -->
    , new String[]{ "Zeta", "918" }// greek capital letter zeta, U+0396 -->
    // greek capital letter zeta, U+0396 -->
    // greek capital letter zeta, U+0396 -->
    , new String[]{ "Eta", "919" }// greek capital letter eta, U+0397 -->
    // greek capital letter eta, U+0397 -->
    // greek capital letter eta, U+0397 -->
    , new String[]{ "Theta", "920" }// greek capital letter theta,U+0398 ISOgrk3 -->
    // greek capital letter theta,U+0398 ISOgrk3 -->
    // greek capital letter theta,U+0398 ISOgrk3 -->
    , new String[]{ "Iota", "921" }// greek capital letter iota, U+0399 -->
    // greek capital letter iota, U+0399 -->
    // greek capital letter iota, U+0399 -->
    , new String[]{ "Kappa", "922" }// greek capital letter kappa, U+039A -->
    // greek capital letter kappa, U+039A -->
    // greek capital letter kappa, U+039A -->
    , new String[]{ "Lambda", "923" }// greek capital letter lambda,U+039B ISOgrk3 -->
    // greek capital letter lambda,U+039B ISOgrk3 -->
    // greek capital letter lambda,U+039B ISOgrk3 -->
    , new String[]{ "Mu", "924" }// greek capital letter mu, U+039C -->
    // greek capital letter mu, U+039C -->
    // greek capital letter mu, U+039C -->
    , new String[]{ "Nu", "925" }// greek capital letter nu, U+039D -->
    // greek capital letter nu, U+039D -->
    // greek capital letter nu, U+039D -->
    , new String[]{ "Xi", "926" }// greek capital letter xi, U+039E ISOgrk3 -->
    // greek capital letter xi, U+039E ISOgrk3 -->
    // greek capital letter xi, U+039E ISOgrk3 -->
    , new String[]{ "Omicron", "927" }// greek capital letter omicron, U+039F -->
    // greek capital letter omicron, U+039F -->
    // greek capital letter omicron, U+039F -->
    , new String[]{ "Pi", "928" }// greek capital letter pi, U+03A0 ISOgrk3 -->
    // greek capital letter pi, U+03A0 ISOgrk3 -->
    // greek capital letter pi, U+03A0 ISOgrk3 -->
    , new String[]{ "Rho", "929" }// greek capital letter rho, U+03A1 -->
    // greek capital letter rho, U+03A1 -->
    // greek capital letter rho, U+03A1 -->
    , // <!-- there is no Sigmaf, and no U+03A2 character either -->
    new String[]{ "Sigma", "931" }// greek capital letter sigma,U+03A3 ISOgrk3 -->
    // greek capital letter sigma,U+03A3 ISOgrk3 -->
    // greek capital letter sigma,U+03A3 ISOgrk3 -->
    , new String[]{ "Tau", "932" }// greek capital letter tau, U+03A4 -->
    // greek capital letter tau, U+03A4 -->
    // greek capital letter tau, U+03A4 -->
    , new String[]{ "Upsilon", "933" }// greek capital letter upsilon,U+03A5 ISOgrk3 -->
    // greek capital letter upsilon,U+03A5 ISOgrk3 -->
    // greek capital letter upsilon,U+03A5 ISOgrk3 -->
    , new String[]{ "Phi", "934" }// greek capital letter phi,U+03A6 ISOgrk3 -->
    // greek capital letter phi,U+03A6 ISOgrk3 -->
    // greek capital letter phi,U+03A6 ISOgrk3 -->
    , new String[]{ "Chi", "935" }// greek capital letter chi, U+03A7 -->
    // greek capital letter chi, U+03A7 -->
    // greek capital letter chi, U+03A7 -->
    , new String[]{ "Psi", "936" }// greek capital letter psi,U+03A8 ISOgrk3 -->
    // greek capital letter psi,U+03A8 ISOgrk3 -->
    // greek capital letter psi,U+03A8 ISOgrk3 -->
    , new String[]{ "Omega", "937" }// greek capital letter omega,U+03A9 ISOgrk3 -->
    // greek capital letter omega,U+03A9 ISOgrk3 -->
    // greek capital letter omega,U+03A9 ISOgrk3 -->
    , new String[]{ "alpha", "945" }// greek small letter alpha,U+03B1 ISOgrk3 -->
    // greek small letter alpha,U+03B1 ISOgrk3 -->
    // greek small letter alpha,U+03B1 ISOgrk3 -->
    , new String[]{ "beta", "946" }// greek small letter beta, U+03B2 ISOgrk3 -->
    // greek small letter beta, U+03B2 ISOgrk3 -->
    // greek small letter beta, U+03B2 ISOgrk3 -->
    , new String[]{ "gamma", "947" }// greek small letter gamma,U+03B3 ISOgrk3 -->
    // greek small letter gamma,U+03B3 ISOgrk3 -->
    // greek small letter gamma,U+03B3 ISOgrk3 -->
    , new String[]{ "delta", "948" }// greek small letter delta,U+03B4 ISOgrk3 -->
    // greek small letter delta,U+03B4 ISOgrk3 -->
    // greek small letter delta,U+03B4 ISOgrk3 -->
    , new String[]{ "epsilon", "949" }// greek small letter epsilon,U+03B5 ISOgrk3 -->
    // greek small letter epsilon,U+03B5 ISOgrk3 -->
    // greek small letter epsilon,U+03B5 ISOgrk3 -->
    , new String[]{ "zeta", "950" }// greek small letter zeta, U+03B6 ISOgrk3 -->
    // greek small letter zeta, U+03B6 ISOgrk3 -->
    // greek small letter zeta, U+03B6 ISOgrk3 -->
    , new String[]{ "eta", "951" }// greek small letter eta, U+03B7 ISOgrk3 -->
    // greek small letter eta, U+03B7 ISOgrk3 -->
    // greek small letter eta, U+03B7 ISOgrk3 -->
    , new String[]{ "theta", "952" }// greek small letter theta,U+03B8 ISOgrk3 -->
    // greek small letter theta,U+03B8 ISOgrk3 -->
    // greek small letter theta,U+03B8 ISOgrk3 -->
    , new String[]{ "iota", "953" }// greek small letter iota, U+03B9 ISOgrk3 -->
    // greek small letter iota, U+03B9 ISOgrk3 -->
    // greek small letter iota, U+03B9 ISOgrk3 -->
    , new String[]{ "kappa", "954" }// greek small letter kappa,U+03BA ISOgrk3 -->
    // greek small letter kappa,U+03BA ISOgrk3 -->
    // greek small letter kappa,U+03BA ISOgrk3 -->
    , new String[]{ "lambda", "955" }// greek small letter lambda,U+03BB ISOgrk3 -->
    // greek small letter lambda,U+03BB ISOgrk3 -->
    // greek small letter lambda,U+03BB ISOgrk3 -->
    , new String[]{ "mu", "956" }// greek small letter mu, U+03BC ISOgrk3 -->
    // greek small letter mu, U+03BC ISOgrk3 -->
    // greek small letter mu, U+03BC ISOgrk3 -->
    , new String[]{ "nu", "957" }// greek small letter nu, U+03BD ISOgrk3 -->
    // greek small letter nu, U+03BD ISOgrk3 -->
    // greek small letter nu, U+03BD ISOgrk3 -->
    , new String[]{ "xi", "958" }// greek small letter xi, U+03BE ISOgrk3 -->
    // greek small letter xi, U+03BE ISOgrk3 -->
    // greek small letter xi, U+03BE ISOgrk3 -->
    , new String[]{ "omicron", "959" }// greek small letter omicron, U+03BF NEW -->
    // greek small letter omicron, U+03BF NEW -->
    // greek small letter omicron, U+03BF NEW -->
    , new String[]{ "pi", "960" }// greek small letter pi, U+03C0 ISOgrk3 -->
    // greek small letter pi, U+03C0 ISOgrk3 -->
    // greek small letter pi, U+03C0 ISOgrk3 -->
    , new String[]{ "rho", "961" }// greek small letter rho, U+03C1 ISOgrk3 -->
    // greek small letter rho, U+03C1 ISOgrk3 -->
    // greek small letter rho, U+03C1 ISOgrk3 -->
    , new String[]{ "sigmaf", "962" }// greek small letter final sigma,U+03C2 ISOgrk3 -->
    // greek small letter final sigma,U+03C2 ISOgrk3 -->
    // greek small letter final sigma,U+03C2 ISOgrk3 -->
    , new String[]{ "sigma", "963" }// greek small letter sigma,U+03C3 ISOgrk3 -->
    // greek small letter sigma,U+03C3 ISOgrk3 -->
    // greek small letter sigma,U+03C3 ISOgrk3 -->
    , new String[]{ "tau", "964" }// greek small letter tau, U+03C4 ISOgrk3 -->
    // greek small letter tau, U+03C4 ISOgrk3 -->
    // greek small letter tau, U+03C4 ISOgrk3 -->
    , new String[]{ "upsilon", "965" }// greek small letter upsilon,U+03C5 ISOgrk3 -->
    // greek small letter upsilon,U+03C5 ISOgrk3 -->
    // greek small letter upsilon,U+03C5 ISOgrk3 -->
    , new String[]{ "phi", "966" }// greek small letter phi, U+03C6 ISOgrk3 -->
    // greek small letter phi, U+03C6 ISOgrk3 -->
    // greek small letter phi, U+03C6 ISOgrk3 -->
    , new String[]{ "chi", "967" }// greek small letter chi, U+03C7 ISOgrk3 -->
    // greek small letter chi, U+03C7 ISOgrk3 -->
    // greek small letter chi, U+03C7 ISOgrk3 -->
    , new String[]{ "psi", "968" }// greek small letter psi, U+03C8 ISOgrk3 -->
    // greek small letter psi, U+03C8 ISOgrk3 -->
    // greek small letter psi, U+03C8 ISOgrk3 -->
    , new String[]{ "omega", "969" }// greek small letter omega,U+03C9 ISOgrk3 -->
    // greek small letter omega,U+03C9 ISOgrk3 -->
    // greek small letter omega,U+03C9 ISOgrk3 -->
    , new String[]{ "thetasym", "977" }// greek small letter theta symbol,U+03D1 NEW -->
    // greek small letter theta symbol,U+03D1 NEW -->
    // greek small letter theta symbol,U+03D1 NEW -->
    , new String[]{ "upsih", "978" }// greek upsilon with hook symbol,U+03D2 NEW -->
    // greek upsilon with hook symbol,U+03D2 NEW -->
    // greek upsilon with hook symbol,U+03D2 NEW -->
    , new String[]{ "piv", "982" }// greek pi symbol, U+03D6 ISOgrk3 -->
    // greek pi symbol, U+03D6 ISOgrk3 -->
    // greek pi symbol, U+03D6 ISOgrk3 -->
    , // <!-- General Punctuation -->
    new String[]{ "bull", "8226" }// bullet = black small circle,U+2022 ISOpub  -->
    // bullet = black small circle,U+2022 ISOpub  -->
    // bullet = black small circle,U+2022 ISOpub  -->
    , // <!-- bullet is NOT the same as bullet operator, U+2219 -->
    new String[]{ "hellip", "8230" }// horizontal ellipsis = three dot leader,U+2026 ISOpub  -->
    // horizontal ellipsis = three dot leader,U+2026 ISOpub  -->
    // horizontal ellipsis = three dot leader,U+2026 ISOpub  -->
    , new String[]{ "prime", "8242" }// prime = minutes = feet, U+2032 ISOtech -->
    // prime = minutes = feet, U+2032 ISOtech -->
    // prime = minutes = feet, U+2032 ISOtech -->
    , new String[]{ "Prime", "8243" }// double prime = seconds = inches,U+2033 ISOtech -->
    // double prime = seconds = inches,U+2033 ISOtech -->
    // double prime = seconds = inches,U+2033 ISOtech -->
    , new String[]{ "oline", "8254" }// overline = spacing overscore,U+203E NEW -->
    // overline = spacing overscore,U+203E NEW -->
    // overline = spacing overscore,U+203E NEW -->
    , new String[]{ "frasl", "8260" }// fraction slash, U+2044 NEW -->
    // fraction slash, U+2044 NEW -->
    // fraction slash, U+2044 NEW -->
    , // <!-- Letterlike Symbols -->
    new String[]{ "weierp", "8472" }// script capital P = power set= Weierstrass p, U+2118 ISOamso -->
    // script capital P = power set= Weierstrass p, U+2118 ISOamso -->
    // script capital P = power set= Weierstrass p, U+2118 ISOamso -->
    , new String[]{ "image", "8465" }// blackletter capital I = imaginary part,U+2111 ISOamso -->
    // blackletter capital I = imaginary part,U+2111 ISOamso -->
    // blackletter capital I = imaginary part,U+2111 ISOamso -->
    , new String[]{ "real", "8476" }// blackletter capital R = real part symbol,U+211C ISOamso -->
    // blackletter capital R = real part symbol,U+211C ISOamso -->
    // blackletter capital R = real part symbol,U+211C ISOamso -->
    , new String[]{ "trade", "8482" }// trade mark sign, U+2122 ISOnum -->
    // trade mark sign, U+2122 ISOnum -->
    // trade mark sign, U+2122 ISOnum -->
    , new String[]{ "alefsym", "8501" }// alef symbol = first transfinite cardinal,U+2135 NEW -->
    // alef symbol = first transfinite cardinal,U+2135 NEW -->
    // alef symbol = first transfinite cardinal,U+2135 NEW -->
    , // <!-- alef symbol is NOT the same as hebrew letter alef,U+05D0 although the
    // same glyph could be used to depict both characters -->
    // <!-- Arrows -->
    new String[]{ "larr", "8592" }// leftwards arrow, U+2190 ISOnum -->
    // leftwards arrow, U+2190 ISOnum -->
    // leftwards arrow, U+2190 ISOnum -->
    , new String[]{ "uarr", "8593" }// upwards arrow, U+2191 ISOnum-->
    // upwards arrow, U+2191 ISOnum-->
    // upwards arrow, U+2191 ISOnum-->
    , new String[]{ "rarr", "8594" }// rightwards arrow, U+2192 ISOnum -->
    // rightwards arrow, U+2192 ISOnum -->
    // rightwards arrow, U+2192 ISOnum -->
    , new String[]{ "darr", "8595" }// downwards arrow, U+2193 ISOnum -->
    // downwards arrow, U+2193 ISOnum -->
    // downwards arrow, U+2193 ISOnum -->
    , new String[]{ "harr", "8596" }// left right arrow, U+2194 ISOamsa -->
    // left right arrow, U+2194 ISOamsa -->
    // left right arrow, U+2194 ISOamsa -->
    , new String[]{ "crarr", "8629" }// downwards arrow with corner leftwards= carriage return, U+21B5 NEW -->
    // downwards arrow with corner leftwards= carriage return, U+21B5 NEW -->
    // downwards arrow with corner leftwards= carriage return, U+21B5 NEW -->
    , new String[]{ "lArr", "8656" }// leftwards double arrow, U+21D0 ISOtech -->
    // leftwards double arrow, U+21D0 ISOtech -->
    // leftwards double arrow, U+21D0 ISOtech -->
    , // <!-- ISO 10646 does not say that lArr is the same as the 'is implied by'
    // arrow but also does not have any other character for that function.
    // So ? lArr canbe used for 'is implied by' as ISOtech suggests -->
    new String[]{ "uArr", "8657" }// upwards double arrow, U+21D1 ISOamsa -->
    // upwards double arrow, U+21D1 ISOamsa -->
    // upwards double arrow, U+21D1 ISOamsa -->
    , new String[]{ "rArr", "8658" }// rightwards double arrow,U+21D2 ISOtech -->
    // rightwards double arrow,U+21D2 ISOtech -->
    // rightwards double arrow,U+21D2 ISOtech -->
    , // <!-- ISO 10646 does not say this is the 'implies' character but does not
    // have another character with this function so ?rArr can be used for
    // 'implies' as ISOtech suggests -->
    new String[]{ "dArr", "8659" }// downwards double arrow, U+21D3 ISOamsa -->
    // downwards double arrow, U+21D3 ISOamsa -->
    // downwards double arrow, U+21D3 ISOamsa -->
    , new String[]{ "hArr", "8660" }// left right double arrow,U+21D4 ISOamsa -->
    // left right double arrow,U+21D4 ISOamsa -->
    // left right double arrow,U+21D4 ISOamsa -->
    , // <!-- Mathematical Operators -->
    new String[]{ "forall", "8704" }// for all, U+2200 ISOtech -->
    // for all, U+2200 ISOtech -->
    // for all, U+2200 ISOtech -->
    , new String[]{ "part", "8706" }// partial differential, U+2202 ISOtech  -->
    // partial differential, U+2202 ISOtech  -->
    // partial differential, U+2202 ISOtech  -->
    , new String[]{ "exist", "8707" }// there exists, U+2203 ISOtech -->
    // there exists, U+2203 ISOtech -->
    // there exists, U+2203 ISOtech -->
    , new String[]{ "empty", "8709" }// empty set = null set = diameter,U+2205 ISOamso -->
    // empty set = null set = diameter,U+2205 ISOamso -->
    // empty set = null set = diameter,U+2205 ISOamso -->
    , new String[]{ "nabla", "8711" }// nabla = backward difference,U+2207 ISOtech -->
    // nabla = backward difference,U+2207 ISOtech -->
    // nabla = backward difference,U+2207 ISOtech -->
    , new String[]{ "isin", "8712" }// element of, U+2208 ISOtech -->
    // element of, U+2208 ISOtech -->
    // element of, U+2208 ISOtech -->
    , new String[]{ "notin", "8713" }// not an element of, U+2209 ISOtech -->
    // not an element of, U+2209 ISOtech -->
    // not an element of, U+2209 ISOtech -->
    , new String[]{ "ni", "8715" }// contains as member, U+220B ISOtech -->
    // contains as member, U+220B ISOtech -->
    // contains as member, U+220B ISOtech -->
    , // <!-- should there be a more memorable name than 'ni'? -->
    new String[]{ "prod", "8719" }// n-ary product = product sign,U+220F ISOamsb -->
    // n-ary product = product sign,U+220F ISOamsb -->
    // n-ary product = product sign,U+220F ISOamsb -->
    , // <!-- prod is NOT the same character as U+03A0 'greek capital letter pi'
    // though the same glyph might be used for both -->
    new String[]{ "sum", "8721" }// n-ary summation, U+2211 ISOamsb -->
    // n-ary summation, U+2211 ISOamsb -->
    // n-ary summation, U+2211 ISOamsb -->
    , // <!-- sum is NOT the same character as U+03A3 'greek capital letter sigma'
    // though the same glyph might be used for both -->
    new String[]{ "minus", "8722" }// minus sign, U+2212 ISOtech -->
    // minus sign, U+2212 ISOtech -->
    // minus sign, U+2212 ISOtech -->
    , new String[]{ "lowast", "8727" }// asterisk operator, U+2217 ISOtech -->
    // asterisk operator, U+2217 ISOtech -->
    // asterisk operator, U+2217 ISOtech -->
    , new String[]{ "radic", "8730" }// square root = radical sign,U+221A ISOtech -->
    // square root = radical sign,U+221A ISOtech -->
    // square root = radical sign,U+221A ISOtech -->
    , new String[]{ "prop", "8733" }// proportional to, U+221D ISOtech -->
    // proportional to, U+221D ISOtech -->
    // proportional to, U+221D ISOtech -->
    , new String[]{ "infin", "8734" }// infinity, U+221E ISOtech -->
    // infinity, U+221E ISOtech -->
    // infinity, U+221E ISOtech -->
    , new String[]{ "ang", "8736" }// angle, U+2220 ISOamso -->
    // angle, U+2220 ISOamso -->
    // angle, U+2220 ISOamso -->
    , new String[]{ "and", "8743" }// logical and = wedge, U+2227 ISOtech -->
    // logical and = wedge, U+2227 ISOtech -->
    // logical and = wedge, U+2227 ISOtech -->
    , new String[]{ "or", "8744" }// logical or = vee, U+2228 ISOtech -->
    // logical or = vee, U+2228 ISOtech -->
    // logical or = vee, U+2228 ISOtech -->
    , new String[]{ "cap", "8745" }// intersection = cap, U+2229 ISOtech -->
    // intersection = cap, U+2229 ISOtech -->
    // intersection = cap, U+2229 ISOtech -->
    , new String[]{ "cup", "8746" }// union = cup, U+222A ISOtech -->
    // union = cup, U+222A ISOtech -->
    // union = cup, U+222A ISOtech -->
    , new String[]{ "int", "8747" }// integral, U+222B ISOtech -->
    // integral, U+222B ISOtech -->
    // integral, U+222B ISOtech -->
    , new String[]{ "there4", "8756" }// therefore, U+2234 ISOtech -->
    // therefore, U+2234 ISOtech -->
    // therefore, U+2234 ISOtech -->
    , new String[]{ "sim", "8764" }// tilde operator = varies with = similar to,U+223C ISOtech -->
    // tilde operator = varies with = similar to,U+223C ISOtech -->
    // tilde operator = varies with = similar to,U+223C ISOtech -->
    , // <!-- tilde operator is NOT the same character as the tilde, U+007E,although
    // the same glyph might be used to represent both  -->
    new String[]{ "cong", "8773" }// approximately equal to, U+2245 ISOtech -->
    // approximately equal to, U+2245 ISOtech -->
    // approximately equal to, U+2245 ISOtech -->
    , new String[]{ "asymp", "8776" }// almost equal to = asymptotic to,U+2248 ISOamsr -->
    // almost equal to = asymptotic to,U+2248 ISOamsr -->
    // almost equal to = asymptotic to,U+2248 ISOamsr -->
    , new String[]{ "ne", "8800" }// not equal to, U+2260 ISOtech -->
    // not equal to, U+2260 ISOtech -->
    // not equal to, U+2260 ISOtech -->
    , new String[]{ "equiv", "8801" }// identical to, U+2261 ISOtech -->
    // identical to, U+2261 ISOtech -->
    // identical to, U+2261 ISOtech -->
    , new String[]{ "le", "8804" }// less-than or equal to, U+2264 ISOtech -->
    // less-than or equal to, U+2264 ISOtech -->
    // less-than or equal to, U+2264 ISOtech -->
    , new String[]{ "ge", "8805" }// greater-than or equal to,U+2265 ISOtech -->
    // greater-than or equal to,U+2265 ISOtech -->
    // greater-than or equal to,U+2265 ISOtech -->
    , new String[]{ "sub", "8834" }// subset of, U+2282 ISOtech -->
    // subset of, U+2282 ISOtech -->
    // subset of, U+2282 ISOtech -->
    , new String[]{ "sup", "8835" }// superset of, U+2283 ISOtech -->
    // superset of, U+2283 ISOtech -->
    // superset of, U+2283 ISOtech -->
    , // <!-- note that nsup, 'not a superset of, U+2283' is not covered by the
    // Symbol font encoding and is not included. Should it be, for symmetry?
    // It is in ISOamsn  --> <!ENTITY nsub", "8836"},
    // not a subset of, U+2284 ISOamsn -->
    new String[]{ "sube", "8838" }// subset of or equal to, U+2286 ISOtech -->
    // subset of or equal to, U+2286 ISOtech -->
    // subset of or equal to, U+2286 ISOtech -->
    , new String[]{ "supe", "8839" }// superset of or equal to,U+2287 ISOtech -->
    // superset of or equal to,U+2287 ISOtech -->
    // superset of or equal to,U+2287 ISOtech -->
    , new String[]{ "oplus", "8853" }// circled plus = direct sum,U+2295 ISOamsb -->
    // circled plus = direct sum,U+2295 ISOamsb -->
    // circled plus = direct sum,U+2295 ISOamsb -->
    , new String[]{ "otimes", "8855" }// circled times = vector product,U+2297 ISOamsb -->
    // circled times = vector product,U+2297 ISOamsb -->
    // circled times = vector product,U+2297 ISOamsb -->
    , new String[]{ "perp", "8869" }// up tack = orthogonal to = perpendicular,U+22A5 ISOtech -->
    // up tack = orthogonal to = perpendicular,U+22A5 ISOtech -->
    // up tack = orthogonal to = perpendicular,U+22A5 ISOtech -->
    , new String[]{ "sdot", "8901" }// dot operator, U+22C5 ISOamsb -->
    // dot operator, U+22C5 ISOamsb -->
    // dot operator, U+22C5 ISOamsb -->
    , // <!-- dot operator is NOT the same character as U+00B7 middle dot -->
    // <!-- Miscellaneous Technical -->
    new String[]{ "lceil", "8968" }// left ceiling = apl upstile,U+2308 ISOamsc  -->
    // left ceiling = apl upstile,U+2308 ISOamsc  -->
    // left ceiling = apl upstile,U+2308 ISOamsc  -->
    , new String[]{ "rceil", "8969" }// right ceiling, U+2309 ISOamsc  -->
    // right ceiling, U+2309 ISOamsc  -->
    // right ceiling, U+2309 ISOamsc  -->
    , new String[]{ "lfloor", "8970" }// left floor = apl downstile,U+230A ISOamsc  -->
    // left floor = apl downstile,U+230A ISOamsc  -->
    // left floor = apl downstile,U+230A ISOamsc  -->
    , new String[]{ "rfloor", "8971" }// right floor, U+230B ISOamsc  -->
    // right floor, U+230B ISOamsc  -->
    // right floor, U+230B ISOamsc  -->
    , new String[]{ "lang", "9001" }// left-pointing angle bracket = bra,U+2329 ISOtech -->
    // left-pointing angle bracket = bra,U+2329 ISOtech -->
    // left-pointing angle bracket = bra,U+2329 ISOtech -->
    , // <!-- lang is NOT the same character as U+003C 'less than' or U+2039 'single left-pointing angle quotation mark' -->
    new String[]{ "rang", "9002" }// right-pointing angle bracket = ket,U+232A ISOtech -->
    // right-pointing angle bracket = ket,U+232A ISOtech -->
    // right-pointing angle bracket = ket,U+232A ISOtech -->
    , // <!-- rang is NOT the same character as U+003E 'greater than' or U+203A
    // 'single right-pointing angle quotation mark' -->
    // <!-- Geometric Shapes -->
    new String[]{ "loz", "9674" }// lozenge, U+25CA ISOpub -->
    // lozenge, U+25CA ISOpub -->
    // lozenge, U+25CA ISOpub -->
    , // <!-- Miscellaneous Symbols -->
    new String[]{ "spades", "9824" }// black spade suit, U+2660 ISOpub -->
    // black spade suit, U+2660 ISOpub -->
    // black spade suit, U+2660 ISOpub -->
    , // <!-- black here seems to mean filled as opposed to hollow -->
    new String[]{ "clubs", "9827" }// black club suit = shamrock,U+2663 ISOpub -->
    // black club suit = shamrock,U+2663 ISOpub -->
    // black club suit = shamrock,U+2663 ISOpub -->
    , new String[]{ "hearts", "9829" }// black heart suit = valentine,U+2665 ISOpub -->
    // black heart suit = valentine,U+2665 ISOpub -->
    // black heart suit = valentine,U+2665 ISOpub -->
    , new String[]{ "diams", "9830" }// black diamond suit, U+2666 ISOpub -->
    // black diamond suit, U+2666 ISOpub -->
    // black diamond suit, U+2666 ISOpub -->
    , // <!-- Latin Extended-A -->
    new String[]{ "OElig", "338" }// -- latin capital ligature OE,U+0152 ISOlat2 -->
    // -- latin capital ligature OE,U+0152 ISOlat2 -->
    // -- latin capital ligature OE,U+0152 ISOlat2 -->
    , new String[]{ "oelig", "339" }// -- latin small ligature oe, U+0153 ISOlat2 -->
    // -- latin small ligature oe, U+0153 ISOlat2 -->
    // -- latin small ligature oe, U+0153 ISOlat2 -->
    , // <!-- ligature is a misnomer, this is a separate character in some languages -->
    new String[]{ "Scaron", "352" }// -- latin capital letter S with caron,U+0160 ISOlat2 -->
    // -- latin capital letter S with caron,U+0160 ISOlat2 -->
    // -- latin capital letter S with caron,U+0160 ISOlat2 -->
    , new String[]{ "scaron", "353" }// -- latin small letter s with caron,U+0161 ISOlat2 -->
    // -- latin small letter s with caron,U+0161 ISOlat2 -->
    // -- latin small letter s with caron,U+0161 ISOlat2 -->
    , new String[]{ "Yuml", "376" }// -- latin capital letter Y with diaeresis,U+0178 ISOlat2 -->
    // -- latin capital letter Y with diaeresis,U+0178 ISOlat2 -->
    // -- latin capital letter Y with diaeresis,U+0178 ISOlat2 -->
    , // <!-- Spacing Modifier Letters -->
    new String[]{ "circ", "710" }// -- modifier letter circumflex accent,U+02C6 ISOpub -->
    // -- modifier letter circumflex accent,U+02C6 ISOpub -->
    // -- modifier letter circumflex accent,U+02C6 ISOpub -->
    , new String[]{ "tilde", "732" }// small tilde, U+02DC ISOdia -->
    // small tilde, U+02DC ISOdia -->
    // small tilde, U+02DC ISOdia -->
    , // <!-- General Punctuation -->
    new String[]{ "ensp", "8194" }// en space, U+2002 ISOpub -->
    // en space, U+2002 ISOpub -->
    // en space, U+2002 ISOpub -->
    , new String[]{ "emsp", "8195" }// em space, U+2003 ISOpub -->
    // em space, U+2003 ISOpub -->
    // em space, U+2003 ISOpub -->
    , new String[]{ "thinsp", "8201" }// thin space, U+2009 ISOpub -->
    // thin space, U+2009 ISOpub -->
    // thin space, U+2009 ISOpub -->
    , new String[]{ "zwnj", "8204" }// zero width non-joiner,U+200C NEW RFC 2070 -->
    // zero width non-joiner,U+200C NEW RFC 2070 -->
    // zero width non-joiner,U+200C NEW RFC 2070 -->
    , new String[]{ "zwj", "8205" }// zero width joiner, U+200D NEW RFC 2070 -->
    // zero width joiner, U+200D NEW RFC 2070 -->
    // zero width joiner, U+200D NEW RFC 2070 -->
    , new String[]{ "lrm", "8206" }// left-to-right mark, U+200E NEW RFC 2070 -->
    // left-to-right mark, U+200E NEW RFC 2070 -->
    // left-to-right mark, U+200E NEW RFC 2070 -->
    , new String[]{ "rlm", "8207" }// right-to-left mark, U+200F NEW RFC 2070 -->
    // right-to-left mark, U+200F NEW RFC 2070 -->
    // right-to-left mark, U+200F NEW RFC 2070 -->
    , new String[]{ "ndash", "8211" }// en dash, U+2013 ISOpub -->
    // en dash, U+2013 ISOpub -->
    // en dash, U+2013 ISOpub -->
    , new String[]{ "mdash", "8212" }// em dash, U+2014 ISOpub -->
    // em dash, U+2014 ISOpub -->
    // em dash, U+2014 ISOpub -->
    , new String[]{ "lsquo", "8216" }// left single quotation mark,U+2018 ISOnum -->
    // left single quotation mark,U+2018 ISOnum -->
    // left single quotation mark,U+2018 ISOnum -->
    , new String[]{ "rsquo", "8217" }// right single quotation mark,U+2019 ISOnum -->
    // right single quotation mark,U+2019 ISOnum -->
    // right single quotation mark,U+2019 ISOnum -->
    , new String[]{ "sbquo", "8218" }// single low-9 quotation mark, U+201A NEW -->
    // single low-9 quotation mark, U+201A NEW -->
    // single low-9 quotation mark, U+201A NEW -->
    , new String[]{ "ldquo", "8220" }// left double quotation mark,U+201C ISOnum -->
    // left double quotation mark,U+201C ISOnum -->
    // left double quotation mark,U+201C ISOnum -->
    , new String[]{ "rdquo", "8221" }// right double quotation mark,U+201D ISOnum -->
    // right double quotation mark,U+201D ISOnum -->
    // right double quotation mark,U+201D ISOnum -->
    , new String[]{ "bdquo", "8222" }// double low-9 quotation mark, U+201E NEW -->
    // double low-9 quotation mark, U+201E NEW -->
    // double low-9 quotation mark, U+201E NEW -->
    , new String[]{ "dagger", "8224" }// dagger, U+2020 ISOpub -->
    // dagger, U+2020 ISOpub -->
    // dagger, U+2020 ISOpub -->
    , new String[]{ "Dagger", "8225" }// double dagger, U+2021 ISOpub -->
    // double dagger, U+2021 ISOpub -->
    // double dagger, U+2021 ISOpub -->
    , new String[]{ "permil", "8240" }// per mille sign, U+2030 ISOtech -->
    // per mille sign, U+2030 ISOtech -->
    // per mille sign, U+2030 ISOtech -->
    , new String[]{ "lsaquo", "8249" }// single left-pointing angle quotation mark,U+2039 ISO proposed -->
    // single left-pointing angle quotation mark,U+2039 ISO proposed -->
    // single left-pointing angle quotation mark,U+2039 ISO proposed -->
    , // <!-- lsaquo is proposed but not yet ISO standardized -->
    new String[]{ "rsaquo", "8250" }// single right-pointing angle quotation mark,U+203A ISO proposed -->
    // single right-pointing angle quotation mark,U+203A ISO proposed -->
    // single right-pointing angle quotation mark,U+203A ISO proposed -->
    , // <!-- rsaquo is proposed but not yet ISO standardized -->
    new String[]{ "euro", "8364" }// -- euro sign, U+20AC NEW -->
    // -- euro sign, U+20AC NEW -->
    // -- euro sign, U+20AC NEW -->
     };

    /**
     * <p>The set of entities supported by standard XML.</p>
     */
    public static final Entities XML;

    /**
     * <p>The set of entities supported by HTML 3.2.</p>
     */
    public static final Entities HTML32;

    /**
     * <p>The set of entities supported by HTML 4.0.</p>
     */
    public static final Entities HTML40;

    static {
        XML = new Entities();
        XML.addEntities(BASIC_ARRAY);
        XML.addEntities(APOS_ARRAY);
    }

    static {
        HTML32 = new Entities();
        HTML32.addEntities(BASIC_ARRAY);
        HTML32.addEntities(ISO8859_1_ARRAY);
    }

    static {
        HTML40 = new Entities();
        fillWithHtml40Entities(HTML40);
    }

    /**
     * <p>Fills the specified entities instance with HTML 40 entities.</p>
     *
     * @param entities
     * 		the instance to be filled.
     */
    static void fillWithHtml40Entities(Entities entities) {
        entities.addEntities(BASIC_ARRAY);
        entities.addEntities(ISO8859_1_ARRAY);
        entities.addEntities(HTML40_ARRAY);
    }

    static interface EntityMap {
        /**
         * <p>Add an entry to this entity map.</p>
         *
         * @param name
         * 		the entity name
         * @param value
         * 		the entity value
         */
        void add(String name, int value);

        /**
         * <p>Returns the name of the entity identified by the specified value.</p>
         *
         * @param value
         * 		the value to locate
         * @return entity name associated with the specified value
         */
        String name(int value);

        /**
         * <p>Returns the value of the entity identified by the specified name.</p>
         *
         * @param name
         * 		the name to locate
         * @return entity value associated with the specified name
         */
        int value(String name);
    }

    static class PrimitiveEntityMap implements EntityMap {
        private Map mapNameToValue = new HashMap();

        private IntHashMap mapValueToName = new IntHashMap();

        /**
         * {@inheritDoc }
         */
        public void add(String name, int value) {
            mapNameToValue.put(name, new Integer(value));
            mapValueToName.put(value, name);
        }

        /**
         * {@inheritDoc }
         */
        public String name(int value) {
            return ((String) (mapValueToName.get(value)));
        }

        /**
         * {@inheritDoc }
         */
        public int value(String name) {
            Object value = mapNameToValue.get(name);
            if (value == null) {
                return -1;
            }
            return ((Integer) (value)).intValue();
        }
    }

    abstract static class MapIntMap implements EntityMap {
        protected Map mapNameToValue;

        protected Map mapValueToName;

        /**
         * {@inheritDoc }
         */
        public void add(String name, int value) {
            mapNameToValue.put(name, new Integer(value));
            mapValueToName.put(new Integer(value), name);
        }

        /**
         * {@inheritDoc }
         */
        public String name(int value) {
            return ((String) (mapValueToName.get(new Integer(value))));
        }

        /**
         * {@inheritDoc }
         */
        public int value(String name) {
            Object value = mapNameToValue.get(name);
            if (value == null) {
                return -1;
            }
            return ((Integer) (value)).intValue();
        }
    }

    static class HashEntityMap extends MapIntMap {
        /**
         * Constructs a new instance of <code>HashEntityMap</code>.
         */
        public HashEntityMap() {
            mapNameToValue = new HashMap();
            mapValueToName = new HashMap();
        }
    }

    static class TreeEntityMap extends MapIntMap {
        /**
         * Constructs a new instance of <code>TreeEntityMap</code>.
         */
        public TreeEntityMap() {
            mapNameToValue = new TreeMap();
            mapValueToName = new TreeMap();
        }
    }

    static class LookupEntityMap extends PrimitiveEntityMap {
        private String[] lookupTable;

        private int LOOKUP_TABLE_SIZE = 256;

        /**
         * {@inheritDoc }
         */
        public String name(int value) {
            if (value < LOOKUP_TABLE_SIZE) {
                return lookupTable()[value];
            }
            return super.name(value);
        }

        /**
         * <p>Returns the lookup table for this entity map. The lookup table is created if it has not been
         * previously.</p>
         *
         * @return the lookup table
         */
        private String[] lookupTable() {
            if (lookupTable == null) {
                createLookupTable();
            }
            return lookupTable;
        }

        /**
         * <p>Creates an entity lookup table of LOOKUP_TABLE_SIZE elements, initialized with entity names.</p>
         */
        private void createLookupTable() {
            lookupTable = new String[LOOKUP_TABLE_SIZE];
            for (int i = 0; i < LOOKUP_TABLE_SIZE; ++i) {
                lookupTable[i] = super.name(i);
            }
        }
    }

    static class ArrayEntityMap implements EntityMap {
        protected int growBy = 100;

        protected int size = 0;

        protected String[] names;

        protected int[] values;

        /**
         * Constructs a new instance of <code>ArrayEntityMap</code>.
         */
        public ArrayEntityMap() {
            names = new String[growBy];
            values = new int[growBy];
        }

        /**
         * Constructs a new instance of <code>ArrayEntityMap</code>
         * specifying the size by which the array should grow.
         *
         * @param growBy
         * 		array will be initialized to and will grow by this amount
         */
        public ArrayEntityMap(int growBy) {
            this.growBy = growBy;
            names = new String[growBy];
            values = new int[growBy];
        }

        /**
         * {@inheritDoc }
         */
        public void add(String name, int value) {
            ensureCapacity(size + 1);
            names[size] = name;
            values[size] = value;
            size++;
        }

        /**
         * Verifies the capacity of the entity array, adjusting the size if necessary.
         *
         * @param capacity
         * 		size the array should be
         */
        protected void ensureCapacity(int capacity) {
            if (capacity > names.length) {
                int newSize = Math.max(capacity, size + growBy);
                String[] newNames = new String[newSize];
                System.arraycopy(names, 0, newNames, 0, size);
                names = newNames;
                int[] newValues = new int[newSize];
                System.arraycopy(values, 0, newValues, 0, size);
                values = newValues;
            }
        }

        /**
         * {@inheritDoc }
         */
        public String name(int value) {
            for (int i = 0; i < size; ++i) {
                if (values[i] == value) {
                    return names[i];
                }
            }
            return null;
        }

        /**
         * {@inheritDoc }
         */
        public int value(String name) {
            for (int i = 0; i < size; ++i) {
                if (names[i].equals(name)) {
                    return values[i];
                }
            }
            return -1;
        }
    }

    static class BinaryEntityMap extends ArrayEntityMap {
        /**
         * Constructs a new instance of <code>BinaryEntityMap</code>.
         */
        public BinaryEntityMap() {
            super();
        }

        /**
         * Constructs a new instance of <code>ArrayEntityMap</code>
         * specifying the size by which the underlying array should grow.
         *
         * @param growBy
         * 		array will be initialized to and will grow by this amount
         */
        public BinaryEntityMap(int growBy) {
            super(growBy);
        }

        /**
         * Performs a binary search of the entity array for the specified key.
         * This method is based on code in {@link java.util.Arrays}.
         *
         * @param key
         * 		the key to be found
         * @return the index of the entity array matching the specified key
         */
        private int binarySearch(int key) {
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                int midVal = values[mid];
                if (midVal < key) {
                    low = mid + 1;
                } else if (midVal > key) {
                    high = mid - 1;
                } else {
                    return mid;// key found

                }
            } 
            return -(low + 1);// key not found.

        }

        /**
         * {@inheritDoc }
         */
        public void add(String name, int value) {
            ensureCapacity(size + 1);
            int insertAt = binarySearch(value);
            if (insertAt > 0) {
                return;// note: this means you can't insert the same value twice

            }
            insertAt = -(insertAt + 1);// binarySearch returns it negative and off-by-one

            System.arraycopy(values, insertAt, values, insertAt + 1, size - insertAt);
            values[insertAt] = value;
            System.arraycopy(names, insertAt, names, insertAt + 1, size - insertAt);
            names[insertAt] = name;
            size++;
        }

        /**
         * {@inheritDoc }
         */
        public String name(int value) {
            int index = binarySearch(value);
            if (index < 0) {
                return null;
            }
            return names[index];
        }
    }

    // package scoped for testing
    EntityMap map = new LookupEntityMap();

    /**
     * <p>Adds entities to this entity.</p>
     *
     * @param entityArray
     * 		array of entities to be added
     */
    public void addEntities(String[][] entityArray) {
        for (int i = 0; i < entityArray.length; ++i) {
            addEntity(entityArray[i][0], Integer.parseInt(entityArray[i][1]));
        }
    }

    /**
     * <p>Add an entity to this entity.</p>
     *
     * @param name
     * 		name of the entity
     * @param value
     * 		vale of the entity
     */
    public void addEntity(String name, int value) {
        map.add(name, value);
    }

    /**
     * <p>Returns the name of the entity identified by the specified value.</p>
     *
     * @param value
     * 		the value to locate
     * @return entity name associated with the specified value
     */
    public String entityName(int value) {
        return map.name(value);
    }

    /**
     * <p>Returns the value of the entity identified by the specified name.</p>
     *
     * @param name
     * 		the name to locate
     * @return entity value associated with the specified name
     */
    public int entityValue(String name) {
        return map.value(name);
    }

    /**
     * <p>Escapes the characters in a <code>String</code>.</p>
     *
     * <p>For example, if you have called addEntity(&quot;foo&quot;, 0xA1),
     * escape(&quot;\u00A1&quot;) will return &quot;&amp;foo;&quot;</p>
     *
     * @param str
     * 		The <code>String</code> to escape.
     * @return A new escaped <code>String</code>.
     */
    public String escape(String str) {
        // todo: rewrite to use a Writer
        StringBuffer buf = new StringBuffer(str.length() * 2);
        int i;
        for (i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            String entityName = this.entityName(ch);
            if (entityName == null) {
                if (ch > 0x7f) {
                    int intValue = ch;
                    buf.append("&#");
                    buf.append(intValue);
                    buf.append(';');
                } else {
                    buf.append(ch);
                }
            } else {
                buf.append('&');
                buf.append(entityName);
                buf.append(';');
            }
        }
        return buf.toString();
    }

    /**
     * <p>Escapes the characters in the <code>String</code> passed and writes the result
     * to the <code>Writer</code> passed. </p>
     *
     * @param writer
     * 		The <code>Writer</code> to write the results of the escaping to.
     * 		Assumed to be a non-null value.
     * @param str
     * 		The <code>String</code> to escape. Assumed to be a non-null value.
     * @throws IOException
     * 		when <code>Writer</code> passed throws the exception from
     * 		calls to the {@link Writer#write(int)} methods.
     * @see #escape(String)
     * @see Writer
     */
    public void escape(Writer writer, String str) throws IOException {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            String entityName = this.entityName(c);
            if (entityName == null) {
                if (c > 0x7f) {
                    writer.write("&#");
                    writer.write(Integer.toString(c, 10));
                    writer.write(';');
                } else {
                    writer.write(c);
                }
            } else {
                writer.write('&');
                writer.write(entityName);
                writer.write(';');
            }
        }
    }

    /**
     * <p>Unescapes the entities in a <code>String</code>.</p>
     *
     * <p>For example, if you have called addEntity(&quot;foo&quot;, 0xA1),
     * unescape(&quot;&amp;foo;&quot;) will return &quot;\u00A1&quot;</p>
     *
     * @param str
     * 		The <code>String</code> to escape.
     * @return A new escaped <code>String</code>.
     */
    public String unescape(String str) {
        int firstAmp = str.indexOf('&');
        if (firstAmp < 0) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str.length());
        buf.append(str.substring(0, firstAmp));
        for (int i = firstAmp; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '&') {
                int semi = str.indexOf(';', i + 1);
                if (semi == (-1)) {
                    buf.append(ch);
                    continue;
                }
                int amph = str.indexOf('&', i + 1);
                if ((amph != (-1)) && (amph < semi)) {
                    // Then the text looks like &...&...;
                    buf.append(ch);
                    continue;
                }
                String entityName = str.substring(i + 1, semi);
                int entityValue;
                if (entityName.length() == 0) {
                    entityValue = -1;
                } else if (entityName.charAt(0) == '#') {
                    if (entityName.length() == 1) {
                        entityValue = -1;
                    } else {
                        char charAt1 = entityName.charAt(1);
                        try {
                            if ((charAt1 == 'x') || (charAt1 == 'X')) {
                                entityValue = Integer.valueOf(entityName.substring(2), 16).intValue();
                            } else {
                                entityValue = Integer.parseInt(entityName.substring(1));
                            }
                            if (entityValue > 0xffff) {
                                entityValue = -1;
                            }
                        } catch (NumberFormatException ex) {
                            entityValue = -1;
                        }
                    }
                } else {
                    entityValue = this.entityValue(entityName);
                }
                if (entityValue == (-1)) {
                    buf.append('&');
                    buf.append(entityName);
                    buf.append(';');
                } else {
                    buf.append(((char) (entityValue)));
                }
                i = semi;
            } else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    /**
     * <p>Unescapes the escaped entities in the <code>String</code> passed and
     * writes the result to the <code>Writer</code> passed.</p>
     *
     * @param writer
     * 		The <code>Writer</code> to write the results to; assumed to be non-null.
     * @param string
     * 		The <code>String</code> to write the results to; assumed to be non-null.
     * @throws IOException
     * 		when <code>Writer</code> passed throws the exception from
     * 		calls to the {@link Writer#write(int)} methods.
     * @see #escape(String)
     * @see Writer
     */
    public void unescape(Writer writer, String string) throws IOException {
        int firstAmp = string.indexOf('&');
        if (firstAmp < 0) {
            writer.write(string);
            return;
        }
        writer.write(string, 0, firstAmp);
        int len = string.length();
        for (int i = firstAmp; i < len; i++) {
            char c = string.charAt(i);
            if (c == '&') {
                int nextIdx = i + 1;
                int semiColonIdx = string.indexOf(';', nextIdx);
                if (semiColonIdx == (-1)) {
                    writer.write(c);
                    continue;
                }
                int amphersandIdx = string.indexOf('&', i + 1);
                if ((amphersandIdx != (-1)) && (amphersandIdx < semiColonIdx)) {
                    // Then the text looks like &...&...;
                    writer.write(c);
                    continue;
                }
                String entityContent = string.substring(nextIdx, semiColonIdx);
                int entityValue = -1;
                int entityContentLen = entityContent.length();
                if (entityContentLen > 0) {
                    if (entityContent.charAt(0) == '#') {
                        // escaped value content is an integer (decimal or hexidecimal)
                        if (entityContentLen > 1) {
                            char isHexChar = entityContent.charAt(1);
                            try {
                                switch (isHexChar) {
                                    case 'X' :
                                    case 'x' :
                                        {
                                            entityValue = Integer.parseInt(entityContent.substring(2), 16);
                                            break;
                                        }
                                    default :
                                        {
                                            entityValue = Integer.parseInt(entityContent.substring(1), 10);
                                        }
                                }
                                if (entityValue > 0xffff) {
                                    entityValue = -1;
                                }
                            } catch (NumberFormatException e) {
                                entityValue = -1;
                            }
                        }
                    } else {
                        // escaped value content is an entity name
                        entityValue = this.entityValue(entityContent);
                    }
                }
                if (entityValue == (-1)) {
                    writer.write('&');
                    writer.write(entityContent);
                    writer.write(';');
                } else {
                    writer.write(entityValue);
                }
                i = semiColonIdx;// move index up to the semi-colon

            } else {
                writer.write(c);
            }
        }
    }
}