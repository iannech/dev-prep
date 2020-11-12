## Depth First Search
We start at the root and explore each branch completely before moving to the next branch.  
DFS is to imagine a maze with only one entrance and one exit. You are at the entrance and want to explore the maze to reach the exit. 
Obviously you cannot split yourself into more than one.  
- Uses STACK
- Uses Backtracking
- Marks visited nodes to avoid cycles
- Complexity O(V + E) - each vertex is visited exactly once, 

### Pseudo/Code [Recursive]
````
void DfsSearchRecursive(Node root) {
    print(node.data + "");
    
    List<Node> neighbours = node.getNeighbours();
    node.visited = true;
    
    for(int i=0; i< neighbours.size(); i++) {
        
        Node element = neighbours.get(i);
        if(element != null && !element.visited)
            DfsSearchRecursive(element);
    }
}
````

### Pseudo/Code [Iterative]
````
void DfsSearchIter(Node node) {
    
    Stack<Node> stack = new Stack<>();
    stack.add(node);
    
    while(!stack.isEmpty()) {
    
        Node element = stack.pop();
        if(! element.visited()) {
            print(" " + element.data);
            element.visited = true;
        }
        
        List<Node> neighbours = element.getNeighbours();
        for(int i=0; i < neighbours.size(); i++) {
            
            Node n = neighbours.get(i);
            if(n != null && !n.visited)
                stack.add(n); 
        }
    }

}

