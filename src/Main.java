import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String []args) {

        int[]arr = {4,3,2,7,8,2,3,1,1};

        int[] nums = {1,-1,0,-1,0,12,0,0,0};

        printArray(segregate0sAndOther(nums));

        //System.out.println(Main.findAllDuplicatesInArray(arr));
        //System.out.println(Main.maxSumSubarray(arr, 3));
    }

    public static List<Integer> findAllDuplicatesInArray(int[] arr) {

        List<Integer> res = new ArrayList<>();

        if(arr == null || arr.length == 0)
            return res;

        for(int i=0; i<arr.length; i++){

            int index = Math.abs(arr[i]) -1;

            if(arr[index] < 0){

                res.add(Math.abs(arr[i]));

            }
            else {

                arr[index] = -arr[index];

            }
        }

        return res;
    }

   static int[] segregate0sAndOther(int[]nums) {

        if(nums == null || nums.length == 0)
            return nums;

        int n = nums.length;
        int i = 0;
        int j = i+1;

        while (j < n) {

            if(nums[i] == 0 && nums[j] > 0){
                swap(nums, i , j);
                i++;
                j++;
            } else if (nums[i] > 0 && nums[j] >=0){
              i++;
              j++;
            }
            else {
                j++;
            }
        }

        return nums;
    }

    static void swap(int[] nums, int x, int y){

        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    static void printArray(int[] nums) {

        for (int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
