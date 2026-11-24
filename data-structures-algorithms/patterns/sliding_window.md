 # Sliding Window Pattern

Sliding window is an approach for processing a **contiguous** portion of a sequence (such as an array or string). Keep track of the current window and move its boundaries instead of recomputing the result for every possible range. This often reduces a quadratic brute-force solution to linear time.

## Fixed-size window

When the window length `k` is known, add the new rightmost element and remove the element that leaves on the left. For example, to find the largest sum of any `k` consecutive values:

```python
def max_window_sum(nums, k):
	if k <= 0 or k > len(nums):
		return None

	window_sum = sum(nums[:k])
	best = window_sum

	for right in range(k, len(nums)):
		window_sum += nums[right] - nums[right - k]
		best = max(best, window_sum)

	return best
```

The initial window takes `O(k)` time; each subsequent move takes `O(1)`, for `O(n)` total time and `O(1)` extra space.

## Variable-size window

When the window length is not fixed, expand it by moving the right boundary. If the window violates a condition, move the left boundary until it is valid again. Track the best valid window as you go.

```python
def longest_at_most_k_distinct(text, k):
	if k < 0:
		return 0

	counts = {}
	left = 0
	best = 0

	for right, char in enumerate(text):
		counts[char] = counts.get(char, 0) + 1

		while len(counts) > k:
			old = text[left]
			counts[old] -= 1
			if counts[old] == 0:
				del counts[old]
			left += 1

		best = max(best, right - left + 1)

	return best
```

Each boundary moves only forward, so this runs in `O(n)` time; the count map uses up to `O(n)` space.

## When to use it

- The problem asks about a contiguous subarray or substring.
- You need a maximum, minimum, sum, count, or other property over ranges.
- A window can be updated efficiently as elements enter or leave.

Sliding window is not automatically suitable for every range problem. In particular, shrinking a variable window based on a sum condition generally relies on nonnegative values; negative values can invalidate the usual expand/shrink logic. Consider prefix sums or another technique when the window condition is not monotonic.


1. Contains nearby duplicate
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that `nums[i] == nums[j]` and 
`abs(i - j) <= k`

```python
Naive approach: quadratic time
Better solution: Sliding Window; Time - O(N), Space - O(k) Traverse given array with fixed set size and check rules as you go

def containsNearbyDuplicate(nums: list[int], k: int) -> bool:
    seen = set()

    for i, num in enumerate(nums):
        if num in seen:
            return True
        seen.add(num)

        if len(seen) > k:
            seen.remove(nums[i - k])
    return False
```

2. Minimum size SubArray sum 
Given an array of positive integers nums, and a positive integer target, return the minimum length of a subarray whose sum is greater or equal to target.
If there's no such subarray return 0.

```python
def minimumSizeSubarrayLen(nums: list[int], target: int) -> int:
    l = 0
    total = 0
    res = float('inf')

    for r in range(len(nums)):
        total += nums[r]
        
        while total >= target:
            res = min(res, r - l + 1)

            total -= nums[l]
            l += 1

    if res = float('inf'):
        return 0
    else:
        return res

```