package array;

import java.util.Arrays;

public class ThreeClosestDenominations {

    static int[] closest(int[] currencies, int x) {
        int smallest = 0, medium = 1, largest = 2;

        for(int i=0; i< currencies.length - largest; i++) {

            while (currencies[smallest] + currencies[medium] + currencies[largest+1] <= x) {
                largest++;
            }

        }

        for(int l=0; l< currencies.length - largest; l++) {

            while (currencies[smallest] + currencies[medium + 1] + currencies[largest] <= x) {
                medium++;
            }
        }


        for(int m=0; m< currencies.length - medium; m++) {

            while (currencies[smallest+1] + currencies[medium] + currencies[largest] <= x) {
                smallest++;
            }
        }

        return new int[] {currencies[smallest], currencies[medium], currencies[largest]};
    }


    public static void main(String [] args) {

        int[] arr = {1,2,5,15,20,25,50,100,200,500};
        int x = 99;


        System.out.println(Arrays.toString(closest(arr, x)));
    }
}

