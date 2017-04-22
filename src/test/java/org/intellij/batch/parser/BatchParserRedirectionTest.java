package org.intellij.batch.parser;

public class BatchParserRedirectionTest extends BatchParserTest {
    @Override
    protected String getTestDataPath() {
        return "test-data/redirection";
    }

    public void testRedirectionToFileWithoutArguments() throws Exception {
        doTest();
    }

    public void testRedirectionToFileBeforeArguments() throws Exception {
        doTest();
    }

    public void testRedirectionToFileBeforeCommand() throws Exception {
        doTest();
    }

    public void testRedirectionToFileBetweenArguments() throws Exception {
        doTest();
    }

    public void testRedirectionToFileAfterArguments() throws Exception {
        doTest();
    }

    public void testRedirectionToHandleWithoutArguments() throws Exception {
        doTest();
    }

    public void testRedirectionToHandleBeforeArguments() throws Exception {
        doTest();
    }

    public void testRedirectionToHandleBeforeCommand() throws Exception {
        doTest();
    }

    public void testRedirectionToHandleBetweenArguments() throws Exception {
        doTest();
    }

    public void testRedirectionToHandleAfterArguments() throws Exception {
        doTest();
    }

    public void testMultipleRedirectionsToFile() throws Exception {
        doTest();
    }
}
