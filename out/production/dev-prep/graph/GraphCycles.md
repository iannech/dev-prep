### Check if undirected graph contains a cycle or not

Approach
- Use BFS traversal
- While traversing, if a node was already visited, return true. Else: traverse the whole graph.

````
static boolean checkGraphCycle(Graph graph, int v, boolean[]visited) {
    
    // Queue to use in Traversal
    Queue<Integer> queue = new ArrayDeque<>();
    
   // mark vertex as visited
   visited[v] = true;
   
   // enqueue vertex
   queue.add(v);
   
   while(!queue.isEmpty()) {
        
        // poll first item
        v = queue.poll();
        
        // retrieve neighbors
        List<Integer> neighbors = graph.adjList.get(v);
        
        for(int e : neighbors){
            
            if(!visited[e]){
                // mark as visited
                visited[e] = true;
                // add to queue
                queue.add(e);
            } else {
                
                // it was already visited and we're revisiting: cycle
                return true;
            }
        }
   }
   
   return false;
 }
````