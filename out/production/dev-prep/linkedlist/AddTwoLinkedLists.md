### Add two linked list numbers
Example

Input

x : 5->7->3->4->null  
y : 9->4->6->null

Output: 6->6->8->0->null


Approach
- We need to add these numbers starting with the least significant numbers  
    5734 + 946
   
- So the approach would be to reverse the two lists then start adding:   
   4375 + 649 = 0866
- Reverse output to 6->6->8->0->null

````
 static Node addTwoLists(Node list1, Node list2) {

        if(list1 == null) return list2;

        if(list2 == null) return list1;

        Node output = null;
        Node prev = null;
        Node temp = null;

        // reverse both lists to allow addition to start with least significant values
        list1 = reverse(list1);
        list2 = reverse(list2);

        int carry = 0;
        int sum;

        while(list1 != null || list2 != null) {

            // retrieve val of current node. Set to 0 if null
            int x = (list1 != null) ? list1.val : 0;
            int y = (list2 != null) ? list2.val : 0;

            // perform addition
            sum = x + y + carry;

            // update carry
            carry = (sum >= 10) ? 1 : 0;

            temp = new Node(sum % 10);

            // if output is null make it head
            if(output == null){
                output = temp;
            } else {
                // add it as the next node
                prev.next = temp;
            }

            // advance prev for next iteration
            prev = temp;

            // advance to the next nodes of list1 and list2
            if(list1 != null) list1 = list1.next;
            if(list2 != null) list2 = list2.next;

            // create a new node if at the end, carry still has a val
            if(carry > 0){
                temp.next = new Node(carry);
            }
        }
        
        return output;
}
````