package subsets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AllSubsetsInArray {

    static List<List<Integer>> res = new ArrayList<>();

    // APPROACH 1
    static List<List<Integer>> subsets(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if(arr == null || arr.length == 0)
            return result;

        int s = 0;

        for(int i=0; i<arr.length; i++) {

            s = result.size();

            for(int j=0; j<s; j++) {

                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(arr[i]);
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

        System.out.println(AllSubsetsInArray.subsetsBacktrack(arr));
    }
}
