### Rotate 2D Matrix Clockwise

Example

Input:  
1 2 3  
4 5 6  
7 8 9   

Output:  
7 4 1   
8 5 2   
9 6 3

**Approach**

1. With Extra Space
- Transpose Rows to Columns

````
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
````

2. In Place
- Shift elements one by one using the No of square cycles.

SC = N/2

````
// Clockwise
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
````