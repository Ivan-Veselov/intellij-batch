package org.intellij.batch.lexer;

import com.intellij.lexer.Lexer;
import org.intellij.batch.BatchLexerAdapter;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.psi.BatchTypes.*;

public class BatchLexerAdapterLabelsTest extends BatchLexerAdapterTest {
    @Override
    protected Lexer createLexer() {
        return new BatchLexerAdapter();
    }

    @Override
    protected String getDirPath() {
        return null;
    }

    public void testLabelDefinition() throws Exception {
        doTest(":label",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label"));
    }

    public void testConsecutiveLabelDefinition() throws Exception {
        doTest(":label1\n:label2",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label1")
                .token(EOL_OPERATOR, "\\n")
                .token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label2"));

        doTest(":label1 \n:label2",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label1")
                .token(WHITE_SPACE, " ")
                .token(EOL_OPERATOR, "\\n")
                .token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label2"));

        doTest(":label1  \n:label2",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label1")
                .token(WHITE_SPACE, "  ")
                .token(EOL_OPERATOR, "\\n")
                .token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label2"));
    }

    public void testLabelWithParenthesesInNameDefinition() throws Exception {
        doTest(":label()",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label()"));

        doTest(":()label",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "()label"));

        doTest(":()",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "()"));
    }

    public void testLabelDefinitionWithIndent() throws Exception {
        doTest("  :label",
                token(WHITE_SPACE, "  ")
                .token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label"));

        doTest("\t:label",
                token(WHITE_SPACE, "\t")
                .token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label"));
    }

    public void testLabelDefinitionWithInnerIndent() throws Exception {
        doTest(":  label",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(WHITE_SPACE, "  ")
                .token(LABEL_NAME, "label"));

        doTest(":\tlabel",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(WHITE_SPACE, "\t")
                .token(LABEL_NAME, "label"));
    }

    public void testLabelDefinitionWithTrailingWhitespaces() throws Exception {
        doTest(":label ",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(WHITE_SPACE, " "));

        doTest(":label  ",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(WHITE_SPACE, "  "));

        doTest(":label\t",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(WHITE_SPACE, "\t"));
    }

    public void testLabelDefinitionWithComment() throws Exception {
        doTest(":label comment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(WHITE_SPACE, " ")
                .token(AFTER_LABEL_NAME_CHARS, "comment"));

        doTest(":label  comment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(WHITE_SPACE, "  ")
                .token(AFTER_LABEL_NAME_CHARS, "comment"));

        doTest(":label\tcomment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(WHITE_SPACE, "\t")
                .token(AFTER_LABEL_NAME_CHARS, "comment"));

        doTest(":label comment ",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(WHITE_SPACE, " ")
                .token(AFTER_LABEL_NAME_CHARS, "comment "));

        doTest(":label:comment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(AFTER_LABEL_NAME_CHARS, ":comment"));

        doTest(":label<comment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(AFTER_LABEL_NAME_CHARS, "<comment"));

        doTest(":label>comment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(AFTER_LABEL_NAME_CHARS, ">comment"));

        doTest(":label&comment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(AFTER_LABEL_NAME_CHARS, "&comment"));

        doTest(":label|comment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(AFTER_LABEL_NAME_CHARS, "|comment"));

        doTest(":label^comment",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label")
                .token(AFTER_LABEL_NAME_CHARS, "^comment"));
    }

    public void testConsecutiveLabelDefinitionWithComments() throws Exception {
        doTest(":label1 comment1\n:label2 comment2",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label1")
                .token(WHITE_SPACE, " ")
                .token(AFTER_LABEL_NAME_CHARS, "comment1")
                .token(EOL_OPERATOR, "\\n")
                .token(LABEL_DEFINITION_OPERATOR, ":")
                .token(LABEL_NAME, "label2")
                .token(WHITE_SPACE, " ")
                .token(AFTER_LABEL_NAME_CHARS, "comment2"));
    }

    public void testDirtyLabelDefinition() throws Exception {
        doTest("\t:  (cmd1)&cmd2 \n  :\t\t()  ",
                token(WHITE_SPACE, "\t")
                .token(LABEL_DEFINITION_OPERATOR, ":")
                .token(WHITE_SPACE, "  ")
                .token(LABEL_NAME, "(cmd1)")
                .token(AFTER_LABEL_NAME_CHARS, "&cmd2 ")
                .token(EOL_OPERATOR, "\\n")
                .token(WHITE_SPACE, "  ")
                .token(LABEL_DEFINITION_OPERATOR, ":")
                .token(WHITE_SPACE, "\t\t")
                .token(LABEL_NAME, "()")
                .token(WHITE_SPACE, "  "));
    }

    public void testJustColon() throws Exception {
        doTest(":",
                token(LABEL_DEFINITION_OPERATOR, ":"));
    }

    public void testConsecutiveColons() throws Exception {
        doTest(":\n:",
                token(LABEL_DEFINITION_OPERATOR, ":")
                .token(EOL_OPERATOR, "\\n")
                .token(LABEL_DEFINITION_OPERATOR, ":"));
    }

    public void testLabelBasedComment() throws Exception {
        doTest("::comment",
                token(LABEL_BASED_COMMENT, "::comment"));

        doTest(":<comment",
                token(LABEL_BASED_COMMENT, ":<comment"));

        doTest(":>comment",
                token(LABEL_BASED_COMMENT, ":>comment"));

        doTest(":&comment",
                token(LABEL_BASED_COMMENT, ":&comment"));

        doTest(":|comment",
                token(LABEL_BASED_COMMENT, ":|comment"));

        doTest(":^comment",
                token(LABEL_BASED_COMMENT, ":^comment"));
    }

    public void testLabelBasedCommentWithIndent() throws Exception {
        doTest(": :comment",
                token(LABEL_BASED_COMMENT, ": :comment"));

        doTest(": <comment",
                token(LABEL_BASED_COMMENT, ": <comment"));

        doTest(": >comment",
                token(LABEL_BASED_COMMENT, ": >comment"));

        doTest(": &comment",
                token(LABEL_BASED_COMMENT, ": &comment"));

        doTest(": |comment",
                token(LABEL_BASED_COMMENT, ": |comment"));

        doTest(": ^comment",
                token(LABEL_BASED_COMMENT, ": ^comment"));
    }
}
