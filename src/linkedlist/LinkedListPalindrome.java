package linkedlist;

import java.util.Stack;

public class LinkedListPalindrome {

    static boolean isListPalindrome(MergeSortLinkedList.Node head) {

        if(head == null)
            return true;

        MergeSortLinkedList.Node current = head;

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

    public static void main(String [] args) {

        MergeSortLinkedList.Node head = new MergeSortLinkedList.Node(1);
        head.next = new MergeSortLinkedList.Node(2);
        head.next.next = new MergeSortLinkedList.Node(3);
        head.next.next.next = new MergeSortLinkedList.Node(2);
        head.next.next.next.next = new MergeSortLinkedList.Node(1);
        head.next.next.next.next.next = null;
        System.out.print(isListPalindrome(head));
    }
}
