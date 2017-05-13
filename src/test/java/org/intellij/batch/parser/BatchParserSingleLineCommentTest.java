package org.intellij.batch.parser;

public class BatchParserSingleLineCommentTest extends BatchParserTest {
    @Override
    protected String getTestDataPath() {
        return "test-data/lable-based-comment";
    }

    public void testComment() throws Exception {
        doTest();
    }

    public void testConsecutiveComments() throws Exception {
        doTest();
    }
}
