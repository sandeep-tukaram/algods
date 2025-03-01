# Recursion/Subproblem Technique

## The Idea - Subproblems
When people talk about recursion, they often get caught up in the mathematical definition. Let's think about it differently - it's really just about solving problems by breaking them into smaller versions of themselves. Subproblems is the big idea. Think of it like solving a big puzzle by first figuring out smaller pieces of it.

The core idea is beautifully simple and worth repeating:
1. Break your problem into smaller subproblems and residuals. Residuals are not the smaller versions of the original problem.
2. Solve those smaller subproblems. Actually assume it solved. This is the Trick!
3. Combine their solutions to solve your original problem

In a pseudocode:
```
solve problem(original) {
    // handle base case. 
    1. usually the subproblem size equals 1.

    // handle recursion - for all subproblems satisfying conditionals, if any
    2. problem(subproblem1), problem(subproblem2).. etc. 

    // derive solution to original problem
    3. Combine solutions of the subproblems and the residuals.
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

--- 

## Subproblem Patterns
Let's explore three main ways to break down problems recursively, using everyday examples you're familiar with:

### Incremental Split
Imagine eating a sandwich (yes, really!). How do you tackle it? One bite at a time, right? This is exactly how incremental recursion works:
- You have a big sandwich (your problem)
- You take one bite (handle one piece)
- Now you have a slightly smaller sandwich (n-1 problem)
- Keep going until you're down to the last bite

This is the simplest recursive pattern: take one piece off, solve the rest. It's like saying "I'll handle this one thing, and assume the rest will work out." This is exactly what insertion sort does - it takes one number and figures out where to place it in an already-sorted list.

### Divide
Think about merging two sorted piles of cards. Here's what you naturally do:
- Split your pile roughly in half
- Sort each half separately
- Merge the two sorted halves together
- Keep doing this until you're down to single cards

This is the divide pattern in action! Instead of taking one bite, you're cutting the problem in half each time and then combining solutions. It's super efficient because you can work on both halves independently and then merge them together. This is exactly how mergesort works - divide into smaller sorted arrays, then combine them back up. The key insight is that merging two sorted lists is much easier than sorting from scratch!

### Partition
Looking up a name in a phone book is a perfect example of partition:
- Pick a page in the middle as your pivot point
- Is your name before or after? We are working with two partitions here. Name appears in one of them only
- Focus only on that partition and pick a new pivot - the middle.
- Keep going until you find your name

This is partition pattern - using a pivot to split a problem into subproblems usually referred as paritions. The above example, to dervive solution to the original problem, disregards one of the partitions and focues on the other. Problems may use more than one piviot, meaning more than two paritions, and solve all partitions and dervive the solution to the original problem.

The beauty of these patterns is that once you start seeing them, you'll notice them everywhere - from sorting algorithms to complex real-world problems.