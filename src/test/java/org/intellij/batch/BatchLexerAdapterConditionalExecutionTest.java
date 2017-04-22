package org.intellij.batch;

import com.intellij.lexer.Lexer;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.psi.BatchTypes.*;

public class BatchLexerAdapterConditionalExecutionTest extends BatchLexerAdapterTest {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testAllConditionals() throws Exception {
        doTest("command1&command2&&command3||command4",
                            token(COMMAND_NAME, "command1")
                            .token(COMMAND_JOIN_OPERATOR, "&")
                            .token(COMMAND_NAME, "command2")
                            .token(COMMAND_AND_OPERATOR, "&&")
                            .token(COMMAND_NAME, "command3")
                            .token(COMMAND_OR_OPERATOR, "||")
                            .token(COMMAND_NAME, "command4"));
    }

    public void testConditionalWithRedirectionBeforeIt() throws Exception {
        doTest("command1>out&command2",
                token(COMMAND_NAME, "command1")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "out")
                .token(COMMAND_JOIN_OPERATOR, "&")
                .token(COMMAND_NAME, "command2"));

        doTest("command1>out&&command2",
                token(COMMAND_NAME, "command1")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "out")
                .token(COMMAND_AND_OPERATOR, "&&")
                .token(COMMAND_NAME, "command2"));

        doTest("command1>out||command2",
                token(COMMAND_NAME, "command1")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "out")
                .token(COMMAND_OR_OPERATOR, "||")
                .token(COMMAND_NAME, "command2"));
    }

    public void testConditionalWithRedirectionAfterIt() throws Exception {
        doTest("command1&>out command2",
                token(COMMAND_NAME, "command1")
                .token(COMMAND_JOIN_OPERATOR, "&")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "out")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command2"));

        doTest("command1&&>out command2",
                token(COMMAND_NAME, "command1")
                .token(COMMAND_AND_OPERATOR, "&&")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "out")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command2"));

        doTest("command1||>out command2",
                token(COMMAND_NAME, "command1")
                .token(COMMAND_OR_OPERATOR, "||")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "out")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command2"));
    }
}