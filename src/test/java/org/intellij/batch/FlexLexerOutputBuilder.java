package org.intellij.batch;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public final class FlexLexerOutputBuilder {
    private final @NotNull
    StringBuilder stringBuilder = new StringBuilder();

    public @NotNull
    FlexLexerOutputBuilder token(final @NotNull IElementType elementType, final @NotNull String charSequence) {
        stringBuilder.append(elementType.toString());
        stringBuilder.append(" ('");
        stringBuilder.append(charSequence);
        stringBuilder.append("')\n");

        return this;
    }

    public @NotNull String toString() {
        return stringBuilder.toString();
    }
}
