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
  IElementType EQUALITY_CONDITION = new BatchElementType("EQUALITY_CONDITION");
  IElementType ERRORLEVEL_CONDITION = new BatchElementType("ERRORLEVEL_CONDITION");
  IElementType EXIST_CONDITION = new BatchElementType("EXIST_CONDITION");
  IElementType IF_COMMAND = new BatchElementType("IF_COMMAND");
  IElementType IF_CONDITION = new BatchElementType("IF_CONDITION");
  IElementType IF_NEGATED_CONDITION = new BatchElementType("IF_NEGATED_CONDITION");
  IElementType JOINED_COMMAND = new BatchElementType("JOINED_COMMAND");
  IElementType LABEL_DEFINITION = new BatchElementType("LABEL_DEFINITION");
  IElementType PARENTHESISED_COMMAND = new BatchElementType("PARENTHESISED_COMMAND");
  IElementType PIPED_COMMAND = new BatchElementType("PIPED_COMMAND");
  IElementType REDIRECTION = new BatchElementType("REDIRECTION");
  IElementType SIMPLE_COMMAND = new BatchElementType("SIMPLE_COMMAND");
  IElementType TOKENS = new BatchElementType("TOKENS");

  IElementType AFTER_LABEL_NAME_CHARS = new BatchTokenType("AFTER_LABEL_NAME_CHARS");
  IElementType CHAR_SEQUENCE = new BatchTokenType("CHAR_SEQUENCE");
  IElementType COMMAND_CONJUNCTION_OPERATOR = new BatchTokenType("COMMAND_CONJUNCTION_OPERATOR");
  IElementType COMMAND_DISJUNCTION_OPERATOR = new BatchTokenType("COMMAND_DISJUNCTION_OPERATOR");
  IElementType COMMAND_JOIN_OPERATOR = new BatchTokenType("COMMAND_JOIN_OPERATOR");
  IElementType COMMAND_NAME = new BatchTokenType("COMMAND_NAME");
  IElementType DECIMAL_NUMBER = new BatchTokenType("DECIMAL_NUMBER");
  IElementType ELSE_KEYWORD = new BatchTokenType("ELSE_KEYWORD");
  IElementType EOL_OPERATOR = new BatchTokenType("EOL_OPERATOR");
  IElementType EQUALITY_OPERATOR = new BatchTokenType("EQUALITY_OPERATOR");
  IElementType ERRORLEVEL_KEYWORD = new BatchTokenType("ERRORLEVEL_KEYWORD");
  IElementType EXIST_KEYWORD = new BatchTokenType("EXIST_KEYWORD");
  IElementType IF_KEYWORD = new BatchTokenType("IF_KEYWORD");
  IElementType LABEL_BASED_COMMENT = new BatchTokenType("LABEL_BASED_COMMENT");
  IElementType LABEL_DEFINITION_OPERATOR = new BatchTokenType("LABEL_DEFINITION_OPERATOR");
  IElementType LABEL_NAME = new BatchTokenType("LABEL_NAME");
  IElementType LEFT_PARENTHESES = new BatchTokenType("LEFT_PARENTHESES");
  IElementType NOT_KEYWORD = new BatchTokenType("NOT_KEYWORD");
  IElementType PIPE_OPERATOR = new BatchTokenType("PIPE_OPERATOR");
  IElementType REDIRECT_TO_FILE_OPERATOR = new BatchTokenType("REDIRECT_TO_FILE_OPERATOR");
  IElementType REDIRECT_TO_HANDLE_OPERATOR = new BatchTokenType("REDIRECT_TO_HANDLE_OPERATOR");
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
      else if (type == EQUALITY_CONDITION) {
        return new BatchEqualityConditionImpl(node);
      }
      else if (type == ERRORLEVEL_CONDITION) {
        return new BatchErrorlevelConditionImpl(node);
      }
      else if (type == EXIST_CONDITION) {
        return new BatchExistConditionImpl(node);
      }
      else if (type == IF_COMMAND) {
        return new BatchIfCommandImpl(node);
      }
      else if (type == IF_CONDITION) {
        return new BatchIfConditionImpl(node);
      }
      else if (type == IF_NEGATED_CONDITION) {
        return new BatchIfNegatedConditionImpl(node);
      }
      else if (type == JOINED_COMMAND) {
        return new BatchJoinedCommandImpl(node);
      }
      else if (type == LABEL_DEFINITION) {
        return new BatchLabelDefinitionImpl(node);
      }
      else if (type == PARENTHESISED_COMMAND) {
        return new BatchParenthesisedCommandImpl(node);
      }
      else if (type == PIPED_COMMAND) {
        return new BatchPipedCommandImpl(node);
      }
      else if (type == REDIRECTION) {
        return new BatchRedirectionImpl(node);
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
