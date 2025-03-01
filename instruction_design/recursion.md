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

--- 

## Patterns
Let's explore three main ways to break down problems recursively, using everyday examples you're familiar with:

### Incremental Pattern
Imagine eating a sandwich (yes, really!). How do you tackle it? One bite at a time, right? This is exactly how incremental recursion works:
- You have a big sandwich (your problem)
- You take one bite (handle one piece)
- Now you have a slightly smaller sandwich (n-1 problem)
- Keep going until you're down to the last bite

This is the simplest recursive pattern: take one piece off, solve the rest. It's like saying "I'll handle this one thing, and assume the rest will work out." This is exactly what insertion sort does - it takes one number and figures out where to put it in an already-sorted list.

When to use it? When your problem naturally breaks down one piece at a time, like:
- Adding numbers in a list
- Counting characters in a string
- Walking through a linked list

### Divide Pattern
Ever looked up a name in a phone book? (Okay, maybe Google is more your thing, but stick with me!) Here's what you naturally do:
- Open the book roughly in the middle
- Is your name before or after?
- Pick that half and split it again
- Keep going until you find your name

This is divide pattern in action! Instead of taking one bite, you're cutting the problem in half each time. It's super efficient, for the phonebook example, because each step eliminates half the remaining work. Think about it - you'd never start at page 1 and check every name, right? Elimination is not the only way to derive solution to the original problem. Sometimes the solution to the original problem is dervied by combining solutions to all the subproblems. Mergsort employs solution to all subproblems.

### Partition Pattern
Let's say you're organizing books by height. Here's a smart way:
- Pick any book as your "measuring stick" (we call this the pivot)
- Put shorter books on the left
- Put taller books on the right
- Now you have three groups: shorter, pivot, and taller
- Repeat for each group. The pivot is already in it's sorted place in the original problem.

This is partition pattern - using one element to split things into three parts: less than, equal to, and greater than. It's like having a sorting party where everyone knows exactly where to go based on the height of that one book.

This pattern is great when:
- You need to organize things around a specific value
- You're comfortable with the fact that splits might not be even
- You want to divide things into logical groups

The beauty of these patterns is that once you start seeing them, you'll notice them everywhere - from sorting algorithms to real-world problem solving.