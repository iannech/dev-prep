### Write a function to check whether an integer is a palindrome. Don't convert the integer to String.

Example  
Input: 121,    TRUE  
Input: 688,    FALSE
Input: 888,    TRUE

**Approach**  
Reverse the integer and compare with original number. If equal, return TRUE, otherwise FALSE

````

static boolean isIntegerPalindrome(int num) {

    int rem = 0;
    int ret = 0;
    
    while(num > 0){
        rem = num % 10;  1, 2, 1
        num = num / 10;  12, 1,
        ret = ret * 10 + rem;
    }
    if(num == ret)
        return true;
    else
        return false;
}
````