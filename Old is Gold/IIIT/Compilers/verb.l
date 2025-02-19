%{
    #include <stdio.h>
    #define YY_DECL int yylex()
    YY_DECL;

    #undef yywrap
    #define yywrap() 1
%}

%%

[/t ]+     ;

is|am|are|were|was  {printf("%s: is a verb\n", yytext);}

[a-zA-Z]            {printf("%s: is not a verb\n", yytext);}

%%

int main(){
    yylex();
}
