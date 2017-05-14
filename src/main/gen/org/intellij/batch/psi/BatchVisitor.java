// This is a generated file. Not intended for manual editing.
package org.intellij.batch.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class BatchVisitor extends PsiElementVisitor {

  public void visitCommand(@NotNull BatchCommand o) {
    visitPsiElement(o);
  }

  public void visitConjointCommand(@NotNull BatchConjointCommand o) {
    visitCommand(o);
  }

  public void visitDisjointCommand(@NotNull BatchDisjointCommand o) {
    visitCommand(o);
  }

  public void visitEqualityCondition(@NotNull BatchEqualityCondition o) {
    visitPsiElement(o);
  }

  public void visitErrorlevelCondition(@NotNull BatchErrorlevelCondition o) {
    visitPsiElement(o);
  }

  public void visitExistCondition(@NotNull BatchExistCondition o) {
    visitPsiElement(o);
  }

  public void visitIfCommand(@NotNull BatchIfCommand o) {
    visitCommand(o);
  }

  public void visitIfCondition(@NotNull BatchIfCondition o) {
    visitPsiElement(o);
  }

  public void visitIfNegatedCondition(@NotNull BatchIfNegatedCondition o) {
    visitPsiElement(o);
  }

  public void visitJoinedCommand(@NotNull BatchJoinedCommand o) {
    visitCommand(o);
  }

  public void visitLabelDefinition(@NotNull BatchLabelDefinition o) {
    visitPsiElement(o);
  }

  public void visitParenthesisedCommand(@NotNull BatchParenthesisedCommand o) {
    visitCommand(o);
  }

  public void visitPipedCommand(@NotNull BatchPipedCommand o) {
    visitCommand(o);
  }

  public void visitRedirection(@NotNull BatchRedirection o) {
    visitPsiElement(o);
  }

  public void visitSimpleCommand(@NotNull BatchSimpleCommand o) {
    visitCommand(o);
  }

  public void visitTokens(@NotNull BatchTokens o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
