## Given a sorted rotated array and a key. implement a function to search and return the index of the key from the array.

Example  
Input: arr = {3,4,5,6,7,1,2}  key = 2  
Output: 6

Input: arr = {2,4,5,8,1} key = 3  
Output: -1 


keywords: sorted, rotated

Approach 1
- Apply Modified Binary Search
    - Have 3 indexes, low, mid and high
    - Exploit a property to discard half of the array
    - Atleast one of the halves will always be sorted and the pivot will be in one half
- Case 1: arr[mid] == key   
    return mid    
- Case 2: arr[mid] <= arr[high]
    - 2a : if(x > arr[mid] && x <= arr[high])  
                low = mid + 1
    - 2b:  high = mid -1
    
- Case 3: arr[low] <= arr[mid]
    - 3a: if(x >= arr[low] && x < arr[mid])  
              high = mid - 1           
    - 3b: low = mid + 1  
    
Assumptions
- Distinct elements
- No Duplicates
    
````
static int searchCircularRotatedArray(int[] arr, int x) {
     // edge case
    if(arr == null || arr.length == 0)
        return -1;
        
    int low = 0;
    int high = arr.length-1;
    
    while(low <= high){
        
        int mid = low + (high - low)/2;
         
        // Case 1: if key is at midpoint
        if(key == arr[mid]){
            return mid;
        } 
        // Case 2
        else if(arr[mid] <= arr[high]){
        
            if(x > arr[mid] && x <= arr[high]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Case 3
        else if(arr[low] <= arr[mid]){
            
            if(x >= arr[low] && x < arr[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
           
    }
    
    return -1;    
}
````    


Approach 2[Incomplete]:
- Apply Modified Binary Search
    - We have to find the point of rotation in the array, call it pivot
    - Based on value at pivot, value at low position, value at high position and key, we'll know which section of array 
    to binary search.
    
    {3,4,5,6,7,1,2}  key = 2  
    
    pivot = index 5
    
        if(arr[pivot] == key || arr[low] == key || arr[high] == key) return index
        
        if(arr[pivot] < key && arr[pivot -1] > key && arr[high] < key)
            binarySearch(arr, low, pivot-1)
        
        if(arr[pivot] < key && arr[high] > key)
            binarySearch(arr, pivot, high)
            // {4,5,6,7,1,2,3}  key = 2
            
   - Finding pivot is the problem  
   
    loop from startInd = 0, nextInd = startInd + 1
            
        if(arr[startInd] < arr[nextInd])
            startInd ++
            nextInd ++
            
        else {
            pivot = nextInd;
        }   
            
            
        
          
````
// find pivot util
static int findPivot(int[]arr) {

    int startInd = 0;
    int nextInd = startInd + 1;
    int len = arr.length;
    int pivot = -1;
    while(startInd < len-1 && nextInd < len){
        
        if(arr[startInd] < arr[nextInd]){
            
            startInd++;
            nextInd++;
            
        } else {
        
            pivot = nextInd;
        }
    }
    
    return pivot;
}

// binary search utility function
static int binarySearchUtil(int[]arr, int low, int high, int key){

    int mid = low + (high - low)/2;
    
    int index = -1;
    
    if(arr[mid] == key)
        return mid;
    
    if(key < arr[mid])
       index = binarySearchUtil(arr, low, mid-1, key);
    else
       index = binarySearchUtil(arr, mid, high, key);        
}

// search rotated array
static int searchSortedRotatedArray(int[] arr) {
    
    // edge case
    if(arr == null || arr.length == 0)
        return -1;
        
    // two pointers
    int low = 0;
    int high = arr.length;
    
    // find pivot
    int pivot = findPivot(arr);
    
    // if key is at either of these positions, we don't need to search
    if(arr[pivot] == key) 
        return index;
    if( arr[low] == key)
        return low;
    if(arr[high] == key)
        return high;
    else if(arr[pivot] < key && arr[pivot - 1] > key && key > arr[high])
        binarySearchUtil(arr, low, pivot-1, key);
    else if(arr[pivot] < key && arr[high] > key)
        binarySearchUtil(arr, pivot, high, key);    
}

````