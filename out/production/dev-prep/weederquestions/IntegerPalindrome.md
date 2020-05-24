### Write a function to check whether an integer is a palindrome. Don't convert the integer to String.

Example  
Input: 121,    TRUE  
Input: 688,    FALSE
Input: 888,    TRUE

**Approach**  
Reverse the integer and compare with original number. If equal, return TRUE, otherwise FALSE

````

static boolean isIntegerPalindrome(int num) {

    int ret = 0;
    int originalNum = num;

    while(num > 0){
        int rem = num % 10;  
        num = num / 10;  
        ret = ret * 10 + rem;
    }
    if(originalNum == ret)
        return true;
    else
        return false;
}
````