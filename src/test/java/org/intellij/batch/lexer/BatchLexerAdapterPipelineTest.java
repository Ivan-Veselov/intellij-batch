package org.intellij.batch.lexer;

import com.intellij.lexer.Lexer;
import org.intellij.batch.BatchLexerAdapter;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.psi.BatchTypes.*;

public class BatchLexerAdapterPipelineTest extends BatchLexerAdapterTest {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testSinglePipe() throws Exception {
        doTest("command1 | command2", token(COMMAND_NAME, "command1")
                                          .token(WHITE_SPACE, " ")
                                          .token(PIPE_OPERATOR, "|")
                                          .token(WHITE_SPACE, " ")
                                          .token(COMMAND_NAME, "command2"));
    }

    public void testSinglePipeWithoutWhitespaces() throws Exception {
        doTest("command1|command2", token(COMMAND_NAME, "command1")
                                        .token(PIPE_OPERATOR, "|")
                                        .token(COMMAND_NAME, "command2"));
    }

    public void testMultiplePipes() throws Exception {
        doTest("command1|command2|command3", token(COMMAND_NAME, "command1")
                                                  .token(PIPE_OPERATOR, "|")
                                                  .token(COMMAND_NAME, "command2")
                                                  .token(PIPE_OPERATOR, "|")
                                                  .token(COMMAND_NAME, "command3"));
    }

    public void testRedirectionBeforePipe() throws Exception {
        doTest("command1 2>&1|command2", token(COMMAND_NAME, "command1")
                                             .token(WHITE_SPACE, " ")
                                             .token(REDIRECT_TO_HANDLE_OPERATOR, "2>&1")
                                             .token(PIPE_OPERATOR, "|")
                                             .token(COMMAND_NAME, "command2"));
    }

    public void testRedirectionAfterPipe() throws Exception {
        doTest("command1 |>out command2", token(COMMAND_NAME, "command1")
                                              .token(WHITE_SPACE, " ")
                                              .token(PIPE_OPERATOR, "|")
                                              .token(REDIRECT_TO_FILE_OPERATOR, ">")
                                              .token(CHAR_SEQUENCE, "out")
                                              .token(WHITE_SPACE, " ")
                                              .token(COMMAND_NAME, "command2"));
    }

    public void testPipeWithCommandsArguments() throws Exception {
        doTest("command1 arg1|command2 arg2", token(COMMAND_NAME, "command1")
                                                  .token(WHITE_SPACE, " ")
                                                  .token(CHAR_SEQUENCE, "arg1")
                                                  .token(PIPE_OPERATOR, "|")
                                                  .token(COMMAND_NAME, "command2")
                                                  .token(WHITE_SPACE, " ")
                                                  .token(CHAR_SEQUENCE, "arg2"));
    }
}