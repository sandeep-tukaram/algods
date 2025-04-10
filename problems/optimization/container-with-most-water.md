# Optimizing the Container With Most Water Problem

## Introduction

The "Container With Most Water" is a classic algorithmic problem that asks us to find the maximum amount of water a container can hold, given an array of heights. Each element in the array represents a vertical height, and the width between any two heights is their index difference.

In mathematical terms, we need to find two indices `i` and `j` that maximize the area calculated as:
```
Area = min(height[i], height[j]) * (j - i)
```

The problem tests our ability to optimize from a simple brute force approach to an elegant linear time solution. Let's journey through three different approaches, from the most intuitive to the most optimized.

## Approach 1: Repeated Full Scan (Brute Force)

The most straightforward approach is to check all possible pairs of heights and calculate the area they form. This is a classic brute force approach where we:

1. Iterate through all pairs of heights (i, j)
2. Calculate the area of the container formed by each pair
3. Keep track of the maximum area found

### Analysis:
- **Time Complexity**: T(n) = n (pivots) * n (scans) = O(n²) - For every i (pivot), we scan left and right to find the container with i column fixed. This results in n pivots with n scans each.
- **Space Complexity**: S(n) = O(1) - We only need a single variable to track the maximum container.

This solution is simple to understand but inefficient for large inputs. It times out on LeetCode for larger test cases.

### Implementation:

```java
int fullScan(int[] height) {
    int max_container = 0;

    for (int i = 0; i < height.length; i++) {
        for (int j = 0; j < height.length; j++) {
            max_container =
                    Math.max(max_container,
                        Math.abs(j-i) * Math.min(height[j], height[i])
                    );
        }
    }

    return max_container;
}
```

## Approach 2: Recursive Solution

Can we do better? Let's explore a recursive approach to this problem.

### Initially Attempted DP Approach (Flawed)

Initially, we might think this is a good candidate for dynamic programming:

1. We define a subproblem `C(i)` as the maximum container between indices 0 and i (a prefix subproblem)
2. Base case: `C(0) = 0` (a single height can't form a container)
3. Recursive relation:
   ```
   C(i) = Max {
            C(i-1),                              // Max container without using the current height
            max((i-j) * min(height[i], height[j])) for all j < i  // Max container with the current height
          }
   ```

In this approach, we view the problem as finding the maximum container for each ending position, and we initially thought memoization would help avoid redundant calculations.

The analysis for this approach would be:
- **Time Complexity**:
  - The recursive relation can be expressed as: T(i) = T(i-1) + O(i)
  - Memoizing T(i) to avoid repeated calculations
  - When fully expanded: T(n) = O(n) + O(n-1) + ... + O(1) = O(n²)
- **Space Complexity**: S(n) = O(n) - To store values of C(i) for 0 <= i < n in the memoization array

### Correct Recursive Solution

Upon further reflection, we realize that memoization isn't actually needed for this recursive approach. The recursion itself doesn't lead to overlapping subproblems that would benefit from memoization.

Each recursive call to find the maximum container at position i independently computes:
1. The maximum container with i as one endpoint (scanning all j < i)
2. The maximum container from previous positions (recursive call for i-1)

While this is still a recursive solution, it doesn't require the overhead of memoization.

### Analysis:
- **Time Complexity**: O(n²) - For every pivot, we scan from 0 to pivot, which results in n(n-1)/2 operations in total
- **Space Complexity**: O(1) - Without memoization, we only need call stack space which is O(n) in worst case, but no additional data structures

The recursive approach without memoization is cleaner but still has quadratic time complexity and times out on LeetCode for larger test cases.

The primary reason both Full Scan and Recursive approaches have O(n²) time complexity is the repeated scans:
  - In Full Scan: For every pivot, one full scan = n²
  - In Recursive: For every pivot, 0 to pivot scan = n(n-1)/2

### Implementation:

Here's the implementation showing both versions - with memoization (commented out) and the correct recursive approach:

```java
int[] memoize; // Used in the flawed DP approach
int dp(int[] height, int pivot) {
    // base
    if (pivot == 0) {
        return 0;
    }

    // use memoization (commented out - flawed approach)
    // if (memoize[pivot] != 0) return memoize[pivot];

    // max container with the pivot
    int max_container_pivot = 0;
    for(int j = 0; j < pivot; j++) {
        max_container_pivot = Math.max(max_container_pivot,
                    (pivot-j) * Math.min(height[pivot], height[j])
                );
    }

    // recursive relation - correct approach
    return Math.max(max_container_pivot, dp(height, pivot-1));
    
    // memoization approach (commented out - flawed)
    // memoize[pivot] = Math.max(max_container_pivot, dp(height, pivot-1));
    // return memoize[pivot];
}
```

## The Optimization Journey

Both our previous approaches have O(n²) time complexity. The key issue is that we're doing repeated scans:
- In the Repeated Full Scan (Brute Force), we scan all pairs.
- In the Recursive approach, for each position i, we scan all positions from 0 to i-1.

Can we avoid these repeated scans? Let's think about the problem differently.

### Understanding the Function to Optimize

We want to maximize: `(j-i) * min(height[i], height[j])`

To maximize this product, we need to:
1. Maximize the width `(j-i)`
2. Maximize the minimum height `min(height[i], height[j])`

These two factors work against each other - increasing the width often means accepting a lower minimum height. Finding the optimal balance is the key to solving this problem efficiently.

## Approach 3: Two Pointer Technique

### The Two Pointer Approach Explained:

1. Start with the widest possible container (left=0, right=n-1).
2. Calculate the area of this container.
3. To find a potentially larger container, we need to increase the minimum height.
4. Move the pointer that points to the smaller height inward:
   - If height[left] <= height[right], move left pointer to the right.
   - Otherwise, move right pointer to the left.
5. Continue this process until the pointers meet.

### The Insight Behind the Optimization

The key insight is realizing that when we move a pointer inward, the width of the container decreases. For the area to increase, the minimum height must increase by enough to compensate for the reduced width.

By always moving the pointer that points to the smaller height, we maximize our chances of finding a larger container. If we were to move the pointer with the larger height, the minimum height (and thus the container's area) would either stay the same or decrease, which isn't helpful.

### Analysis:
- **Time Complexity**: O(n) - We process each element at most once.
- **Space Complexity**: O(1) - We only use two pointers and a variable to track the maximum area.

The two-pointer approach offers an elegant solution with linear time complexity:

### Implementation:

```java
int twoPointer(int[] heights) {
    int left = 0;
    int right = heights.length-1;

    int maxContainer = 0;
    while(left < right) {
        int container = (right - left) * Math.min(heights[left], heights[right]);
        maxContainer = Math.max(maxContainer, container);

        // move the pointers
        if (heights[left] <= heights[right]) {
            left++;
        } else {
            right--;
        }
    }
    return maxContainer;
}
```

## Conclusion: Comparing the Approaches

Let's compare our three approaches:

| Approach | Time Complexity | Space Complexity | Description |
|----------|----------------|------------------|-------------|
| Repeated Full Scan (Brute Force) | O(n²) | O(1) | Check all possible pairs of heights |
| Recursive Solution | O(n²) | O(1) | Recursive approach without memoization overhead |
| Two Pointer | O(n) | O(1) | Strategically move pointers to find the optimal container |

The two-pointer approach offers the best performance with linear time complexity and constant space complexity. It's a beautiful example of how a problem that initially seems to require examining all pairs (a quadratic operation) can be solved in linear time with the right insight.

This optimization journey shows the importance of:
1. Thinking about problems from different perspectives
2. Understanding the trade-offs in the function we're trying to maximize
3. Finding ways to make greedy choices that don't sacrifice the optimal solution

The container with most water problem is a classic example of how algorithmic thinking can transform an inefficient solution into an elegant and efficient one.
