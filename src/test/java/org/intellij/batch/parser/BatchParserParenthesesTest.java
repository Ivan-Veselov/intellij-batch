package org.intellij.batch.parser;

public class BatchParserParenthesesTest extends BatchParserTest {
    @Override
    protected String getTestDataPath() {
        return "test-data/parentheses";
    }

    public void testCommandWithNoArgumentsInParentheses() throws Exception {
        doTest();
    }

    public void testCommandWithArgumentsInParentheses() throws Exception {
        doTest();
    }

    public void testRedirectionToFileAfterParentheses() throws Exception {
        doTest();
    }

    public void testRedirectionToFileBeforeParentheses() throws Exception {
        doTest();
    }

    public void testMultipleRedirectionAroundParentheses() throws Exception {
        doTest();
    }

    public void testPipeAfterParentheses() throws Exception {
        doTest();
    }

    public void testConditionalWithParentheses() throws Exception {
        doTest();
    }

    public void testSequenceOfCommandsInParentheses() throws Exception {
        doTest();
    }

    public void testComplexTest() throws Exception {
        doTest();
    }
}
