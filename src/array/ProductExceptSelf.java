package array;


public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] L = new int[n];  // to hold products of elements on LHS of i
        int [] R = new int[n]; // to hold products of elements on RHS of i

        int[] output = new int[n]; // final output

        L[0] = 1;  // there are no elements to the left of L[0] so set the product as 1
        for(int i=1; i<n; i++) {

            L[i] = nums[i - 1] * L[i - 1];

        }

        R[n-1] = 1;
        for(int i = n-2; i >=0; i--){

            R[i] = nums[i+1] * R[i+1];
        }

        // combine for final output
        for(int i=0; i<n; i++) {

            output[i] = L[i] * R[i];
        }

        return output;

    }


    public static void main(String[] args) {

        int[] input = {1,2,3,4};

        ProductExceptSelf productExceptSelf = new ProductExceptSelf();

       int[] output = productExceptSelf.productExceptSelf(input);

        for (int i=0; i<input.length; i++) {
            System.out.print(output[i]+" ");
        }
    }
}
