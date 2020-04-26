### Given a 2-D matrix of 0’s and 1’s, where 1 represents a building component and 0 represents an empty area. We need to calculate total number of connected building components.

Hint: Refer to Counting the islands problem

Example  
11000  
11000  
00100  
00011  

output: 3

11110  
11010  
11000  
00000  

output: 1


Approach: DFS

````

int countBuildingComponents(int[][] grid) {
    
    int height = grid.length;
    int length = grid[0].length;
    int components = 0;
    int row = 0;
    int col = 0;    
    boolean[][] visited = new boolean[row][col];
   
    for(;row < height; row++) {
        for(; col<length; col++) {
            
            if(visited[row][col] != false){
                dfsUtil(grid[row][col], components, visited[][], row, col, height, length);
            }
        }
    }
    
    return components;
}

int dfsUtil(int[][]grid, int components, boolean[][] visited, int row, int col, int h, int l) {

  if(h < 0 || col < 0)
    return -1;
   
  if(row >= h || row < 0 || col > length || col < 0 || visited[row][col] == true)
    continue;
    
  if(visited[row][col] != true && grid[row][col] == 1){
    // go L-R-U-D
    visited[row][col] == true;
    components +=1;
    dfsUtil(grid, components, visited[][], row, col-1);
    dfsutil(grid, components, visited[][], row, col+1);
    dfsUtil(grid, components, visited[][], row-1, col);
    dfsutil(grid, components, visited[][], row+1, col);
    
  }
}



````