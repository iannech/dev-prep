### Given an integer greater than 0, return it's Roman equivalent

Example

Input: 1245 Output: M + CC+ XL + V = MCCLXV

input: 34 = XXX + IV = XXXIV

Hint: A literal cannot be occur 4 times in a row eg XXXX -> prepend next literal to it ie LX
Constraint: We have an upper limit of 3999

Approach:
- A very simple approach is to store all roman representations in 4 arrays
  - ones
  - tens
  - hundreds
  - thousands

- Then for each position starting with the least significant, fetch its corresponding mapping in the arrays
- Use division and modulus to achieve this
````

static String convertIntegerToRoman(int num) {

    String [] thousands = {"", "M", "MM", "MMM"};
    String [] hundreds = {"", "C", "CC", "CCC", "CD","D", "DC", "DCC", "DCCC", "CM"};
    String [] tens = {"", "X", "XX", "XXX", "XL", "L", "LX","LXX", "LXXX", "LC"};
    String [] ones = {"", "I,"II","III","IV","V","VI","VII","VIII","IX","X"};
    
    return thousands(num / 1000) +
           hundreds((num % 1000) / 100) +
           tens((num % 100) / 10) +
           ones(num % 10);
           
}
````

