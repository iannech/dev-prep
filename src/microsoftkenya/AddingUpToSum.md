### Given an array of values and a target sum k. Return the index of pair elements adding up to the sum

Example  
Input: arr {2,1,5,4,6,8,3},  k = 14

Output = [4,5]

Assumption: No repeating elements

**Approach**

- With extra space  
O(n) - space  
O(n) - time  
Map<index, value> = [<0,2>, <1,1>, <2,5>, <3,4>, <4,6>, <5,8>, <6,3>]

loop through array:
        c = k - arr[i]    
        if(map.contains(c))
            list.add(i)
            list.add(map.get(c))
        return list
        
            
- With no extra space  
Space = O(1)  
Time = O(n) * O(log(n)) = nlog(n)  
Sort the array in O(log(n)) time  
arr = {1,2,3,4,5,6,8}  

Use two pointers    
i = 0  
j = arr.length-1

loop from both ends:  
    add arr[i] + arr[j]  
    if(sum > k)  
        j--  
    if(sum < k)  
        i++  
    else if(sum == k) 
        list.add(i)  
        list.add(j)  
    return list     
 
 **Code**       
 ````
 static ArrayList<Integer> pairsAddingToSum(int[]arr, int k) {
    
    // edge case
    if(arr.length < 2 || arr == null)
        return new ArrayList<>();
    
    // output list
    List<Integer> ret = new ArrayList<>();
    
    // map to hold K,V pair of value and index of value
    Map<Integer,Integer> map = new HashMap<>();
    
    for(int i=0; i<arr.length; i++){
        map.put(arr[i], i);
    }
    
    // scan the array, compute complete of the value at index and check if map contains it
    for(int index=0; index<arr.length;index++){
        int complement = k - arr[index];
        
        if(map.containsKey(complement)){
            // add the two indexes whose values add up to k
            ret.add(index);
            ret.add(map.get(complement));
            break;
        }
    }
    
    return ret;
 }
 ````