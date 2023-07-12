grammar Assignment;



startOfGrammar returns [int check]: eachRow EOF
                {$check = ($eachRow.check == 1 && ($eachRow.sumOfFirstRow == $eachRow.sumOfFirstCol))?1:0;};

eachRow returns[int sumOfFirstRow, int sumOfFirstCol ,int length, int check]:
                     eachRowDash '#' eachRow1 = eachRow {$sumOfFirstRow =$eachRowDash.sumOfEachRow;
                     $sumOfFirstCol = $eachRowDash.valOfFirCol + ($eachRow1.sumOfFirstCol);
                     $length = $eachRowDash.lengthOfEachRow;
                     $check = ($eachRow1.check ==1 && ($eachRowDash.lengthOfEachRow == $eachRow1.length))?1:0;}
                    |
                    eachRowDash {$sumOfFirstRow = $eachRowDash.sumOfEachRow;
                                    $sumOfFirstCol = $eachRowDash.valOfFirCol;
                                    $length = $eachRowDash.lengthOfEachRow;
                                    $check = 1;
                                   };

eachRowDash returns[int lengthOfEachRow, int sumOfEachRow, int valOfFirCol]:
                          DIGITS eachRowDash1 = eachRowDash{$lengthOfEachRow = 1 + ($eachRowDash1.lengthOfEachRow);
                          $sumOfEachRow = ($eachRowDash1.sumOfEachRow) + $DIGITS.int;
                          $valOfFirCol = $DIGITS.int;}
                        | DIGITS {$lengthOfEachRow = 1;
                                  $sumOfEachRow = $DIGITS.int;
                                  $valOfFirCol = $DIGITS.int;};
DIGITS: [0-9] ;
WS: [ \t\n\r]+ -> skip;