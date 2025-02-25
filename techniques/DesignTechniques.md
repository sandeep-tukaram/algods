# Instruction design techniques

When I first read books on algorithms, the design aspect of algorithms at best appeared random. Some genius had an eureka moment and voila! It took many repeated readings to realize the underlying techniques.

--- 

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

--- 

## Optimization techniques
Two techniques is what I have come across till now. [1]
+ Greedy approach - optimize every step, leads to globally optimal solution. Proving correctness is a challenge.
+ Dynamic programming - overlapping subproblems

## Randomized algorithm
+ Randomized quicksort -> uses randomization to increase the probably of balanced partition.