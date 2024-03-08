### Given a 2-D matrix of 0’s and 1’s, where 1 represents an infected person and 0 represents an uninfected person. After each second an infected person infects his 4 uninfected neighbors(L, R, U, D). Need to calculate time such that all becomes infected.
Example  

[  
 [0,1,0,0],  
 [0,0,1,1],  
 [1,0,0,0],  
 [0,1,1,0]  
 ]  
 Output : 
 
 Approach - BFS traversal of the matrix while keeping a count that increases when all 4 neighbors of an infected patient are infected.  
 
````
int infectPatients(int[][]mat) {
    
    Queue<Integer> queue = new LinkedList<>();
    int height = mat.length;
    int width = mat[0].length;
    boolean[][] visited = new int[height][width];
    int timer = 0;
    int row = 0;
    int col = 0;
    
    queue.add(mat[row][col]);
    
    while(!queue.isEmpty()) {
                
        if(row >= height || row < 0 || col > length || col < 0 || visited[row][col] == true)
            continue;
        
        visited[row][col] = true;
        
        int element = queue.poll();
        if(element == 1){
            mat[row][col-1] = 1;
            queue.add(mat[row][col-1]);
            
            mat[row][col+1] = 1;
            queue.add(mat[row][col+1]);
            
            mat[row-1][col] = 1;
            queue.add(mat[row-1][col]);
            
            mat[row+1][col] = 1;
            queue.add(mat[row+1][col]);   
            timer += 1;

        } else {
            queue.add(mat[row][col-1]);
            queue.add(mat[row][col+1]);
            queue.add(mat[row-1][col]);
            queue.add(mat[row+1][col]);
            
        }
    }
    
    return timer;
}
````