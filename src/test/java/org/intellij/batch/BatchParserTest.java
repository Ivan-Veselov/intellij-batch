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

    public void testTwoSequentialSimpleCommands() throws Exception {
        doTest();
    }

    public void testTwoSequentialPipedCommands() throws Exception {
        doTest();
    }

    public void testOrOfTwoCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testOrOfThreeCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testOrOfTwoCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testOrOfThreeCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testAndOfTwoCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testAndOfThreeCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testAndOfTwoCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testAndOfThreeCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testJoinOfTwoCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testJoinOfThreeCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testJoinOfTwoCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testJoinOfThreeCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testThreeSequentialBooleanCommands() throws Exception {
        doTest();
    }
}
