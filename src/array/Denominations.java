package array;

import java.util.ArrayList;
import java.util.List;

public class Denominations {

    static List findDenom(int[] arr, int x) {

        List<Integer> newArray = new ArrayList<>();

        int h = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                newArray.add(arr[i]);
//                x = x / 2;
                //findDenom(arr, x);            }
            }
        }


        x = x /2;
        findDenom(arr, x);
        return newArray;


//    static int findSmallestAbs(int y, int x) {
//        return Math.max(y,x);
    }

    public static void main(String [] args) {
        int[] arr = {1,5,20,25,50,100};
        int x = 50;
        System.out.println(findDenom(arr, x));
    }
}
