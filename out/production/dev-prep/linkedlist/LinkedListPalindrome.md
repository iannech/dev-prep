### Determine if a linked list is a Palindrome or not

Example  
Input:  1->2->3->2->1->null   
Output : TRUE

Input: 1->2->3->3->1->null  
Output: FALSE

Approach 1
- Use STACK push elements of the list into Stack one by one
- Run another loop through the list while popping elements off the stack. If they are the same, it is a palindrome

````
static boolean isListPalindrome(Node head) {
    
    if(head == null)
        return true;
        
    Node current = head;
    
    Stack<Integer> stack = new Stack<>();
    
    while(current != null) {
        
        stack.push(current.val);
        current = current.next;
    }
    
   
    current = head;
         
    while(current != null) {
        
        int temp = stack.pop();
        
        if(temp != current.val) {
            return false;
        } else {
            current = current.next;
        }
    }
    
    return true;
}
````

Approach 2
- Find midpoint of the list
- Reverse from midpoint to end.
- Compare if head to mid equals reversed mid-tail

