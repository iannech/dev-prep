###Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), Find all duplicates in an array. Some elements appear twice and others appear once.
   
Could you do it without extra space and in O(n) runtime?

Example:  
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]  

// Approach 1 [HashMap/HashSet]  
1. Loop through array and for each element check if it exists in map, if true, update count. Otherwise insert into map with 
count of 1

2. Use SET and loop through array: for each element try adding to set, if not success, add that element to list. Return list
````
public List<Integer> findDuplicates(int[] arr){
    
    if(arr == null || arr.length < 2)
        return -1;
        
    
    int n = arr.length;
    
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    
    for(int i=0; i<n; i++){
        
        if(!set.add(arr[i]) {
            list.add(arr[i]);
        } else {
            set.add(arr[i]);
        }
    }
    
    return list;
}
````

// Approach 2 [No Extra Space]    
Hint:1 ≤ a[i] ≤ n (n = size of array)  - all elements in the array can rep an index  

Use a simple Mathematical approach of turning each element to a -ve by and if you encounter an element that brings up 
that -ve again know its a duplicate.
````

public List<Integer> findAllDuplicates(int[] arr){
    List<Integer> res = new ArrayList<>();
    
    if(arr == null || arr.length == 0)
        return res;
        
    for(int i=0; i<arr.length;i++) {
        
        int index = Math.abs(arr[i]) -1;
        if(arr[index] < 0){
            res.add(arr[index]);
        } else {
            arr[index] = -arr[index];
        }
    }
}
````