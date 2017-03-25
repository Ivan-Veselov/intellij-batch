package org.intellij.batch;

import com.intellij.psi.tree.IElementType;

public final class BatchTokens {
    public static final IElementType COMMAND_NAME = new IElementType("COMMAND_NAME", null);

    public static final IElementType CHAR_SEQUENCE = new IElementType("CHAR_SEQUENCE", null);

    public static final IElementType EOL_OPERATOR = new IElementType("EOL_OPERATOR", null);

    public static final IElementType REDIRECT_OPERATOR = new IElementType("REDIRECT_OPERATOR", null);

    public static final IElementType PIPE_OPERATOR = new IElementType("PIPE_OPERATOR", null);

    public static final IElementType CONDITIONAL_OPERATOR = new IElementType("CONDITIONAL_OPERATOR", null);

    public static final IElementType LEFT_PARENTHESES = new IElementType("LEFT_PARENTHESES", null);

    public static final IElementType RIGHT_PARENTHESES = new IElementType("RIGHT_PARENTHESES", null);

    public static final IElementType IF_KEYWORD = new IElementType("IF_KEYWORD", null);

    public static final IElementType EXIST_KEYWORD = new IElementType("EXIST_KEYWORD", null);
}
