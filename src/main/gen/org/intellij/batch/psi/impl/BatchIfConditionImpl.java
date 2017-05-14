// This is a generated file. Not intended for manual editing.
package org.intellij.batch.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.batch.psi.BatchTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.batch.psi.*;

public class BatchIfConditionImpl extends ASTWrapperPsiElement implements BatchIfCondition {

  public BatchIfConditionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatchVisitor visitor) {
    visitor.visitIfCondition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatchVisitor) accept((BatchVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BatchEqualityCondition getEqualityCondition() {
    return findChildByClass(BatchEqualityCondition.class);
  }

  @Override
  @Nullable
  public BatchErrorlevelCondition getErrorlevelCondition() {
    return findChildByClass(BatchErrorlevelCondition.class);
  }

  @Override
  @Nullable
  public BatchExistCondition getExistCondition() {
    return findChildByClass(BatchExistCondition.class);
  }

}
