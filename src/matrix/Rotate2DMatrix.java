package matrix;

public class Rotate2DMatrix {


    // CLOCKWISE
    static void rotateMatrixClockwise(int[][] mat, int N) {

        int C = N/2;

        for(int r=0; r<C; r++) {
            for(int c=0; c<N-1-r; c++) {

                int temp = mat[r][c];
                mat[r][c] = mat[N-1-c][r];
                mat[N-1-c][r] = mat[N-1-r][N-1-c];
                mat[N-1-r][N-1-c] = mat[c][N-1-r];
                mat[c][N-1-r] = temp;
            }
        }

        printMatrix(mat);
    }

    static int[][] rotateMatrix(int[][] mat) {


        int R = mat.length;
        int C = mat[0].length;
        int[][] ret = new int[C][R];

        for(int r=0; r<R;r++){
            for(int c=0; c<C; c++) {

                ret[c][R-1-r] = mat[r][c];
            }
        }

        return ret;
    }

    static void  printMatrix(int[][] mat) {
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++){

                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public  static void main(String[] args) {


        int [][] matrix = new int[][]
                {{1,2,3},
                {4,5,6},
                {7,8,9}};

        int N = matrix.length;

        Rotate2DMatrix.rotateMatrixClockwise(matrix, N);

//        int newMat[][] = rotateMatrix(matrix);
//        printMatrix(newMat);

    }
}
