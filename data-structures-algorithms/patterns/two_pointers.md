1. Best time to buy and sell stock
Given a list of stock prices, find max profit by buying and day and selling on a future day.

```python
Naive approach: Use nested loops to compare each possible buy-sell pairs in the array. Time - O(N^2)

Better approach: Greedy algorithm Use two pointers. for each L, iterate R across and calculate profit, when R > L, we knowwe have evaluated all potential max
profits, so move L to where R is and repeat. Time - O(N), Space - O(1)

def max_profit(prices):
    if prices is None:
        return 0
    
    l = 0
    r = 1
    maxP = 0

    while r != len(prices):
        if prices[l] < prices[r]:
            profit = prices[r] - prices[l]
            maxP = max(maxP, profit)
        else:
            l = r

        r += 1
    return maxP
```

2. Squares of Sorted Arrays
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order
```python

Naive approach: Square each num in the array then sort the array using .sort() to produce solution of Time - O(n log n)

Better Approach: Two pointers L and R with a double-ended deque() that allows us to append to the queue depending on the square of the absolute value at nums[L] and nums[R].
We will then return the deque as a list.
Time - O(N)
hint: absolute squared value of a +ve and -ve value will be the same

def sortedSquares(self, nums):
    
    ans = collections.deque()
    l,r = 0, len(nums) - 1

    while l <= r:
        leftAbs, rightAbs = Abs(nums[l]), Abs(nums[r])

        if leftAbs > rightAbs:
            ans.appendleft(leftAbs * leftAbs)
            l += 1
        else:
            ans.appendleft(rightAbs * rightAbs)
            r -= 1
    return list(ans)
```

3. Three Sums
Given an integer array nums, return all the triplets, `[nums[i], nums[j], nums[k]]` such that `i != j, i != k` and `j != k` and `nums[i] + nums[j] + nums[k] == 0`
```python
Naive approach: 3 nested loops giving a Time - O(N^3) solution. Sorting the array can help us overcome the duplication problem

Better approach: Two pointers. Sort and iterate through list for first value in triplet. Use two pointers moveing left and right to find 0
Time - (N^2)log N but log N is insignificant in this case so N^2

def threeSum(nums):
    # populate with unique (i,j,k) == 0
    triplets = []

    nums.sort()

    # first loop through considering i
    for indx, val in enumerate(nums):

        # if i is same as previous value, skip it. it has already been evaluated
        if indx > 0 and (val == nums[indx - 1]):
            continue
        
        left = indx + 1
        right = len(nums) - 1

        # when indx is penultimate left indx(j) == right indx(k)
        while l < r:
            currentSum = val + nums[left] + nums[right]

            if currentSum > 0:
                right -= 1
            elif currentSum < 0:
                left += 1
            else:
                triplets.append(val, nums[left], nums[right])
                left += 1

                # keep evaluating for more solutions


                while left < right and nums[left] == nums[left-1]:
                    left += 1
        return triplets
```

4. Longest Mountain Array