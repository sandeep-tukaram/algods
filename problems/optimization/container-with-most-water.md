# Optimizing the Container With Most Water Problem

## Introduction

The "Container With Most Water" is a classic algorithmic problem that asks us to find the maximum amount of water a container can hold, given an array of heights. Each element in the array represents a height of a vertical line, and the width between any two lines is their index difference.

In mathematical terms, we need to find two indices `i` and `j` that maximize the area calculated as:
```
Area = min(height[i], height[j]) * (j - i)
```

The problem tests our ability to optimize from a simple brute force approach to an elegant linear time solution. Let's journey through three different approaches, from the most intuitive to the most optimized.

## Approach 1: Repeated Full Scan (Brute Force)

The most straightforward approach is to check all possible pairs of lines and calculate the area they form. This is a classic brute force approach where we:

1. Iterate through all pairs of lines (i, j)
2. Calculate the area of the container formed by each pair
3. Keep track of the maximum area found

### Analysis:
- **Time Complexity**: O(n²) - We have n choices for the left boundary and n choices for the right boundary, resulting in n² operations.
- **Space Complexity**: O(1) - We only need a single variable to track the maximum container.

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

## Approach 2: Dynamic Programming

Can we do better? Let's try a dynamic programming approach.

### The DP Approach Explained:

1. We define a subproblem `C(i)` as the maximum container between indices 0 and i.
2. Base case: `C(0) = 0` (a single line can't form a container)
3. Recursive relation:
   ```
   C(i) = Max {
            C(i-1),                              // Max container without using the current line
            max((i-j) * min(height[i], height[j])) for all j < i  // Max container with the current line
          }
   ```

In this approach, we view the problem as finding the maximum container for each ending position, and we use memoization to avoid redundant calculations.

### Analysis:
- **Time Complexity**: O(n²) - For each pivot, we need to check all previous positions.
- **Space Complexity**: O(n) - We store solutions to n subproblems.

Despite using memoization, this approach still has quadratic time complexity and doesn't provide the improvement we hoped for. It also times out on LeetCode for larger test cases.

### Implementation:

```java
int[] memoize;
int dp(int[] height, int pivot) {
    // base
    if (pivot == 0) {
        return 0;
    }

    // use memoization
    if (memoize[pivot] != 0) return memoize[pivot];

    // max container with the pivot
    int max_container_pivot = 0;
    for(int j = 0; j < pivot; j++) {
        max_container_pivot = Math.max(max_container_pivot, 
                    (pivot-j) * Math.min(height[pivot], height[j])
                );
    }

    // recursive relation
    memoize[pivot] = Math.max(max_container_pivot, dp(height, pivot-1));
    return memoize[pivot];
}
```

## The Optimization Journey

Both our previous approaches have O(n²) time complexity. The key issue is that we're doing repeated scans:
- In the Repeated Full Scan (Brute Force), we scan all pairs.
- In the DP approach, for each position i, we scan all positions from 0 to i-1.

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
| Repeated Full Scan (Brute Force) | O(n²) | O(1) | Check all possible pairs of lines |
| Dynamic Programming | O(n²) | O(n) | Use memoization to avoid redundant calculations |
| Two Pointer | O(n) | O(1) | Strategically move pointers to find the optimal container |

The two-pointer approach offers the best performance with linear time complexity and constant space complexity. It's a beautiful example of how a problem that initially seems to require examining all pairs (a quadratic operation) can be solved in linear time with the right insight.

This optimization journey shows the importance of:
1. Thinking about problems from different perspectives
2. Understanding the trade-offs in the function we're trying to maximize
3. Finding ways to make greedy choices that don't sacrifice the optimal solution

The container with most water problem is a classic example of how algorithmic thinking can transform an inefficient solution into an elegant and efficient one.

