package org.intellij.batch.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.testFramework.LexerTestCase;
import org.jetbrains.annotations.NotNull;

// TODO: override createLexer method?
public abstract class BatchLexerAdapterTest extends LexerTestCase {
    protected void doTest(final @NotNull String text, final @NotNull FlexLexerOutputBuilder builder) throws Exception {
        doTest(text, builder.toString());
    }

    protected @NotNull FlexLexerOutputBuilder token(final @NotNull IElementType elementType,
                                                    final @NotNull String charSequence) {
        return new FlexLexerOutputBuilder().token(elementType, charSequence);
    }
}