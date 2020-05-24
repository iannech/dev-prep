## Find the median of two sorted arrays

Example

Input : arr1 = [1,3,5], arr2 = [2,4,6,5]  
Output : 3.5

Keywords > sorted, median

Assumptions > same size? - NO, -ve elements? - NO

Basic Approach  
- Merge the two arrays, sort, then find median OR we could sort as we merge by comparing elements of both lists
- Time complexity - sorting - O(log (n + m)), finding median - (m+n)/2 => O(log(m+n))
- Space - O(m+n) - new array


````
static double findMedian(int[]arr1, int[]arr2) {

    int n1 = arr1.length;
    int n2 = arr2.length;
    
    int median =0;
    // 
    int[]newArr = new int[n1+n2];
    
    // copy arr1 values
    for(int i=0; i<n1; i++){
        newArr = arr1[i];
    }
    
    // copy arr2 values
    for(int i=0; i<n2; i++){
        newArr = arr2[i];
    }
    
    // sort
    Arrays.sort(newArray);
    
    int mid = newArr.length/2;
    
    if(newArr.length % 2 == 0){
        
        median = (double)(newArr[mid] + newArr[mid -1])/2;
    
    } else {
    
        median = newArr[mid];
    }
    
    return median;
}
````