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

LineTerminator = \r | \n | \r\n
LineCharacter = [^\r\n]
Whitespace = [ \t\f]

SpecialCharacter = [<>]
// TODO: Looks very ugly, might become an issue. Something must be done.
// SequenceCharacter = [{LineCharacter}--[{SpecialCharacter}||{Whitespace}]]
SequenceCharacter = [[^\r\n]--[[<>]||[ \t\f]]]

Digit = [0-9]

RedirectSymbol = > | < | >>
RedirectOperator = {Digit}? {RedirectSymbol} (& {Digit})?

%state READING_CMD_ARGS

%%

{LineTerminator} { yybegin(YYINITIAL); return EOL_OPERATOR; }

<YYINITIAL, READING_CMD_ARGS> {
    {Whitespace}+ { return WHITE_SPACE; }

    {RedirectOperator} { return REDIRECT_OPERATOR; }
}

<YYINITIAL> {
    {SequenceCharacter}* { yybegin(READING_CMD_ARGS); return COMMAND_NAME; }
}

<READING_CMD_ARGS> {
    {SequenceCharacter}* { return COMMAND_ARGUMENT; }
}

[^] { return BAD_CHARACTER; }
