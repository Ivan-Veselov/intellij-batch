package org.intellij.batch;

import com.intellij.lexer.Lexer;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.BatchTokens.*;

public class BatchLexerAdapterIfCommandTest extends BatchLexerAdapterTest {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testSimpleIfExistLowerCase() throws Exception {
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
    }

    public void testSimpleIfExistUpperCase() throws Exception {
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
    }

    public void testSimpleIfExistMixedCase() throws Exception {
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
    }

    public void testNestedIfExist() throws Exception {
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
        }
}