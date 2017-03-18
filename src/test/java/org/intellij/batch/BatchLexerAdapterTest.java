package org.intellij.batch;

import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.testFramework.LexerTestCase;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.BatchTokens.*;

public final class BatchLexerAdapterTest extends LexerTestCase {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    private void doTest(final @NotNull String text, final @NotNull LexerOutputBuilder builder) throws Exception {
        doTest(text, builder.toString());
    }

    private @NotNull LexerOutputBuilder token(final @NotNull IElementType elementType,
                                              final @NotNull String charSequence) {
        return new LexerOutputBuilder().token(elementType, charSequence);
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
                                  .token(COMMAND_ARGUMENT, "arg"));
    }

    public void testCommandArgumentSurroundedByWhitespaces() throws Exception {
        doTest("command  \targ\t", token(COMMAND_NAME, "command")
                                        .token(WHITE_SPACE, "  \t")
                                        .token(COMMAND_ARGUMENT, "arg")
                                        .token(WHITE_SPACE, "\t"));
    }

    public void testCommandWithMultipleArguments() throws Exception {
        doTest("command arg1 arg2", token(COMMAND_NAME, "command")
                                        .token(WHITE_SPACE, " ")
                                        .token(COMMAND_ARGUMENT, "arg1")
                                        .token(WHITE_SPACE, " ")
                                        .token(COMMAND_ARGUMENT, "arg2"));
    }

    public void testCommandWithMultipleArgumentsAndLineTerminator() throws Exception {
        doTest("command arg1 arg2\n", token(COMMAND_NAME, "command")
                                          .token(WHITE_SPACE, " ")
                                          .token(COMMAND_ARGUMENT, "arg1")
                                          .token(WHITE_SPACE, " ")
                                          .token(COMMAND_ARGUMENT, "arg2")
                                          .token(EOL_OPERATOR, "\\n"));
    }

    public void testMultipleCommands() throws Exception {
        doTest("command1 arg1 arg2\ncommand2 arg", token(COMMAND_NAME, "command1")
                                                       .token(WHITE_SPACE, " ")
                                                       .token(COMMAND_ARGUMENT, "arg1")
                                                       .token(WHITE_SPACE, " ")
                                                       .token(COMMAND_ARGUMENT, "arg2")
                                                       .token(EOL_OPERATOR, "\\n")
                                                       .token(COMMAND_NAME, "command2")
                                                       .token(WHITE_SPACE, " ")
                                                       .token(COMMAND_ARGUMENT, "arg"));
    }

    public void testMultipleCommandsSurroundedByLineTerminators() throws Exception {
        doTest("\ncommand1 arg1 arg2\ncommand2 arg\n", token(EOL_OPERATOR, "\\n")
                                                           .token(COMMAND_NAME, "command1")
                                                           .token(WHITE_SPACE, " ")
                                                           .token(COMMAND_ARGUMENT, "arg1")
                                                           .token(WHITE_SPACE, " ")
                                                           .token(COMMAND_ARGUMENT, "arg2")
                                                           .token(EOL_OPERATOR, "\\n")
                                                           .token(COMMAND_NAME, "command2")
                                                           .token(WHITE_SPACE, " ")
                                                           .token(COMMAND_ARGUMENT, "arg")
                                                           .token(EOL_OPERATOR, "\\n"));
    }

    private static final class LexerOutputBuilder {
        private final @NotNull StringBuilder stringBuilder = new StringBuilder();

        public @NotNull LexerOutputBuilder token(final @NotNull IElementType elementType,
                                                 final @NotNull String charSequence) {
            stringBuilder.append(elementType.toString());
            stringBuilder.append(" ('");
            stringBuilder.append(charSequence);
            stringBuilder.append("')\n");

            return this;
        }

        public @NotNull String toString() {
            return stringBuilder.toString();
        }
    }
}