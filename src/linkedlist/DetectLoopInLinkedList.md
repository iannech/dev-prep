## Given a linked list, check if the linked list has loop or not.

Questions
- What is a loop in a LL
- Examples?


Assumption
- Using an Abstract implementation of LL with a Node class

Approach
- Have 2 pointers; slowPointer moves 1 node at a time, fastPointer moves two nodes at a time. Both start at head node.
- If both pointers meet at any given time, return true else return false


````
class Node {
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
    }
}

static boolean checkIfLinkedListHasALoop(Node head) {

    if(head == null)
        return false;
    
    Node current = head;
    
    // two pointers
    Node slowPointer = head;
    Node fastPointer = head;
    
    // traverse the list
    while(fastPointer != null && slowPointer != null && fastPointer.next != null){
        
        fastPointer = fastPointer.next.next;
        slowPointer = slowPointer.next;
        
        if(fastPointer == slowPointer){
            return true;
        }
        
       
    }
    
    return false;
}
````