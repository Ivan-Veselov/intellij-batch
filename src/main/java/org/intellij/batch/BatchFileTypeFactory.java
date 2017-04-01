package org.intellij.batch;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.fileTypes.FileTypeConsumer.EXTENSION_DELIMITER;

public class BatchFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(final @NotNull FileTypeConsumer consumer) {
        consumer.consume(BatchFileType.getInstance(), "bat" + EXTENSION_DELIMITER + "cmd");
    }
}
