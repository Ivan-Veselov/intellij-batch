package org.intellij.batch;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.*;
import static org.intellij.batch.BatchTokens.*;

%%

%class BatchLexer
%unicode
%implements FlexLexer
%function advance
%type IElementType

%{
    /** Memorized lexical state */
    private int memorizedState = YYINITIAL;

    /**
    * Enters a new lexical state and remebers the current one
    *
    * @param newState the new lexical state
    */
    public void memorizeAndBegin(int newState) {
        memorizedState = yystate();
        yybegin(newState);
    }

    /**
    * Returns a memorized lexical state
    */
    public int getMemorizedState() {
        return memorizedState;
    }

    /**
    * Enters a memorized lexical state
    */
    public void beginMemorized() {
        yybegin(getMemorizedState());
    }
%}

LineTerminator = \r | \n | \r\n
LineCharacter = [^\r\n]
Whitespace = [ \t\f]

SpecialCharacter = [<>|]

// Set difference {LineCharacter} \ ({SpecialCharacter} | {Whitespace})
SequenceCharacter = !(!{LineCharacter} | {SpecialCharacter} | {Whitespace})

Digit = [0-9]

RedirectSymbol = > | < | >>
RedirectToFileOperator = {Digit}? {RedirectSymbol}
RedirectToHandleOperator = {Digit}? {RedirectSymbol} & {Digit}

%state READING_CMD_ARGS
%state READING_REDIRECTION_DESTINATION

%%

{LineTerminator} { yybegin(YYINITIAL); return EOL_OPERATOR; }

<YYINITIAL, READING_CMD_ARGS, READING_REDIRECTION_DESTINATION> {
    {Whitespace}+ { return WHITE_SPACE; }
}

<YYINITIAL, READING_CMD_ARGS> {
    {RedirectToHandleOperator} { return REDIRECT_OPERATOR; }

    {RedirectToFileOperator} { memorizeAndBegin(READING_REDIRECTION_DESTINATION); return REDIRECT_OPERATOR; }

    "|" { yybegin(YYINITIAL); return PIPE_OPERATOR; }
}

<YYINITIAL> {
    {SequenceCharacter}+ { yybegin(READING_CMD_ARGS); return COMMAND_NAME; }
}

<READING_CMD_ARGS> {
    {SequenceCharacter}+ { return CHAR_SEQUENCE; }
}

<READING_REDIRECTION_DESTINATION> {SequenceCharacter}+ { beginMemorized(); return CHAR_SEQUENCE; }

[^] { return BAD_CHARACTER; }
