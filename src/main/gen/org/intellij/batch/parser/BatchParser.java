// This is a generated file. Not intended for manual editing.
package org.intellij.batch.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.batch.psi.BatchTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BatchParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == SIMPLE_COMMAND) {
      r = simpleCommand(b, 0);
    }
    else if (t == TOKENS) {
      r = tokens(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return batchFile(b, l + 1);
  }

  /* ********************************************************** */
  // (simpleCommand)*
  static boolean batchFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batchFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!batchFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "batchFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (simpleCommand)
  private static boolean batchFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batchFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleCommand(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMAND_NAME (CHAR_SEQUENCE)* EOL_OPERATOR
  public static boolean simpleCommand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleCommand")) return false;
    if (!nextTokenIs(b, COMMAND_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMAND_NAME);
    r = r && simpleCommand_1(b, l + 1);
    r = r && consumeToken(b, EOL_OPERATOR);
    exit_section_(b, m, SIMPLE_COMMAND, r);
    return r;
  }

  // (CHAR_SEQUENCE)*
  private static boolean simpleCommand_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleCommand_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, CHAR_SEQUENCE)) break;
      if (!empty_element_parsed_guard_(b, "simpleCommand_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // COMMAND_NAME
  // CHAR_SEQUENCE
  // EOL_OPERATOR
  // REDIRECT_OPERATOR
  // PIPE_OPERATOR
  // CONDITIONAL_OPERATOR
  // LEFT_PARENTHESES
  // RIGHT_PARENTHESES
  // IF_KEYWORD
  // EXIST_KEYWORD
  // ELSE_KEYWORD
  public static boolean tokens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tokens")) return false;
    if (!nextTokenIs(b, COMMAND_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMAND_NAME, CHAR_SEQUENCE, EOL_OPERATOR, REDIRECT_OPERATOR, PIPE_OPERATOR, CONDITIONAL_OPERATOR, LEFT_PARENTHESES, RIGHT_PARENTHESES, IF_KEYWORD, EXIST_KEYWORD, ELSE_KEYWORD);
    exit_section_(b, m, TOKENS, r);
    return r;
  }

}
