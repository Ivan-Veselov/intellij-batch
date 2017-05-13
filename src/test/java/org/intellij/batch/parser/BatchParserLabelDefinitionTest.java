package org.intellij.batch.parser;

public class BatchParserLabelDefinitionTest extends BatchParserTest {
    @Override
    protected String getTestDataPath() {
        return "test-data/label-definition";
    }

    public void testSimpleDefinition() throws Exception {
        doTest();
    }

    public void testConsecutiveDefinitions() throws Exception {
        doTest();
    }
}
