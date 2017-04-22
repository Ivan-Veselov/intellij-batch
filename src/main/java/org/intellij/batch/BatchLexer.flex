package org.intellij.batch;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.batch.util.Action;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.TokenType.*;
import static org.intellij.batch.psi.BatchTypes.*;
%%

%class BatchLexer
%unicode
%ignorecase
%implements FlexLexer
%function advance
%type IElementType

%{
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
%}

LineTerminator = \r | \n | \r\n
LineCharacter = [^\r\n]
Whitespace = [ \t\f]

SpecialCharacter = [<>|&()]

// Set difference {LineCharacter} \ ({SpecialCharacter} | {Whitespace})
SequenceCharacter = !(!{LineCharacter} | {SpecialCharacter} | {Whitespace})

SequenceCharacterOrParentheses = {SequenceCharacter} | "(" | ")"

Digit = [0-9]

RedirectSymbol = > | < | >>
RedirectToFileOperator = {Digit}? {RedirectSymbol}
RedirectToHandleOperator = {Digit}? {RedirectSymbol} & {Digit}

/* Keywords */
ifKeyword = if
existKeyword = exist
elseKeyword = else

%state READING_CMD_ARGS
%state READING_ONE_CHAR_SEQUENCE
%state MATCH_PARENTHESES
%state AFTER_MATCHED_PARENTHESES
%state AFTER_IF_KEYWORD

%%

/*
 * TODO: keywords are handled a little bit incorrect.
 * If there is a matched or opened parentheses right after a keyword then this keword is treated as an arbitrary command
 * and not as a keyword. Basically keyword rules just ignore parentheses. Also it might be helpful to match special
 * symbols.
 */

<YYINITIAL> {
    {LineTerminator} { return EOL_OPERATOR; }

    {ifKeyword} { yybegin(AFTER_IF_KEYWORD); return IF_KEYWORD; }

    "(" { openedParentheses++; return LEFT_PARENTHESES; }

    ({SequenceCharacter} | ")")+ {
        backtrackUntilMatchingParenthesesOrBegin(READING_CMD_ARGS);

        if (yylength() != 0) {
            return COMMAND_NAME;
        }
    }
}

<READING_CMD_ARGS> {
    {SequenceCharacterOrParentheses}+ { backtrackUntilMatchingParentheses(); return CHAR_SEQUENCE; }
}

<READING_ONE_CHAR_SEQUENCE> {
    {SequenceCharacterOrParentheses}+ {
        backtrackUntilMatchingParenthesesOr(beginMemorizedAction);

        return CHAR_SEQUENCE;
    }
}

<MATCH_PARENTHESES> {
    ")" { openedParentheses--; yybegin(AFTER_MATCHED_PARENTHESES); return RIGHT_PARENTHESES; }
}

<AFTER_MATCHED_PARENTHESES> {
    ")" { backtrackUntilMatchingParentheses(); if (yylength() != 0) { return BAD_CHARACTER; } }

    {elseKeyword} / {Whitespace} { yybegin(YYINITIAL); return ELSE_KEYWORD; }
}

<AFTER_IF_KEYWORD> {
    {existKeyword} { memorizeAndBegin(YYINITIAL, READING_ONE_CHAR_SEQUENCE); return EXIST_KEYWORD; }
}

/* Common rules */

/* Rules for pipe and conditional execution operators */
<READING_CMD_ARGS, AFTER_MATCHED_PARENTHESES> {
    "|" { yybegin(YYINITIAL); return PIPE_OPERATOR; }

    "&" { yybegin(YYINITIAL); return COMMAND_JOIN_OPERATOR; }

    "&&" { yybegin(YYINITIAL); return COMMAND_AND_OPERATOR; }

    "||" { yybegin(YYINITIAL); return COMMAND_OR_OPERATOR; }
}

/* Rules for line terminators */
<READING_CMD_ARGS, AFTER_MATCHED_PARENTHESES> {
    {LineTerminator} { yybegin(YYINITIAL); return EOL_OPERATOR; }
}

/* Rules for whitespaces */
<YYINITIAL, READING_CMD_ARGS, READING_ONE_CHAR_SEQUENCE, AFTER_MATCHED_PARENTHESES, AFTER_IF_KEYWORD> {
    {Whitespace}+ { return WHITE_SPACE; }
}

/* Rules for redirect operators */
<YYINITIAL, READING_CMD_ARGS, AFTER_MATCHED_PARENTHESES> {
    {RedirectToHandleOperator} { return REDIRECT_OPERATOR; }

    {RedirectToFileOperator} { memorizeAndBegin(READING_ONE_CHAR_SEQUENCE); return REDIRECT_OPERATOR; }
}

[^] { return BAD_CHARACTER; }
