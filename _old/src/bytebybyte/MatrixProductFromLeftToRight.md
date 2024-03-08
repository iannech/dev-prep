## Given a matrix, find the path from top left to bottom right with the greatest product by moving only down and right.

Input:  
[1,2,3]  
[4,5,6]   
[7,8,9]

Output: 1-4-7-8-9 = 2016

[​ -1​ ,2,3]  
[​ 4,5,-6​ ]  
[​ 7,8,9]

Output: -1-> 4 -> 5 -> -6 -> 9 =1080

Approach: (Modified DFS that only goes right and bottom)
- Start at mat[0][0], 

