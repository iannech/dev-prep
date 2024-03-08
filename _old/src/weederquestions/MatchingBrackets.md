## Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
   
What is valid parentheses?
- Open brackets must be closed by same type of brackets
- Open brackets must be closed in the correct order

Example:

Input: "()"    
Output: true

Input: "()[]{}"  
Output: true

Input: "(]"  
Output: false

Input: "([)]"  
Output: false

Input: "{[]}"  
Output: true

Approach
- Using a stack. push each character into stack.
- Loop through the characters, pop from stack and compare if the current character is the matching pair of what you've 
popped from stack.

two methods
- checkIfValidBrackets()
- comparatorMethod()


````
boolean checkIfValidBrackets(String input){

    // edge case
    if(input == null || input.length() == 0)
        return false;
        
    Stack<Character> charStack = new Stack<>();
    
    char[] charArr = input.toCharArray();
    
    // push each character into stack
    for(int index=0; index<charArr.length; index++){
        
        charStack.push(charArr[index]);
    } 
    
    // compare to check if valid bracket
    for(int index=0; index<charArr.length; index++) {
        
        if(comparator(charArr[index], charStack.pop())){
            
            return true;
        }
    }
    
    return false;
}


boolean comparator(char a, char b){
    
    if(a == '{' && b == '}' || a == '(' && b == ')' || a == '[' && b == ']'){
        
        return true;
    }  
    
    return false;
    
}
````
