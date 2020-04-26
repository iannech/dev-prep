package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RotateSquareMatrix90 {

    /**
     * Matrix considered here is N x N size
     * */

    public static void main(String[] args) {

        RotateSquareMatrix90 rotateSquareMatrix90 = new RotateSquareMatrix90();
        int[][] grid = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        rotateSquareMatrix90.rotateMatrix(grid);
    }

    /**
     * With Extra Space
     * - Create a matrix of the same size an input matrix.
     * - Interchange rows and columns of the original matrix copying them onto the new matrix
     * */

    public void rotateMatrix(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        System.out.println(rotate(grid, h, w));

    }


    static int[][] rotate(int[][]grid, int h, int w) {

        int[][] newMat = new int[h][w];
        Queue<Integer> queue = new LinkedList<>();

        for(int j=0; j<w; j++){

            for(int i=h-1; i>0; i--){
                queue.add(grid[j][i]);
            }

            while(!queue.isEmpty()){

                for(int y=0; y<h; y++) {
                    for(int x=0; x<w; x++) {
                        int temp = queue.poll();
                        newMat[y][x] = temp;
                    }
                }
            }
        }

        return newMat;
    }


    /**
     * In Place
     * - Consider the number of square cycles (N/2) to control your loop
     * - In 1st cycle, swap elements of 1st row, last column, last row and 1st row one by one
     * - In subsequent cycles, move inner
     * */

    static void rotateSquareMatrixClockWise90(int[][] grid, int h, int w) {

        for(int i = 0; i < h/2; i++) {

            for(int j = i; j < h-i-1; j++) {

                int temp = grid[i][j];
                grid[i][j] = grid[h-1-j][i];
                grid[h-1-j][i] = grid[h-1-j][h-1-i];
                grid[h-1-j][h-1-i] = grid[j][h-1-i];
                grid[j][h-1-i] = temp;
            }
        }
    }


}
