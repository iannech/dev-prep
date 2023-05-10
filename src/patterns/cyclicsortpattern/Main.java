package patterns.cyclicsortpattern;

/**
 * Main method to execute Cyclic sort pattern questions
 * */
public class Main {


    /**
     * Find Missing Integer in sorted array of range 1 - N
     * */
    static int findMissingInteger(int[] input) {

        // edge case check
        if(input == null || input.length == 0)
            return -1;

        // loop through each element checking if input[element] == index + 1
        for(int index = 0; index < input.length;){

            // if this condition is violated, then an element index + 1 should have been at index
            if(input[index] == index + 1)
                index++;
            else
                return index + 1;

        }

        return -1;
    }


    public static void main(String [] args) {

        System.out.println(findMissingInteger(new int[]{1, 2, 3, 4, 5, 6, 8, 9}));
    }
}
