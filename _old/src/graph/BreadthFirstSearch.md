## Breadth-first Search/Level order traversal
We visit all neighbors of a node a before moving to the next node.
- BFS is NOT Recursive
- It uses a Queue
- Uses an array of size V to distinguish between visited and unvisited states
- Time complexity O(V+E) - if we use Adjacency List

In BFS, we push the root node to the queue and then continually iterating until the queue is empty.
For each iteration, we remove the node at the head of the queue and "visit" that node. 
After removing the node, we also insert its children into the queue.

````
void bfsSearch(Node node) {
    
    Queue queue = new Queue();
    
    node.visited = true;
    
    queue.enqueue(node);
    
    while(!queue.isEmpty()) {
        
        Node elem = queue.poll();
        print(" "+ elem.data);
        
        List<Node> neighbors = elem.getNeighbors();
        
        for(Node node : neighbors){
            if(! node.visited) {
                
                node.visited = true;
                queue.enqueue(node);
            }
            
        }
    
    }
}
````

## BFS JAVA

````
class Graph {
    // number of vertices in our graph
    private int V;

    // define our adjacent list
    private LinkedList<Integer> adj[];

    // constructor to initialize our graph
    public Graph(int v){
        v = V;
        adj = new LinkedList[v];
        for (int i = 0; i<v; i++>)
            adj[i] = new LinkedList();
    }

    //assume we have methods to add edges, so we wont implement them

    // bfs util
    void graphBFS(int s){
        // validations ?

        // BFS uses a queue
        LinkedList<Integer> queue = new LinkedList();
        
        // boolean array to track visited nodes
        boolean visited [] = new boolean[V];

        // mark source as visited then add to queue
        visited[s] = true;
        queue.add(s);

        // visit children nodes
        while(queue.size() != 0){
            
            // deque a node from queue and print
            s = queue.poll();
            System.out.println(s + " ");

            // get all adjacent vertices of s and if any hasn't been visited, mark it as visited and enqueue it
            Iterator<Integer> iterator = adj[s].listIterator();
            while(iterator.hasNext()){
                // get element
                int n = iterator.next();
                if(!visited[n]){
                   visited[n] = true;    
                   queue.add(n); 
                }
            }
        }
    }
}
````

## BFS Questions
1. BFS Implementation
2. Check if undirected graph contains a cycle or not
3. Find the shortest path from source to destination
4. Count the number of islands 
5. Least cost path in a weighted Digraph
6. Shortest path in a maze