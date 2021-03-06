// This is a generated file. Not intended for manual editing.
package org.intellij.batch.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.batch.psi.BatchTypes.*;
import org.intellij.batch.psi.*;

public class BatchSimpleCommandImpl extends BatchCommandImpl implements BatchSimpleCommand {

  public BatchSimpleCommandImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatchVisitor visitor) {
    visitor.visitSimpleCommand(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatchVisitor) accept((BatchVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BatchRedirection> getRedirectionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BatchRedirection.class);
  }

}
