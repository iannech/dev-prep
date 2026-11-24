# Google L5 Coding Practice: Pattern Variants

Thirty original practice prompts based on the ten patterns in [favorite_patterns.md](favorite_patterns.md). These are **constructed exercises, not reported Google questions, leaked questions, or predictions of interview frequency**. The ranking in that file is a study input, not a verified frequency distribution.

The emphasis is on useful L5-level practice: modeling an unfamiliar story, stating an invariant, writing correct code, explaining complexity, and adapting when a constraint changes. Some prompts are deliberately moderate; the follow-up is where the deeper reasoning starts. This covers coding preparation, not the entire L5 interview loop.

## How to practice

- Attempt the prompts without opening the pattern key. The order deliberately mixes patterns.
- Use a 40-minute practice budget: 5 minutes for clarification and examples, 5 for the model and approach, 25 for implementation, and 5 for testing and complexity. This is a practice format, not a claim about Google's round timing.
- Before coding, say what information a state must retain, what makes a partial solution safe to discard, and why the algorithm applies.
- Implement the base prompt first. Then spend 10-15 minutes on its follow-up, including whether the original algorithm still works.
- Afterward, record the missed modeling decision, not just the algorithm name. Reattempt missed questions without hints several days later.

**Suggested order:** 01-10 provide one exercise per source pattern; 11-20 deepen the twists; 21-30 combine ideas or push constraints. This is a curriculum order, not a likelihood ranking. For mocks, choose an unseen ID randomly.

Unless stated otherwise, inputs satisfy the stated constraints, IDs are integers, graph vertices are `0..n-1`, and output order is unrestricted. Return an explicit impossibility result where requested. Complexity targets in the key concern the base prompt, not automatically its follow-up.

## Prompts: do not classify them before attempting

### 01. A delivery robot with a demolition budget

An `R x C` grid contains open cells and walls. A robot starts at the open top-left cell and must reach the open bottom-right cell. A move goes to one orthogonally adjacent cell and takes one step. Entering a wall consumes one of at most `k` demolition credits; it does not permanently change the grid. Return the minimum steps, or `-1`.

**Constraints:** `1 <= R,C <= 40`, `0 <= k <= 10`.

**Example:** `grid = [[0,1,0],[0,1,0],[0,0,0]], k = 1` -> `4`, where `1` is a wall.

**Twist to handle:** Reaching a cell first does not necessarily make all later visits useless.

**Follow-up:** The robot alternates day/night after every step, can enter walls only during the day, and can wait in place for one step. It starts during the day; the departure phase determines whether wall entry is allowed. What changes in the state and termination argument?

### 02. A build pipeline with parallel workers

There are `n` tasks, positive durations `duration[i]`, and prerequisite edges `u -> v`. Unlimited workers are available; a task can start only after all its prerequisites finish. Return the earliest time all tasks can finish, or `-1` if the dependencies are cyclic.

**Constraints:** `1 <= n <= 100,000`, at most `200,000` edges, durations at most `10^9`; duplicate edges may occur.

**Example:** `duration = [3,2,4]`, edges `[(0,2),(1,2)]` -> `7`.

**Twist to handle:** Summing durations or merely returning a valid task order is insufficient.

**Follow-up:** There are only two workers. Give a counterexample to reusing the unlimited-worker calculation, and explain why choosing which available task to run becomes a different problem. No optimal polynomial-time implementation is required for this follow-up.

### 03. Splitting a daily processing log

Positive job sizes arrive in a fixed order. Split the array into exactly `d` nonempty contiguous batches, preserving order. Return the smallest possible largest batch sum.

**Constraints:** `1 <= d <= n <= 100,000`, job sizes at most `10^9`.

**Example:** `jobs = [7,2,5,10,8], d = 2` -> `18`.

**Twist to handle:** A feasibility check that uses fewer than `d` batches can still be sufficient. Explain why.

**Follow-up:** Job sizes may be negative. Identify exactly which arguments break, and propose an alternative suitable for `n <= 500`, `d <= 50`.

### 04. A route through exactly one inspection point

An undirected tree has an integer weight and a boolean `marked` flag on every vertex. Return the maximum sum of a nonempty simple path containing **exactly one** marked vertex, or `NONE` if no such path exists. A path can start and end anywhere.

**Constraints:** `1 <= n <= 100,000`; weights are in `[-10^9,10^9]`.

**Example:** Chain `0-1-2`, weights `[5,-2,4]`, flags `[false,true,false]` -> `7`.

**Twist to handle:** Negative weights and the exact-count requirement make the usual "discard every negative branch" rule unsafe if applied without state.

**Follow-up:** Require exactly `q` marked vertices, with `q <= 10`. What states must be combined at a vertex, and what is the resulting complexity?

### 05. Choosing a limited number of reservations

Each reservation is `(start, end, value)`, where `start < end` and `value > 0`. Accept at most `k` reservations with no overlap to maximize total value. Intervals are half-open: one ending at time `t` is compatible with one starting at `t`. Return the maximum value.

**Constraints:** `n <= 100,000`, `1 <= k <= 20`, timestamps and values at most `10^9`.

**Example:** `[(1,3,5),(3,5,6),(1,5,20)], k = 2` -> `20`.

**Twist to handle:** Earliest-finish scheduling does not optimize value, and an unrestricted optimum may exceed the reservation limit.

**Follow-up:** Return the chosen original reservation IDs too. What memory must be retained or recomputed?

### 06. When did a collaboration group become large enough?

Initially `n` people are isolated. Each event `(time,u,v)` connects two people permanently. Events are unsorted and may repeat. Given a person `p` and target `s`, return the earliest event timestamp when `p` belongs to a connected group of at least `s` people; return `0` if `s = 1`, or `-1` if it never happens.

**Constraints:** `n <= 200,000`, at most `200,000` events, `1 <= s <= n`, event times are positive.

**Example:** `n = 4`, events `[(8,1,2),(3,0,1),(10,2,3)]`, `p = 0, s = 3` -> `8`.

**Twist to handle:** A connection can be indirect; duplicate edges must not inflate group sizes.

**Follow-up:** Connections can also be removed. Explain why the same structure is insufficient and outline an offline approach if all events are known.

### 07. A log excerpt with quotas and banned markers

Given a lowercase string `text`, positive character quotas `required`, and a set of banned characters disjoint from `required`, return `[left,right)` for the shortest substring meeting every quota and containing no banned character. Break ties by smallest `left`; return `NONE` if impossible. `required` is nonempty.

**Constraints:** `len(text) <= 200,000`; quotas may exceed the total available occurrences.

**Example:** `text = "abxcab", required = {a:1,b:1}, banned = {x}` -> `[0,2)`.

**Twist to handle:** Banned markers invalidate every candidate crossing them, while surplus required characters should not prevent shrinking.

**Follow-up:** Characters arrive as a stream. Return only the best start/end positions, without retaining the whole stream. What occurrence information is sufficient, and how large can it become?

### 08. A skyline with unequal building widths

Adjacent histogram bars have positive widths `w[i]` and nonnegative heights `h[i]`. Find the largest rectangle under the skyline whose horizontal span covers a contiguous set of complete bars. Return its area.

**Constraints:** `1 <= n <= 200,000`, widths and heights at most `10^9`; areas can reach `2 * 10^23`, so use 128-bit or arbitrary-precision integers.

**Example:** `h = [3,1,3], w = [2,4,1]` -> `7`.

**Twist to handle:** The number of bars in a span is not its physical width.

**Follow-up:** Bars arrive one at a time and the current maximum must be returned after every append. Explain why a stack that finalizes bars only when they are popped does not, by itself, answer every prefix correctly.

### 09. Shortest evacuation routes to any exit

In a simple undirected, unweighted graph, a nonempty set of vertices are exits. For every vertex, return its distance to the nearest exit and the number of distinct shortest vertex-sequence routes to any nearest exit, modulo `1,000,000,007`. An exit has distance `0` and one empty-edge route to itself. An unreachable vertex has distance `-1` and count `0`.

**Constraints:** `n <= 200,000`, at most `300,000` edges.

**Example:** Edges `[(0,1),(0,2),(1,3),(2,3)]`, exits `{3}` -> distances `[2,1,1,0]`, counts `[2,1,1,1]`.

**Twist to handle:** Equally short arrivals add routes; longer arrivals do not.

**Follow-up:** Edges now have positive integer travel times. Which ordering assumption fails, and how would you replace it? What becomes harder if zero-time cycles are allowed?

### 10. Searching a board with unreadable tiles

A board contains lowercase letters and `?` tiles. Each `?` can represent any one letter on a particular visit. Return all distinct dictionary words that can be formed by orthogonally adjacent cells without reusing a cell within a word.

**Constraints:** Board at most `6 x 6`; at most `10,000` distinct nonempty words, total dictionary length at most `100,000`, maximum word length `12`.

**Example:** Board `[['c','?'],['x','t']]`, dictionary `["cat","cut","cart"]` -> `{"cat","cut"}`.

**Twist to handle:** One board prefix can correspond to several dictionary prefixes, but most branches should be pruned immediately.

**Follow-up:** Each cell can be used twice per word instead of once. What state and pruning rules change? Is runtime still polynomial in board size and maximum word length?

### 11. Correcting a query under a budget

Transform string `a` into string `b` using insertion, deletion, and substitution, with positive integer costs `ci`, `cd`, and `cs`. Matching equal characters costs zero. Return the minimum cost if it is at most budget `B`, otherwise `-1`.

**Constraints:** String lengths at most `2,000`, each cost in `[1,100]`, `0 <= B <= 200`.

**Example:** `a = "cat", b = "cut", ci = 2, cd = 2, cs = 3, B = 3` -> `3`.

**Twist to handle:** The cheapest way to replace a character may be deletion plus insertion, not substitution.

**Follow-up:** Exploit the small budget to avoid evaluating the full table. Derive a safe band using the minimum cost of changing string length; do not assume unit costs.

### 12. Is an observed order uniquely determined?

You know there are exactly `n` labeled items. Observations are sequences of distinct item IDs, each claiming relative order. Decide whether they imply exactly one complete order of all `n` items. Return `UNIQUE` with that order, `AMBIGUOUS`, or `INCONSISTENT` if no complete order exists.

**Constraints:** `n <= 100,000`, total observation length at most `200,000`; some items may never appear.

**Example:** `n = 3`, observations `[[0,1],[1,2]]` -> `UNIQUE [0,1,2]`; observations `[[0,1]]` -> `AMBIGUOUS`.

**Twist to handle:** Duplicate evidence is not an additional constraint, and unseen items still belong to the universe.

**Follow-up:** For an ambiguous result, produce two distinct valid orders. For an inconsistent result, produce one directed cycle. Does stopping at the first ambiguous choice distinguish ambiguity from inconsistency?

### 13. Finding the first physical occurrence

A nondecreasing array was rotated at an unknown pivot and can contain duplicates. Return the smallest **array index** containing target `x`, or `-1`.

**Constraints:** `n <= 200,000`; the empty array is allowed.

**Example:** `a = [2,2,3,1,2], x = 2` -> `0`.

**Twist to handle:** Returning any matching index is incorrect, and equal endpoints may hide which side is ordered.

**Follow-up:** Can you guarantee logarithmic worst-case time? Give an adversarial family and distinguish physical index from position in the unrotated sorted sequence.

### 14. Deleting all leaves simultaneously

Given a rooted tree with unique vertex IDs, repeatedly remove every current leaf in one simultaneous round. Return the IDs removed in each round, starting with round `0`. Children may appear in any input order.

**Constraints:** `1 <= n <= 200,000`; the root is supplied, and a leaf has no remaining children.

**Example:** Root `0`, edges `0->1, 0->2, 1->3` -> `[{2,3},{1},{0}]`.

**Twist to handle:** A node that becomes a leaf during a round cannot be removed until the next round.

**Follow-up:** A vertex also has a nonnegative cooldown `c[v]`. Leaves finish at time `c[v]`; other vertices finish at `max(child finish times) + 1 + c[v]`. Return completion times without simulating each time unit.

### 15. Reordering identifiers through allowed swaps

You have a lowercase string and pairs of positions. You may swap the characters at any listed pair arbitrarily many times. Return the lexicographically smallest reachable string.

**Constraints:** String length at most `200,000`, at most `200,000` pairs; pairs may repeat.

**Example:** `s = "dcab"`, pairs `[(0,3),(1,2)]` -> `"bacd"`.

**Twist to handle:** Positions connected indirectly can exchange characters even if that pair is not explicitly listed.

**Follow-up:** Each allowed edge can be used at most once. Show why component membership alone no longer captures reachability.

### 16. Roads whose removal disconnects a network

An undirected multigraph contains road IDs; multiple roads may connect the same pair of cities. Return every road ID whose individual removal increases the number of connected components. The initial graph may already be disconnected. There are no self-loops.

**Constraints:** `n <= 200,000`, at most `300,000` roads.

**Example:** Roads `[(id=0,0,1),(id=1,0,1),(id=2,1,2)]` -> `{2}`.

**Twist to handle:** Skipping every edge to a DFS parent incorrectly treats parallel roads as one road.

**Follow-up:** Roads only get added, and you must report the number of disconnecting roads after each addition. Explain what the static traversal fails to maintain; an advanced online implementation is optional.

### 17. A repeating temperature schedule

An array is a circular schedule. For each day, return the number of steps forward to the first strictly warmer day, considering only the next `n-1` days. Return `-1` if there is none.

**Constraints:** `1 <= n <= 200,000`; temperatures can be negative or equal.

**Example:** `[3,1,2]` -> `[-1,1,1]`.

**Twist to handle:** Equal temperatures do not qualify, and a day cannot be its own answer after a full lap.

**Follow-up:** Require a temperature at least `delta > 0` warmer. Does the original pop/discard rule remain valid? Use `[3,2,4]` with `delta = 2` to test it, and propose another data structure if needed.

### 18. Counting bounded excerpts with exactly k categories

Given an integer array, count nonempty contiguous subarrays that have exactly `k` distinct values and length at most `L`.

**Constraints:** `n <= 200,000`, `1 <= k,L <= n`; values are arbitrary signed integers.

**Example:** `a = [1,2,1], k = 2, L = 2` -> `2`.

**Twist to handle:** A length bound and a distinct-count bound must hold at the same time.

**Follow-up:** Instead of the total, return for each right endpoint how many qualifying subarrays end there. Can the same reasoning be reused?

### 19. A lock with one override token

A lock consists of `d` decimal wheels. One move increments or decrements one wheel by one, wrapping between `0` and `9`. Start at all zeros. Some combinations are blocked. You have one token allowing entry into one blocked combination on one move; after spending it, you can leave normally but cannot enter any blocked combination again. Return the minimum moves to a target, or `-1`.

**Constraints:** `1 <= d <= 4`; start is not blocked, target may be blocked.

**Example:** `d = 1`, blocked `{"1","9"}`, target `"2"` -> `2`, using the token to enter `"1"`.

**Twist to handle:** The same combination with and without the token remaining represents different future possibilities.

**Follow-up:** Turning wheel `i` costs positive integer `cost[i]`. Which part of the algorithm changes, and which state components stay the same?

### 20. Assigning jobs to identical machines

Assign every positive-duration job to one of `m` identical machines. Jobs on one machine run sequentially; machines run in parallel. Return the minimum possible finishing time.

**Constraints:** `1 <= n <= 12`, `1 <= m <= n`, durations at most `10^6`.

**Example:** `jobs = [3,2,3], m = 3` -> `3`.

**Twist to handle:** Machine labels do not matter, so many assignments describe the same load configuration.

**Follow-up:** Return one assignment using original job IDs. Then explain why the same exhaustive approach is unsuitable for `n = 100,000`, even with pruning.

### 21. A map with free express links

A directed graph has ordinary edges costing `1` and express edges costing `0`. Express edges may form cycles. Given source and target, return the minimum cost, or `-1` if unreachable.

**Constraints:** `n <= 200,000`, at most `300,000` edges.

**Example:** Edges `0->1 (1), 0->2 (0), 2->1 (0), 1->3 (1)` -> cost from `0` to `3` is `1`.

**Twist to handle:** A vertex's first discovery need not be its cheapest arrival.

**Follow-up:** Edge costs become arbitrary nonnegative integers. Which optimization no longer applies? Can you safely stop when the target is first discovered?

### 22. Counting optimal increasing histories

Given an integer array, return the length of its longest strictly increasing subsequence and the number of such subsequences modulo `1,000,000,007`. Subsequences are distinct by their index sequences, even when values match.

**Constraints:** `0 <= n <= 3,000`; return `(0,0)` for an empty array.

**Example:** `[1,3,5,4,7]` -> `(4,2)`; `[2,2,2]` -> `(1,3)`.

**Twist to handle:** Keeping just the smallest possible tail for each length does not preserve the number of optimal histories.

**Follow-up:** Increase `n` to `200,000`. Describe coordinate compression and a data structure whose merge operation combines `(best length, count)` correctly.

### 23. A common ancestor of requested objects

Given a rooted binary tree and a nonempty set of target node IDs, return their lowest common ancestor only if **every** target exists in the tree; otherwise return `NONE`. Node IDs are unique, but displayed node values may repeat.

**Constraints:** `1 <= n <= 200,000`, at most `100,000` target IDs.

**Example:** Root `A` with children `B,C`: targets `{B,C}` -> `A`; targets `{B,X}` -> `NONE` if `X` is absent.

**Twist to handle:** Finding a plausible ancestor for the targets that happen to exist does not satisfy the contract.

**Follow-up:** The tree is fixed and there are `100,000` pair queries. What preprocessing avoids traversing the entire tree for each query?

### 24. Printers that become available at different times

Printer `i` becomes available at integer time `start[i]` and takes positive integer `period[i]` per item. Its first item finishes at `start[i] + period[i]`. All printers operate independently. Return the earliest integer time at which at least `T` items have finished.

**Constraints:** `1 <= n <= 100,000`, `1 <= T <= 10^12`, `0 <= start[i] <= 10^9`, `1 <= period[i] <= 10^6`. State the arithmetic range required.

**Example:** Printers `(start,period) = [(0,2),(3,1)]`, `T = 4` -> `5`.

**Twist to handle:** A printer contributes nothing before its first completion; per-item event simulation may be infeasible.

**Follow-up:** Each printer takes a break of `b[i]` time units after every `q[i]` completed items. Derive the new count-by-time formula and explain whether the outer search still applies.

### 25. A dictionary from an unknown alphabet

A list of distinct nonempty lowercase words is sorted under an unknown alphabet order. Return `INVALID` if no order explains it; otherwise return the lexicographically smallest valid ordering of all characters appearing in the words, and whether that order is uniquely determined.

**Constraints:** Total word length at most `200,000`; the alphabet has at most `26` characters.

**Example:** `["ab","ac"]` -> order `"abc"`, not unique; `["abc","ab"]` -> `INVALID`.

**Twist to handle:** Only the first differing character between adjacent words supplies an ordering edge; reversed prefix order is invalid without any cycle.

**Follow-up:** Return one concrete explanation of invalidity: either an offending prefix pair or a cycle of character constraints.

### 26. Activating cells on an initially empty map

An `R x C` map starts entirely inactive. Each operation activates one cell; activating an already active cell is a no-op. After each operation, return the number of active orthogonally connected components and the size of the largest one.

**Constraints:** `R,C <= 10^9`, at most `200,000` operations. Do not allocate storage proportional to `R*C`.

**Example:** `R = C = 3`, operations `[(0,0),(0,1),(2,2),(0,0)]` -> `[(1,1),(1,2),(2,2),(2,2)]`.

**Twist to handle:** The coordinate space is huge but sparse, and several neighbors can already belong to the same component.

**Follow-up:** Operations may deactivate cells too. Explain why undoing one local merge is not enough.

### 27. The longest stable sensor interval

Given an integer array and nonnegative tolerance `D`, return the length of the longest contiguous subarray whose maximum minus minimum is at most `D`.

**Constraints:** `n <= 200,000`, values in `[-10^9,10^9]`.

**Example:** `[8,2,4,7], D = 4` -> `2`.

**Twist to handle:** Both extrema must be maintained as old samples leave, not just as new samples arrive.

**Follow-up:** The array arrives as an unbounded stream, and you must return the best length so far after every arrival. What storage does your method actually require in the worst case?

### 28. Exactly k symmetric chunks

Return all ways to split a string into exactly `k` nonempty contiguous substrings, each of which is a palindrome. Different cut positions define different answers.

**Constraints:** `1 <= n <= 18`, `1 <= k <= n`.

**Example:** `s = "aabb", k = 2` -> `[["aa","bb"]]`.

**Twist to handle:** Testing the same substring repeatedly wastes work, and some partial partitions cannot possibly reach exactly `k` pieces.

**Follow-up:** Only the number of partitions is needed, modulo `1,000,000,007`, and `n <= 1,000`. How does the algorithm change when output enumeration disappears?

### 29. The largest clean area in a row stream

Binary matrix rows arrive one at a time. After each row, return the area of the largest all-ones axis-aligned rectangle anywhere in the matrix seen so far.

**Constraints:** At most `2,000` rows and `2,000` columns; retain only `O(columns)` working memory, excluding emitted answers.

**Example:** Rows `[1,0,1]`, then `[1,1,1]` -> outputs `[1,3]`.

**Twist to handle:** The best rectangle may end at an earlier row, and storing the whole matrix is forbidden.

**Follow-up:** Only the most recent `H` rows count. Explain why keeping the all-time maximum is now wrong, and why simply capping column heights at `H` does not recover rectangles ending at earlier rows in the active window.

### 30. Two robots sharing a warehouse

Two labeled robots occupy distinct open cells of a grid. At each synchronous step, each robot either waits or moves to an orthogonally adjacent open cell. They may never end a step in the same cell or swap positions across the same edge in that step. Return the minimum steps until both are at their respective goals, or `-1`. A robot may leave its goal before the final step.

**Constraints:** Grid at most `8 x 8`; starts are distinct, goals are distinct, and all four supplied positions are open.

**Example:** Grid `[['.','.']]`, starts `(left,right)`, goals `(right,left)` -> `-1`.

**Twist to handle:** Two independently shortest routes may conflict; collision checks must consider both the old and new joint positions.

**Follow-up:** One robot move costs energy `1` and waiting costs `0`; minimize total energy rather than elapsed steps. How do transition costs and the search algorithm change?

---

## Pattern key and self-review hints

**Stop here until you have attempted the chosen prompt.** These are modeling hints and target bounds, not full solutions. Bounds include recursion stacks where applicable; use iterative traversals for deep trees/graphs when the language's recursion limit is unsafe.

<details>
<summary>Reveal patterns, invariants, complexity targets, and common traps</summary>

| ID | Underlying pattern | Core reasoning and target complexity | Common failure |
|----|--------------------|--------------------------------------|----------------|
| 01 | BFS on state space | State `(row,col,credits left)`. FIFO layers minimize steps; a plain cell-level visited flag loses information. `O(R*C*(k+1))` time and space. The follow-up also needs phase. | Keeping only the first arrival per cell, regardless of remaining credits. |
| 02 | Topological sort + DAG DP | Propagate `finish[v] = duration[v] + max(finish[parent])`; only finalize after all incoming edges are processed. Detect a cycle by processed count. `O(n+e)` time and space. Count duplicate edges consistently or deduplicate both adjacency and indegrees. | Adding prerequisite durations even when they run in parallel; integer overflow. |
| 03 | Binary search on the answer | For a capacity, greedily count batches; feasibility is monotone. With positive sizes, a partition using at most `d` groups can be split into exactly `d`. `O(n log S)` time, `O(1)` auxiliary space, `S = sum(jobs)`. | Using the exact-group argument with negative values; confusing answer monotonicity with validity of the greedy check. |
| 04 | Tree DFS + constrained path DP | Retain best downward paths containing zero or one marked vertex. Combine at most two child branches through the current vertex, counting its mark once; represent impossible states explicitly. `O(n)` time and space. | Treating an impossible state as sum zero, or combining two one-mark branches. For `q` marks, child-state convolution yields `O(n*q^2)` time. |
| 05 | DP + sorted interval search | Sort by end time; find the compatible predecessor with binary search. For each allowed count, choose skip or take. `O(n log n + n*k)` time, `O(n)` auxiliary space with rolling count layers. | Using `end < start` instead of `end <= start`, or greedily selecting by value/finish time. |
| 06 | Union-find with component sizes | Sort events by time, union distinct roots, and inspect the size of `find(p)`. Same-time processing may return as soon as the threshold holds because only the timestamp matters. `O(e log e + e*alpha(n) + n)` time, `O(n+e)` space including sorted events. | Adding sizes for an already-connected pair; processing the unsorted input as chronology. |
| 07 | Sliding window with quota deficits | Track how many required occurrences are still missing; shrink while valid. A banned character forces the window past it and resets its counts. `O(n + Q)` time, `O(Q)` working space, where `Q` is the alphabet size (26 here). | Counting distinct required letters rather than required occurrences, or shrinking past a necessary occurrence. |
| 08 | Monotonic stack + prefix widths | When a bar is popped, its height is the limiting height over a known index span. Compute physical span width using prefix sums, not bar count. `O(n)` time and space. | Mixing index distances with physical widths; mishandling equal heights or the final flush. |
| 09 | Multi-source graph BFS + counting | Seed all exits at distance zero. On first discovery set distance/count; on another edge from the previous layer add its count. `O(n+e)` time and space. | Revisiting longer routes, double-enqueuing equal-distance arrivals, or multiplying counts without justification. |
| 10 | Backtracking + trie | Carry the trie node and used-cell state; expand `?` only along existing child edges. Deduplicate terminal words. With `b` cells, max length `ell`, and dictionary size `D` in characters, a conservative bound is `O(D + b*4^ell*D)`, accounting for wildcard branching through dictionary prefixes and output materialization; working space `O(D+b+ell)`, excluding output. | Memoizing only `(cell,trie node)` despite different used-cell sets; claiming trie pruning guarantees polynomial runtime. |
| 11 | Weighted edit-distance DP | Prefix states consider insert/delete/substitute independently. Full-table baseline: `O(len(a)*len(b))` time, `O(min(len(a),len(b))+1)` rolling space if swapping strings also swaps insertion/deletion costs. | Assuming substitution is always preferable, or swapping strings without adjusting asymmetric costs. |
| 12 | Topological ordering + uniqueness | Build adjacent-pair edges and include every labeled item. More than one ready vertex proves nonuniqueness only if a full order ultimately exists; a cycle takes precedence. `O(n+M)` time and space for total observation length `M`. | Returning `AMBIGUOUS` immediately, before discovering a cycle in another component. |
| 13 | Rotated-array search with duplicates | Duplicate-aware search must preserve the smallest physical index, including candidates on both sides of a rotation. Check index zero early; do not claim strict logarithmic bounds. `O(n)` worst-case time, `O(1)` space is acceptable; defend any faster typical-case approach. | Returning the first match found by ordinary rotated search; claiming duplicates never affect complexity. |
| 14 | Tree postorder / reverse layering | A leaf has removal round zero; every other vertex has `1 + max(child round)`. Group vertices by that number. `O(n)` time and space including output. | Grouping by distance from the root or deleting newly exposed leaves in the current round. |
| 15 | Union-find + sorting | Repeated edge swaps permit arbitrary permutations within each connected component. Place its sorted characters at its sorted indices. `O(n log n + e*alpha(n))` time, `O(n)` auxiliary space excluding input pairs. | Swapping only explicitly paired positions once, instead of reasoning about reachability. |
| 16 | Graph DFS / low-link bridges | A DFS tree edge `(u,v)` is a bridge when `low[v] > discovery[u]`. Skip only the incoming edge ID, not every edge to the parent vertex. Traverse all components. `O(n+e)` time and space. | Using `>=`, skipping parallel back edges, or exploring only vertex zero. |
| 17 | Circular monotonic stack | Scan two logical copies with absolute positions; resolve each original index once and enforce a distance below `n`. Equal values do not resolve a day. `O(n)` time and space. | Treating equality as warmer; using modulo indices to compute distances without tracking the lap. |
| 18 | Sliding window via count subtraction | Count subarrays with at most `k` distinct and length at most `L`, then subtract the corresponding count for `k-1`. Each endpoint contributes `right-left+1`. Define the at-most-zero helper as zero. `O(n)` expected time with hash maps, `O(n)` space. | Subtracting an unbounded-length count, or assuming exactly-`k` validity itself is a monotone window condition. |
| 19 | BFS on state space | State `(combination,token available)`; transition legality is based on the destination and remaining token. At most `2*10^d` states and `2*d` outgoing moves per state. `O(d*10^d)` time with numeric encodings and `O(10^d)` state storage. | Marking a combination globally visited, or rejecting a blocked target before considering the token. |
| 20 | Backtracking + symmetry pruning | Assign larger jobs first, skip machines with equal current loads, and prune branches that cannot improve the incumbent. A conservative bound is `O(n*m^n + n log n)` time including sorting and per-state bookkeeping, `O(n+m)` auxiliary space; pruning is not a polynomial guarantee. | Exploring all permutations of identical empty machines; returning sorted job indices as original IDs. |
| 21 | Graph traversal: 0-1 BFS | Relax distances; push zero-cost improvements to the deque front and unit-cost improvements to the back. Use the standard ordered-deque discipline and discard stale entries if queued with distances. `O(n+e)` time and space. | Using FIFO discovery order or marking visited on enqueue as if all edges had equal cost. |
| 22 | DP with length-and-count state | For each ending index, merge predecessor lengths: replace count on a better length, add on an equal length. Combine all globally optimal endpoints. `O(n^2)` time, `O(n)` space. | Allowing equal values as predecessors or deduplicating equal-valued index sequences. |
| 23 | Tree DFS + membership accounting | Hash target IDs; each subtree returns its matched count and candidate ancestor. Only return the candidate after checking the total equals the requested set size. `O(n+k)` expected time and space. | Returning as soon as a partial LCA is found, skipping the global presence check, or comparing displayed values instead of IDs. |
| 24 | Binary search on completion time | Printer contribution at time `t` is `max(0,floor((t-start[i])/period[i]))`. Search a monotone total, using a safe upper bound such as `min(start[i]+period[i]*T)` and saturating sums at `T`. `O(n log U)` time, `O(1)` auxiliary space. | Counting an item at availability time; overflow in bounds or summed counts. |
| 25 | Topological sort + min-heap | Add deduplicated first-difference edges; reject the prefix violation separately. A min-heap selects the smallest ready character; multiple choices imply nonuniqueness if traversal completes. `O(W + A log A)` time, `O(A^2)` auxiliary space, total input characters `W`, alphabet size `A <= 26`. | Omitting isolated characters, adding constraints after the first difference, or treating smallest valid order as unique. |
| 26 | Sparse union-find | Map active coordinate pairs to compact IDs. An activation adds one component, and each successful union removes one. Update the maximum from root sizes. `O(q*alpha(q))` expected time, `O(q)` space for `q` operations. | Allocating the full map; decrementing component count for duplicate activation or failed union. |
| 27 | Sliding window + two monotonic deques | Store candidate min/max indices; shrink until their difference is within tolerance, expiring indices as the left boundary moves. `O(n)` time, `O(n)` worst-case space. | Keeping just current extrema without replacements; assuming streaming implies constant storage. |
| 28 | Backtracking + palindrome preprocessing | Precompute palindrome validity, then enumerate cuts with remaining-piece feasibility checks. `O(n^2 + n*2^n)` conservative time including output construction; `O(n^2+n)` working space excluding output. | Ignoring output size or accepting partitions with fewer than exactly `k` chunks. |
| 29 | Monotonic stack over evolving histograms | Maintain consecutive-one heights per column. For each row, solve a histogram rectangle problem and retain the best across rows. `O(R*C)` total time, `O(C)` working space. | Returning only the current row's histogram maximum; retaining every previous row. |
| 30 | BFS on a product state space | State is the ordered pair of robot positions. Generate at most 25 move pairs and reject shared destinations and head-on swaps. For `V` open cells, `O(V^2)` time and space with constant branching. | Solving separately, treating robots as interchangeable, or forcing a robot to stay at its goal. |

`alpha` denotes the inverse Ackermann function from path-compressed, size/rank-balanced union-find. Hash-map bounds above are expected bounds. Input adjacency storage is included for graph/tree problems. Output-sensitive enumeration bounds are intentionally conservative, not promises that every worst-case instance is quick.

</details>

## Follow-up checkpoints worth explaining aloud

Use these after attempting the relevant follow-ups; they are intended to expose incorrect transfer of a familiar template.

<details>
<summary>Reveal selected follow-up checkpoints</summary>

- **03:** Negative sizes invalidate the greedy capacity checker and the "split any group safely" argument. The decision predicate for an exact-`d` partition is still monotone in the capacity, but the old checker is not valid. A direct `O(d*n^2)` partition DP is suitable for the smaller constraints.
- **07:** For positions only, retain at most the most recent required quota of occurrences for each required character since the last banned marker. Once all quotas are satisfied, the minimum of those characters' oldest retained positions is the latest valid start for that endpoint. Storage is `O(sum(required.values()))`, plus alphabet bookkeeping, not necessarily constant in the quota input.
- **08:** The prefix `[2,2]` already has area `4` although no shorter bar has arrived to pop either height. Online queries need an additional way to evaluate unresolved spans.
- **11:** Any prefix state on a path costing at most `B` has `abs(i-j) <= floor(B/min(ci,cd))`; asymmetric insertion/deletion costs can tighten this band further. Positive costs justify discarding over-budget states.
- **12:** An isolated ready vertex can coexist with a separate directed cycle. Multiple ready choices do not establish that any complete order exists.
- **15:** On a three-position path with two edges, unlimited swaps can reverse the endpoints while restoring the middle, but using each edge at most once cannot. Connectivity no longer describes all reachable permutations.
- **17:** In `[3,2,4]` with `delta = 2`, day `2` can use `4`, but day `3` cannot use `4`. Discarding the earlier `3` just because a later `2` exists loses a different threshold requirement. For example, a range-maximum tree over a doubled array can find the first qualifying position in the next `n-1` positions in `O(log n)` per query.
- **19:** Positive wheel-dependent costs replace FIFO BFS with Dijkstra, not the token-aware state model.
- **22:** A compressed-value prefix query must exclude the current value for strict increase. Merge equal best lengths by summing counts; treat the empty predecessor query as the single way to start a length-one subsequence.
- **24:** With `x = t-start[i] >= 0` and cycle length `q[i]*period[i]+b[i]`, the count is `(x // cycle)*q[i] + min(q[i], (x % cycle)//period[i])`. Count is zero for `x < 0`. The final item of a batch completes before its break; no break follows a partially completed batch.
- **27:** A long strictly increasing stream with sufficiently large `D` keeps a linear-sized minimum deque. Streaming support does not imply bounded working memory independent of the active interval.
- **28:** Counting uses prefix-length and piece-count DP with palindrome lookups: `O(k*n^2)` time with `O(n^2 + k*n)` space is a straightforward target.
- **29:** With one column, `H = 2`, and rows `1,0,0`, an all-time maximum incorrectly remains `1` although the active window contains no ones. Conversely, rows `1,1,0` have active-window maximum `1` even though the current histogram height is `0`.
- **30:** Joint transitions cost `0`, `1`, or `2` energy, so ordinary FIFO BFS and standard 0-1 BFS do not directly apply. Dijkstra works; the collision rules and joint state remain necessary.

</details>

## What a successful attempt should demonstrate

| Dimension | Self-check |
|-----------|------------|
| Modeling | I can explain why the state contains exactly the information needed for future choices. |
| Correctness | I can defend the invariant or recurrence, not just name a pattern. |
| Implementation | My code handles duplicates, missing results, boundaries, and the numeric range in the prompt. |
| Testing | I checked the smallest case, an impossible case where applicable, and an adversarial case that breaks a tempting shortcut. |
| Adaptation | I can name the assumption removed by the follow-up and decide whether to extend or replace the algorithm. |

Mark an exercise **solid** only after implementing it without the key and explaining its follow-up. Remembering the canonical problem does not count as recognizing the variant.

## Canonical warm-ups, only when a prerequisite is missing

These public problems are background practice, not evidence that Google asks these variants. Attempt the custom prompt first; use a warm-up only if the underlying technique is unfamiliar.

| Source pattern | Public warm-up |
|----------------|----------------|
| Graph BFS/DFS | [01 Matrix](https://leetcode.com/problems/01-matrix/), [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/) |
| Dynamic programming | [Edit Distance](https://leetcode.com/problems/edit-distance/), [Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/) |
| Tree DFS/BFS | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/), [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) |
| Binary search | [Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/), [Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) |
| Topological sort | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/), [Parallel Courses III](https://leetcode.com/problems/parallel-courses-iii/) |
| Union-find | [Accounts Merge](https://leetcode.com/problems/accounts-merge/), [Smallest String With Swaps](https://leetcode.com/problems/smallest-string-with-swaps/) |
| Sliding window | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/), [Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/) |
| Backtracking | [Word Search II](https://leetcode.com/problems/word-search-ii/), [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) |
| Monotonic stack | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/), [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) |
| BFS on state space | [Open the Lock](https://leetcode.com/problems/open-the-lock/), [Shortest Path in a Grid with Obstacles Elimination](https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/) |

This bank follows the supplied ten-pattern scope. It is not an exhaustive coding syllabus: keep heaps, interval sweeps, hashing, two pointers, greedy proofs, and basic data-structure implementation in your broader rotation too.
