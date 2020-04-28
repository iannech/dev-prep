package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent Graph object
 * */
public class Graph {

    // A list of lists to represent Adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int N) {

        adjList = new ArrayList<>(N);

        for(int i=0; i<N; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // Add edges to the undirected graph
        for(int i=0; i<edges.size(); i++) {

            int src = edges.get(i).source;
            int dest = edges.get(i).dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
