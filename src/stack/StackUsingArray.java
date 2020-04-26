package stack;

public class StackUsingArray {

    static int size = 100;

    static int[] stack = new int[size];

    int top = stack.length;

    public void push(int element){

        if(!isFull()){
            top--;
            stack[top] = element;
        } else {
            System.out.println("Stack Overflow");
        }
    }



    public int peek() {

        if(top == stack.length){
            System.out.println("Stack Underflow");
            return -1;
        } else {
            System.out.println(stack[top]);
            return stack[top];
        }

    }


    public int pop() {

        int x;
        if(top == stack.length){
            return -1;
        } else {
            x = stack[top];
            top++;
            return x;
        }

    }


    private boolean isFull() {
        if(top == 0 ){
            return true;
        }else {
            return false;
        }

    }


    public static void main (String [] args) {

        StackUsingArray stack = new StackUsingArray();
        stack.push(10);
        stack.push(20);

        stack.peek();
        stack.pop();
        stack.peek();
        stack.push(30);

        stack.peek();


    }
}
