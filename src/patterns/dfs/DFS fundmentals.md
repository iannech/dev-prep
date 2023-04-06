## When to use DFS

### Tree

DFS is essentially pre-order tree traversal.

- Traverse and find/create/modify/delete node
- Traverse with return value (finding max subtree, detect balanced tree)

### Combinatorial problems

DFS/backtracking and combinatorial problems are a match made in heaven (or silver bullet and werewolf 😅). As we will see in the Combinatorial Search module, combinatorial search problems boil down to searching in trees.

- How many ways are there to arrange something
- Find all possible combinations of ...
- Find all solutions to a puzzle

### Graph

Trees are special graphs that have no cycle. We can still use DFS in graphs with cycles. We just have to record the nodes we have visited and avoiding re-visiting them and going into an infinite loop.

- Find a path from point A to B
- Find connected components
- Detect cycles
