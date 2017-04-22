// This is a generated file. Not intended for manual editing.
package org.intellij.batch.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.batch.psi.impl.*;

public interface BatchTypes {

  IElementType COMMAND = new BatchElementType("COMMAND");
  IElementType CONJOINT_COMMAND = new BatchElementType("CONJOINT_COMMAND");
  IElementType DISJOINT_COMMAND = new BatchElementType("DISJOINT_COMMAND");
  IElementType JOINED_COMMAND = new BatchElementType("JOINED_COMMAND");
  IElementType PIPED_COMMAND = new BatchElementType("PIPED_COMMAND");
  IElementType SIMPLE_COMMAND = new BatchElementType("SIMPLE_COMMAND");
  IElementType TOKENS = new BatchElementType("TOKENS");

  IElementType CHAR_SEQUENCE = new BatchTokenType("CHAR_SEQUENCE");
  IElementType COMMAND_CONJUNCTION_OPERATOR = new BatchTokenType("COMMAND_CONJUNCTION_OPERATOR");
  IElementType COMMAND_DISJUNCTION_OPERATOR = new BatchTokenType("COMMAND_DISJUNCTION_OPERATOR");
  IElementType COMMAND_JOIN_OPERATOR = new BatchTokenType("COMMAND_JOIN_OPERATOR");
  IElementType COMMAND_NAME = new BatchTokenType("COMMAND_NAME");
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
       if (type == CONJOINT_COMMAND) {
        return new BatchConjointCommandImpl(node);
      }
      else if (type == DISJOINT_COMMAND) {
        return new BatchDisjointCommandImpl(node);
      }
      else if (type == JOINED_COMMAND) {
        return new BatchJoinedCommandImpl(node);
      }
      else if (type == PIPED_COMMAND) {
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
