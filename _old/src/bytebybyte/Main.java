package bytebybyte;

import java.util.*;

public class Main {


    /**
     * Median of two sorted Arrays
     * */
    static double findMedian(int[]arr1, int[]arr2){

        // have a check if 1 array is null or empty

        int len1 = arr1.length;
        int len2 = arr2.length;

        //merge the two arrays
        int[] newArr = new int[len1+len2];
        int len3 = newArr.length;

        // copy both arrays into newArr: we could sort as we copy
        int i = 0;
        int j = 0;

        System.arraycopy(arr1, 0, newArr, 0, len1);
        System.arraycopy(arr2, 0 , newArr, len1, len2);

        Arrays.sort(newArr);

        // find median
        int mid = newArr.length/2;
        double median = 0;

        if(len3 % 2 == 0){
            median = (double) (newArr[mid] + newArr[mid-1]) / 2;

        } else {
            median = newArr[mid];
        }

        // return median
        return median;
    }

    /**
     * Find all Duplicates in an Array
     *
     * Constraint: for each value 1 <= x <= len(array)
     * */
    static List<Integer> findAllDuplicateInArray(int[] arr){

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

            if(arr[i] != (i + 1))
                result.add(arr[i]);
        }

        return result;
    }


    /**
     * find the length of the longest sequence of
     * consecutive numbers in the array.
     * */
    static int findLongestSequence(int[]arr){

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

            if(i + 1 >= len) break;

            while(arr[i+1] - arr[i] > 1){
                counter = 1;
                i++;
            }
            counter++;
            i++;

        }

        return counter;
    }

    // Using a Set: Assumption - all elements are unique
    static int findLongestSequenceUsingSet(int[]arr){
        // edge case
        if(arr.length == 0 || arr == null)
            return -1;

        Set<Integer> set = new HashSet<>();

        // add elements to set
        for(int i : arr) {
            set.add(i);
        }

        // initialize result as 1
        int maxLen = 1;

        // loop through each element
        for(int e : arr){

            // check if element e is candidate for starting of a sequence i.e previou element (e-1)
            // does not exist in the set
            if(!set.contains(e - 1)){

                // len stores the length of subsequence starting current element
                int len = 1;

                // check for presence of elements e+1, e+2, e+3 ...
                while(set.contains(e + len))
                    len++;

                // update maxLen

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }


    /**
     * Search a Sorted, Rotated Array
     * */

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

        int index;

        if(arr[mid] == key)
            return mid;

        if(key < arr[mid])
            index = binarySearchUtil(arr, low, mid-1, key);
        else
            index = binarySearchUtil(arr, mid, high, key);

        System.out.println(index);
        return index;
    }

    // search rotated array
    static int searchSortedRotatedArray(int[] arr, int key) {

        // edge case
        if(arr == null || arr.length == 0)
            return -1;
        int index = -1;
        // two pointers
        int low = 0;
        int high = arr.length;

        // find pivot
        int pivot = findPivot(arr);

        // if key is at either of these positions, we don't need to search
        if(arr[pivot] == key)
            return pivot;
        if( arr[low] == key)
            return low;
        if(arr[high] == key)
            return high;
        else if(arr[pivot] < key && arr[pivot - 1] > key && key > arr[high])
            index = binarySearchUtil(arr, low, pivot-1, key);
        else if(arr[pivot] < key && arr[high] > key)
            index = binarySearchUtil(arr, pivot, high, key);

        return index;
    }

    static int searchCircularRotatedArray(int[] arr, int key) {
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

                if(key > arr[mid] && key <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // Case 3
            else if(arr[low] <= arr[mid]){

                if(key >= arr[low] && key < arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }
        return -1;
    }

    /**
     * MAIN METHOD
     * */

    public static void main(String []args) {

        int [] arr1 = {1,3,5,7};
        int [] arr2 = {2,4,6};

        //array duplicates
        int [] arr3 = {1,2,2,2};  // 1,2,2,3

        // longest sequence of consecutive
        int[] arr4 = {5,7,4,2,3,1};

        // search rotated sorted array
        int[] arr5 =  {3,4,5,6,7,1,2};

        //System.out.println(findAllDuplicateInArray(arr3));

        //System.out.println(findMedian(arr1, arr2));

        //System.out.println(findLongestSequenceUsingSet(arr4));

        System.out.println(searchCircularRotatedArray(arr5, 3));
    }
}
