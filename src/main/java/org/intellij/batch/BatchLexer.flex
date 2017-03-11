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

LineTerminator = \R
WhiteSpace = {LineTerminator} | [ \t\f]

%%

/* keywords */
<YYINITIAL> [Ee][Cc][Hh][Oo] { return KEYWORD_ECHO; }

<YYINITIAL> {
    {WhiteSpace} { /* ignore */ }
}

/* error fallback */
[^] { throw new Error("Illegal character <"+ yytext() + ">"); }
