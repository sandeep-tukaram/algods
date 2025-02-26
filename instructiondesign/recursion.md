## Recursion/Subproblems approach
Recursion is a mathematical term. What helped me more is to think in terms of subproblems. The big idea is simple. Split a bigger problem into smaller subproblems. Then, derive the solution of the original problem using the solutions to the subproblems.

General pseudocode has a recursive structure.
```
    original problem  {
        solve subproblem1, subproblem2 ...         
        derive solution to the original problem reusing solution to the subproblems.
    }
```

How to split ? There are few inuitive ways (n): 
+ incremental ->  subproblem(n - k) + residue(k). Usually k = 1. 
+ divide -> subproblem(n/k). Not all subproblems have to be equal in size though.
+ partition -> subproblem(k-1) + residue(1) + subproblem(n-k). Residue in this case is referred to as a pivot. There can be multiple such pivots.
