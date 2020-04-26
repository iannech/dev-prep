### Given an array  of  integers n and a number d perform d left rotations on the array. Return the updated rotated array.

Example

Input: arr[1,2,3,4,5] , d = 2  
Output: [3,4,5,1,2]


Simple Approach -> Rotate each element 1 by 1
````
static int[] leftRotateArray(int[] arr, int d) {
    
    if(arr == null || arr.length == 0)
        return arr;
        
    int n = arr.length;
    
    for(int i=0; i<d; i++){
        
        leftRotateUtil(arr, n);
    }
    
    return arr;
}

// shifts every element by 1 to the left
static void leftRotateUtil(int[] arr, int n){
    
    int i;
    int temp = arr[0];
    
    for(i=0; i<n-1; i++) 
        arr[i] = arr[i+1];    
    arr[i] = temp;
}
````

