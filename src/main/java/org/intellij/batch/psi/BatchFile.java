package org.intellij.batch.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.intellij.batch.BatchFileType;
import org.intellij.batch.BatchLanguage;
import org.jetbrains.annotations.NotNull;

public class BatchFile extends PsiFileBase {
    public BatchFile(final @NotNull FileViewProvider viewProvider) {
        super(viewProvider, BatchLanguage.getInstance());
    }

    @Override
    public @NotNull FileType getFileType() {
        return BatchFileType.getInstance();
    }

    @Override
    public @NotNull String toString() {
        return "Batch File";
    }
}
