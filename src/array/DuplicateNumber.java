package array;

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

    public static void main(String[] args) {

        int[] nums = {3,1,3,4,2};

        DuplicateNumber duplicateNumber = new DuplicateNumber();

        System.out.println(duplicateNumber.findDuplicate(nums));
    }
}
