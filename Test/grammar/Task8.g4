/**
 * Write your info here
 *
 * @name Mariam Wael
 * @id 46-1356
 * @labNumber 21
 */

grammar Task8;



/**
 * This rule is to check your grammar using "ANTLR Preview"
 */
test: (IF |LP| RP| ELSE | COMP | ID | NUM | LIT)+ /* (Rule1 | Rule2 | ... | RuleN)+ */ EOF; //Replace the non-fragment lexer rules here

// Write all the necessary lexer rules and fragment lexer rules here
WS : [ \n\t\r] -> skip;
IF: [iI][fF];
ELSE:[eE][lL][sS][eE];
COMP: '>'|'<'|'>='|'<='|'=='|'!=';

ID: (ALPA|('_')) (ALPA|DIGIT|'_')*;


LIT: DOUBLEQ (MATCHESANYTHINGEXCEPT |ANTTHINGPRECEEDWITH)* DOUBLEQ;

NUM: (DIGIT)+ (DECIMAL)? (EEXPR)?;
LP:'(';
RP: ')';

fragment DIGIT:[0-9];
fragment ALPA:[a-zA-Z];
fragment E options {caseInsensitive = true;}: 'e';
fragment EEXPR: E ('+'|'-')? DIGIT+ ;
fragment DECIMAL:'.' DIGIT+ ;
fragment DOUBLEQ:'"';
fragment MATCHESANYTHINGEXCEPT: ~('"'|'\\');
fragment ANTTHINGPRECEEDWITH:'\\'.;