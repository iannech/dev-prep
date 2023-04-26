### Topological Sorting

#### Idea

TS for a Directed Acyclic Graph(DAG) is a linear ordering of vertices such that for every directed edge(u,v), vertex u comes before v in the ordering.

Example (./images/DAG.png)

#### Applications

- Build systems - eg in IDEs. If the project has libraries dependent on each other, the IDEA does a topological sort to find the order of build
- Advanced-Package Tool (apt-get) - TPS of packages to be installed or removed for a particular program
- Task Scheduling - TPS in scheduling interdepend tasks
- Pre-requisite problems - eg University course ordering where some courses must be done before others can be done.

Note: Topological Sorting is different from DFS

In Topological Sorting:

- We use a temporary stack.
- We don't print the vertex immediately.
- We first recursively call topological sorting for all its adjacent vertices, then push it to a stack.
- Finally print the contents of the stack.

Note: A vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack.

### Approach

Create a stack to store the nodes.
Initialize _visited_ array of size N to keep the record of visited nodes.
Run a loop from 0 till N:
if the node is not marked _True_ in _visited_ array:
Call the recursive function for topological sort and perform the following steps:
Mark the current node as _True_ in the _visited_ array.
Run a loop on all the nodes which has a directed edge to the current node
if the node is not marked True in the _visited_ array:
Recursively call the topological sort function on the node
Push the current node in the stack.
Print all the elements in the stack.

### Code

```
class Graph {
    // no of vertices
    private int V;

    // Adjacency list as ArrayList of ArrayLists
    private List<ArrayList<Integer>> adj;

    // constructor
    Graph(int v){
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);

        for(int i=0; i<v; ++i){
            adj.add(new ArrayList<Integer>());
        }
    }

    // function to add an edge to the graph
    void addEdge(int v, int w){
        adj.get(v).add(w);
    }

    // function to do Topological sort
    // it uses a recursive topologicalSortUtil()
    void topologicalSort(){
        Stack<Integer> stack = new Stack();

        // mark all vertices as not visited
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++){
            visited[i] = false;
        }

        // call recursive helper func to store topological sort starting from all vertices, one by one
        for(int i=0; i<V; i++){
            if(visited[i] == false){
                topologicalSortUtil(i, visited, stack);
            }
        }

        // print contents of stack
        while(stack.empty == false){
            System.out.print(stack.pop() + " ");
        }
    }

    // a recursive util function for TPS
    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack){
        // mark current node as visited
        visited[i] = true;

        Integer i;

        // recur for all the vertices adjacent to this vertex
        Iterator<Integer> iter = adj.get(v).iterator();
        while(iter.hasNext()){
            i = iter.next();
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }

        // push current vertex to stack which stores results
        stack.push(new Integer(v));
    }
}
```

### Complexity

Time = O(V+E)
Space = O(V) - extra stack needed
