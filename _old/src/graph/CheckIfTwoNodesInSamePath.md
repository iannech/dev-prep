
###Check if two nodes are in the same path


### Using Extra Space
-> Starting from root
    -> check if root has children
        -> while true, push root to stack
        -> recurse root.next as new root until root.next == null
    -> pop items from stack one by one and check if the items
````
Node {

    int value;
    Node next;

    Node() {

    }
}

static boolean checkIfNodesOnSamePath(Node root, int x, int y) {

    Node mainRoot = root;

    Set<Integer> set = new HashSet<>();
    Set<Node> visited = new HashSet<>();

    if(root == null || root.next == null){

        return false;
    }

    while(root.next() != null) {

        if(visited.contains(root)
            continue;

        if(root.value == x || root.value == y)
            set.add(root.value);


        if(root.next == null)
            root = mainRoot;

        visited.add(root);

        checkIfNodesOnSamePath(root.next, x, y)
    }
}


static boolean checkIfStackContains(Stack<Integer>stack, int i, int j) {

    sta
}