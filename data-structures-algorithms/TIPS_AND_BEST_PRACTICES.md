# Implementation Tips & Best Practices

## Getting Started (Day 1)

### Setup (30 minutes)
1. **Create LeetCode account** (free or premium)
   - Preferred: Premium for curated lists and filtering
   - Price: ~$10-15/month

2. **Get a notebook or digital doc**
   - Track patterns learned
   - Write pseudo-code before implementation
   - Reflect on mistakes

3. **Bookmark key resources**
   - LeetCode Discuss (for solutions)
   - GeeksforGeeks (for concepts)
   - VisuAlgo.net (for visualization)

4. **Set up study environment**
   - Quiet space, 1-2 hours uninterrupted
   - Good chair, monitor (for speed running)
   - Phone on silent/away

### First Week Focus
- Solve 1 easy problem per day
- Understand patterns, not just solutions
- Don't worry about speed yet

---

## How to Solve a Problem (Systematic Approach)

### Step 1: Understand (5 min)
```
Read problem carefully. Ask:
- What is input? What is output?
- What are constraints? (array size, value range)
- What edge cases exist? (empty, single element, duplicates)
- Examples: Can I trace through them?
```

### Step 2: Approach (10 min)
```
Before coding:
- Brainstorm 2-3 approaches
- Discuss trade-offs (time vs space)
- Choose best for constraints
- Write pseudo-code or draw diagram
```

### Step 3: Code (15-20 min)
```
- Write clean, readable code
- Add comments for complex logic
- Test with provided examples
- Check syntax
```

### Step 4: Test (5 min)
```
- Run through given examples
- Test edge cases (empty, single, duplicates)
- Check off-by-one errors
- Trace through with print statements
```

### Step 5: Optimize (5 min)
```
- Can we reduce time complexity?
- Can we reduce space complexity?
- Trade-offs: Is it worth it?
```

### Step 6: Review (5 min)
```
- Read solution on LeetCode Discuss
- Understand any better approaches
- Note patterns for future
```

**Total Time: ~45-50 minutes per problem initially**

---

## When You Get Stuck (Not First Attempt Success)

### Level 1: Rethink (5-10 min)
- Walk away for 2-3 minutes
- Re-read problem statement
- Trace through example manually
- Try a different approach

### Level 2: Hint (5-10 min)
- Look at LeetCode Discuss (high-level only)
- Search: "[Problem Name] approach"
- Read others' approach (not full solution)
- Go back and code yourself

### Level 3: Study Solution (10-15 min)
- Read editorial solution
- Understand the approach
- Close it and code from scratch
- Important: Don't copy-paste

### Level 4: Come Back Later
- Mark as "need review"
- Do different problem
- Return to this after 1 week
- Solve again from memory

**Never:** Copy-paste solutions (kills learning)

---

## Common Problem-Solving Patterns

### Arrays & Strings
1. **Two Pointers:** Start from opposite ends, meet in middle
   - Use when: Sorted array, palindrome, container, reverse
   - Example: Container with Most Water

2. **Sliding Window:** Fixed/dynamic window over array
   - Use when: Substring, subarray, consecutive elements
   - Example: Longest Substring Without Repeating

3. **Prefix Sum:** Pre-compute cumulative sums
   - Use when: Range sum queries, subarray sum
   - Example: Subarray Sum Equals K

### Trees
1. **DFS:** Depth-first, recursive or stack-based
   - Use when: Path problems, leaf problems, all solutions needed
   - Example: Path Sum, All Root-to-Leaf Paths

2. **BFS:** Level-order, queue-based
   - Use when: Level-by-level, shortest path in unweighted tree
   - Example: Binary Tree Level Order Traversal

### Graphs
1. **DFS:** Explore deep before backtracking
   - Use when: Connected components, cycles, topological sort
   - Example: Number of Islands

2. **BFS:** Explore by levels
   - Use when: Shortest path (unweighted), level exploration
   - Example: Shortest Path in Binary Matrix

3. **Topological Sort:** Order for directed acyclic graph
   - Use when: Course prerequisites, dependency resolution
   - Example: Course Schedule

### DP
1. **Linear DP:** dp[i] depends on previous elements
   - Example: Climbing Stairs, House Robber

2. **2D DP:** dp[i][j] depends on neighbors
   - Example: Unique Paths, Edit Distance

3. **Knapsack:** DP with limited capacity
   - Example: 0/1 Knapsack, Coin Change

### Searching
1. **Binary Search:** Eliminate half each iteration
   - Condition: Array must be sorted
   - Example: First Bad Version, Search in Rotated Array

### Backtracking
1. **Permutations:** Order matters, use all elements
   - Example: Permutations, N-Queens

2. **Combinations:** Order doesn't matter, select subset
   - Example: Combinations, Subsets

3. **Partition:** Break into non-overlapping subsets
   - Example: Palindrome Partitioning

---

## Speed Development Timeline

### Weeks 1-2 (Learning Phase)
- Time: 45-60 min per problem
- Focus: Understanding, not speed
- Success rate: 40-60%

### Weeks 3-4 (Pattern Phase)
- Time: 30-40 min per problem
- Focus: Recognizing patterns
- Success rate: 60-75%

### Weeks 5-6 (Mastery Phase)
- Time: 20-30 min per problem
- Focus: Quick implementation
- Success rate: 75-85%

### Weeks 7-8 (Interview Phase)
- Time: 15-20 min per problem (easy), 25-35 min (medium/hard)
- Focus: Communication + solution
- Success rate: 80%+

**Note:** Speed develops naturally from understanding patterns. Don't force it.

---

## Handling Different Problem Types in Interview

### Type 1: Classic (75% of problems)
- Standard DSA problem
- Clear problem statement
- Deterministic solution

**Approach:**
1. Ask clarifying questions
2. Discuss approach before coding
3. Code, test, optimize
4. Discuss complexity

### Type 2: Twist (15% of problems)
- Standard problem with a variation
- Requires adapting known pattern

**Approach:**
1. Recognize base pattern
2. Identify what's different
3. Adapt your approach
4. Test edge cases

### Type 3: Novel (10% of problems)
- Completely new, you haven't seen
- Tests problem-solving ability

**Approach:**
1. Stay calm (everyone struggles here)
2. Break into sub-problems
3. Solve pieces, then combine
4. Start with brute force, optimize
5. **Communication is key here**

---

## Interviewer Red Flags to Avoid

❌ **Don't:**
- Jump into coding immediately without discussing approach
- Ignore edge cases
- Claim complexity without verification
- Go silent for long periods
- Say "I don't know" without trying
- Ask for full solution instead of hints

✅ **Do:**
- Clarify problem statement
- Discuss approach options
- Verbalize your thinking
- Ask for hints if truly stuck
- Acknowledge complexity
- Show eagerness to learn

---

## Optimal Study Schedule (Sample Week)

### Ultra-Busy Week (5-6 hours total)
```
Monday:    1 easy (30 min) - lunch break
Tuesday:   1 easy + 1 medium (60 min) - evening
Wednesday: 1 medium (45 min) - lunch
Thursday:  1 easy + 1 medium (60 min) - evening
Friday:    1 medium (45 min) - lunch
Saturday:  2 medium or 1 review (90 min) - morning
Sunday:    REST
Total:     ~6 hours, 6-7 problems
```

### Moderate-Busy Week (8-10 hours total)
```
Monday:    1 easy + 1 medium (75 min) - evening
Tuesday:   1 medium (45 min) - lunch
Wednesday: 1 medium (45 min) - lunch
Thursday:  1 easy + 1 medium (75 min) - evening
Friday:    1 medium (45 min) - lunch
Saturday:  2 medium (90 min) - morning
Sunday:    1 review (30 min) - or REST
Total:     ~8 hours, 9 problems
```

### Ideal Week (12-14 hours total)
```
Monday:    2 medium (90 min) - evening
Tuesday:   1 easy + 1 medium (75 min) - lunch + evening
Wednesday: 2 medium (90 min) - evening
Thursday:  1 easy + 1 medium (75 min) - lunch + evening
Friday:    2 medium (90 min) - evening
Saturday:  2 medium or 1 hard (90 min) - morning
Sunday:    1 review (30 min) - or REST
Total:     ~12-14 hours, 12-14 problems
```

**Adjust based on work demands. Consistency > Intensity.**

---

## When to Take a Break

### Take a Day Off If:
- Feeling burned out (quality drops)
- Completed 5-6 consecutive days well
- Got less than 6 hours sleep
- Major work deadline this week

### Don't Take a Break If:
- Just had a failed problem
- Only 2-3 days into the week
- Feeling momentum

**Golden Rule:** 80% consistency > 100% intensity for 2 weeks

---

## Dealing with Imposter Syndrome

### Real Talk:
- Every engineer struggles with DSA sometimes
- Interviews aren't about perfection
- Companies expect you to think aloud, not be perfect
- Getting rusty is normal; sharpening is achievable

### When Discouraged:
1. **Remember:** You've solved these before
2. **Perspective:** Even failing = learning
3. **Progress:** Compare Week 1 to Week 3, not to perfection
4. **Purpose:** This is a refresh, not a rebuild

### Confidence Boosters:
- ✓ Solve early problem again (see improvement)
- ✓ Read success stories in r/cscareerquestions
- ✓ Celebrate small wins (each problem completed)
- ✓ Remember: Google called YOU

---

## Final Tips

### Code Quality
- Use meaningful variable names
- Add comments for complex logic
- Avoid magic numbers
- Keep functions small and focused

### Testing Mindset
- Always test before submitting
- Trace through with example
- Think of edge cases proactively
- Test empty, single element, large inputs

### Communication Winning
- Explain approach first
- Say complexity before coding
- Ask clarifying questions
- Think aloud (don't go silent)

### The 80/20 Rule
- 20% of patterns solve 80% of problems
- Focus on: Two pointers, Hash maps, DFS/BFS, DP basics, Binary search
- Master these 5, you'll solve most problems

---

You're ready to start. Pick Week 1 problem 1 and go solve it. Good luck! 🎯
