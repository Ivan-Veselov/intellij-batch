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
LineWhiteSpace = [ \t\f]
WhiteSpace = {LineTerminator} | {LineWhiteSpace}

// TODO: Looks very ugly, might become an issue. Something must be done.
VarIdentifierCharacter = [[^\r\n]--=] // {InputCharacter}--=
FirstVarIdentifierCharacter = [[[^\r\n]--=]--[ \t\f]] // {VarIdentifierCharacter}--{LineWhiteSpace}

%state SET_AWAITS_VAR_NAME, SET_AWAITS_STRING

%%

<SET_AWAITS_VAR_NAME> {
    {LineWhiteSpace} { /* ignore */ }

    {FirstVarIdentifierCharacter}{VarIdentifierCharacter}* { return VAR_IDENTIFIER; }

    = { yybegin(SET_AWAITS_STRING); return OP_ASSIGN; }
}

<SET_AWAITS_STRING> {
    {InputCharacter}* { return STRING_LITERAL; }
}

<SET_AWAITS_VAR_NAME, SET_AWAITS_STRING> {LineTerminator} { yybegin(YYINITIAL); }

/* keywords */
<YYINITIAL> [Ee][Cc][Hh][Oo] { return KEYWORD_ECHO; }
<YYINITIAL> [Ss][Ee][Tt] { yybegin(SET_AWAITS_VAR_NAME); return KEYWORD_SET; }

<YYINITIAL> {
    {WhiteSpace} { /* ignore */ }
}

/* error fallback */
[^] { throw new Error("Illegal character <"+ yytext() + ">"); }
