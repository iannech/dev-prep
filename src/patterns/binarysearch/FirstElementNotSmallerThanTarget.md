Given an array of integers sorted in increasing order and a target, find the index of the first element in the array that is larger than or equal to the target. Assume that it is guaranteed to find a satisfying number.

### Example

Input: arr = [1, 3, 3, 5, 8, 8, 10]
target = 2
Output: 1

keywords -> sorted, find/search for element
solution: BinarySearch

### Approach

- The target is our key to be searched in the array
- Using binary search:
  - find the midpoint of the array, check if key >= element at mid.
  - If above condition matches, either return midpoint or index mid + 1 if key > mid [contention] -- since all elements to the right of mid might be greater than target, how do we know the right one to return?
  - Otherwise, discard half the list that is < mid element and adjust new boundaries of search space

### Code

```
static int findElement(int[] arr, int key){

    //edge cases
    if(arr == null || arr.length == 0)
    {
        return -1;
    }

    // define bounds
    int hi = arr.length - 1;
    int low = 0;
    int keyIndex = -1;

    while (hi >= low){

        // find midpoint
        int mid = low + (hi - low)/2; // to prevent possible overflow

        if (arr[mid] >= key){

            keyIndex = mid;
            hi = mid - 1;
        }
        else{
            low = mid + 1;
        }
    }
    return keyIndex;
}
```

### Time complexity

O(log n)
