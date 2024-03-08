## Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array

Example:
input = [3,0,1]
output = 2

Example 2:
input = [9,6,4,2,3,5,7,0,1]
output = 8

Assumptions

- No duplicates
- n == nums.length

### Approach 1

- Use a simple math formula that returns sum of n elements = > n \* (n + 1)/2 to get expected sum
- Get the sum of elements in the array nums
- return expected sum = sum of elements in nums. It is the missing element

```
public static int findMissingNumber(int[] nums){
    // edge case
    if(nums == null)
        return -1;

    int n = nums.length;

    int expectedSum = n * (n + 1)/2;

    int sum = 0;

    for(int i=0; i<n; i++){

        sum += nums[i];
    }

    return expectedSum - sum;
}
```

### Approach 2

- Using bit manipulation
  // xor all the elements of the array
  // since the element is in the range 0 to n
  // use another variable and xor it from 0 to n
  // the required ans is obtained by xor the final two variables
  // for eg. arr[] = { 0,2,6,3,8,1,4,5} then xor = 0^2^6^3^8^1^4^5 and total = 0^1^2^3^4^5^6^7^8
  // but total = ( 0^2^6^3^8^1^4^5)^ 7
  // total = xor ^7
  // total^xor = xor^xor^7
  // total ^xor = 7

```
public static int findMissingNumberBit(int[] nums){

    // edge case
    if(nums == null)
        return -1;

    int xOr = 0;

    for(int i : nums){
        xOr = xOr ^ 1;
    }

    for(int i = 0; i<nums.length; i++){
        xOr = xOr ^ 1;
    }

    return xOr;
}
```
