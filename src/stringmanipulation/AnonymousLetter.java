package stringmanipulation;

import java.util.HashSet;
import java.util.Set;

public class AnonymousLetter {

    public static void main(String [] args) {

        String L = "I love you dear";
        String N = "you and I are in love dear";

        System.out.println(AnonymousLetter.anonymousLoveLetter(L,N));

    }

    static boolean anonymousLoveLetter(String L, String N) {

        if(N==null && L == null) return true;

        if(N == null || L == null || N.length() == 0 || L.length() == 0)
            return false;


        L = L.replaceAll("\\s","");
        N = N.replaceAll("\\s","");

        Set<Character> availableChars = new HashSet<>();
        char[] charMessage = L.toCharArray();
        int j = 0;

        for(int i=0; i<N.length(); i++) {
            availableChars.add(N.charAt(i));
        }

        while(j < charMessage.length) {

            if(availableChars.contains(charMessage[j])){
                availableChars.remove(charMessage[j]);
                j++;
            } else {

                return false;
            }
        }

        return true;
    }

    static boolean detectAnonymousLoveLetter(String L, String N){

        if(N==null && L == null) return true;

        if(N == null || L == null || N.length() == 0 || L.length() == 0)
            return false;

        int[] availableChars = new int[256];

        for(int i = 0; i < N.length(); i++){
            int asciiCode = (int)(N.charAt(i));
            availableChars[asciiCode]++;
        }

        for(int r = 0; r < L.length(); r++){
            int asciiCode = (int)(L.charAt(r));
            availableChars[asciiCode]--;
            if(availableChars[asciiCode] < 0)
                return false;
        }
        return true;
    }

}
