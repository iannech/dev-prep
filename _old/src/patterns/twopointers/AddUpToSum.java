package patterns.twopointers;

import java.util.ArrayList;
import java.util.List;

public class AddUpToSum {

    /**
     * Given a SORTED array of integers return indices of two elements whose sum adds up to k
     *
     * */
    public static void main(String []args) {

        int[]arr = {2,7,11,15};
        int k = 9;

        System.out.println(addUpToSum(arr,k));
    }

    static List<Integer> addUpToSum(int[] arr, int k) {

        int i=0;
        int j = arr.length-1;
        List<Integer> list = new ArrayList<>();

        while (i<j) {

            if(arr[i] + arr[j] == k){
                list.add(i);
                list.add(j);
                return list;

            }else if(arr[i] + arr[j] < k){
                i++;
            } else if(arr[i] + arr[j] > k) {
                j--;
            }
        }

        return list;
    }
}
