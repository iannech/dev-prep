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

    // NO EXTRA Space
    static List<Integer> findAllDuplicates(int[] arr){
        List<Integer> res = new ArrayList<>();

        if(arr == null || arr.length == 0)
            return res;

        for(int i=0; i<arr.length;i++) {

            int index = Math.abs(arr[i]) - 1;

            if(arr[index] < 0){

                res.add(Math.abs(arr[index]));

            } else {

                arr[index] = -arr[index];

            }
        }

        return res;
    }


    public static void main(String []args) {

        int arr[] = {1,2,3,4,3,1,5,6};
        FindAllDuplicatesInArray duplicatesInArray = new FindAllDuplicatesInArray();
        System.out.println(duplicatesInArray.findDuplicates(arr));

        System.out.println(findAllDuplicates(arr));

        // copy array
    }
}
