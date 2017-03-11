package org.intellij.batch;

import com.intellij.lexer.Lexer;
import com.intellij.testFramework.LexerTestCase;

public class BatchLexerAdapterTest extends LexerTestCase {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testEchoLowerCase() throws Exception {
        doTest("echo", "KEYWORD_ECHO ('echo')");
    }

    public void testEchoUpperCase() throws Exception {
        doTest("ECHO", "KEYWORD_ECHO ('ECHO')");
    }

    public void testEchoMultiCase() throws Exception {
        doTest("EcHo", "KEYWORD_ECHO ('EcHo')");
    }

    public void testEchoWithWhiteSpaces() throws Exception {
        doTest(" echo \n", "KEYWORD_ECHO ('echo')");
    }
}