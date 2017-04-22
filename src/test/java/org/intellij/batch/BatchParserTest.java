package org.intellij.batch;

import com.intellij.lang.ParserDefinition;
import com.intellij.testFramework.ParsingTestCase;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class BatchParserTest extends ParsingTestCase {
    private BatchParserTest(@NonNls @NotNull String dataPath,
                            @NotNull String fileExt,
                            boolean lowercaseFirstLetter,
                            @NotNull ParserDefinition... definitions) {
        super(dataPath, fileExt, lowercaseFirstLetter, definitions);
    }

    public BatchParserTest() {
        this("", "bat", false, new BatchParserDefinition());
    }

    @Override
    protected String getTestDataPath() {
        return "test-data/";
    }

    private void doTest() {
        doTest(true);
    }

    public void testSimpleCommandWithNoArguments() throws Exception {
        doTest();
    }

    public void testSimpleCommandWithArgument() throws Exception {
        doTest();
    }

    public void testSimpleCommandWithMultipleArguments() throws Exception {
        doTest();
    }

    public void testTwoSimpleCommandsInPipeline() throws Exception {
        doTest();
    }

    public void testThreeSimpleCommandsInPipeline() throws Exception {
        doTest();
    }

    public void testTwoPipedCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testThreePipedCommandsWithArguments() throws Exception {
        doTest();
    }
}
