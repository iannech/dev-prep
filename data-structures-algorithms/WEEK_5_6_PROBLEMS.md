# Week 5-6: Algorithms & Advanced Patterns - Recommended Problems

## Dynamic Programming (Week 5)

### Medium
- Climbing Stairs (LeetCode 70)
- House Robber (LeetCode 198)
- Coin Change (LeetCode 322)
- Longest Increasing Subsequence (LeetCode 300)
- Longest Common Subsequence (LeetCode 1143)
- Edit Distance (LeetCode 72)
- Partition Equal Subset Sum (LeetCode 416)
- Decode Ways (LeetCode 91)
- Best Time to Buy and Sell Stock III (LeetCode 123)

### Hard
- Regular Expression Matching (LeetCode 10)
- Word Break II (LeetCode 140)
- Maximum Product Subarray (LeetCode 152)

**DP Pattern Templates to Master:**
```
1. 1D DP: dp[i] = f(dp[i-1], dp[i-2], ...)
2. 2D DP: dp[i][j] = f(dp[i-1][j], dp[i][j-1], ...)
3. Memoization (top-down recursion)
4. Tabulation (bottom-up iteration)
5. Space optimization (rolling array technique)
```

---

## Sorting, Searching & Binary Search (Week 6 - Part 1)

### Easy
- Binary Search (LeetCode 704)
- First Bad Version (LeetCode 278)

### Medium
- Search Insert Position (LeetCode 35)
- Find First and Last Position (LeetCode 34)
- Kth Smallest Element in BST (LeetCode 230)
- Search in Rotated Sorted Array (LeetCode 33)
- Peak Index in Mountain Array (LeetCode 852)

**Binary Search Pattern:**
```
Template 1: When searching for exact value
Template 2: When finding leftmost occurrence
Template 3: When finding rightmost occurrence
Template 4: When answer is in answer space, not value space
```

---

## Backtracking & Recursion (Week 6 - Part 2)

### Medium
- Permutations (LeetCode 46)
- Combinations (LeetCode 77)
- Subsets (LeetCode 78)
- Word Search (LeetCode 79)
- Combination Sum (LeetCode 39)
- Palindrome Partitioning (LeetCode 131)
- Letter Combinations of Phone Number (LeetCode 17)
- Generate Parentheses (LeetCode 22)
- N-Queens (LeetCode 51)

### Hard
- Sudoku Solver (LeetCode 37)

**Backtracking Template:**
```python
def backtrack(candidates, path, result):
    if is_valid_solution(path):
        result.append(path[:])
        return
    
    for candidate in candidates:
        # Choose
        path.append(candidate)
        # Explore
        backtrack(remaining_candidates, path, result)
        # Unchoose
        path.pop()
```

---

## Greedy Algorithms (Week 6 - Optional)

### Medium
- Jump Game (LeetCode 55)
- Jump Game II (LeetCode 45)
- Interval Scheduling (not on LeetCode, but classic)
- Video Stitching (LeetCode 1024)

**Greedy Pattern:**
1. Prove greedy choice is optimal
2. Verify subproblem has optimal structure
3. Build solution incrementally

---

## Time Complexity Cheat Sheet

| Algorithm | Time | Space | Notes |
|-----------|------|-------|-------|
| Binary Search | O(log n) | O(1) | Works on sorted data |
| Merge Sort | O(n log n) | O(n) | Stable sort |
| Quick Sort | O(n log n) avg, O(n²) worst | O(log n) | In-place |
| Heap Sort | O(n log n) | O(1) | In-place |
| DP (1D) | O(n × m) | O(n) or O(n×m) | Depends on state |
| Backtracking | O(k^n) in worst | O(n) recursion depth | Highly problem-dependent |
| Graph DFS/BFS | O(V + E) | O(V) | V=vertices, E=edges |

---

## Week 5-6 Daily Schedule Example

```
Monday (90 min):     Climbing Stairs, House Robber, Binary Search review
Tuesday (60 min):    Coin Change, Longest Increasing Subsequence
Wednesday (60 min):  Edit Distance, Search Insert Position, Find First/Last
Thursday (90 min):   Permutations, Combinations, Subsets
Friday (60 min):     Letter Combinations, Generate Parentheses
Saturday (90 min):   Word Search, Combination Sum + DP review problem
Sunday (Optional):   Review weak area from the week
```
