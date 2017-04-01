package org.intellij.batch;

import com.intellij.lexer.Lexer;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.psi.BatchTypes.*;

public class BatchLexerAdapterParenthesesTest extends BatchLexerAdapterTest {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testSimpleOneLineVariations() throws Exception {
        doTest("((command ((5))",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "((5")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command (5(5))",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "(5(5")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command 5((5))",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5((5")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command (5))",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "(5")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command 5))",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("(command ((5)",
                token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "((5")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("(command (5)",
                token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "(5")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("(command 5)",
                token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("command ((5))",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "((5))"));

        doTest("command ((5)5)",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "((5)5)"));

        doTest("command ((5))5",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "((5))5"));

        doTest("command (5))",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "(5))"));

        doTest("command 5))",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5))"));

        doTest("command ((5)",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "((5)"));
    }

    public void testOneLineVariationsWithRedirection() throws Exception {
        doTest("((command t>a))",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "a")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command t)>a)",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(RIGHT_PARENTHESES, ")")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "a")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command t))>a",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "a"));

        doTest("((command t>a)>b)",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "a")
                .token(RIGHT_PARENTHESES, ")")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "b")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command t>a))>b",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "a")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "b"));

        doTest("((command t)>a)>b",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(RIGHT_PARENTHESES, ")")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "a")
                .token(RIGHT_PARENTHESES, ")")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "b"));

        doTest("((command t>a)>b)>c",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "a")
                .token(RIGHT_PARENTHESES, ")")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "b")
                .token(RIGHT_PARENTHESES, ")")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "c"));

        doTest("command t>(",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "("));

        doTest("command t>)",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, ")"));

        doTest("command t>()",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "t")
                .token(REDIRECT_OPERATOR, ">")
                .token(CHAR_SEQUENCE, "()"));
    }

    public void testOneLineVariationsWithConditionals() throws Exception {
        doTest("(command 5 & command 5)",
                token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(WHITE_SPACE, " ")
                .token(CONDITIONAL_OPERATOR, "&")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command 5 & command 5))",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(WHITE_SPACE, " ")
                .token(CONDITIONAL_OPERATOR, "&")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("command 5 & (command 5)",
                token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(WHITE_SPACE, " ")
                .token(CONDITIONAL_OPERATOR, "&")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("(command 5 & (command 5))",
                token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(WHITE_SPACE, " ")
                .token(CONDITIONAL_OPERATOR, "&")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("(command 5) & (command 5)",
                token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(CONDITIONAL_OPERATOR, "&")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")"));

        doTest("((command 5) & (command 5))",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(CONDITIONAL_OPERATOR, "&")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "5")
                .token(RIGHT_PARENTHESES, ")")
                .token(RIGHT_PARENTHESES, ")"));
    }

    public void testOpenedParenthesesOnAnotherLine() throws Exception {
        doTest("(\ncommand arg)",
                token(LEFT_PARENTHESES, "(")
                .token(EOL_OPERATOR, "\\n")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg")
                .token(RIGHT_PARENTHESES, ")"));
    }

    public void testMatchingParenthesesOnAnotherLine() throws Exception {
        doTest("(command arg\n)",
                token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg")
                .token(EOL_OPERATOR, "\\n")
                .token(RIGHT_PARENTHESES, ")"));
    }

    public void testBothParenthesesOnAnotherLine() throws Exception {
        doTest("(\ncommand arg\n)",
                token(LEFT_PARENTHESES, "(")
                .token(EOL_OPERATOR, "\\n")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg")
                .token(EOL_OPERATOR, "\\n")
                .token(RIGHT_PARENTHESES, ")"));
    }

    public void testParenthesizedCommandOnMultipleLines() throws Exception {
        doTest("((\ncommand arg\n)&(command arg)\n)",
                token(LEFT_PARENTHESES, "(")
                .token(LEFT_PARENTHESES, "(")
                .token(EOL_OPERATOR, "\\n")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg")
                .token(EOL_OPERATOR, "\\n")
                .token(RIGHT_PARENTHESES, ")")
                .token(CONDITIONAL_OPERATOR, "&")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg")
                .token(RIGHT_PARENTHESES, ")")
                .token(EOL_OPERATOR, "\\n")
                .token(RIGHT_PARENTHESES, ")"));
    }

    public void testRightParenthesesAsArgumentAfterParentheses() throws Exception {
        doTest("(command) & command )",
                token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(CONDITIONAL_OPERATOR, "&")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, ")"));
    }

    public void testCommandArgWithNoDelimiterViaParentheses() throws Exception {
        doTest("command(arg",
                token(COMMAND_NAME, "command")
                .token(CHAR_SEQUENCE, "(arg"));
    }
}