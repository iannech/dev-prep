package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    static class Node {

        int data;
        boolean visited;
        List<Node> neighbours;

        public Node (int data){
            this.data = data;
            this.neighbours=new ArrayList<>();
        }

        public void addneighbours(Node neighbourNode)
        {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    // Iterative
    void dfsSearchIter(Node node) {

        // Uses Stack
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while(!stack.empty()) {

            Node element = stack.pop();
            if(!element.visited) {
                System.out.print(element.data + " ");
                element.visited = true;
            }

            List<Node> neighbors = element.getNeighbours();

            for(int i=0; i< neighbors.size(); i++) {

                Node n = neighbors.get(i);
                if(n != null && !n.visited) {
                    stack.add(n);
                }
            }
        }
    }

    void dfsSearchRecursive(Node node) {

        System.out.print(node.data + " ");
        node.visited = true;

        List<Node> neigbours = node.getNeighbours();
        for (int i =0; i<neigbours.size(); i++) {

            Node element = neigbours.get(i);

            if(element != null && !element.visited) {
                dfsSearchRecursive(element);
            }
        }
    }

    boolean checkIfPathExistsDfs(Node node1, Node node2) {

        // getNeighbours of Node1,check if Node2 is one of them
        // if Yes, return true Else choose one of the neighbors and recheck

        node1.visited=true;

        List<Node> neighbours = node1.getNeighbours();
        for(int i=0; i<neighbours.size(); i++) {

            Node node = neighbours.get(i);
            if(node != null && node2.data == node.data && !node.visited){
                return true;
            } else {
                checkIfPathExistsDfs(node, node2);
            }
        }

        return false;
    }

    public static void main(String []args) {

        Node node40 = new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node50);
        node20.addneighbours(node60);
        node20.addneighbours(node30);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

        System.out.println("The DFS traversal of the graph using stack ");
        depthFirstSearch.dfsSearchIter(node40);

        System.out.println();

        // Resetting the visited flag for nodes
        node40.visited=false;
        node10.visited=false;
        node20.visited=false;
        node30.visited=false;
        node60.visited=false;
        node50.visited=false;
        node70.visited=false;

        System.out.println("The DFS traversal of the graph using recursion ");
        depthFirstSearch.dfsSearchRecursive(node40);

        System.out.println("Check if path exists");
        System.out.println(depthFirstSearch.checkIfPathExistsDfs(node50, node70));
    }
}
