package org.intellij.batch;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.intellij.batch.parser.BatchParser;
import org.intellij.batch.psi.BatchFile;
import org.intellij.batch.psi.BatchTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.batch.psi.BatchTypes.EOL_OPERATOR;

public class BatchParserDefinition implements ParserDefinition {
    private static final @NotNull TokenSet WHITESPACES = TokenSet.create(WHITE_SPACE, EOL_OPERATOR);

    private static final @NotNull IFileElementType FILE = new IFileElementType(BatchLanguage.getInstance());

    @Override
    public @NotNull Lexer createLexer(final Project project) {
        return new BatchLexerAdapter();
    }

    @Override
    public PsiParser createParser(final Project project) {
        return new BatchParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getWhitespaceTokens() {
        return WHITESPACES;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiElement createElement(final ASTNode node) {
        return BatchTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(final FileViewProvider viewProvider) {
        return new BatchFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(final ASTNode left, final ASTNode right) {
        return SpaceRequirements.MAY;
    }
}
