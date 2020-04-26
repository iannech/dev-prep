package amazonsde12020;

import java.util.HashMap;
import java.util.Map;

public class RemoveStringsToFormPalindrome {

    public static void main(String []args) {
        String S = "dad";
        System.out.println(RemoveStringsToFormPalindrome.removeMinimumNumber(S));

    }

    public static int removeMinimumNumber(String S) {

        if(S == null || S.length() == 0)
            return -1;

        Map<Character, Integer> map = new HashMap<>();

        int count = 0;
        int poll = 1;

        for(int i=0; i<S.length(); i++) {
            if(map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), poll+1);
            } else {
                map.put(S.charAt(i), poll);
            }
        }

        System.out.println(map);
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 != 0)
                count++;
        }

        return count;
    }
}
