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
    if (t == PIPELINE) {
      r = pipeline(b, 0);
    }
    else if (t == SIMPLE_COMMAND) {
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
  // pipeline*
  static boolean batchFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batchFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!pipeline(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "batchFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // [pipeline PIPE_OPERATOR] simpleCommand
  public static boolean pipeline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pipeline")) return false;
    if (!nextTokenIs(b, COMMAND_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pipeline_0(b, l + 1);
    r = r && simpleCommand(b, l + 1);
    exit_section_(b, m, PIPELINE, r);
    return r;
  }

  // [pipeline PIPE_OPERATOR]
  private static boolean pipeline_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pipeline_0")) return false;
    pipeline_0_0(b, l + 1);
    return true;
  }

  // pipeline PIPE_OPERATOR
  private static boolean pipeline_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pipeline_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pipeline(b, l + 1);
    r = r && consumeToken(b, PIPE_OPERATOR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMAND_NAME CHAR_SEQUENCE*
  public static boolean simpleCommand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleCommand")) return false;
    if (!nextTokenIs(b, COMMAND_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMAND_NAME);
    r = r && simpleCommand_1(b, l + 1);
    exit_section_(b, m, SIMPLE_COMMAND, r);
    return r;
  }

  // CHAR_SEQUENCE*
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
  // EOL_OPERATOR
  // REDIRECT_OPERATOR
  // CONDITIONAL_OPERATOR
  // LEFT_PARENTHESES
  // RIGHT_PARENTHESES
  // IF_KEYWORD
  // EXIST_KEYWORD
  // ELSE_KEYWORD
  public static boolean tokens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tokens")) return false;
    if (!nextTokenIs(b, EOL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EOL_OPERATOR, REDIRECT_OPERATOR, CONDITIONAL_OPERATOR, LEFT_PARENTHESES, RIGHT_PARENTHESES, IF_KEYWORD, EXIST_KEYWORD, ELSE_KEYWORD);
    exit_section_(b, m, TOKENS, r);
    return r;
  }

}
