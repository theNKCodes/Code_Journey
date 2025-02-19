
//     int poscount, negcount, posfcount, negfcount;

// %%
// [+]?[0-9]+              {poscount++;}
// "-"[0-9]+               {negcount++;}
// [+]?[0-9]+"."[0-9]+     {posfcount++;}
// "-"[0-9]+"."[0-9]+      {negfcount++;}
// [ \t]                   ;
// \n                      return 0;
// %%

//  int yywrap(){}


%{
#include <stdio.h>

int poscount = 0;
int negcount = 0;
int posfcount = 0;
int negfcount = 0;
%}

%%
[+]?[0-9]+             { poscount++; printf("Positive Integer: %s\n", yytext); }
"-"[0-9]+              { negcount++; printf("Negative Integer: %s\n", yytext); }
[+]?[0-9]+"."[0-9]+    { posfcount++; printf("Positive Float: %s\n", yytext); }
"-"[0-9]+"."[0-9]+     { negfcount++; printf("Negative Float: %s\n", yytext); }
[ \t]                  ; // Ignore whitespace
\n                     { return 0; } // Terminate on newline
.                      ; // Ignore other characters

%%

int yywrap() {
    return 1; // Indicate that there is no more input
}

int main() {
    yylex(); // Run the lexer
    printf("Total Positive Integers: %d\n", poscount);
    printf("Total Negative Integers: %d\n", negcount);
    printf("Total Positive Floats: %d\n", posfcount);
    printf("Total Negative Floats: %d\n", negfcount);

    return 0;
}
