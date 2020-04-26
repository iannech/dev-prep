package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] arr){


        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        if(arr == null || arr.length < 2)
            return list;
        int n = arr.length;

        for(int i=0; i<n; i++){

            if(!set.add(arr[i])){
                list.add(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }

        return list;
    }


    public static void main(String []args) {

        int arr[] = null;
        FindAllDuplicatesInArray duplicatesInArray = new FindAllDuplicatesInArray();
        System.out.println(duplicatesInArray.findDuplicates(arr));
    }
}
