package org.intellij.batch.lexer;

import com.intellij.lexer.Lexer;
import org.intellij.batch.BatchLexerAdapter;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.psi.BatchTypes.*;

public class BatchLexerAdapterIfCommandTest extends BatchLexerAdapterTest {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testCommandNamePrefixedWithIf() throws Exception {
        doTest("ifA arg",
                token(COMMAND_NAME, "ifA")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg"));
    }

    public void testSimpleIf() throws Exception {
        doTest("if exist a command arg",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "a")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg"));

        doTest("IF EXIST a command arg",
                token(IF_KEYWORD, "IF")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "EXIST")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "a")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg"));

        doTest("iF ExIsT a command arg",
                token(IF_KEYWORD, "iF")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "ExIsT")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "a")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg"));

        doTest("if str1 == str2 command arg",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg"));
    }

    public void testNestedIfs() throws Exception {
        doTest("if exist f if exist f command arg",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg"));

        doTest("if str1 == str2 if str1 == str2 command arg",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "arg"));
    }

    public void testIfElse() throws Exception {
        doTest("if exist f (command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if str1 == str2 (command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));
    }

    public void testElseRightAfterParentheses() throws Exception {
        doTest("if exist f (command)else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if str1 == str2 (command)else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));
    }

    public void testIfElseWithPipe() throws Exception {
        doTest("if exist f command|(command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(PIPE_OPERATOR, "|")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if str1 == str2 command|(command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(PIPE_OPERATOR, "|")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));
    }

    public void testIfElseWithConditionals() throws Exception {
        doTest("if exist f command&(command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(COMMAND_JOIN_OPERATOR, "&")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if exist f command||(command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(COMMAND_DISJUNCTION_OPERATOR, "||")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if exist f command&&(command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(COMMAND_CONJUNCTION_OPERATOR, "&&")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if str1 == str2 command&(command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(COMMAND_JOIN_OPERATOR, "&")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if str1 == str2 command||(command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(COMMAND_DISJUNCTION_OPERATOR, "||")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if str1 == str2 command&&(command) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(COMMAND_CONJUNCTION_OPERATOR, "&&")
                .token(LEFT_PARENTHESES, "(")
                .token(COMMAND_NAME, "command")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));
    }

    public void testIfElseOnMultipleLines() throws Exception {
        doTest("if exist f (\ncommand\n) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(EOL_OPERATOR, "\\n")
                .token(COMMAND_NAME, "command")
                .token(EOL_OPERATOR, "\\n")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));

        doTest("if str1 == str2 (\ncommand\n) else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(LEFT_PARENTHESES, "(")
                .token(EOL_OPERATOR, "\\n")
                .token(COMMAND_NAME, "command")
                .token(EOL_OPERATOR, "\\n")
                .token(RIGHT_PARENTHESES, ")")
                .token(WHITE_SPACE, " ")
                .token(ELSE_KEYWORD, "else")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command"));
    }

    public void testIfWithFakeElse() throws Exception {
        doTest("if exist f command else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(EXIST_KEYWORD, "exist")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "f")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "else")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "command"));

        doTest("if str1 == str2 command else command",
                token(IF_KEYWORD, "if")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str1")
                .token(WHITE_SPACE, " ")
                .token(EQUALITY_OPERATOR, "==")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "str2")
                .token(WHITE_SPACE, " ")
                .token(COMMAND_NAME, "command")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "else")
                .token(WHITE_SPACE, " ")
                .token(CHAR_SEQUENCE, "command"));
    }
}
