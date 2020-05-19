### Given a weighted graph, find the shortest path

**Hint:** Dijktra's Algorithm

**Approach**
- Use BFS but with a priority queue that takes in the weights as the priority.
- Starting with the start node, the cost is 0 since we are already there. We don't know how to get anywhere else, so those
costs are Integer.MAX_VALUE(infinity). 
- First in the queue is the startNode. Dequeue it then We'll start looking at it's neighbors  
    : Repeat
     - Pick node with lowest cost in the priority queue
     - Dequeue it, Look at its neighbors and repeat.
- When we reach the destination, we have to backtrack to trace the route that got us there.

Time & Space complexity  
- Inserting N nodes into priority queue will take O(N * log(N)) - priority queues have log(N) insertion time.
- We'll update costInQueue once per edge, O(M) times. Each priority queue update takes log(N) time, hence O(M * log(N))
- All together: O(N log(N)) + O(M * log(N)) = O((M + N) log(N))


