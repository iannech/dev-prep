package stringmanipulation;

import java.util.*;

public class FirstNonRepeatingChar {

    public static void main(String [] args) {

        String input = "aaab";
//        getFirstNonRepeatingCharacter(input);
        System.out.println(fndFirstNonRepeating("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkofg"));
    }

    static void getFirstNonRepeatingCharacter(String input) {

        char[] arr = input.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        if(arr.length < 1) {
            return;
        }

        for(int i=0; i<arr.length;i++){
            set.add(arr[i]);
        }

        Iterator<Character> it = set.iterator();

        if(it.hasNext()){
            System.out.println(it.next());
        } else {
            System.out.println("_");
        }
    }

    static void fndFirstNonRepeatingOriginal(String  arr) {

        char[] input = arr.toCharArray();

        int n = input.length;

        if(input.length < 2){
            return;
        }

        Map<Character, Integer> map = new LinkedHashMap<>(); // to ensure items are inserted in order into Map
        for(int i=0;i<n; i++) {

            if(map.containsKey(input[i])){
                map.remove(input[i]);
            } else {
                map.put(input[i],i);
            }
        }

        Character charr = null;

        if (map.entrySet().iterator().hasNext()){
            System.out.println(charr.toString());
        } else {
            System.out.println("_");

        }

    }

    static char fndFirstNonRepeating(String  arr) {

        char[] input = arr.toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();

        char[] charArray = arr.toCharArray();

        int i = 0;

        while (i < charArray.length){

            if (!map.containsKey(charArray[i])){
                map.put(charArray[i], 1);
            }else {
                map.put(charArray[i], map.get(charArray[i]) + 1);
            }

            i++;

        }

        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }


        return '_';

    }

}
