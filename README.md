# Berlin Clock
Input : hh:mm:ss
Example : 14:32:09 (current time)
Output
Y
RROO
RRRR
YYRYYROOOOO   32 / 5 = 6
YYOO		  32 % 5 = 2

HH 
Seconds Row: SS % 2 = 0 (O),  SS %2 !=0 Y
FIRST ROW: HH / 5 , MM/5 
SECOND ROW : HH % 5, MM % 5
