package array;

import java.util.Arrays;

public class SmallestMissingPositiveInteger {

//    static int findSmallestMissingInteger(int [] arr) {
//
//        // 1,1,2,3,4,6
//        int currMinNAv = 1;
//        int minNVal = 1;
//        for(int i = 0; i<arr.length; i++) {
//
//            if(!Arrays.asList(arr).contains(arr[i] + 1)){
//                currMinNAv = arr[i]+1;
//            }
//
//            if(!Arrays.asList(arr).contains(arr[i] - 1)){
//                currMinNAv = arr[i] - 1;
//
//            }
//        }
//
////        currMinNAv = Math.min(currMinNAv, minNVal);
//        if(currMinNAv < 1)
//            currMinNAv = 1;
//
//
//        return currMinNAv;
//    }
//
//
//    static int findSmallestMissingInt(int[] arr){
//        int small = 1;
//
//        for(int i = 0; i<arr.length; i++) {
//            if(arr[i] == small + 1){
//                small = arr[i] +1;
//            }
//        }
//
//        if(small < 1)
//            small = 1;
//
//        return small;
//    }

   // {2, 3, -7, 6, 8, 1, -10, 15 } --> {2, 3, 1, 6, 8, 1, 1, 1} -->{}
    public static int findSmallestMissingPostiveInteger(int[] nums) {

        int n = nums.length;

        // 1. Check if 1 exists in the array, if NO, return 1
        boolean oneExists = false;
        for(int i=0; i<n; i++) {

            if(nums[i] == 1)
                oneExists = true;
        }

        if(!oneExists)
            return 1;

        // 2. Convert -ve nos and nos > n to 1
        for(int i=0; i<n; i++) {
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }

        // 3. Traverse array while changing element at index = nums[i] to -ve
        for(int i = 0; i<n; i++) {
            int v = Math.abs(nums[i]);

            if(v == n)
                nums[0] = -1 * Math.abs(nums[0]);
            else
                nums[v] = -1 * Math.abs(nums[v]);
        }

        // 4. Traverse the array and return the index of first +ve index
        for (int k=1; k<n; k++) {
            if(nums[k] > 0) {
                return k;
            }
        }

        if(nums[0] > 0)
            return n;

        // 5. More edge cases
        return n + 1;
    }


    public static void main(String[] args) {

        int[] arr = {1};

        System.out.println(findSmallestMissingPostiveInteger(arr));
        //System.out.println(findSmallestMissingInt(arr));

    }
}
