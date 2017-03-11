package org.intellij.batch;

import com.intellij.psi.tree.IElementType;

public final class BatchTokens {
    public static final IElementType KEYWORD_ECHO = new IElementType("KEYWORD_ECHO", null);

    public static final IElementType KEYWORD_SET = new IElementType("KEYWORD_SET", null);

    public static final IElementType OP_ASSIGN = new IElementType("OP_ASSIGN", null);

    public static final IElementType VAR_IDENTIFIER =
            new IElementType("VAR_IDENTIFIER", null);

    public static final IElementType STRING_LITERAL = new IElementType("STRING_LITERAL", null);
}
