### Min Heap
A binary tree with the following properties:
- Its a complete Binary tree [all levels are completely filled except possibly the last level and the last level has keys
 as left as possible].
 - The parent key is smaller than the the children and right child > left child.
 - Typically represented as an Array
 - The Root Element = A[0]
 - A[(i - 1)/2] - returns parent node
 - A[(2*i) + 1] - returns left child node
 - A[(2*i) + 2] - returns right child node