package org.intellij.batch;

import com.intellij.lexer.Lexer;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.psi.BatchTypes.*;

public final class BatchLexerAdapterCommandBasicsTest extends BatchLexerAdapterTest {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testSingleCommand() throws Exception {
        doTest("command", token(COMMAND_NAME, "command"));
    }

    public void testCommandSurroundedByWhitespaces() throws Exception {
        doTest("\t  command\t ", token(WHITE_SPACE, "\t  ")
                                     .token(COMMAND_NAME, "command")
                                     .token(WHITE_SPACE, "\t "));
    }

    public void testCommandSurroundedByLineTerminators() throws Exception {
        doTest("\ncommand\r\n", token(EOL_OPERATOR, "\\n")
                                    .token(COMMAND_NAME, "command")
                                    .token(EOL_OPERATOR, "\r\\n"));
    }

    public void testCommandWithArgument() throws Exception {
        doTest("command arg", token(COMMAND_NAME, "command")
                                  .token(WHITE_SPACE, " ")
                                  .token(CHAR_SEQUENCE, "arg"));
    }

    public void testCommandArgumentSurroundedByWhitespaces() throws Exception {
        doTest("command  \targ\t", token(COMMAND_NAME, "command")
                                        .token(WHITE_SPACE, "  \t")
                                        .token(CHAR_SEQUENCE, "arg")
                                        .token(WHITE_SPACE, "\t"));
    }

    public void testCommandWithMultipleArguments() throws Exception {
        doTest("command arg1 arg2", token(COMMAND_NAME, "command")
                                        .token(WHITE_SPACE, " ")
                                        .token(CHAR_SEQUENCE, "arg1")
                                        .token(WHITE_SPACE, " ")
                                        .token(CHAR_SEQUENCE, "arg2"));
    }

    public void testCommandWithMultipleArgumentsAndLineTerminator() throws Exception {
        doTest("command arg1 arg2\n", token(COMMAND_NAME, "command")
                                          .token(WHITE_SPACE, " ")
                                          .token(CHAR_SEQUENCE, "arg1")
                                          .token(WHITE_SPACE, " ")
                                          .token(CHAR_SEQUENCE, "arg2")
                                          .token(EOL_OPERATOR, "\\n"));
    }

    public void testMultipleCommands() throws Exception {
        doTest("command1 arg1 arg2\ncommand2 arg", token(COMMAND_NAME, "command1")
                                                       .token(WHITE_SPACE, " ")
                                                       .token(CHAR_SEQUENCE, "arg1")
                                                       .token(WHITE_SPACE, " ")
                                                       .token(CHAR_SEQUENCE, "arg2")
                                                       .token(EOL_OPERATOR, "\\n")
                                                       .token(COMMAND_NAME, "command2")
                                                       .token(WHITE_SPACE, " ")
                                                       .token(CHAR_SEQUENCE, "arg"));
    }

    public void testMultipleCommandsSurroundedByLineTerminators() throws Exception {
        doTest("\ncommand1 arg1 arg2\ncommand2 arg\n", token(EOL_OPERATOR, "\\n")
                                                           .token(COMMAND_NAME, "command1")
                                                           .token(WHITE_SPACE, " ")
                                                           .token(CHAR_SEQUENCE, "arg1")
                                                           .token(WHITE_SPACE, " ")
                                                           .token(CHAR_SEQUENCE, "arg2")
                                                           .token(EOL_OPERATOR, "\\n")
                                                           .token(COMMAND_NAME, "command2")
                                                           .token(WHITE_SPACE, " ")
                                                           .token(CHAR_SEQUENCE, "arg")
                                                           .token(EOL_OPERATOR, "\\n"));
    }
}