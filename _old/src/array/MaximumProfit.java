package array;

public class MaximumProfit {

    public static int findMaxProfit(int[] arr) {


        int maxP = 0;
        int min = arr[0];
        int max = arr[0];

        int n = arr.length;

        for(int i = 1; i < n-1; i++) {

            if(arr[i+1] > arr[i]){

                min = arr[i+1];
            }

            if(arr[i-1] > arr[i]){
                min = arr[i];
            }


            if(arr[i+1] < arr[i] && i > 0 || i == n-2){
                maxP = maxP + (max - min);
                System.out.println("Max P =  " +maxP + " Max = "+ max +" Min = "+min);

                min = max = arr[i+1];
            }

        }

        return maxP;
    }

    public static void main(String [] args) {


        int [] arr = {100,180,260,310,40,535,695,10,500};

        System.out.println(findMaxProfit(arr));
    }
}
