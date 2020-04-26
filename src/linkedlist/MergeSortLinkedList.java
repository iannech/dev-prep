package linkedlist;

public class MergeSortLinkedList {

    Node head = null;

    static class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    // Entry Method
    Node mergeSort(Node h) {

        // base case
        if(h == null || h.next == null) {
            return h;
        }

        // get middle point of list
        Node middle = getMidPoint(h);
        Node nextOfMiddle = middle.next;

        // set next of middle node to null
        middle.next = null;

        // apply merge sort on left list
        Node left = mergeSort(h);

        // apply merge sort on right list
        Node right = mergeSort(nextOfMiddle);

        // merge left and right lists
        Node sortedList = sortedMerge(left,right);

        return sortedList;

    }

    // Merge lists Util
    static Node sortedMerge(Node left, Node right) {

        Node result = null;

        // base cases
        if(left == null)
            return right;

        if(right == null)
            return left;

        // Pick left or right and recur
        if(left.val <= right.val){
            result = left;
            result.next = sortedMerge(left.next, right);
        }
        else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }

        return result;
    }

    // Get Middle Util
    static Node getMidPoint(Node head) {

        if (head == null)
            return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
