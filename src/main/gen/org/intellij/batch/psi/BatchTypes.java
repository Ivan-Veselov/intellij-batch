// This is a generated file. Not intended for manual editing.
package org.intellij.batch.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.batch.psi.impl.*;

public interface BatchTypes {

  IElementType COMMAND = new BatchElementType("COMMAND");
  IElementType PIPED_COMMAND = new BatchElementType("PIPED_COMMAND");
  IElementType SIMPLE_COMMAND = new BatchElementType("SIMPLE_COMMAND");
  IElementType TOKENS = new BatchElementType("TOKENS");

  IElementType CHAR_SEQUENCE = new BatchTokenType("CHAR_SEQUENCE");
  IElementType COMMAND_NAME = new BatchTokenType("COMMAND_NAME");
  IElementType CONDITIONAL_OPERATOR = new BatchTokenType("CONDITIONAL_OPERATOR");
  IElementType ELSE_KEYWORD = new BatchTokenType("ELSE_KEYWORD");
  IElementType EOL_OPERATOR = new BatchTokenType("EOL_OPERATOR");
  IElementType EXIST_KEYWORD = new BatchTokenType("EXIST_KEYWORD");
  IElementType IF_KEYWORD = new BatchTokenType("IF_KEYWORD");
  IElementType LEFT_PARENTHESES = new BatchTokenType("LEFT_PARENTHESES");
  IElementType PIPE_OPERATOR = new BatchTokenType("PIPE_OPERATOR");
  IElementType REDIRECT_OPERATOR = new BatchTokenType("REDIRECT_OPERATOR");
  IElementType RIGHT_PARENTHESES = new BatchTokenType("RIGHT_PARENTHESES");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PIPED_COMMAND) {
        return new BatchPipedCommandImpl(node);
      }
      else if (type == SIMPLE_COMMAND) {
        return new BatchSimpleCommandImpl(node);
      }
      else if (type == TOKENS) {
        return new BatchTokensImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
