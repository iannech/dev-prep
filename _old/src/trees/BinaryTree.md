## Structure

- data
- address of left child
- address of right child

## Types of binary trees

1. Full Binary tree
   Every parent node/internal node has either 2 children or no children

2. Perfect Binary tree
   Every internal node has exactly two child nodes and all child nodes are at the same level

3. Complete Binary tree
   Like a full binary tree but

- every level must be completely filled
- all leaf elements must lean towards the left
- last leaf element might not have a right sibling

4. Degenerate or Pathological tree
   Have a single child, either left or right

5. Skewed Binary tree
   A degenerate tree either dominated by left nodes or right nodes

6. Balanced Binary tree
   Tree in which the difference between the height of left and right subtree for each node is either 0 or 1

## Binary tree applications

- For easy and quick access to data
- In router algorithms
- To implement heap data structure
- Syntax tree

## Implementation

```
class Node {
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree(int key){
        root = new Node(key);
    }

    BinaryTree(){
        root = null;
    }

    // main class
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
    }
}
```
