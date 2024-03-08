import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int solution1(int[] arr) {

        int currentSliceStart = 0;
        int maxSliceLength = 1;
        int maxSliceStart=0;

        for(int i=1; i< arr.length; i++){

            if (arr[i - 1] >= arr[i])
                currentSliceStart = i;


            if(i - currentSliceStart + 1 > maxSliceLength){

                maxSliceStart = currentSliceStart;

                maxSliceLength = i - currentSliceStart + 1;
            }
        }

        return maxSliceStart;

    }

    // modified to return sum of max slice
    public static int solution(int[] A)
    {

        int currSum = A[0];
        int maxSum = A[0];

        for (int i = 1; i < A.length; i++)     //  {1,3};  curr=4 max=4
        {
            if (A[i - 1] >= A[i]) {
                maxSum = Math.max(currSum, maxSum);
                currSum = A[i];

            } else {

                currSum += A[i];
            }
            maxSum = Math.max(currSum, maxSum);

        }

        return maxSum;
    }


    public static void main (String[] args) {

        int [] arr = {2,2,2,2,1,-1,2,1,3};
        int[] arr3 = {2,2,2,2,1,2,-1,2,1,3,4};
        // sum of different slices: {2,2,2,2,1,1,4}

        int [] arr2 = {7,1,2,3,4,5,1,2,3};

        //System.out.println(solution(arr3));
        System.out.println(solution(arr3));

    }



}
