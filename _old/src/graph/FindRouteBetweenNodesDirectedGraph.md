##  Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

````
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
````