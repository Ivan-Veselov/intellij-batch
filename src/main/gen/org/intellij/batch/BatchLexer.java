/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package org.intellij.batch;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.batch.util.Action;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.TokenType.*;
import static org.intellij.batch.psi.BatchTypes.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>BatchLexer.flex</tt>
 */
class BatchLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int READING_CMD_ARGS = 2;
  public static final int READING_ONE_CHAR_SEQUENCE = 4;
  public static final int READING_ONE_DECIMAL_NUMBER = 6;
  public static final int READING_LABEL = 8;
  public static final int READING_COMMENT = 10;
  public static final int MATCH_PARENTHESES = 12;
  public static final int AFTER_MATCHED_PARENTHESES = 14;
  public static final int AFTER_IF_KEYWORD = 16;
  public static final int READING_EQUALITY_OPERATOR = 18;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8,  8,  9, 9
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [8, 6, 7]
   * Total runtime size is 1296 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>13]|((ch>>7)&0x3f)]<<7)|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 136 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\207\100");

  /* The ZZ_CMAP_Y table has 128 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\1");

  /* The ZZ_CMAP_A table has 384 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\3\1\2\2\0\1\1\22\0\1\3\5\0\1\14\1\0\1\31\1\6\2\0\1\4\1\11\2\0\12\10"+
    "\1\7\1\4\1\13\1\15\1\12\6\0\1\23\1\17\2\0\1\16\2\0\1\26\1\0\1\20\1\21\2\0"+
    "\1\27\1\25\1\22\1\0\1\30\1\0\1\24\5\0\1\5\6\0\1\23\1\17\2\0\1\16\2\0\1\26"+
    "\1\0\1\20\1\21\2\0\1\27\1\25\1\22\1\0\1\30\1\0\1\24\3\0\1\32\263\0\2\16\115"+
    "\0\1\25");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\12\0\1\1\2\2\1\3\1\4\1\5\1\1\2\6"+
    "\1\1\1\7\2\10\1\11\1\12\1\13\1\14\1\4"+
    "\1\15\1\16\1\17\1\20\1\21\2\4\3\22\1\4"+
    "\1\0\1\23\1\0\1\24\1\25\1\26\1\0\3\22"+
    "\1\27\1\30\1\0\1\31\2\22\1\0\2\22\1\32"+
    "\1\33\5\22\1\34";

  private static int [] zzUnpackAction() {
    int [] result = new int[66];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\33\0\66\0\121\0\154\0\207\0\242\0\275"+
    "\0\330\0\363\0\u010e\0\u0129\0\u0144\0\u015f\0\u0144\0\u017a"+
    "\0\u0195\0\u01b0\0\u01cb\0\u01e6\0\u0144\0\u0201\0\u021c\0\u0237"+
    "\0\u0252\0\u026d\0\u0288\0\u0288\0\u02a3\0\u0144\0\u02be\0\u0144"+
    "\0\u0144\0\u02d9\0\u02f4\0\u030f\0\u032a\0\u0345\0\u0360\0\u017a"+
    "\0\u037b\0\u0396\0\u010e\0\u0144\0\u0144\0\u03b1\0\u03cc\0\u03e7"+
    "\0\u0402\0\u0144\0\u0144\0\u041d\0\u030f\0\u0438\0\u0453\0\u046e"+
    "\0\u0489\0\u04a4\0\u0144\0\u030f\0\u04bf\0\u04da\0\u04f5\0\u0510"+
    "\0\u052b\0\u030f";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[66];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\13\1\14\1\15\1\16\2\17\1\13\1\20\1\21"+
    "\1\13\1\22\1\23\2\17\1\24\12\13\1\25\1\17"+
    "\1\26\1\14\1\15\1\16\1\26\1\17\2\26\1\27"+
    "\1\26\1\22\1\23\1\30\15\26\1\31\1\32\2\17"+
    "\1\16\1\32\1\17\4\32\3\17\15\32\4\17\1\16"+
    "\4\17\1\33\1\34\21\17\1\35\1\14\1\15\1\16"+
    "\2\36\1\35\1\36\2\35\4\36\14\35\1\36\1\37"+
    "\1\14\1\15\1\16\27\37\6\17\1\40\25\17\1\14"+
    "\1\15\1\16\2\17\1\41\1\17\1\42\1\17\1\22"+
    "\1\23\1\30\6\17\1\43\6\17\1\31\1\44\2\17"+
    "\1\16\2\17\4\44\4\17\2\44\1\45\2\44\1\46"+
    "\6\44\4\17\1\16\11\17\1\47\15\17\1\13\5\0"+
    "\1\13\1\0\2\13\4\0\13\13\4\0\1\15\66\0"+
    "\1\16\32\0\1\50\2\51\1\0\1\51\2\0\4\51"+
    "\14\0\1\51\1\13\5\0\1\13\1\0\2\13\1\22"+
    "\1\23\2\0\13\13\14\0\1\23\1\0\1\52\32\0"+
    "\1\52\16\0\1\13\5\0\1\13\1\0\2\13\4\0"+
    "\1\13\1\53\11\13\2\0\1\26\3\0\1\26\1\0"+
    "\4\26\3\0\15\26\1\0\1\26\3\0\1\26\1\0"+
    "\4\26\1\22\1\23\1\0\15\26\15\0\1\54\50\0"+
    "\1\55\1\32\3\0\1\32\1\0\4\32\3\0\15\32"+
    "\11\0\1\33\22\0\1\35\3\0\1\35\1\0\1\35"+
    "\1\0\2\35\3\0\15\35\1\0\1\37\2\0\30\37"+
    "\12\0\1\22\1\23\45\0\1\56\4\0\1\44\5\0"+
    "\4\44\4\0\14\44\1\0\1\44\5\0\4\44\4\0"+
    "\3\44\1\57\10\44\1\0\1\44\5\0\4\44\4\0"+
    "\6\44\1\60\2\44\1\61\2\44\16\0\1\62\15\0"+
    "\1\51\2\0\30\51\10\0\1\63\47\0\1\64\5\0"+
    "\1\44\5\0\4\44\4\0\4\44\1\65\7\44\1\0"+
    "\1\44\5\0\4\44\4\0\1\66\13\44\1\0\1\44"+
    "\5\0\4\44\4\0\11\44\1\67\2\44\24\0\1\70"+
    "\7\0\1\44\5\0\4\44\4\0\7\44\1\71\4\44"+
    "\1\0\1\44\5\0\4\44\4\0\3\44\1\72\10\44"+
    "\4\0\1\73\27\0\1\44\5\0\4\44\4\0\4\44"+
    "\1\74\7\44\1\0\1\44\5\0\4\44\4\0\11\44"+
    "\1\75\2\44\1\0\1\44\5\0\4\44\4\0\10\44"+
    "\1\76\3\44\1\0\1\44\5\0\4\44\4\0\5\44"+
    "\1\77\6\44\1\0\1\44\5\0\4\44\4\0\12\44"+
    "\1\100\1\44\1\0\1\44\5\0\4\44\4\0\5\44"+
    "\1\101\6\44\1\0\1\44\5\0\4\44\4\0\10\44"+
    "\1\102\3\44\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1350];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\12\0\2\1\1\11\1\1\1\11\5\1\1\11\10\1"+
    "\1\11\1\1\2\11\6\1\1\0\1\1\1\0\1\1"+
    "\2\11\1\0\3\1\2\11\1\0\3\1\1\0\2\1"+
    "\1\11\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[66];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    /** An invalid lexical state */
    private final static int invalidState = -1;

    /** Memorized lexical state */
    private int memorizedState = invalidState;

    /** Number of opened parentheses */
    private int openedParentheses = 0;

    /** An action which calls beginMemorized method */
    private final @NotNull Action beginMemorizedAction =
        new Action() {
            @Override
            public void execute() {
                beginMemorized();
            }
        };

   /**
    * Enters a new lexical state and remebers a given one.
    *
    * @param stateToMemorize a lexical state to memorize.
    * @param newState new lexical state.
    */
    private void memorizeAndBegin(final int stateToMemorize, final int newState) {
        memorizedState = stateToMemorize;
        yybegin(newState);
    }

   /**
    * Enters a new lexical state and remebers the current one.
    *
    * @param newState new lexical state.
    */
    private void memorizeAndBegin(final int newState) {
        memorizeAndBegin(yystate(), newState);
    }

   /**
    * Enters a memorized lexical state and invalidate memorized state.
    */
    private void beginMemorized() {
        yybegin(memorizedState);
        memorizedState = invalidState;
    }

   /**
    * Pushes all characters which appeared after first matching parentheses back into the input stream and begins new
    * lexical state MATCH_PARENTHESES. If no matching parentheses found given action is executed.
    *
    * @param nothingMatchedAction an action to execute if no matching parentheses is found.
    */
    private void backtrackUntilMatchingParenthesesOr(final @NotNull Action nothingMatchedAction) {
        if (openedParentheses == 0) {
            nothingMatchedAction.execute();
            return;
        }

        String text = yytext().toString();
        int parenthesesIndex = text.indexOf(')');

        if (parenthesesIndex < 0) {
            nothingMatchedAction.execute();
            return;
        }

        yypushback(text.length() - parenthesesIndex);
        yybegin(MATCH_PARENTHESES);
    }

   /**
    * Calls backtrackUntilMatchingParenthesesOr. If no matching parentheses found lexer begins given state.
    *
    * @param nothingMatchedState a state to begin if no matching parentheses is found.
    */
    private void backtrackUntilMatchingParenthesesOrBegin(final int nothingMatchedState) {
        backtrackUntilMatchingParenthesesOr(
            new Action() {
                @Override
                public void execute() {
                    yybegin(nothingMatchedState);
                }
            }
        );
    }

   /**
    * Calls backtrackUntilMatchingParenthesesOr with no action.
    */
    private void backtrackUntilMatchingParentheses() {
        backtrackUntilMatchingParenthesesOr(Action.noAction);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  BatchLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { backtrackUntilMatchingParenthesesOrBegin(READING_CMD_ARGS);

        if (yylength() != 0) {
            return COMMAND_NAME;
        }
            }
          case 29: break;
          case 2: 
            { yybegin(YYINITIAL); return EOL_OPERATOR;
            }
          case 30: break;
          case 3: 
            { return WHITE_SPACE;
            }
          case 31: break;
          case 4: 
            { return BAD_CHARACTER;
            }
          case 32: break;
          case 5: 
            { yybegin(READING_LABEL); return LABEL_DEFINITION_OPERATOR;
            }
          case 33: break;
          case 6: 
            { memorizeAndBegin(READING_ONE_CHAR_SEQUENCE); return REDIRECT_TO_FILE_OPERATOR;
            }
          case 34: break;
          case 7: 
            { openedParentheses++; return LEFT_PARENTHESES;
            }
          case 35: break;
          case 8: 
            { backtrackUntilMatchingParentheses(); return CHAR_SEQUENCE;
            }
          case 36: break;
          case 9: 
            { yybegin(YYINITIAL); return COMMAND_JOIN_OPERATOR;
            }
          case 37: break;
          case 10: 
            { yybegin(YYINITIAL); return PIPE_OPERATOR;
            }
          case 38: break;
          case 11: 
            { backtrackUntilMatchingParenthesesOr(beginMemorizedAction);

        return CHAR_SEQUENCE;
            }
          case 39: break;
          case 12: 
            { beginMemorized(); return DECIMAL_NUMBER;
            }
          case 40: break;
          case 13: 
            { yybegin(READING_COMMENT);
        return LABEL_NAME;
            }
          case 41: break;
          case 14: 
            { yypushback(1); yybegin(READING_COMMENT);
            }
          case 42: break;
          case 15: 
            { return AFTER_LABEL_NAME_CHARS;
            }
          case 43: break;
          case 16: 
            { openedParentheses--; yybegin(AFTER_MATCHED_PARENTHESES); return RIGHT_PARENTHESES;
            }
          case 44: break;
          case 17: 
            { backtrackUntilMatchingParentheses(); if (yylength() != 0) { return BAD_CHARACTER; }
            }
          case 45: break;
          case 18: 
            { yybegin(READING_EQUALITY_OPERATOR);
        return CHAR_SEQUENCE;
            }
          case 46: break;
          case 19: 
            { return LABEL_BASED_COMMENT;
            }
          case 47: break;
          case 20: 
            { yybegin(AFTER_IF_KEYWORD); return IF_KEYWORD;
            }
          case 48: break;
          case 21: 
            { yybegin(YYINITIAL); return COMMAND_CONJUNCTION_OPERATOR;
            }
          case 49: break;
          case 22: 
            { yybegin(YYINITIAL); return COMMAND_DISJUNCTION_OPERATOR;
            }
          case 50: break;
          case 23: 
            { memorizeAndBegin(YYINITIAL, READING_ONE_CHAR_SEQUENCE); return EQUALITY_OPERATOR;
            }
          case 51: break;
          case 24: 
            { return REDIRECT_TO_HANDLE_OPERATOR;
            }
          case 52: break;
          case 25: 
            { return NOT_KEYWORD;
            }
          case 53: break;
          case 26: 
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL/*, zzStartRead, zzEndRead - zzStartRead*/, zzStartRead, 4);
            { yybegin(YYINITIAL); return ELSE_KEYWORD;
            }
          case 54: break;
          case 27: 
            { memorizeAndBegin(YYINITIAL, READING_ONE_CHAR_SEQUENCE); return EXIST_KEYWORD;
            }
          case 55: break;
          case 28: 
            { memorizeAndBegin(YYINITIAL, READING_ONE_DECIMAL_NUMBER); return ERRORLEVEL_KEYWORD;
            }
          case 56: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
