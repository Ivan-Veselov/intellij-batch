package org.intellij.batch.parser;

public class BatchParserSimpleCommandTest extends BatchParserTest {
    @Override
    protected String getTestDataPath() {
        return "test-data/simple-command";
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

    public void testTwoSequentialSimpleCommands() throws Exception {
        doTest();
    }
}
