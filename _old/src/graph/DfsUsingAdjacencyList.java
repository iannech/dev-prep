package graph;

import java.util.Arrays;
import java.util.List;

public class DfsUsingAdjacencyList {

    // Recursive
    public static void DFS(Graph graph, int v,  boolean[] visited) {

        // mark node as visited
        visited[v] = true;

        // print out the node
        System.out.print(v + " ");

        // do for every neighbor of v
        List<Integer> neighbors = graph.adjList.get(v);

        for(int e : neighbors) {

            if(visited[e] = false){
                DFS(graph, e, visited);
            }
        }
    }

    public static void main(String [] args) {

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

        for (int i=0; i<N; i++) {
            if(!visited[i]){
                DFS(graph, i, visited);
            }
        }
    }

}
