# DSA Interview Prep - Quick Reference & Cheat Sheet

## 8-Week Study Overview at a Glance

```
Week 1-2: Fundamentals (Arrays, Strings, Linked Lists)
        ↓
Week 3-4: Data Structures (Trees, Graphs, Heaps)
        ↓
Week 5-6: Algorithms (DP, Sorting, Searching, Backtracking)
        ↓
Week 7:   Mixed Practice + Mock Interviews (1-2)
        ↓
Week 8:   Final Push + Mock Interviews (2-3)
        ↓
    GOOGLE INTERVIEW 🎯
```

## Time Investment Summary

```
Total Time: 60-70 hours over 8 weeks
Daily: 1-2 hours (5-6 days/week)
Weekly: 10-14 hours
Problems: 150-200 total
Target Success Rate: 80%+ by Week 8
```

---

## Essential Data Structures (Know Cold)

### 1. Arrays
```python
# Key operations:
- Access: O(1)
- Insert: O(n)
- Delete: O(n)
- Patterns: Two pointers, sliding window, binary search
```

### 2. Hash Map / Hash Set
```python
# Key operations:
- Insert: O(1) avg
- Delete: O(1) avg
- Lookup: O(1) avg
- Use: Counting, caching, deduplication
```

### 3. Linked List
```python
class ListNode:
    def __init__(self, val=0):
        self.val = val
        self.next = None

# Key: Dummy nodes, slow/fast pointers
```

### 4. Stack
```python
stack = []
stack.append(x)    # Push
stack.pop()        # Pop
# Use: Function calls, parentheses matching, backtracking
```

### 5. Queue
```python
from collections import deque
q = deque()
q.append(x)        # Enqueue
q.popleft()        # Dequeue
# Use: BFS, level-order traversal
```

### 6. Binary Tree
```python
class TreeNode:
    def __init__(self, val=0):
        self.val = val
        self.left = None
        self.right = None

# Traversals: Inorder, Preorder, Postorder, Level-order
```

### 7. Graph (Adjacency List)
```python
# Represent as:
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D'],
    # ...
}
# Or: List of lists for nodes 0 to n-1
```

### 8. Heap / Priority Queue
```python
import heapq
# Min heap (default)
heapq.heappush(heap, x)
heapq.heappop(heap)

# Max heap: negate values or use -x
```

---

## Top 20 Patterns to Master

### Easy Category (Must Know)
1. **Hash Map** - Two Sum, Contains Duplicate
2. **Two Pointers** - Container with Most Water
3. **Sliding Window** - Longest Substring
4. **Recursion** - Climb Stairs
5. **Dummy Node** - Merge Two Lists

### Medium Category (Should Know)
6. **Tree DFS** - Path Sum, Balanced Tree
7. **Tree BFS** - Level Order Traversal
8. **Graph DFS** - Number of Islands
9. **Topological Sort** - Course Schedule
10. **Binary Search** - Search Insert Position
11. **Backtracking** - Permutations, Combinations
12. **DP 1D** - House Robber, Coin Change
13. **DP 2D** - Unique Paths, Edit Distance
14. **Greedy** - Jump Game
15. **Merge K Lists** - Priority Queue

### Hard Category (Nice to Know)
16. **DP Complex** - Word Ladder, Regex
17. **Union-Find** - Connected Components
18. **Segment Tree** - Range Queries
19. **Trie** - Word Search II
20. **System Design Light** - Cache (LRU)

---

## Algorithm Complexity Quick Ref

### Sorting Algorithms
| Algorithm | Best | Average | Worst | Space | Stable |
|-----------|------|---------|-------|-------|--------|
| Merge Sort | n log n | n log n | n log n | n | Yes |
| Quick Sort | n log n | n log n | n² | log n | No |
| Heap Sort | n log n | n log n | n log n | 1 | No |
| Bubble Sort | n | n² | n² | 1 | Yes |

### Graph Algorithms
| Algorithm | Time | Space | Use |
|-----------|------|-------|-----|
| DFS | O(V+E) | O(V) | Components, cycles |
| BFS | O(V+E) | O(V) | Shortest path (unweighted) |
| Dijkstra | O((V+E)log V) | O(V) | Shortest path (weighted) |
| Topological | O(V+E) | O(V) | Dependency order |

### Dynamic Programming Approaches
```
1. Identify state: What are we solving for?
2. Define recurrence: How does state depend on subproblems?
3. Base case: When do we stop recursing?
4. Memoization: Cache results (top-down)
5. Tabulation: Build up from base (bottom-up)
```

---

## Interview Communication Checklist

### Before Coding (Crucial!)
- [ ] Confirm you understand the problem
- [ ] Ask about constraints (input size, value range)
- [ ] Discuss your approach (let interviewer guide)
- [ ] Agree on time/space trade-offs
- [ ] State time complexity estimate

### While Coding
- [ ] Explain what you're doing
- [ ] Write clean, readable code
- [ ] Add comments for complex logic
- [ ] Don't go silent (keeps communication open)

### After Coding
- [ ] Test with provided examples
- [ ] Test edge cases (empty, single, duplicates)
- [ ] Walk through your solution
- [ ] Discuss complexity (verify estimate)
- [ ] Suggest optimizations (even if not coding)

### If Stuck
- [ ] "Let me think about this for a moment"
- [ ] Talk through your thinking aloud
- [ ] Ask clarifying questions
- [ ] Try simpler version first
- [ ] Don't give up immediately

---

## Weak Area Recovery Plan

### If You Struggle with [Category]

**Trees:**
- Watch: Striver's Tree DSA playlist
- Practice: 5 more problems focusing on [sub-topic]
- Review: Tree traversal templates

**Dynamic Programming:**
- Watch: Aditya Verma DP tutorials
- Practice: Start with 1D DP, then 2D
- Review: Recurrence relation, memoization

**Graphs:**
- Watch: Graph visualization on VisuAlgo
- Practice: 5 more problems with explicit visualization
- Review: DFS/BFS vs when to use each

**Binary Search:**
- Watch: Binary search templates tutorial
- Practice: 3-4 more problems with different templates
- Review: When mid moves left/right

**Backtracking:**
- Watch: Backtracking template walkthrough
- Practice: Permutations, Combinations, then harder
- Review: Choose-Explore-Unchoose pattern

---

## Weekly Milestone Checklist

### Week 1 Milestone: Fundamentals Solid?
- [ ] Can solve any array/string problem under 20 min
- [ ] Know two-pointer and sliding window cold
- [ ] Hash map usage is second nature

### Week 2 Milestone: Lists Complete?
- [ ] Can reverse linked list without thinking
- [ ] Fast/slow pointer pattern is intuitive
- [ ] Dummy node trick feels natural

### Week 3 Milestone: Trees Comfortable?
- [ ] All tree traversals (4 types) from memory
- [ ] Level-order traversal is automatic
- [ ] Path problems feel like standard tree work

### Week 4 Milestone: Graphs & Heaps?
- [ ] DFS/BFS feel like array/tree traversal
- [ ] Topological sort makes intuitive sense
- [ ] Heap operations are quick to implement

### Week 5 Milestone: DP Clicking?
- [ ] Can identify recurrence relation quickly
- [ ] Memoization feels natural
- [ ] Base cases are instinctive

### Week 6 Milestone: All Algorithms Done?
- [ ] Binary search template is muscle memory
- [ ] Backtracking pattern is automatic
- [ ] Can identify pattern in new problems

### Week 7 Milestone: Weak Areas Fixed?
- [ ] Identified weak categories from Weeks 1-6
- [ ] Re-solved 5+ problems in weak area
- [ ] Now comfortable with those topics

### Week 8 Milestone: Interview Ready?
- [ ] Completed 2+ mock interviews
- [ ] Average score improved from Week 7
- [ ] Communication is clear and confident

---

## Day Before Interview Prep

### Night Before
```
❌ Don't study new problems
✅ Do light review of key patterns
❌ Don't stay up late
✅ Get 8+ hours sleep
❌ Don't stress
✅ Do breathing exercises
```

### Morning Of
```
✅ Eat a good breakfast
✅ Light exercise or walk (clears mind)
✅ Review 1-2 favorite patterns (confidence)
✅ Test all technical setup early
✅ Arrive 15 min early to interview
❌ Don't cram
❌ Don't check new problems
```

### During Interview
```
✅ Take a breath, stay calm
✅ Think aloud constantly
✅ Ask clarifying questions
✅ Discuss approach before coding
✅ Test your solution
✅ Accept feedback gracefully
❌ Don't panic if stuck
❌ Don't go silent
❌ Don't claim solutions you don't understand
```

---

## Success Metrics by Week

### Week 1-2 Goals
- ✅ Solve 30-40 problems (50-60% first attempt)
- ✅ Know 5 fundamental patterns
- ✅ Feel familiar with problem-solving flow

### Week 3-4 Goals
- ✅ Solve 30-40 problems (60-70% first attempt)
- ✅ Know 10 patterns (including tree/graph)
- ✅ Recognize patterns in new problems

### Week 5-6 Goals
- ✅ Solve 30-40 problems (70-80% first attempt)
- ✅ Know 15 patterns across all categories
- ✅ Apply patterns to novel problems

### Week 7 Goals
- ✅ Solve 30-35 mixed problems (75-85% first attempt)
- ✅ Complete 1-2 mock interviews
- ✅ Identify any remaining weak areas

### Week 8 Goals
- ✅ Complete 2-3 full mock interviews
- ✅ Average mock score: 75%+
- ✅ Feel confident heading into real interview

---

## Final Sanity Checks

Before your Google interview, verify:

- [ ] Can implement any data structure from scratch
- [ ] Know Big O for all common operations
- [ ] Can recognize problem patterns quickly
- [ ] Comfortable thinking aloud in code
- [ ] Never copied solutions (understanding > memorization)
- [ ] Practiced on actual interview platform
- [ ] Mock interview communication is smooth
- [ ] Can optimize solution in real-time
- [ ] Handle edge cases automatically
- [ ] Ask clarifying questions instinctively

---

## You've Got This! 💪

This 8-week plan is designed for someone exactly like you:
- Experienced engineer ✅
- Full-time work commitment ✅
- Rusty on DSA ✅
- High-pressure timeline ✅

**The secret:** 
> Consistency + Pattern Recognition + Communication = Interview Success

Start Week 1 tomorrow. By Week 8, you'll be ready.

**Google Kenya is calling. Let's make this happen.** 🎯
