package weederquestions;

public class PascalsTriangle {


    // Method 1
    public static void pascalsTriangleMethod1(int n) {

        int[] prevRow = {};
        int[] currRow = {1};

        printArray(currRow);

        for (int i = 2; i <= n; i++) {
            currRow = new int[i];
            currRow[0] = 1;
            currRow[i - 1] = 1;

            for (int j = 0; j < i - 3; j++) {
                currRow[j + 1] = prevRow[j] + prevRow[j + 1];
            }

            printArray(currRow);
            prevRow = currRow;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void printPascal(int n){
        int [][] arr = new int[n][n];
        for (int y = 0; y < n; y++){
            for (int x = 0; x < y+1; x++){

                if (x == 0) {

                    arr[x][y] = 1;

                }
                else {

                    arr[x][y] = (arr[x - 1][y - 1]) + (arr[x][y-1]);

                }
                if (y == 0 || y == x)
                    System.out.println(arr[x][y] + "\t");
                else
                    System.out.print(arr[x][y] + "\t");
            }
        }
    }


    public static void main(String []args){
        PascalsTriangle.printPascal(7);
    }
}
