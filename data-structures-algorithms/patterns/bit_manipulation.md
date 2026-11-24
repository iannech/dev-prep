# Bit Manipulation Notes

## Core ideas

- Think in terms of bits, not values.
- Most questions use a few standard operations:
  - Check a bit: `(n >> i) & 1`
  - Set a bit: `n | (1 << i)`
  - Clear a bit: `n & ~(1 << i)`
  - Toggle a bit: `n ^ (1 << i)`
  - Isolate lowest set bit: `n & -n`
  - Remove lowest set bit: `n & (n - 1)`

## Useful facts

- `x & (x - 1)` removes the rightmost set bit.
- `x & -x` keeps only the rightmost set bit.
- `n & (n - 1) == 0` means `n` is a power of two.
- XOR is great for finding duplicates or a missing value:
  - `a ^ a = 0`
  - `a ^ 0 = a`
  - XOR is commutative and associative.

## Common question patterns

### 1. Check if a bit is set

- Example: `((n >> i) & 1) == 1`
- Usually used in index-based bitmask problems.

### 2. Count set bits

- Use `while n != 0: n &= n - 1; count++`
- Time: `O(number of set bits)`
- Alternative: `n.bit_count()` in Python.

### 3. Find a missing or duplicate number

- XOR all elements with index/value ranges.
- Typical pattern when numbers are in a range and only one value is missing/duplicated.

### 4. Power of two check

- `n > 0 && (n & (n - 1)) == 0`
- Works because powers of two have exactly one set bit.

### 5. Masking and submasks

- A mask helps keep only selected bits.
- Example: `mask = (1 << k) - 1` gets the lowest `k` bits.
- Useful for extracting ranges or checking multiple flags.

## Typical interview tips

- Before writing code, decide which bit operation is needed:
  - `&` = mask / filter
  - `|` = set bits
  - `^` = toggle / unique value
  - `~` = clear bits in a mask
  - `<<` / `>>` = move bits left or right
- Keep an eye on edge cases:
  - zero
  - negative numbers
  - sign bits
  - large integers
- Most bit-manipulation problems are about patterns, not fancy math.

## Example: single number

```python
nums = [4, 1, 2, 1, 2]
result = 0
for n in nums:
    result ^= n
print(result)  # 4
```

- XOR cancels duplicate values, leaving the unique one.

## Example: check if power of two

```python
def is_power_of_two(n):
    return n > 0 and (n & (n - 1)) == 0
```

## Summary

Bit manipulation questions usually rely on a small set of patterns:
- mask and extract bits
- set/clear/toggle bits
- XOR tricks for duplicates or missing values
- count or isolate set bits

If you recognize the pattern, the solution is often short and efficient.
