# Recursio/Subproblem Technique

## The Idea
When people talk about recursion, they often get caught up in the mathematical definition. Let's think about it differently - it's really just about solving problems by breaking them into smaller versions of themselves. Think of it like solving a big puzzle by first figuring out smaller pieces of it.

The core idea is beautifully simple and worth repeating:
1. Break your problem into smaller subproblems
2. Solve those smaller subproblems
3. Combine their solutions to solve your original problem

Every recursive solution follows this pattern:
```
solve original_problem {
    1. Break into smaller subproblems and residuals. Residuals are not the smaller versions of the original problem.
    2. Solve each subproblem. Actually assume solved. This is the Trick!
    3. Combine solutions and residuals. Derive the solution to the original_problem.
}
```

### Sorting Example
Let's make this concrete with a classic example: sorting an array of numbers. Here's the key insight - if you can sort n numbers, you can definitely sort n-1 numbers, right? This is the recursive thinking we're looking for!

Take a moment to let that sink in - it's a powerful idea.

Let's break it down with some pseudocode. Say we have an array A[1..n]:
- sort(A[1..n]) is our main problem: sorting n elements
- sort(A[1..n-1]) is our smaller subproblem: sorting n-1 elements

Here's where the magic of recursive thinking comes in: imagine we've already solved the smaller problem (sorting n-1 elements). Don't worry about how - just assume it's done! Now our big problem becomes much simpler: "How do we insert one more number into an already sorted array?" This is exactly what insertion sort does!

Remember: The key to understanding recursion is being comfortable with this "assume the smaller problem is solved" thinking. It comes up again and again.

## Common Patterns
There are three main ways to break down problems recursively. You'll see these patterns everywhere:

```
1. Incremental: Break into (n-k) + k elements
   - Usually k=1, like in our sorting example
   - Example: Insertion sort

2. Divide: Split into n/k sized pieces
   - Pieces don't need to be exactly equal
   - Example: Merge sort splits into n/2 pieces

3. Partition: Split into three parts
   - left_part(k-1) + pivot(1) + right_part(n-k)
   - Example: Quicksort uses a pivot to divide and conquer
```

The beauty of recursion is that once you recognize these patterns, you'll start seeing them everywhere in problem-solving!