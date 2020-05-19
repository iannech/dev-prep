### Given an integer greater than 0, return it's Roman equivalent

Example

Input: 1245 Output: M + CC+ XL + V = MCCLXV

input: 34 = XXX + IV = XXXIV

Hint: A literal cannot be occur 4 times in a row eg XXXX -> prepend next literal to it ie LX


Approach:

Have a set/array/map containing these roman literal representations

1000  900  500 400  100  90    50   40   10    9     5    4    1

["M","CM","D","CD", "C","XC", "L", "XL", "X", "IX", "V", "IV","I"] 

int rem;
int count = 0;

rem = 1245 % 10 = 5           Does set contain 5? Yes. Get V
N = N/10 = 124
count++ = 1
Multiplier = 10^1 

rem = 124%10 = 4
rem = Multiplier * rem = 40  Does set contain 40? Yes. Get XL  prepend to V ---- XLV
N = 124/10 = 12
count++ = 2


rem = 12%10 = 2
rem = Mul * rem * count = 10 ^ 2 * 2 = 200  prepend CCXLV
N = 10/10 =
