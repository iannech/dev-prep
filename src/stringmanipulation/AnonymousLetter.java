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

        // edge case check if both are null
        if(N==null && L == null) return true;

        // edge case if either is null
        if(N == null || L == null || N.length() == 0 || L.length() == 0)
            return false;

        // init an array with size of extended ASCII size
        int[] availableChars = new int[256];

        // for each character in News Paper
        for(int i = 0; i < N.length(); i++){

            // get it's int representation
            int asciiCode = (int)(N.charAt(i));
            // and add it to the availableChars array
            availableChars[asciiCode]++;

        }

        // For each letter in Letter
        for(int r = 0; r < L.length(); r++){

            // get it's int representation
            int asciiCode = (int)(L.charAt(r));
            // remove it from Newspaper
            availableChars[asciiCode]--;

            // if we run out of letters from newspaper return false
            if(availableChars[asciiCode] < 0)
                return false;
        }

        // we have enough letters
        return true;
    }

}
