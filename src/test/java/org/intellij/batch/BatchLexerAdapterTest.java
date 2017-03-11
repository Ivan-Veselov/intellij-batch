package org.intellij.batch;

import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.testFramework.LexerTestCase;
import org.jetbrains.annotations.NotNull;

import static org.intellij.batch.BatchTokens.*;

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
        doTest("echo", new LexerOutputBuilder().token(KEYWORD_ECHO, "echo").toString());
    }

    public void testEchoUpperCase() throws Exception {
        doTest("ECHO", new LexerOutputBuilder().token(KEYWORD_ECHO, "ECHO").toString());
    }

    public void testEchoMultiCase() throws Exception {
        doTest("EcHo", new LexerOutputBuilder().token(KEYWORD_ECHO, "EcHo").toString());
    }

    public void testEchoWithWhiteSpaces() throws Exception {
        doTest(" echo \n", new LexerOutputBuilder().token(KEYWORD_ECHO, "echo").toString());
    }

    public void testSetNormal() throws Exception {
        doTest("set name=str\necho",
                new LexerOutputBuilder()
                        .token(KEYWORD_SET, "set")
                        .token(VAR_IDENTIFIER, "name")
                        .token(OP_ASSIGN, "=")
                        .token(STRING_LITERAL, "str")
                        .token(KEYWORD_ECHO, "echo")
                        .toString());
    }

    public void testSetOddString() throws Exception {
        doTest("set name=  str = \necho",
                new LexerOutputBuilder()
                        .token(KEYWORD_SET, "set")
                        .token(VAR_IDENTIFIER, "name")
                        .token(OP_ASSIGN, "=")
                        .token(STRING_LITERAL, "  str = ")
                        .token(KEYWORD_ECHO, "echo")
                        .toString());
    }

    public void testSetOddIdentifier() throws Exception {
        doTest("set   na  me  =str\necho",
                new LexerOutputBuilder()
                        .token(KEYWORD_SET, "set")
                        .token(VAR_IDENTIFIER, "na  me  ")
                        .token(OP_ASSIGN, "=")
                        .token(STRING_LITERAL, "str")
                        .token(KEYWORD_ECHO, "echo")
                        .toString());
    }

    public void testSetNoIdentifier() throws Exception {
        doTest("SET   ===\necho",
                new LexerOutputBuilder()
                        .token(KEYWORD_SET, "SET")
                        .token(OP_ASSIGN, "=")
                        .token(STRING_LITERAL, "==")
                        .token(KEYWORD_ECHO, "echo")
                        .toString());
    }

    public void testSetNoString() throws Exception {
        doTest("SeT   name =\necho",
                new LexerOutputBuilder()
                        .token(KEYWORD_SET, "SeT")
                        .token(VAR_IDENTIFIER, "name ")
                        .token(OP_ASSIGN, "=")
                        .token(KEYWORD_ECHO, "echo")
                        .toString());
    }

    public void testSetIdentifierOnly() throws Exception {
        doTest("set  \tname  \necho",
                new LexerOutputBuilder()
                        .token(KEYWORD_SET, "set")
                        .token(VAR_IDENTIFIER, "name  ")
                        .token(KEYWORD_ECHO, "echo")
                        .toString());
    }

    public void testSetAssignOnly() throws Exception {
        doTest("set    =\necho",
                new LexerOutputBuilder()
                        .token(KEYWORD_SET, "set")
                        .token(OP_ASSIGN, "=")
                        .token(KEYWORD_ECHO, "echo")
                        .toString());
    }

    public void testSetKeywordsInside() throws Exception {
        doTest("set echo=echo\necho",
                new LexerOutputBuilder()
                        .token(KEYWORD_SET, "set")
                        .token(VAR_IDENTIFIER, "echo")
                        .token(OP_ASSIGN, "=")
                        .token(STRING_LITERAL, "echo")
                        .token(KEYWORD_ECHO, "echo")
                        .toString());
    }

    private final class LexerOutputBuilder {
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