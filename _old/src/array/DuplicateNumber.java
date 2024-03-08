package array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {

    public int findDuplicate(int[]nums) {

        int length = nums.length;
        int i = 0;

        while(i < length) {

            while(nums[i] != nums[nums[i] -1]){

                swap(nums, i, nums[i]- 1);

            }

            if(i != nums[i] - 1)
                return nums[i];

            i++;
        }

        return -1;
    }

    void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // with O(n) space
    static int findDuplicateNum(int[]arr){

        Set<Integer> set = new HashSet<>();

        // edge case


        int i = 0;
        while (i < arr.length){

            if(set.add(arr[i])){
                i++;
            } else {
                return arr[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1};

        DuplicateNumber duplicateNumber = new DuplicateNumber();

        System.out.println(duplicateNumber.findDuplicate(nums));
        System.out.println(findDuplicateNum(nums));
    }
}
