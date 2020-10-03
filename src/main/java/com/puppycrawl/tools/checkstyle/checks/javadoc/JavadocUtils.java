////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2014  Oliver Burn
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////
package com.puppycrawl.tools.checkstyle.checks.javadoc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.DetailNode;
import com.puppycrawl.tools.checkstyle.api.JavadocTagInfo;
import com.puppycrawl.tools.checkstyle.api.JavadocTokenTypes;
import com.puppycrawl.tools.checkstyle.api.TextBlock;
import com.puppycrawl.tools.checkstyle.api.Utils;

/**
 * Contains utility methods for working with Javadoc.
 * @author Lyle Hanson
 */
public final class JavadocUtils
{
    /** maps from a token name to value */
    private static final ImmutableMap<String, Integer> TOKEN_NAME_TO_VALUE;
    /** maps from a token value to name */
    private static final String[] TOKEN_VALUE_TO_NAME;

    // Using reflection gets all token names and values from JavadocTokenTypes class
    // and saves to TOKEN_NAME_TO_VALUE and TOKEN_VALUE_TO_NAME collections.
    static {
        final ImmutableMap.Builder<String, Integer> builder = ImmutableMap.builder();

        final Field[] fields = JavadocTokenTypes.class.getDeclaredFields();

        String[] tempTokenValueToName = new String[0];

        for (final Field f : fields) {

            // Only process public int fields.
            if (!Modifier.isPublic(f.getModifiers())
                    || f.getType() != Integer.TYPE)
            {
                continue;
            }

            final String name = f.getName();

            try {
                final int tokenValue = f.getInt(name);
                builder.put(name, tokenValue);
                if (tokenValue > tempTokenValueToName.length - 1) {
                    final String[] temp = new String[tokenValue + 1];
                    System.arraycopy(tempTokenValueToName, 0, temp, 0, tempTokenValueToName.length);
                    tempTokenValueToName = temp;
                }
                if (tokenValue == -1) {
                    tempTokenValueToName[0] = name;
                }
                else {
                    tempTokenValueToName[tokenValue] = name;
                }
            }
            catch (Exception e) {
                throw new IllegalStateException("Failed to instantiate collection of Javadoc tokens"
                        , e);
            }
        }

        TOKEN_NAME_TO_VALUE = builder.build();
        TOKEN_VALUE_TO_NAME = tempTokenValueToName;
    }

    ///CLOVER:OFF
    /** prevent instantiation */
    private JavadocUtils()
    {
    }

    ///CLOVER:ON

    /**
     * Gets validTags from a given piece of Javadoc.
     * @param aCmt
     *        the Javadoc comment to process.
     * @param aTagType
     *        the type of validTags we're interested in
     * @return all standalone validTags from the given javadoc.
     */
    public static JavadocTags getJavadocTags(TextBlock aCmt,
            JavadocTagType aTagType)
    {
        final String[] text = aCmt.getText();
        final List<JavadocTag> tags = Lists.newArrayList();
        final List<InvalidJavadocTag> invalidTags = Lists.newArrayList();
        Pattern blockTagPattern =
                Utils.getPattern("/\\*{2,}\\s*@(\\p{Alpha}+)\\s");
        for (int i = 0; i < text.length; i++) {
            final String s = text[i];
            final Matcher blockTagMatcher = blockTagPattern.matcher(s);
            if ((aTagType.equals(JavadocTagType.ALL) || aTagType
                    .equals(JavadocTagType.BLOCK)) && blockTagMatcher.find())
            {
                final String tagName = blockTagMatcher.group(1);
                String content = s.substring(blockTagMatcher.end(1));
                if (content.endsWith("*/")) {
                    content = content.substring(0, content.length() - 2);
                }
                final int line = aCmt.getStartLineNo() + i;
                int col = blockTagMatcher.start(1) - 1;
                if (i == 0) {
                    col += aCmt.getStartColNo();
                }
                if (JavadocTagInfo.isValidName(tagName)) {
                    tags.add(
                            new JavadocTag(line, col, tagName, content.trim()));
                }
                else {
                    invalidTags.add(new InvalidJavadocTag(line, col, tagName));
                }
            }
            // No block tag, so look for inline validTags
            else if (aTagType.equals(JavadocTagType.ALL)
                    || aTagType.equals(JavadocTagType.INLINE))
            {
                // Match JavaDoc text after comment characters
                final Pattern commentPattern =
                        Utils.getPattern("^\\s*(?:/\\*{2,}|\\*+)\\s*(.*)");
                final Matcher commentMatcher = commentPattern.matcher(s);
                final String commentContents;
                final int commentOffset; // offset including comment characters
                if (!commentMatcher.find()) {
                    commentContents = s; // No leading asterisks, still valid
                    commentOffset = 0;
                }
                else {
                    commentContents = commentMatcher.group(1);
                    commentOffset = commentMatcher.start(1) - 1;
                }
                final Pattern tagPattern =
                        Utils.getPattern(".*?\\{@(\\p{Alpha}+)\\s+(.*?)\\}");
                final Matcher tagMatcher = tagPattern.matcher(commentContents);
                while (tagMatcher.find()) {
                    if (tagMatcher.groupCount() == 2) {
                        final String tagName = tagMatcher.group(1);
                        final String tagValue = tagMatcher.group(2).trim();
                        final int line = aCmt.getStartLineNo() + i;
                        int col = commentOffset + (tagMatcher.start(1) - 1);
                        if (i == 0) {
                            col += aCmt.getStartColNo();
                        }
                        if (JavadocTagInfo.isValidName(tagName)) {
                            tags.add(new JavadocTag(line, col, tagName,
                                    tagValue));
                        }
                        else {
                            invalidTags.add(new InvalidJavadocTag(line, col,
                                    tagName));
                        }
                    }
                    // else Error: Unexpected match count for inline JavaDoc
                    // tag!
                }
            }
            blockTagPattern =
                    Utils.getPattern("^\\s*\\**\\s*@(\\p{Alpha}+)\\s");
        }
        return new JavadocTags(tags, invalidTags);
    }

    /**
     * The type of Javadoc tag we want returned.
     */
    public enum JavadocTagType
    {
        /** block type. */
        BLOCK,
        /** inline type. */
        INLINE,
        /** all validTags. */
        ALL;
    }

    /**
     * Checks that aCommentContent starts with '*' javadoc comment identifier.
     * @param aCommentContent
     *        content of block comment
     * @return true if aCommentContent starts with '*' javadoc comment
     *         identifier.
     */
    public static boolean isJavadocComment(String aCommentContent)
    {
        boolean result = false;

        if (!aCommentContent.isEmpty()) {
            final char docCommentIdentificator = aCommentContent.charAt(0);
            result = docCommentIdentificator == '*';
        }

        return result;
    }

    /**
     * Checks block comment content starts with '*' javadoc comment identifier.
     * @param aBlockCommentBegin
     *        block comment AST
     * @return true if block comment content starts with '*' javadoc comment
     *         identifier.
     */
    public static boolean isJavadocComment(DetailAST aBlockCommentBegin)
    {
        final String commentContent = getBlockCommentContent(aBlockCommentBegin);
        return isJavadocComment(commentContent);
    }

    /**
     * Gets content of block comment.
     * @param aBlockCommentBegin
     *        block comment AST.
     * @return content of block comment.
     */
    public static String getBlockCommentContent(DetailAST aBlockCommentBegin)
    {
        final DetailAST commentContent = aBlockCommentBegin.getFirstChild();
        return commentContent.getText();
    }

    /**
     * Get content of Javadoc comment.
     * @param aJavadocCommentBegin
     *        Javadoc comment AST
     * @return content of Javadoc comment.
     */
    public static String getJavadocCommentContent(DetailAST aJavadocCommentBegin)
    {
        final DetailAST commentContent = aJavadocCommentBegin.getFirstChild();
        return commentContent.getText().substring(1);
    }

    /**
     * Returns the first child token that has a specified type.
     * @param aNode
     *        Javadoc AST node
     * @param aType
     *        the token type to match
     * @return the matching token, or null if no match
     */
    public static DetailNode findFirstToken(DetailNode aNode, int aType)
    {
        DetailNode retVal = null;
        for (DetailNode i = getFirstChild(aNode); i != null; i = getNextSibling(i)) {
            if (i.getType() == aType) {
                retVal = i;
                break;
            }
        }
        return retVal;
    }

    /**
     * Gets first child node of specified node.
     *
     * @param aNode DetailNode
     * @return first child
     */
    public static DetailNode getFirstChild(DetailNode aNode)
    {
        return aNode.getChildren().length > 0 ? aNode.getChildren()[0] : null;
    }

    /**
     * Checks whether aNode contains any node of specified type among children on any deep level.
     *
     * @param aNode DetailNode
     * @param aType token type
     * @return true if aNode contains any node of aType type among children on any deep level.
     */
    public static boolean branchContains(DetailNode aNode, int aType)
    {
        DetailNode curNode = aNode;
        while (curNode != null) {

            if (aType == curNode.getType()) {
                return true;
            }

            DetailNode toVisit = getFirstChild(curNode);
            while ((curNode != null) && (toVisit == null)) {
                toVisit = getNextSibling(curNode);
                if (toVisit == null) {
                    curNode = curNode.getParent();
                }
            }

            if (curNode == toVisit) {
                break;
            }

            curNode = toVisit;
        }

        return false;
    }

    /**
     * Gets next sibling of specified node.
     *
     * @param aNode DetailNode
     * @return next sibling.
     */
    public static DetailNode getNextSibling(DetailNode aNode)
    {
        final DetailNode parent = aNode.getParent();
        if (parent != null) {
            final int nextSiblingIndex = aNode.getIndex() + 1;
            final DetailNode[] children = parent.getChildren();
            if (nextSiblingIndex <= children.length - 1) {
                return children[nextSiblingIndex];
            }
        }
        return null;
    }

    /**
     * Gets previous sibling of specified node.
     * @param aNode DetailNode
     * @return previous sibling
     */
    public static DetailNode getPreviousSibling(DetailNode aNode)
    {
        final DetailNode parent = aNode.getParent();
        if (parent != null) {
            final int previousSiblingIndex = aNode.getIndex() - 1;
            final DetailNode[] children = parent.getChildren();
            if (previousSiblingIndex >= 0) {
                return children[previousSiblingIndex];
            }
        }
        return null;
    }

    /**
     * Returns the name of a token for a given ID.
     * @param aID
     *        the ID of the token name to get
     * @return a token name
     */
    public static String getTokenName(int aID)
    {
        if (aID == JavadocTokenTypes.EOF) {
            return "EOF";
        }
        if (aID > TOKEN_VALUE_TO_NAME.length - 1) {
            throw new IllegalArgumentException("Unknown javadoc token id. Given id: " + aID);
        }
        final String name = TOKEN_VALUE_TO_NAME[aID];
        if (name == null) {
            throw new IllegalArgumentException("Unknown javadoc token id. Given id: " + aID);
        }
        return name;
    }

    /**
     * Returns the ID of a token for a given name.
     * @param aName
     *        the name of the token ID to get
     * @return a token ID
     */
    public static int getTokenId(String aName)
    {
        final Integer id = TOKEN_NAME_TO_VALUE.get(aName);
        if (id == null) {
            throw new IllegalArgumentException("Unknown javadoc token name. Given name " + aName);
        }
        return id.intValue();
    }

}
