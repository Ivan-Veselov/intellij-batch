package org.intellij.batch.parser;

import com.intellij.lang.ParserDefinition;
import com.intellij.testFramework.ParsingTestCase;
import org.intellij.batch.BatchParserDefinition;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public abstract class BatchParserTest extends ParsingTestCase {
    private BatchParserTest(@NonNls @NotNull String dataPath,
                            @NotNull String fileExt,
                            boolean lowercaseFirstLetter,
                            @NotNull ParserDefinition... definitions) {
        super(dataPath, fileExt, lowercaseFirstLetter, definitions);
    }

    public BatchParserTest() {
        this("", "bat", false, new BatchParserDefinition());
    }

    protected void doTest() {
        doTest(true);
    }
}
