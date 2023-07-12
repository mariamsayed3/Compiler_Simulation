grammar try;




t returns[int val]: f t_dash[$f.val] {$val = $t_dash.syn;};

t_dash[int inh] returns[int syn]: '*' f t1 = t_dash[$inh * $f.val]{$syn = $t1.syn;} | {$syn = $inh}; // or fady dah m3nah epsilon

f returns[int val]: DIGIT {$val = $DIGIT.int;}; //parser rule //Integer.parseInt(.text)
DIGIT: [0-9]; //token

//refernce any attribute b7ot $

