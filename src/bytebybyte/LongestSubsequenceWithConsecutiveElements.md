## Given an unsorted array, find the length of the longest sequence of consecutive numbers in the array.

Example

[​ 4 ​ , 2 ​ , 1 ​ , 6 , ​ 5 ​ ] = 3 --> [4,5,6]

[​ 5 ​ , 5 ​ , 3 ​ , 1] = 1 --> [5] or [3] or [1]

Approach

BruteForce
- Sort array input.- O(n log(n))
 [1,2,4,5,6]
- Compare consecutive elements if diff is 1 and keep a counter that starts from 1 -> O(n)

````
static int findLogestSequence(int[]arr){
    
    // edge case
    if(arr.length == 0 || arr == null)
        return -1;
        
    int len = arr.length;
    int counter = 1;
    
    // sort
    Arrays.sort(arr);
    
    // compare elements
    int i = 0;
    while(i < len) {
        
        while(arr[i+1] - arr[i] > 1){
            counter = 1;
            i++;
        } else {
            counter++;
            i++;
        }
    }
}
````
