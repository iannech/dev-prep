### Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.


Constraints
- Less than O(n^2) time
- Use constant space O(1)
- Don't modify array - you can't sort   

Example  
Input = [1,3,4,2,2]  
Output = 2

Input: [3,1,3,4,2]   
Output: 3

Approach: Cyclic Sorting Pattern
````
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
````
