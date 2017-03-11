package org.intellij.batch;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static org.intellij.batch.BatchTokens.*;

%%

%class BatchLexer
%unicode
%implements FlexLexer
%function advance
%type IElementType

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
LineWhitespace = [ \t\f]
Whitespace = {LineTerminator} | {LineWhitespace}

// TODO: Looks very ugly, might become an issue. Something must be done.
VarIdentifierCharacter = [[^\r\n]--=] // {InputCharacter}--=
FirstVarIdentifierCharacter = [[[^\r\n]--=]--[ \t\f]] // {VarIdentifierCharacter}--{LineWhiteSpace}

EchoKeyword = [Ee][Cc][Hh][Oo]

%state READING_STRING
%state ECHO_CONSUME_LINE_WHITESPACE
%state SET_READING_VAR_NAME

%%

<READING_STRING> {
    {InputCharacter}* { return STRING_LITERAL; }
}

<ECHO_CONSUME_LINE_WHITESPACE> {
    {LineWhitespace} { yybegin(READING_STRING); }
}

<SET_READING_VAR_NAME> {
    {LineWhitespace} { /* ignore */ }

    {FirstVarIdentifierCharacter}{VarIdentifierCharacter}* { return VAR_IDENTIFIER; }

    = { yybegin(READING_STRING); return OP_ASSIGN; }
}

<READING_STRING, SET_READING_VAR_NAME> {LineTerminator} { yybegin(YYINITIAL); }

/* keywords */
// TODO: need to put some lookahead to prevent echoblabla matching
<YYINITIAL> {EchoKeyword} /{LineWhitespace} { yybegin(ECHO_CONSUME_LINE_WHITESPACE); return KEYWORD_ECHO; }
<YYINITIAL> {EchoKeyword} { yybegin(READING_STRING); return KEYWORD_ECHO; }
<YYINITIAL> [Ss][Ee][Tt] { yybegin(SET_READING_VAR_NAME); return KEYWORD_SET; }

<YYINITIAL> {
    {Whitespace} { /* ignore */ }
}

/* error fallback */
[^] { throw new Error("Illegal character <"+ yytext() + ">"); }
