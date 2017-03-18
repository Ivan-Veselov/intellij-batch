package org.intellij.batch;

import com.intellij.psi.tree.IElementType;

public final class BatchTokens {
    public static final IElementType COMMAND_NAME = new IElementType("COMMAND_NAME", null);

    public static final IElementType COMMAND_ARGUMENT = new IElementType("COMMAND_ARGUMENT", null);

    public static final IElementType EOL_OPERATOR = new IElementType("EOL_OPERATOR", null);
}
