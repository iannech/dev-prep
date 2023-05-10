package patterns.subsets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AllSubsetsInArray {

    static List<List<Integer>> res = new ArrayList<>();

    // APPROACH 1
    static List<List<Integer>> subsets(int[] arr) {

        // a list to return all our subsets
        List<List<Integer>> result = new ArrayList<>();
        // empty will be among the subsets
        result.add(new ArrayList<>());

        if(arr == null || arr.length == 0)
            return result;

        int s;

        // for each element of the array: go adding it to all subsets in result
        for(int i=0; i<arr.length; i++) {

            // get current size of return list
            s = result.size();

            // loop through each arrayList in return list
            for(int j=0; j<s; j++) {

                // retrieve each arrayList and update it with current element i
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(arr[i]);
                // add it back
                result.add(temp);
            }
        }

        return result;
    }

    // APPROACH 2 : BACKTRACKING
    static List<List<Integer>> subsetsBacktrack(int[] arr) {

        backtrackUtil(arr, 0, new ArrayList<>());

        return res;
    }

    static void backtrackUtil(int[] arr, int index, ArrayList<Integer> list) {

        if(arr.length == index){
            List<Integer> curr = new ArrayList<>(list);
            res.add(curr);
            return;
        }

        list.add(arr[index]);
        backtrackUtil(arr, index+1, list);
        list.remove(list.size() - 1);
        backtrackUtil(arr, index+1, list);

    }



    public static void main(String []args) {

        int[] arr = {1,2,3};

        System.out.println(AllSubsetsInArray.subsets(arr));
    }
}
