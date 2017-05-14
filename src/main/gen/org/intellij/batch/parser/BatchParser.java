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
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == COMMAND) {
      r = command(b, 0, -1);
    }
    else if (t == EQUALITY_CONDITION) {
      r = equalityCondition(b, 0);
    }
    else if (t == ERRORLEVEL_CONDITION) {
      r = errorlevelCondition(b, 0);
    }
    else if (t == EXIST_CONDITION) {
      r = existCondition(b, 0);
    }
    else if (t == IF_CONDITION) {
      r = ifCondition(b, 0);
    }
    else if (t == IF_NEGATED_CONDITION) {
      r = ifNegatedCondition(b, 0);
    }
    else if (t == LABEL_DEFINITION) {
      r = labelDefinition(b, 0);
    }
    else if (t == REDIRECTION) {
      r = redirection(b, 0);
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

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(COMMAND, CONJOINT_COMMAND, DISJOINT_COMMAND, IF_COMMAND,
      JOINED_COMMAND, PARENTHESISED_COMMAND, PIPED_COMMAND, SIMPLE_COMMAND),
  };

  /* ********************************************************** */
  // (command | labelDefinition | LABEL_BASED_COMMENT)*
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

  // command | labelDefinition | LABEL_BASED_COMMENT
  private static boolean batchFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batchFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1, -1);
    if (!r) r = labelDefinition(b, l + 1);
    if (!r) r = consumeToken(b, LABEL_BASED_COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CHAR_SEQUENCE EQUALITY_OPERATOR CHAR_SEQUENCE
  public static boolean equalityCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityCondition")) return false;
    if (!nextTokenIs(b, CHAR_SEQUENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CHAR_SEQUENCE, EQUALITY_OPERATOR, CHAR_SEQUENCE);
    exit_section_(b, m, EQUALITY_CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // ERRORLEVEL_KEYWORD DECIMAL_NUMBER
  public static boolean errorlevelCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorlevelCondition")) return false;
    if (!nextTokenIs(b, ERRORLEVEL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ERRORLEVEL_KEYWORD, DECIMAL_NUMBER);
    exit_section_(b, m, ERRORLEVEL_CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // EXIST_KEYWORD CHAR_SEQUENCE
  public static boolean existCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "existCondition")) return false;
    if (!nextTokenIs(b, EXIST_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EXIST_KEYWORD, CHAR_SEQUENCE);
    exit_section_(b, m, EXIST_CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // existCondition | equalityCondition | errorlevelCondition
  public static boolean ifCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCondition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_CONDITION, "<if condition>");
    r = existCondition(b, l + 1);
    if (!r) r = equalityCondition(b, l + 1);
    if (!r) r = errorlevelCondition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NOT_KEYWORD ifCondition
  public static boolean ifNegatedCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifNegatedCondition")) return false;
    if (!nextTokenIs(b, NOT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT_KEYWORD);
    r = r && ifCondition(b, l + 1);
    exit_section_(b, m, IF_NEGATED_CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // LABEL_DEFINITION_OPERATOR LABEL_NAME [AFTER_LABEL_NAME_CHARS]
  public static boolean labelDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labelDefinition")) return false;
    if (!nextTokenIs(b, LABEL_DEFINITION_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LABEL_DEFINITION_OPERATOR, LABEL_NAME);
    r = r && labelDefinition_2(b, l + 1);
    exit_section_(b, m, LABEL_DEFINITION, r);
    return r;
  }

  // [AFTER_LABEL_NAME_CHARS]
  private static boolean labelDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labelDefinition_2")) return false;
    consumeToken(b, AFTER_LABEL_NAME_CHARS);
    return true;
  }

  /* ********************************************************** */
  // REDIRECT_TO_HANDLE_OPERATOR | (REDIRECT_TO_FILE_OPERATOR CHAR_SEQUENCE)
  public static boolean redirection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "redirection")) return false;
    if (!nextTokenIs(b, "<redirection>", REDIRECT_TO_FILE_OPERATOR, REDIRECT_TO_HANDLE_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REDIRECTION, "<redirection>");
    r = consumeToken(b, REDIRECT_TO_HANDLE_OPERATOR);
    if (!r) r = redirection_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // REDIRECT_TO_FILE_OPERATOR CHAR_SEQUENCE
  private static boolean redirection_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "redirection_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, REDIRECT_TO_FILE_OPERATOR, CHAR_SEQUENCE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EOL_OPERATOR
  public static boolean tokens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tokens")) return false;
    if (!nextTokenIs(b, EOL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL_OPERATOR);
    exit_section_(b, m, TOKENS, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: command
  // Operator priority table:
  // 0: BINARY(joinedCommand)
  // 1: BINARY(disjointCommand)
  // 2: BINARY(conjointCommand)
  // 3: BINARY(pipedCommand)
  // 4: ATOM(parenthesisedCommand)
  // 5: ATOM(simpleCommand) ATOM(ifCommand)
  public static boolean command(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "command")) return false;
    addVariant(b, "<command>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<command>");
    r = parenthesisedCommand(b, l + 1);
    if (!r) r = simpleCommand(b, l + 1);
    if (!r) r = ifCommand(b, l + 1);
    p = r;
    r = r && command_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean command_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "command_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, COMMAND_JOIN_OPERATOR)) {
        r = command(b, l, 0);
        exit_section_(b, l, m, JOINED_COMMAND, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, COMMAND_DISJUNCTION_OPERATOR)) {
        r = command(b, l, 1);
        exit_section_(b, l, m, DISJOINT_COMMAND, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, COMMAND_CONJUNCTION_OPERATOR)) {
        r = command(b, l, 2);
        exit_section_(b, l, m, CONJOINT_COMMAND, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, PIPE_OPERATOR)) {
        r = command(b, l, 3);
        exit_section_(b, l, m, PIPED_COMMAND, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // redirection* LEFT_PARENTHESES command+ RIGHT_PARENTHESES redirection*
  public static boolean parenthesisedCommand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesisedCommand")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARENTHESISED_COMMAND, "<parenthesised command>");
    r = parenthesisedCommand_0(b, l + 1);
    r = r && consumeToken(b, LEFT_PARENTHESES);
    r = r && parenthesisedCommand_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESES);
    r = r && parenthesisedCommand_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // redirection*
  private static boolean parenthesisedCommand_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesisedCommand_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!redirection(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parenthesisedCommand_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // command+
  private static boolean parenthesisedCommand_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesisedCommand_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1, -1);
    int c = current_position_(b);
    while (r) {
      if (!command(b, l + 1, -1)) break;
      if (!empty_element_parsed_guard_(b, "parenthesisedCommand_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // redirection*
  private static boolean parenthesisedCommand_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesisedCommand_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!redirection(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parenthesisedCommand_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // redirection* COMMAND_NAME (CHAR_SEQUENCE | redirection)*
  public static boolean simpleCommand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleCommand")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_COMMAND, "<simple command>");
    r = simpleCommand_0(b, l + 1);
    r = r && consumeToken(b, COMMAND_NAME);
    r = r && simpleCommand_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // redirection*
  private static boolean simpleCommand_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleCommand_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!redirection(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleCommand_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (CHAR_SEQUENCE | redirection)*
  private static boolean simpleCommand_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleCommand_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!simpleCommand_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleCommand_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // CHAR_SEQUENCE | redirection
  private static boolean simpleCommand_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleCommand_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, CHAR_SEQUENCE);
    if (!r) r = redirection(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IF_KEYWORD (ifCondition | ifNegatedCondition) command [ELSE_KEYWORD command]
  public static boolean ifCommand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCommand")) return false;
    if (!nextTokenIsSmart(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IF_KEYWORD);
    r = r && ifCommand_1(b, l + 1);
    r = r && command(b, l + 1, -1);
    r = r && ifCommand_3(b, l + 1);
    exit_section_(b, m, IF_COMMAND, r);
    return r;
  }

  // ifCondition | ifNegatedCondition
  private static boolean ifCommand_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCommand_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ifCondition(b, l + 1);
    if (!r) r = ifNegatedCondition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ELSE_KEYWORD command]
  private static boolean ifCommand_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCommand_3")) return false;
    ifCommand_3_0(b, l + 1);
    return true;
  }

  // ELSE_KEYWORD command
  private static boolean ifCommand_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCommand_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, ELSE_KEYWORD);
    r = r && command(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

}
