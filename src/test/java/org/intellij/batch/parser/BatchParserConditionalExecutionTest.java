package org.intellij.batch.parser;

public class BatchParserConditionalExecutionTest extends BatchParserTest {
    @Override
    protected String getTestDataPath() {
        return "test-data/conditional-execution";
    }

    public void testDisjunctionOfTwoCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testDisjunctionOfThreeCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testDisjunctionOfTwoCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testDisjunctionOfThreeCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testConjunctionOfTwoCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testConjunctionOfThreeCommandsWithNoArguments() throws Exception {
        doTest();
    }

    public void testConjunctionOfTwoCommandsWithArguments() throws Exception {
        doTest();
    }

    public void testConjunctionOfThreeCommandsWithArguments() throws Exception {
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

    public void testThreeSequentialConditionalCommands() throws Exception {
        doTest();
    }

    public void testMixedConditionalsWithNoArguments() throws Exception {
        doTest();
    }

    public void testMixedConditionalsWithArguments() throws Exception {
        doTest();
    }

    public void testConjunctionWithPipe() throws Exception {
        doTest();
    }

    public void testDisjunctionWithPipe() throws Exception {
        doTest();
    }

    public void testJoiningWithPipe() throws Exception {
        doTest();
    }
}
