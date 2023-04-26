## Given a sorted Array of n-1 consective numbers which are in the range 1 to n. Write an efficient algorithm to find the missing number.

keywords: sorted, range = 1 - n, missing val

Examples:  
Input :  [1, 2, 3, 4, 6, 7, 8]  
Output : 5

Input: [1, 2, 3, 4, 5, 6, 8, 9]  
Output: 7

Assumptions: No duplicates

Approach 1
- Since we expect the array to be of size n, there's a formula for getting sum of n items
- Find  ExpectedSum =  n (n + 1) / 2 --- 72/2 = 36
- And  CurrentSum = 31
- Missing number will be ExpectedSum - CurrentSum. missing = 36 - 31 = 5
- Time => O(n)

But we want to make use of the info provided(range, sorted)

Approach 2  

- We can note that comparing each digit with its index,  element = index + 1
- We expect that if we loop through array, all elements should have this mapping. 
- If we get a conflict, then the missing number can be found at that point.

 0  1  2  3  4  5  6  
[1, 2, 3, 4, 6, 7, 8]

return (i + 1) as the missing integer

````
static int findMissingInteger(int[] input) {

    // edge case check
    if(input == null || input.length == 0)
        return -1;
        
    // loop through each element checking if input[element] == index + 1
    for(int index = 0; index < input.length;){
        
        if(input[index] == index + 1)
            return index++;
        else
            return index + 1;
    }
    
    return -1;
} 
````

