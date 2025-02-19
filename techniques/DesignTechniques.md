# Design techniques

When I first read books on algorithms, the design aspect of algorithms at best appeared random. Some genius had an eureka moment and voila! It took many repeated readings to realize the usage of design techniques. 


## Subproblems approach
The big idea is simple. Split a problem into smaller problems (subproblems). Solve the subproblems and reuse their solution to solve the original problem. The general structure of the idea looks like below. 

    solve problem  {
        solve subproblem1 {}, subproblem2 {} ...        // split/divide
        reuse solutions of all the subproblems.         // combine
    }

There are few ways to split a problem into subproblems 
+ incremental
+ divide
+ partition

## Optimization
Two techniques is what I have come across till now. [1]
+ Greedy approach - optimize every step, leads to globally optimal solution. Proving correctness is a challenge.
+ Dynamic programming - overlapping subproblems

## Randomized algorithm
+ Randomized quicksort -> uses randomization to increase the probably of balanced partition.