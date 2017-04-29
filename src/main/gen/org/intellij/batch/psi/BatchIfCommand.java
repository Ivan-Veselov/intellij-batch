// This is a generated file. Not intended for manual editing.
package org.intellij.batch.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BatchIfCommand extends BatchCommand {

  @NotNull
  List<BatchCommand> getCommandList();

  @NotNull
  BatchIfCondition getIfCondition();

}
