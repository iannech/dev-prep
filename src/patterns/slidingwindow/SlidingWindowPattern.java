package patterns.slidingwindow;

public class SlidingWindowPattern {

    /**
     * Find the Smallest Sub-array with given sum = K
     * */
    static int smallestSubarray(int[]arr, int sum) {

        if(arr == null || arr.length == 0)
            return -1;

        int windowStart = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int curr_sum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){

            curr_sum += arr[windowEnd];

            // try to minimize minWindowSize
            while(curr_sum >= sum){
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                curr_sum -= arr[windowStart];
                windowStart++;
            }

        }

        return minWindowSize;
    }


    /**
     *Find Maximum sum sub-array of size K
     * */
    static int maxSumSubarray(int[] arr, int k) {

        if(arr == null || arr.length == 0)
            return -1;

        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {

            curr_sum += arr[i]; // add element infront of window

            if(i >= k - 1){
                max_sum = Math.max(curr_sum, max_sum);
                curr_sum = curr_sum - arr[i - (k - 1)]; // subtract element at beginning of window
            }
        }

        return max_sum;
    }

    public static void main(String[] args) {

        int[] arr = {4,2,2,7,8,1,2,8,1,0};
        int targetSum = 6;

        System.out.println(smallestSubarray(arr,targetSum));
    }
}
