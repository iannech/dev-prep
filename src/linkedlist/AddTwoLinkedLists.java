package linkedlist;

public class AddTwoLinkedLists {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

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

    static Node reverse(Node X) {

        Node prev = null;
        Node current = X;

        while(current != null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {

    }
}
