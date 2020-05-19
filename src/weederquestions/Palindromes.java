package weederquestions;

public class Palindromes {

    public static void main(String[]args){

       System.out.println(isIntegerPalindrome(6886));
    }


    /**
     * Check if Integer is Palindrome without converting to String
     **/
    static boolean isIntegerPalindrome(int num) {


        int ret = 0;
        int originalNum = num;
        while(num > 0){
            int rem = num % 10;
            num = num / 10;
            ret = ret * 10 + rem;

        }

        if(originalNum == ret){
            return true;
        }

        return false;
    }
}
