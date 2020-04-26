package matrix;

public class Rotate2DMatrix {


    // CLOCKWISE
    static void rotateMatrixClockwise(int[][] mat, int N) {

        int C = N/2;

        for(int i=0; i<C; i++) {
            for(int j=0; j<N-1-i; j++) {

                int temp = mat[i][j];
                mat[i][j] = mat[N-1-j][i];
                mat[N-1-j][i] = mat[N-1-i][N-1-j];
                mat[N-1-i][N-1-j] = mat[j][N-1-i];
                mat[j][N-1-i] = temp;
            }
        }

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
    }
}
