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

public class BatchDisjointCommandImpl extends BatchCommandImpl implements BatchDisjointCommand {

  public BatchDisjointCommandImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatchVisitor visitor) {
    visitor.visitDisjointCommand(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatchVisitor) accept((BatchVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BatchCommand> getCommandList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BatchCommand.class);
  }

}
