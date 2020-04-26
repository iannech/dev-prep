###Given two Linkedlists in sorted increasing order. Merge them in decreasing order. You have to merge in place, you can’t create new linkedlist.

Example  
Input:  
3->4  
1->2->3  


Output:  4->3->3->2->1

Approach  
Merge the two lists, in place, then reverse the list before returning it.  
RECURSION

````
static class Node {
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
    }
}


Node mergeListsInDecreasingOrder(Node head1, Node head2) {
    
    if(head1 == null && head2 == null) return null;
    
    if(head1 == null) 
        return reverse(head2);
    
    if(head2 == null) 
        return reverse(head1);
        
    if(head1.data <= head2.data){
        head1.next = mergeListsInDecreasingOrder(head1.next, head2);
    } else {
        
        Node temp = head2;
        head2 = head2.next;
        temp.next = head1;
        head1 = temp;
        head1.next = mergeListsInDecreasingOrder(head1.next, head2);
    }
    
    head1 = reverse(head1);
    
    return head1;
}


Node reverse(Node head) {
    
    Node current = head;
    Node prev = null;
    
    while(current != null) {
        Node next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    
    return prev;
}
````
    
