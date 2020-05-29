## Given an array with both +ive and -ive integers, return a pair with highest product.

Keywords: -ve, +ve, pair, highest product

Assumptions: unsorted

Examples:  
Input: arr[] = {1, 4, 3, 6, 7, 0}  
Output: {6,7}  

Input: arr[] = {-1, -3, -4, 2, 0, -5}   
Output: {-4,-5} 

BruteForce - O(n^2)
- Check all possible pairs while keeping track of highest product seen yet
- update highest product as you traverse

````
static void findPairsWithMaxProduct(int[]arr){
    
    if (n < 2){ 
        System.out.println("No pairs exists"); 
        return; 
    }
     
    int posA = arr[0];
    int posB = arr[1];
    
    for(int i=0; i<arr.length; i++){
        
        for(int j=i +1; j<arr.length; j++){
        
            if(arr[i] * arr[j] > posA * posB){
                
                posA = arr[i];
                posB = arr[j]
            }
        }
    }
    
    System.out.println("Max product pair is {" + 
                               posA + ", " + posB + "}"); 
}
````
Better Approach - O(n)
- Keep track of maximum +ve value
- Second maximum +ve value
- Maximum -ve value -> -ve value with max absolute value
- Second maximum -ve value

- At the end of the loop, compare products of (a,b) and (c,d). Return maximum of the two


````
static void findPairsWithMaxProduct(int[] arr){
    
    int n = arr.length;
    
    if(arr == null || n < 2)
        System.out.println("No pair exists!");
    
    
    if(n == 2){
        System.out.println(arr[0] + "," arr[1]);
    }
    
    // since we are trying to maximize
    int positiveMaxA = Integer.MIN_VALUE:
    int positiveMaxB = Integer.MIN_VALUE;
    
    int negativeMaxA = Integer.MIN_VALUE;
    int negativeMaxB = Integer.MIN_VALUE;
    
    // Traverse given array
    for(int index=0; index < n; index++){
    
        // update positive max and second max if need be
        if(arr[index] > positiveMaxA){
            
            positiveMaxB = positiveMaxA;
            positiveMaxA = arr[index];
            
        } else if(arr[index] > positiveMaxB){
            
            positiveMaxB = arr[index];
        }
        
        // update negative max and second max if need be
        if(arr[index] < 0 && Maths.abs(arr[index]) > Maths.abs(negativeMaxA)){
            negativeMaxB = negativeMaxA;
            negativeMaxA = arr[index];
        } else if(arr[index] < 0 && Maths.abs(arr[index]) > Maths.abs(negativeMaxB)){
            
            negativeMaxB = arr[index];
        }
    }
    
    if(negativeMaxA * negativeMaxB > positiveMaxA * positiveMaxB){
        
        System.out.println(negativeMaxA + "," negativeMaxB);
    } else {
        
        System.out.println(positiveMaxA + "," positiveMaxB);
    }
}
````