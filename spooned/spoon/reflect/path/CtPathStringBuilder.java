/**
 * Copyright (C) 2006-2018 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.reflect.path;


/**
 * Created by nicolas on 27/08/2015.
 */
public class CtPathStringBuilder {
    private final java.util.regex.Pattern pathPattern = java.util.regex.Pattern.compile("([/.#])([^/.#\\[]+)(\\[([^/.#]*)\\])?");

    private final java.util.regex.Pattern argumentPattern = java.util.regex.Pattern.compile("(\\w+)=([^=\\]]+)");

    private java.lang.Class load(java.lang.String name) throws spoon.reflect.path.CtPathException {
        // try without name
        try {
            return java.lang.Class.forName(name);
        } catch (java.lang.ClassNotFoundException ex) {
        }
        // search in spoon.reflect.declaration
        try {
            return java.lang.Class.forName(("spoon.reflect.declaration." + name));
        } catch (java.lang.ClassNotFoundException ex) {
        }
        // search in
        try {
            return java.lang.Class.forName(("spoon.reflect.code." + name));
        } catch (java.lang.ClassNotFoundException ex) {
            throw new spoon.reflect.path.CtPathException(java.lang.String.format("Unable to locate element with type %s in Spoon model", name));
        }
    }

    private static final java.lang.String MAIN_DELIMITERS = ".#/";

    private static final java.lang.String PATH_DELIMITERS = ".#/[";

    private static final java.lang.String ARG_NAME_DELIMITERS = "=";

    private static final java.util.regex.Pattern NAME_MATCHER = java.util.regex.Pattern.compile("\\w+");

    /**
     * Build path from a string representation.
     *
     * for example:
     * new CtPathBuilder().fromString(".spoon.test.path.Foo.foo#statement[index=0]")
     * Match the first statement of method foo from class spoon.test.path.Foo.
     *
     * Some specials characters
     * . :  match with the given name
     * # : match with a CtPathRole
     * / : match with a element type (for example, to match all classes, use /CtClass
     */
    public spoon.reflect.path.CtPath fromString(java.lang.String pathStr) throws spoon.reflect.path.CtPathException {
        spoon.reflect.path.impl.CtPathImpl path = new spoon.reflect.path.impl.CtPathImpl();
        spoon.reflect.path.CtPathStringBuilder.Tokenizer tokenizer = new spoon.reflect.path.CtPathStringBuilder.Tokenizer(pathStr);
        java.lang.String token = tokenizer.getNextToken(spoon.reflect.path.CtPathStringBuilder.MAIN_DELIMITERS);
        while (token != null) {
            java.lang.String kind = token;
            spoon.reflect.path.impl.CtPathElement pathElement;
            token = tokenizer.getNextToken(spoon.reflect.path.CtPathStringBuilder.PATH_DELIMITERS);
            if (((token != null) && ((token.length()) == 1)) && (spoon.reflect.path.CtPathStringBuilder.PATH_DELIMITERS.contains(token))) {
                // nextToken is again path delimiter. It means there is no token value in between
                throw new spoon.reflect.path.CtPathException("Path value is missing");
            }
            if (spoon.reflect.path.impl.CtNamedPathElement.STRING.equals(kind)) {
                // reg exp cannot be used in string, because `.` and `[` are reserved characters for CtPath
                pathElement = new spoon.reflect.path.impl.CtNamedPathElement(token, false);
            } else
                if (spoon.reflect.path.impl.CtTypedNameElement.STRING.equals(kind)) {
                    pathElement = new spoon.reflect.path.impl.CtTypedNameElement(load(token));
                } else
                    if (spoon.reflect.path.impl.CtRolePathElement.STRING.equals(kind)) {
                        pathElement = new spoon.reflect.path.impl.CtRolePathElement(spoon.reflect.path.CtRole.fromName(token));
                    } else {
                        throw new spoon.reflect.path.CtPathException(("Unexpected token " + kind));
                    }


            token = tokenizer.getNextToken(spoon.reflect.path.CtPathStringBuilder.PATH_DELIMITERS);
            if (spoon.reflect.path.impl.AbstractPathElement.ARGUMENT_START.equals(token)) {
                while (true) {
                    java.lang.String argName = tokenizer.getNextToken(spoon.reflect.path.CtPathStringBuilder.ARG_NAME_DELIMITERS);
                    if (!(spoon.reflect.path.CtPathStringBuilder.NAME_MATCHER.matcher(argName).matches())) {
                        throw new spoon.reflect.path.CtPathException(("Argument name must be a word, but is: " + argName));
                    }
                    token = tokenizer.getNextToken(spoon.reflect.path.CtPathStringBuilder.ARG_NAME_DELIMITERS);
                    if (!(spoon.reflect.path.impl.AbstractPathElement.ARGUMENT_NAME_SEPARATOR.equals(token))) {
                        throw new spoon.reflect.path.CtPathException(("Expects " + (spoon.reflect.path.impl.AbstractPathElement.ARGUMENT_NAME_SEPARATOR)));
                    }
                    token = parseArgumentValue(tokenizer, argName, pathElement);
                    if ("]".equals(token)) {
                        break;
                    }
                    // read next argument
                } 
                token = tokenizer.getNextToken(spoon.reflect.path.CtPathStringBuilder.MAIN_DELIMITERS);
            }
            path.addLast(pathElement);
        } 
        return path;
    }

    private static final java.lang.String ARG_VALUE_DELIMITERS = "[];()";

    /**
     *
     *
     * @return last token
     */
    private java.lang.String parseArgumentValue(spoon.reflect.path.CtPathStringBuilder.Tokenizer tokenizer, java.lang.String argName, spoon.reflect.path.impl.CtPathElement pathElement) {
        java.lang.StringBuilder argValue = new java.lang.StringBuilder();
        java.util.Deque<java.lang.String> stack = new java.util.ArrayDeque<>();
        while (true) {
            java.lang.String token = tokenizer.getNextToken(spoon.reflect.path.CtPathStringBuilder.ARG_VALUE_DELIMITERS);
            if (("(".equals(token)) || ("[".equals(token))) {
                // starts bracket
                stack.push(token);
            } else
                if ((stack.size()) > 0) {
                    // we are in some brackets. Just wait for end of bracket
                    if (")".equals(token)) {
                        // closing bracket
                        java.lang.String kind = stack.pop();
                        if (!("(".equals(kind))) {
                            throw new spoon.reflect.path.CtPathException(("Unexpected end of bracket " + token));
                        }
                    } else
                        if ("]".equals(token)) {
                            // closing bracket
                            java.lang.String kind = stack.pop();
                            if (!("[".equals(kind))) {
                                throw new spoon.reflect.path.CtPathException(("Unexpected end of bracket " + token));
                            }
                        }

                } else
                    if (("]".equals(token)) || (";".equals(token))) {
                        // finished reading of argument value
                        pathElement.addArgument(argName, argValue.toString());
                        return token;
                    }


            argValue.append(token);
        } 
    }

    private static class Tokenizer {
        java.util.StringTokenizer tokenizer;

        int length;

        int off;

        Tokenizer(java.lang.String str) {
            length = str.length();
            off = 0;
            tokenizer = new java.util.StringTokenizer(str, spoon.reflect.path.CtPathStringBuilder.MAIN_DELIMITERS, true);
        }

        java.lang.String getNextToken(java.lang.String delimiters) {
            try {
                if ((off) >= (length)) {
                    return null;
                }
                java.lang.String token = tokenizer.nextToken(delimiters);
                off += token.length();
                return token;
            } catch (java.util.NoSuchElementException e) {
                throw new spoon.SpoonException("Unexpected error", e);
            }
        }
    }
}

