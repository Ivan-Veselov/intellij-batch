package org.intellij.batch;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class BatchFileType extends LanguageFileType {
    private static final @NotNull BatchFileType INSTANCE = new BatchFileType();

    public static @NotNull BatchFileType getInstance() {
        return INSTANCE;
    }

    @Override
    public @NotNull String getName() {
        return "Batch file";
    }

    @Override
    public @NotNull String getDescription() {
        return "Batch script file";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "bat";
    }

    @Override
    public @Nullable Icon getIcon() {
        return null;
    }

    private BatchFileType() {
        super(BatchLanguage.getInstance());
    }
}
