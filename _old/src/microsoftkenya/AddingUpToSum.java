package microsoftkenya;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddingUpToSum {

    // With Extra Space
    static List<Integer> pairsAddingToSum(int[]arr, int k) {

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


    public static void main(String[] args) {

        int[] arr = {2,1};
        int k = 6;

        System.out.println(pairsAddingToSum(arr,k));
    }
}
