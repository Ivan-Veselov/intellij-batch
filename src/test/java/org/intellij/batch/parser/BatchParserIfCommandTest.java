package org.intellij.batch.parser;

public class BatchParserIfCommandTest extends BatchParserTest {
    @Override
    protected String getTestDataPath() {
        return "test-data/if-command";
    }

    public void testSimpleIfExist() throws Exception {
        doTest();
    }

    public void testSimpleIfEquals() throws Exception {
        doTest();
    }

    public void testIfExistElse() throws Exception {
        doTest();
    }

    public void testIfEqualsElse() throws Exception {
        doTest();
    }

    // TODO: add more tests.
    // TODO: Test with nested ifs.
}
