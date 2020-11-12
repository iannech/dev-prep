package safinterview;

import java.util.Arrays;

public class BillInterview {




    static int longestSubstringWithoutRepeatingCharacters(String input) {


        int n = input.length();

        int result = 0; // result

        // intialize all chars as -1
        int [] lastInd = new int[256];
        Arrays.fill(lastInd, -1);

        // Initialize start of current window
        int i = 0;

        // Scan the input left to right while keeping track of longest length of non-repeating characters

        // Move end of current window
        for (int j = 0; j < n; j++) {

            // Find the last index of str[j]
            i = Math.max(i, lastInd[input.charAt(j)] + 1);

            // Update result if we get a larger window
            result = Math.max(result, j - i + 1);

            // Update last index of j.
            lastInd[input.charAt(j)] = j;
        }
        return result;
    }


    static int largestDifference(int[] arr){

        // edge case
        if(arr == null || arr.length == 0){
            return 0;
        }

        // compare two consecutive elements, left to right while
        // keeping track of maximum difference seen so far
        int i = 0;
        int max = Integer.MIN_VALUE;
        int currentMax = 0;

        for(int j = i+1; j < arr.length; j++){

            // calculate current max
            currentMax = arr[j] - arr[i];
            // compare and update max
            max = Math.max(currentMax, max);

            // increment i
            i +=1;

        }

        return max;
    }













    public static void main(String[] args){
        String str = "geaksopuforgeeks";
        System.out.println("The input string is " + str);

        System.out.println(longestSubstringWithoutRepeatingCharacters(str));

        int[] arr = {1,3,4,5,8,9,15,30};

        System.out.println(largestDifference(arr));
    }
}
