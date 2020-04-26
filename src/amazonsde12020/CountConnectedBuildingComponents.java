package amazonsde12020;

public class CountConnectedBuildingComponents {

//    int countBuildingComponents(int[][] grid) {
//
//        int height = grid.length;
//        int length = grid[0].length;
//        int components = 0;
//        int row = 0;
//        int col = 0;
//        boolean[][] visited = new boolean[height][length];
//
//        for(int i=0; i<height; i++) {
//            for (int j=0; j < length; j++) {
//                visited[i][j] = false;
//            }
//        }
//        for(;row < height; row++) {
//            for(; col< length; col++) {
//
//                if(grid[row][col] == 1){
//                    dfsUtil(grid, components, row, col, visited);
//                }
//
//            }
//        }
//
//        return components;
//    }
//
//    void dfsUtil(int[][]grid, int components, int row, int col, boolean[][]visited) {
//
//        int h = grid.length;
//        int l = grid[0].length;
//
//        if(row >= h || row < 0 || col > l || col < 0 || grid[row][col] != 1)
//            return;
//
//
//        // go L-R-U-D
//        visited[row][col] = true;
//        components +=1;
//        dfsUtil(grid, components, row, col-1,visited);
//        dfsUtil(grid, components, row, col+1,visited);
//        dfsUtil(grid, components,row-1, col, visited);
//        dfsUtil(grid, components,row+1, col, visited);
//
//
//    }

    int countBuildingComponents(int[][] grid) {

        int h = grid.length;
        int l = grid[0].length;
        int components =0;
        if(h == 0)
            return 0;

        for(int i=0; i<h; i++) {

            for(int j=0; j<l; j++) {

                if(grid[i][j] == 1){
                    components = DfsUtil(grid, i, j,components);
                }
            }
        }

        return components;
    }

    int DfsUtil(int[][] grid, int row, int col, int components) {

        int H = grid.length;
        int L = grid[0].length;

        if(row >= H || row < 0 || col >= L || col < 0 || grid[row][col] != 1)
            return 0;

        grid[row][col] = 0; // mark as visited
        components = components + 1;

        DfsUtil(grid, row +1 , col,components);
        DfsUtil(grid, row-1, col, components);
        DfsUtil(grid, row, col+1, components);
        DfsUtil(grid, row, col-1,components);

        return components;
    }

    public static void main(String[] args) {
        int [][] mat = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 1, 1}
        };

        CountConnectedBuildingComponents buildingComponents = new CountConnectedBuildingComponents();
        System.out.println(buildingComponents.countBuildingComponents(mat));
    }
}
