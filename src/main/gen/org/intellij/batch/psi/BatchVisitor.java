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

  public void visitJoinedCommand(@NotNull BatchJoinedCommand o) {
    visitCommand(o);
  }

  public void visitPipedCommand(@NotNull BatchPipedCommand o) {
    visitCommand(o);
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
