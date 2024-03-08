### Given an m x n matrix, return all elements of the matrix in spiral order

Example  
Input:   
[  
  [1,2,3],  
  [4,5,6],  
  [7,8,9]  
]

Output: [1,2,3,6,9,8,7,4,5]

Approach  
- Init a return list
- Starting with element at Top go Right while adding elements to list.
- When you reach mat[0].length -1. Go Bottom
- When you reach Bottom, Go Left
- When you reach Left, Go Top
- Repeat

Constraints: Have checks to ensure you don't go out of bounds of the matrix in all 4 directions

Code
````
List<Integer> spiralOrder(int[][] mat ){

    List<Integer> res = new ArrayList<>();
     
    // edge case
    if(mat.length == 0 || mat[0].length == 0)
        return res;
    
    // params to help in traversal
    int left = 0;
    int top = 0;
    int right = mat[0].length -1;
    int bottom = mat.length -1;
    
    // traverse the matrix in spiral order
    // it is true if we are within bounds
    while(true) {
        
        // go right
        for(int i=left; i<=right; i++)
            res.add(mat[top][i]);
        top++;
        
        if(left > right || top > bottom)
            break;
        
        // go down
        for(int i=top; i<=bottom; i++)
            res.add(mat[i][right]);
        right--;
       
        if(top > bottom || left > right)
            break;
        
        // go left
        for(int i=right; i>=left; i--)
            res.add(mat[bottom][i]);
        bottom--;
        
        if(left > right || top > bottom)
            break;
            
        // go up
        for(int i=bottom; i>=top; i--)
            res.add(mat[i][left]);
        left++;
        
        if(left > right || top > bottom)
             break;
        
    }   
    
    return res; 
}
````