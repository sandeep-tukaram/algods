## Recursion/Subproblems approach
Recursion approach is probably the most prominent also basis of other techniques such as dynamic programming. Recursion is a mathematical term. What helped me more is to think in terms of subproblems. The big idea is simple. Split a bigger problem into smaller subproblems. Then, derive the solution of the original problem using the solutions to the subproblems.

General pseudocode has a recursive structure.
```
    original problem  {
        solve subproblem1, subproblem2 ...         
        derive solution to the original problem reusing solution to the subproblems.
    }
```

Let me illustrate the thought process with a small example. Say, we have a problem to sort an array of size n. The given problem size is n. 
For the sake of argument, lets say we have an algorithm to sort the numbers. The question is would that algorithm also apply to a problem of say size 
n-1 ? The intuitive answer is yes. It should be. If I can sort n elements, using the same algorithm I should be able to sort a problem with n-1 elements. 

Take a pause here and think about what is being said. 

In a pseudocode notation, lets say we have a function sort(A) which encapsulates an sorting algorithm. Ideally this will be generic, doesn't matter what the size of A is. 

sort(A[1..n]) is the given problem, sorts n elements of A.
sort(A[1..n-1]) sorts the first n-1 elements of A. 

The technique of recursion now asks whether we can reuse the solution of the subproblem sort(A[1..n-1]) to derive solution for sort(A[1..n]). In other words, how can we place element A[n] in the sorted A[1..n-1]? Think about this for a moment. This answer leads to what is popularly known as insertion sorting. 

One again, the idea is simple. Given a problem, can we construct it's solution derived from reusing the solution to the subproblems. A subproblem is nothing but the same problem applied to a smaller size of the input.


How to split ? There are few inuitive ways (n): 
+ incremental ->  subproblem(n - k) + residue(k). Usually k = 1. 
+ divide -> subproblem(n/k). Not all subproblems have to be equal in size though.
+ partition -> subproblem(k-1) + residue(1) + subproblem(n-k). Residue in this case is referred to as a pivot. There can be multiple such pivots.
