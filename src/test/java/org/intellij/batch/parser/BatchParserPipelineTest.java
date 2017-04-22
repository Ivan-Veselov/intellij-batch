package org.intellij.batch.parser;

public class BatchParserPipelineTest extends BatchParserTest {
    @Override
    protected String getTestDataPath() {
        return "test-data/pipeline";
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

    public void testPipeWithRedirection() throws Exception {
        doTest();
    }

    public void testTwoSequentialPipedCommands() throws Exception {
        doTest();
    }
}
