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
  public static final int READING_LABEL = 6;
  public static final int READING_COMMENT = 8;
  public static final int MATCH_PARENTHESES = 10;
  public static final int AFTER_MATCHED_PARENTHESES = 12;
  public static final int AFTER_IF_KEYWORD = 14;
  public static final int READING_EQUALITY_OPERATOR = 16;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8, 8
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
    "\11\0\1\3\1\2\2\0\1\1\22\0\1\3\5\0\1\13\1\0\1\26\1\6\2\0\1\4\3\0\12\10\1\7"+
    "\1\4\1\12\1\14\1\11\6\0\1\22\1\16\2\0\1\15\2\0\1\25\1\0\1\17\1\20\3\0\1\24"+
    "\1\21\3\0\1\23\5\0\1\5\6\0\1\22\1\16\2\0\1\15\2\0\1\25\1\0\1\17\1\20\3\0\1"+
    "\24\1\21\3\0\1\23\3\0\1\27\263\0\2\15\115\0\1\24");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\11\0\1\1\2\2\1\3\1\4\1\5\1\1\2\6"+
    "\1\1\1\7\2\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\2\4\3\21\1\4\1\0\1\22"+
    "\1\0\1\23\1\24\1\25\1\0\2\21\1\26\1\27"+
    "\1\0\1\30\1\21\1\0\1\21\1\31\1\32";

  private static int [] zzUnpackAction() {
    int [] result = new int[54];
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
    "\0\0\0\30\0\60\0\110\0\140\0\170\0\220\0\250"+
    "\0\300\0\330\0\360\0\u0108\0\u0120\0\u0108\0\u0138\0\u0150"+
    "\0\u0168\0\u0180\0\u0198\0\u0108\0\u01b0\0\u01c8\0\u01e0\0\u01f8"+
    "\0\u0210\0\u0228\0\u0108\0\u0240\0\u0108\0\u0108\0\u0258\0\u0270"+
    "\0\u0288\0\u02a0\0\u02b8\0\u02d0\0\u0138\0\u02e8\0\u0300\0\330"+
    "\0\u0108\0\u0108\0\u0318\0\u0330\0\u0348\0\u0108\0\u0108\0\u0360"+
    "\0\u0288\0\u0378\0\u0390\0\u03a8\0\u0108\0\u0288";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[54];
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
    "\1\12\1\13\1\14\1\15\2\16\1\12\1\17\1\20"+
    "\1\21\1\22\2\16\1\23\10\12\1\24\1\16\1\25"+
    "\1\13\1\14\1\15\1\25\1\16\2\25\1\26\1\21"+
    "\1\22\1\27\13\25\1\30\1\31\2\16\1\15\1\31"+
    "\1\16\3\31\3\16\13\31\1\16\1\32\1\13\1\14"+
    "\1\15\2\33\1\32\1\33\1\32\4\33\12\32\1\33"+
    "\1\34\1\13\1\14\1\15\24\34\6\16\1\35\22\16"+
    "\1\13\1\14\1\15\2\16\1\36\1\16\1\37\1\21"+
    "\1\22\1\27\6\16\1\40\4\16\1\30\1\41\2\16"+
    "\1\15\1\41\1\16\3\41\3\16\3\41\1\42\2\41"+
    "\1\43\4\41\4\16\1\15\10\16\1\44\13\16\1\12"+
    "\5\0\1\12\1\0\1\12\4\0\11\12\4\0\1\14"+
    "\60\0\1\15\27\0\1\45\2\46\1\0\1\46\1\0"+
    "\4\46\12\0\1\46\1\12\5\0\1\12\1\0\1\12"+
    "\1\21\1\22\2\0\11\12\13\0\1\22\1\0\1\47"+
    "\27\0\1\47\14\0\1\12\5\0\1\12\1\0\1\12"+
    "\4\0\1\12\1\50\7\12\2\0\1\25\3\0\1\25"+
    "\1\0\3\25\3\0\13\25\1\0\1\25\3\0\1\25"+
    "\1\0\3\25\1\21\1\22\1\0\13\25\14\0\1\51"+
    "\43\0\1\52\1\31\3\0\1\31\1\0\3\31\3\0"+
    "\13\31\1\0\1\32\3\0\1\32\1\0\1\32\1\0"+
    "\1\32\3\0\13\32\1\0\1\34\2\0\25\34\11\0"+
    "\1\21\1\22\42\0\1\53\2\0\1\41\3\0\1\41"+
    "\1\0\3\41\3\0\13\41\1\0\1\41\3\0\1\41"+
    "\1\0\3\41\3\0\4\41\1\54\6\41\1\0\1\41"+
    "\3\0\1\41\1\0\3\41\3\0\7\41\1\55\3\41"+
    "\15\0\1\56\13\0\1\46\2\0\25\46\10\0\1\57"+
    "\43\0\1\60\3\0\1\41\3\0\1\41\1\0\3\41"+
    "\3\0\5\41\1\61\5\41\1\0\1\41\3\0\1\41"+
    "\1\0\3\41\3\0\1\41\1\62\11\41\23\0\1\63"+
    "\5\0\1\41\3\0\1\41\1\0\3\41\3\0\10\41"+
    "\1\64\2\41\4\0\1\65\24\0\1\41\3\0\1\41"+
    "\1\0\3\41\3\0\5\41\1\66\5\41\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[960];
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
    "\11\0\2\1\1\11\1\1\1\11\5\1\1\11\6\1"+
    "\1\11\1\1\2\11\6\1\1\0\1\1\1\0\1\1"+
    "\2\11\1\0\2\1\2\11\1\0\2\1\1\0\1\1"+
    "\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[54];
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
          case 27: break;
          case 2: 
            { yybegin(YYINITIAL); return EOL_OPERATOR;
            }
          case 28: break;
          case 3: 
            { return WHITE_SPACE;
            }
          case 29: break;
          case 4: 
            { return BAD_CHARACTER;
            }
          case 30: break;
          case 5: 
            { yybegin(READING_LABEL); return LABEL_DEFINITION_OPERATOR;
            }
          case 31: break;
          case 6: 
            { memorizeAndBegin(READING_ONE_CHAR_SEQUENCE); return REDIRECT_TO_FILE_OPERATOR;
            }
          case 32: break;
          case 7: 
            { openedParentheses++; return LEFT_PARENTHESES;
            }
          case 33: break;
          case 8: 
            { backtrackUntilMatchingParentheses(); return CHAR_SEQUENCE;
            }
          case 34: break;
          case 9: 
            { yybegin(YYINITIAL); return COMMAND_JOIN_OPERATOR;
            }
          case 35: break;
          case 10: 
            { yybegin(YYINITIAL); return PIPE_OPERATOR;
            }
          case 36: break;
          case 11: 
            { backtrackUntilMatchingParenthesesOr(beginMemorizedAction);

        return CHAR_SEQUENCE;
            }
          case 37: break;
          case 12: 
            { yybegin(READING_COMMENT);
        return LABEL_NAME;
            }
          case 38: break;
          case 13: 
            { yypushback(1); yybegin(READING_COMMENT);
            }
          case 39: break;
          case 14: 
            { return AFTER_LABEL_NAME_CHARS;
            }
          case 40: break;
          case 15: 
            { openedParentheses--; yybegin(AFTER_MATCHED_PARENTHESES); return RIGHT_PARENTHESES;
            }
          case 41: break;
          case 16: 
            { backtrackUntilMatchingParentheses(); if (yylength() != 0) { return BAD_CHARACTER; }
            }
          case 42: break;
          case 17: 
            { yybegin(READING_EQUALITY_OPERATOR);
        return CHAR_SEQUENCE;
            }
          case 43: break;
          case 18: 
            { return LABEL_BASED_COMMENT;
            }
          case 44: break;
          case 19: 
            { yybegin(AFTER_IF_KEYWORD); return IF_KEYWORD;
            }
          case 45: break;
          case 20: 
            { yybegin(YYINITIAL); return COMMAND_CONJUNCTION_OPERATOR;
            }
          case 46: break;
          case 21: 
            { yybegin(YYINITIAL); return COMMAND_DISJUNCTION_OPERATOR;
            }
          case 47: break;
          case 22: 
            { memorizeAndBegin(YYINITIAL, READING_ONE_CHAR_SEQUENCE); return EQUALITY_OPERATOR;
            }
          case 48: break;
          case 23: 
            { return REDIRECT_TO_HANDLE_OPERATOR;
            }
          case 49: break;
          case 24: 
            { return NOT_KEYWORD;
            }
          case 50: break;
          case 25: 
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL/*, zzStartRead, zzEndRead - zzStartRead*/, zzStartRead, 4);
            { yybegin(YYINITIAL); return ELSE_KEYWORD;
            }
          case 51: break;
          case 26: 
            { memorizeAndBegin(YYINITIAL, READING_ONE_CHAR_SEQUENCE); return EXIST_KEYWORD;
            }
          case 52: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
