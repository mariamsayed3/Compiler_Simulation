grammar GUC;

start returns [int check,int rowResult,int colResult]
  : s EOF {
        $check = ($s.check==1&&($s.firstrow==$s.colsum)) ? 1: 0;
        $rowResult=$s.firstrow;
        $colResult=$s.colsum;

    }
  ;
s returns [int check,int firstrow,int length,int colsum]
  : sDash HASH s1=s  {
      $firstrow = $sDash.sum;
      $check =($s1.check==1&&($s1.length==$sDash.length))?1:0;
      $length=$sDash.length;
      $colsum=$sDash.val+$s1.colsum;
    }
    |
     sDash
     {
      $firstrow = $sDash.sum;
      $colsum=$sDash.val;
      $length=$sDash.length;
      $check=1;
     }
  ;
sDash returns [int length,int sum,int val]
  : a=DIGIT  s1Dash=sDash {
       $length=1+$s1Dash.length;
       $sum=$s1Dash.sum+Integer.parseInt($a.text);
       $val=Integer.parseInt($a.text);
    }
|
    a= DIGIT
     {
     $length=1;
     $sum=Integer.parseInt($a.text);
     $val=Integer.parseInt($a.text);
     }
  ;
DIGIT : [0-9] ;
HASH : '#';
WS : [ \t\n\r]+ -> skip;