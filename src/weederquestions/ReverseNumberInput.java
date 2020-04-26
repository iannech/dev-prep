package weederquestions;

public class ReverseNumberInput {

    static int reverseNumber(int num) {

        int reversedNum = 0;

        if(num <= 10)
            return num;

        while (num > 0){

            reversedNum = reversedNum * 10;
            reversedNum = reversedNum + num % 10;
            num = num / 10;
        }

        return reversedNum;
    }

    public static void main(String [] args){

        System.out.println(reverseNumber(10));
    }
}
