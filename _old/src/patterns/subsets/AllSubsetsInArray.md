### Given a set of distinct integers, nums, return all possible subsets (the power set).
    
    Note: The solution set must not contain duplicate subsets.
    
Example:

Input: nums = [1,2,3]  
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


Approach 1  
Have a list of lists called res that will return all the subsets.  
Loop through the elements as you create a new list temp that you put in the element at arr[i]  
And update all other temp lists in res with the current element arr[i] using a loop that runs through the size of res 

````
static List<List<Integer>> subsets(int[] arr) {
    
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    
    if(arr == null || arr.length == 0)
        return res;
        
    int s = 0;
    
    for(int i : arr) {
        
        s = res.size();
        
        for(int j=0; j<s; j++) {
            
            List<Integer> temp = new ArrayList<>(res.get(i));
            temp.add(arr[i]);
            res.add(temp);
        }
    }
    
    return res;
}
````

Approach 2 : BACKTRACKING  
[1,2,3]   
- Starting with index 0, arr[0] = 1

````
List<List<Integer>> res = new ArrayList<>();

static List<List<Integer>> subsets(int[] arr) {
    
    backtrackUtil(arr, 0, new ArrayList<>());
    
    return res;
}

void backtrackUtil(int[] arr, int index, ArrayList<Integer>() list) {
    
    if(arr.length == index){
        List<Integer> curr = new ArrayList<Integer>(list);
        res.add(curr);
        return;
    }
    
    list.add(arr[index]);
    backtrackUtil(arr, index+1, list);
    list.remove(list.size() - 1);
    backtrackUtil(arr, index+1, list);
    
}
````
 