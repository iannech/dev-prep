package stack;

public class StackUsingLinkedList {

    private Node head = null;


    public void push(int element) {
        Node newNode = new Node(element);
        if(head == null){
            head = newNode;
        } else {

            Node temp = head;
            head = newNode;
            head.next = temp;
        }
    }

    public Node pop() {
        Node temp = head;
        head = head.next;
        System.out.println(temp.val);
        return temp;
    }

    public Node peek() {
        System.out.println(head.val);
        return head;
    }

    static class Node {

        int val;

        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String []args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.peek();
        stack.pop();
        stack.push(30);
        stack.peek();
        stack.pop();
        stack.peek();

    }
    }


