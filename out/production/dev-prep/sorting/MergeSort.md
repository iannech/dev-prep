### Merge Sort

Big O - O(nLog(n))  

**Approach**

Pseudo-code
````
mergeSort(arr[], l, r)
if(r > l)
    - find the middle point to divide the array into 2 halves
          mid = (l + r)/2;
    - call merge sort for the first half
          mergeSort(arr, l, m)
    - call merge sort for the second half
          mergeSort(arr, m+1, r)
    - merge the two halves sorted in step 2 and 3
         merge(arr, l, m, r)
````

Code
````
int mergeSort(int[] arr, int l, int r) {
    
    if(l<r) {
        
        int mid = (l + r)/2;
        
        // call merge sort on LHS
        mergeSort(arr, l, m);
        
        // call merge sort on RHS
        mergeSort(arr, m+1, r);
        
        // merge the sorted halves
        merge(arr, l, mid, r);
        
    }
}

void merge(int[]arr, int l, int mid, int r) {
    // find sizes of two subarrays to be merged
    int n1 = (mid - l) + 1;
    int n2 = r - mid;
    
    // create two temp arrays
    int L[] = new int[n1];
    int R[] = new int[n2];
    
    // copy data to the temp arrays
    for(int i=0; i<n1; i++){
        L[i] = arr[l + i];
    }
    
    for(int j=0; j<n2; j++) {
        L[j] = arr[m + 1 + j];
    }
    
    // merge the temp arrays
    
    // Initial indexes of first and second subarrays 
    int i = 0, j = 0; 
    
    // Initial index of merged subarray array
    int k = l;
    while(i < n1 && j<n2) {
        
        if(L[i] <= R[j]) {
            arr[k] = L[i];
            i++;        
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    
    // copy remaining elements of L1
    while(i < n1){
        arr[k] = L[i];
        i++;
        k++;
    }
    // copy remaining elements of R2
    while(j < n2){
        arr[k] = R[j];
        j++;
        k++;
    }
}
````