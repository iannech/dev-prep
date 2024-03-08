package weederquestions;

import java.util.Stack;

public class Main {

    static boolean checkIfValidBrackets(String input){

        // edge case
        if(input == null || input.length() == 0)
            return false;

        Stack<Character> charStack = new Stack<>();

        char[] charArr = input.toCharArray();

        // push each character into stack
        for(int index=0; index<charArr.length; index++){

            charStack.push(charArr[index]);
        }

        // compare to check if valid bracket
        for(int index=0; index<charArr.length; index++) {

            if(comparator(charArr[index], charStack.pop())){

                return true;
            }
        }

        return false;
    }


    static boolean comparator(char a, char b){

        if(a == '{' && b == '}' || a == '(' && b == ')' || a == '[' && b == ']'){

        return true;
    }

    return false;

    }

    // integer Palindrome
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


    public static void main(String[]args) {

        System.out.println(checkIfValidBrackets("()[]{}"));

        System.out.println(isIntegerPalindrome(1));
    }
}
