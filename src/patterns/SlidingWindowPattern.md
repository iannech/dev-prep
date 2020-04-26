### Sliding Window Pattern

- Used to perform a required operation on a specific window size of an *Array* or *LinkedList*
- Works on iterable data structures -> Array, LinkedList, String
- Commonalities - Everything is grouped in a sequence
- Example keywords
    - Minimum
    - Maximum
    - Longest
    - Shortest
    - Contained
 - Common Questions
    - Maximum sum sub-array of size K (easy) - *fixed length*
    - Smallest sum that is equal or greater to some value S - *dynamic variant*
    - String Anagrams (hard)
    - Longest substring with no more than k distinct characters - *dynamic variant with auxilary Data structure*
    - String permutations - check if a given string exists as a permutation in another string - *dynamic variant with auxilary Data structure*
    

**Maximum sum sub-array of size K = 3**

Example  
Input: arr = [4,2,1,7,8,1,2,8,1,0], k = 3 

Approach

**Brute Force** - 3 nested loops O(n^3)

**Sliding Window Pattern**  O(n)  
  
If curr_sum >= max_sum, max_sum = Math.max(curr_sum, max_sum)

````
static int maxSumSubarray(int[] arr, int k) {
    
    if(arr == null || arr.length == 0)
        return -1;
    
    int curr_sum = 0;
    int max_sum = Integer.MIN_VALUE;
    
    for(int i=0; i<arr.length; i++) {
        
        curr_sum += arr[i]; // add element infront of window
        
        if(i >= k - 1){
            max_sum = Math.max(curr_sum, max_sum);
            curr_sum = curr_sum - arr[i - (k - 1)]; // subtract element at beginning of window
        }
    }
    
    return max_sum;
}
````

**Smallest Sub-array with given sum = k**

*Example*  
Input: arr[4,2,2,7,8,1,2,8,1,0]  k = 8  
Output = 1

Approach  
**BruteForce** - 

**Sliding Window**  
Run a caterpillar like window that grows when the sum < k and shrinks when sum >= k and we are trying to minimize the window
size so as to get smallest sub-array.  
Define two pointers -> windowStart, windowEnd - will help us add   
Have a variable minWindowSize = Integer.MAX_VALUE - what we are trying to Minimize 
Have a var curr_sum = 0 - help us track sum through the array
````
static int smallestSubarray(int[]arr, int sum) {
    
    if(arr == null || arr.length == 0)
        return -1;
        
    int windowStart = 0;
    int minWindowSize = Integer.MAX_VALUE;
    int curr_sum = 0;
    
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
        
        curr_sum += arr[windowEnd];
        
        // try to minimize minWindowSize
        while(curr_sum >= sum){
            minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
            curr_sum -= arr[windowStart];
            windowStart++;
        }
        
    }
    
    return minWindowSize;
}
````