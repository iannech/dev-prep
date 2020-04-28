package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class BfsUsingAdjacencyList {

    // Performs BFS on graph starting from vertex V
    public static void breadthFirstSearch(Graph graph, int v, boolean[] visited) {

        // Queue to be used in BFS: ArrayDeque provides a resizable array in which elements can be added/removed from
        // both ends
        Queue<Integer> queue = new ArrayDeque<>();

        // mark starting vertex as visited
        visited[v] = true;

        // push vertex to queue
        queue.add(v);

        // run until queue is empty
        while (!queue.isEmpty()) {

            // pop front node from queue and print it
            int elem = queue.poll();
            System.out.print(elem + " ");

            // do for every edge
            List<Integer> neighbors = graph.adjList.get(elem);

            for(int e : neighbors){

                if(!visited[e]){
                    // mark it as visited and push to queue
                    visited[e] = true;

                    queue.add(e);
                }
            }
        }
    }


    public static void main(String[]args) {

        // List of edges
        List<Edge> edges = Arrays.asList(
                new Edge(1,2), new Edge(1,3), new Edge(1,4),
                new Edge(2,5), new Edge(2,5), new Edge(5,9),
                new Edge(5,10), new Edge(4,7), new Edge(4,8),
                new Edge(7,11), new Edge(7,12)
        );

        // set no. of vertices in the graph
        int N = 15;

        // create graph from the edges
        Graph graph = new Graph(edges, N);

        // keeps track of visited Nodes
        boolean[] visited = new boolean[N];

        // Do BFS traversal from all undiscovered nodes to cover all unconnected components of the graph
        for(int i=0; i<N; i++) {

            if(visited[i] == false)
                // start BFS from vertex i
                breadthFirstSearch(graph, i, visited);
        }
    }
}
