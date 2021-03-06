package org.intellij.batch.lexer;

import com.intellij.lexer.Lexer;
import org.intellij.batch.BatchLexerAdapter;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.psi.BatchTypes.*;

public class BatchLexerAdapterRedirectionTest extends BatchLexerAdapterTest {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testSimpleRedirection() throws Exception {
        doTest("command > out", token(COMMAND_NAME, "command")
                                    .token(WHITE_SPACE, " ")
                                    .token(REDIRECT_TO_FILE_OPERATOR, ">")
                                    .token(WHITE_SPACE, " ")
                                    .token(CHAR_SEQUENCE, "out"));
    }

    public void testRedirectionWithWhitespaces() throws Exception {
        doTest("command  >  \tout", token(COMMAND_NAME, "command")
                                        .token(WHITE_SPACE, "  ")
                                        .token(REDIRECT_TO_FILE_OPERATOR, ">")
                                        .token(WHITE_SPACE, "  \t")
                                        .token(CHAR_SEQUENCE, "out"));
    }

    public void testSimpleRedirectionWithoutWhitespaces() throws Exception {
        doTest("command>out", token(COMMAND_NAME, "command")
                                  .token(REDIRECT_TO_FILE_OPERATOR, ">")
                                  .token(CHAR_SEQUENCE, "out"));
    }


    /**
     * Wrong tokenization
     */
    public void testSimpleRedirectionBeforeCommand() throws Exception {
        doTest("> out command", token(REDIRECT_TO_FILE_OPERATOR, ">")
                                    .token(WHITE_SPACE, " ")
                                    .token(CHAR_SEQUENCE, "out")
                                    .token(WHITE_SPACE, " ")
                                    .token(COMMAND_NAME, "command"));
    }

    public void testRedirectionWithHandle() throws Exception {
        doTest("command 2> out", token(COMMAND_NAME, "command")
                                     .token(WHITE_SPACE, " ")
                                     .token(REDIRECT_TO_FILE_OPERATOR, "2>")
                                     .token(WHITE_SPACE, " ")
                                     .token(CHAR_SEQUENCE, "out"));
    }

    public void testRedirectionRightAfterArgumentWithDigit() throws Exception {
        doTest("command arg1> out", token(COMMAND_NAME, "command")
                                        .token(WHITE_SPACE, " ")
                                        .token(CHAR_SEQUENCE, "arg1")
                                        .token(REDIRECT_TO_FILE_OPERATOR, ">")
                                        .token(WHITE_SPACE, " ")
                                        .token(CHAR_SEQUENCE, "out"));
    }

    public void testRedirectionRightAfterDigits() throws Exception {
        doTest("command 11> out", token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "11")
                .token(REDIRECT_TO_FILE_OPERATOR, ">")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "out"));
    }

    public void testRedirectionToHandle() throws Exception {
        doTest("command >&1", token(COMMAND_NAME, "command")
                                   .token(WHITE_SPACE, " ")
                                   .token(REDIRECT_TO_HANDLE_OPERATOR, ">&1"));
    }

    public void testRedirectionToHandleWithArgumentAfterIt() throws Exception {
        doTest("command >&1 arg", token(COMMAND_NAME, "command")
                                      .token(WHITE_SPACE, " ")
                                      .token(REDIRECT_TO_HANDLE_OPERATOR, ">&1")
                                      .token(WHITE_SPACE, " ")
                                      .token(CHAR_SEQUENCE, "arg"));
    }

    public void testRedirectionFromHandleToHandle() throws Exception {
        doTest("command 2>&1", token(COMMAND_NAME, "command")
                                   .token(WHITE_SPACE, " ")
                                   .token(REDIRECT_TO_HANDLE_OPERATOR, "2>&1"));
    }

    public void testRedirectionFromHandleToHandleWithSubsequentArgument() throws Exception {
        doTest("command 2>&100", token(COMMAND_NAME, "command")
                                     .token(WHITE_SPACE, " ")
                                     .token(REDIRECT_TO_HANDLE_OPERATOR, "2>&1")
                                     .token(CHAR_SEQUENCE, "00"));
    }

    public void testRedirectionFromHandleToHandleRightBeforeCommand() throws Exception {
        doTest("2>&1command", token(REDIRECT_TO_HANDLE_OPERATOR, "2>&1")
                                  .token(COMMAND_NAME, "command"));
    }
}