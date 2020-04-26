package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesAtLevel {


    static class Node {
        Node left;
        Node right;

        int val;

        public Node(int val) {
            this.val = val;

        }
    }

    void printAllNodesAGivenLevel(Node root, int N) {

        int count = 0;

        if(root == null || N < 1)
            System.out.println(root.val);

        Queue<Node> queue = new LinkedList<>();

        while (root.left != null || root.right != null) {
             queue.add(root.left);
             queue.add(root.right);
             count += 1;
             while (!queue.isEmpty()) {
                 if (count == N) {
                     for(Node node : queue){
                         System.out.println(node.val);
                     }

                     queue.remove();
                 }

                 printAllNodesAGivenLevel(root.left, N);
                 printAllNodesAGivenLevel(root.right, N);
             }

        }
    }


    void printNodesAtGivenLevelRecursive(Node root, int N){

        int count = 0;

        if(root == null)
            return;

    }
}
