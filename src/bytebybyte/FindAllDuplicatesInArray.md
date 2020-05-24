## Given an array of integers where each value 1 <= x <= len(array), write a function that finds all the duplicates in the array.

Example:  

arr [1,2,3]   = []  
arr [1,2,2]   = [2]  
arr [3,3,3]   = [3]  
arr [2,1,2,1] = [2,1]


important info: 1 <= x <= len(array)

Approach 1: 
- Sort the list
- Check if arr[i] = i - 1
- if yes, continue; else add that number as duplicate

 0   1   2  
[1,  2,  2]

- Time complexity: sorting = O( n log n), going through array = O(n)  => O( n log(n))

````
List<Integer> findAllDuplicateInArray(int[] arr){
    
    // return list
    List<Integer> result = new ArrayList<Integer>();
    
    // edge case
    if(arr.length == 0 || arr == null){
        return result;
    }
    
    // sort array
    Arrays.sort(arr);
    
    // check if this constraint is obeyed: arr[i] ==i - 1
    for(int i=0; i<arr.length; i++){
        
        if(arr[i] != i+1)
            result.add(arr[i]);
    }
    
    return result;
}
````

 

