package org.intellij.batch;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

public class BatchLanguage extends Language {
    private static final @NotNull BatchLanguage INSTANCE = new BatchLanguage();

    public static @NotNull BatchLanguage getInstance() {
        return INSTANCE;
    }

    private BatchLanguage() {
        super("Batch");
    }
}
