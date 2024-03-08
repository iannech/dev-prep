package weederquestions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {

        // define return list
        List<List<Integer>> res = new ArrayList<>();

        // edge case
        if(nums.length == 0 || nums == null)
            return res;


        int l = 0;
        int r = nums.length - 1;

        res.add(permuteUtil(nums, l, r));

        return res;

    }

    static List<Integer> permuteUtil(int[]nums, int l, int r){

        /**
         * Fix one element at time at position 1 (use swap util) -> [123] -> [213] -> [321]
         * Make recursive calls to the rest of the characters
         * Use swap to the string back to original form for next iteration -> [123]
         *
         * */
        List<Integer> arrayList = new ArrayList<>();

        if(l == r){
            for(int i=0; i<nums.length; i++)
                arrayList.add(nums[i]);

        } else {

            for(int i=l; i<=r; i++){

                nums = swap(nums, l, i);
                permuteUtil(nums, l+1, r);
                nums = swap(nums, l, i); // backtrack to previous condition
            }

        }

        System.out.println(arrayList);

        return arrayList;
    }

    // swapping util
    static int[] swap(int[] arr, int x, int y) {

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return arr;
    }


    public static void main(String []args) {

        int[] nums = {1,2,3};

        System.out.println(permute(nums));
    }
}
