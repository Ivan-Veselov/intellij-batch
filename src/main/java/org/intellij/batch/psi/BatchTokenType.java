package org.intellij.batch.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.batch.BatchLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class BatchTokenType extends IElementType {
    public BatchTokenType(final @NotNull @NonNls String debugName) {
        super(debugName, BatchLanguage.getInstance());
    }

    @Override
    public String toString() {
        return "BatchTokenType." + super.toString();
    }
}
