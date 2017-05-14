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

    public void testIfEqualsWithoutDelimiters() throws Exception {
        doTest();
    }

    public void testIfNotExist() throws Exception {
        doTest();
    }

    public void testIfNotEquals() throws Exception {
        doTest();
    }

    public void testIfExistElse() throws Exception {
        doTest();
    }

    public void testIfEqualsElse() throws Exception {
        doTest();
    }

    public void testIfNotExistElse() throws Exception {
        doTest();
    }

    public void testIfNotEqualsElse() throws Exception {
        doTest();
    }

    public void testIfExistElseOnMultipleLines() throws Exception {
        doTest();
    }

    public void testIfEqualsElseOnMultipleLines() throws Exception {
        doTest();
    }

    public void testNestedIfs() throws Exception {
        doTest();
    }

    public void testNestedIfsInnerWithElse() throws Exception {
        doTest();
    }

    public void testNestedIfsOuterWithElse() throws Exception {
        doTest();
    }

    public void testNestedIfsBothWithElse() throws Exception {
        doTest();
    }
}
