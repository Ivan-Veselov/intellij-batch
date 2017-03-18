package org.intellij.batch;

import com.intellij.psi.tree.IElementType;
import com.intellij.testFramework.LexerTestCase;
import org.jetbrains.annotations.NotNull;

public abstract class BatchLexerAdapterTest extends LexerTestCase {
    protected void doTest(final @NotNull String text, final @NotNull FlexLexerOutputBuilder builder) throws Exception {
        doTest(text, builder.toString());
    }

    protected @NotNull FlexLexerOutputBuilder token(final @NotNull IElementType elementType,
                                                    final @NotNull String charSequence) {
        return new FlexLexerOutputBuilder().token(elementType, charSequence);
    }
}