# algods
This is a repository to study and implement algorithms and data structures. By study I mean notes reading books, articles, blogs etc. 


## Algorithms 
Given a problem specification including input and output relation, an algorithm is a step by step computational instructions to solve the problem. The algorithm must be useful for all instances of the problem. It must be correct. It must be practical meaning efficient. A problem can have multiple algorithms, and the most efficient one is the best. 

### Problems

Problem specifies the provided input and the expected output relation in general terms [1]. These computational problems which, as far as I understand,  means solvable by algorithms using a programming language and a computer. 

Some of the problems are:
- Sorting
- Searching
- Optimization
- Graph problems
- String problems
- Computational geometry
- Matrix problems
etc.

### Solutions

    Input  -->  Algorithm (computational instructions)  -->  Output

The programming language provides the constructs to express the algorithm. The algorithm is compiled into an executable program run on a computer. The computer provides the resources to execute the program. 

                            Algorithm (Program)
    Input  --->     ------------------------------------               --->  Output
                        Computer (CPU, Memory, etc.)

### RAM model
RAM model is apparently the simplest model of computer and popular in textbooks. Few pointers on this model. 
#### CPU
+ a single processor.
+ executes instructions sequentially, no concurrent execution.
+ all instructions take same amount of time.
+ arithmetic instructions - add, subtract, multiply, divide, modulo, floor, ceiling.
+ data movement instructions - load, store, copy.
+ control flow instructions - conditional branch, unconditional branch, function call, return.
    
#### Memory
+ unlimited in-memory storage.
+ memory-hierarchy is not considered. No cache, no disk IO etc.

#### to simplify, take it with a grain of salt.
+ all instructions take same amount of time. Read -> Cormen discuses whether exponential operation is constant time [1].
+ all memory accesses take same amount of time.


### Efficiency
Algorithms (programs) use computer resources to execute. The resources are time (CPU time) and space (memory). Algorithm's efficiency is measured by time and space. Less usage of CPU  and memory is more efficient. Each problem can have multiple algorithm solutions. For example, sorting can be done by bubble sort, selection sort, insertion sort, merge sort, quick sort, heap sort, etc. For a given instance, some algorithms are more efficient than others, meaning their usage of CPU and Memory is less.

### Correctness
Correctness of algorithm has to be proven. This is usally done using mathematical tools and reasoning.

## Techniques
When I first read books on algorithms, the design aspect of algorithms at best appeared random. Some genius had an eureka moment and voila! an algorithm is born. It took many repeated readings to realize that algorithm are designed using techniques and not magic. 


### Subproblems technique
The big idea is simple. Split a problem into smaller problems (subproblems). Solve the subproblems and reuse their solution to solve the original problem. The general structure of the idea looks like below. 

    solve problem  {
        solve subproblem1 {}, subproblem2 {} ...        // split/divide
        reuse solutions of all the subproblems.         // combine
    }

There are few ways to split a problem into subproblems 
+ incremental
+ divide
+ partition

### Optimization

### Dynamic Programming
Dynamic Programming is a technique that breaks a problem into smaller subproblems, solves each subproblem, and then combines the solutions to solve the original problem.

### Greedy
Greedy is a technique that makes the best choice at each step.

### Backtracking
Backtracking is a technique that tries to solve a problem by trying to build a solution incrementally, and abandoning a solution that fails to meet the constraints of the problem.

### Branch and Bound
Branch and Bound is a technique that tries to solve a problem by trying to build a solution incrementally, and abandoning a solution that fails to meet the constraints of the problem.

### Randomized Algorithms
Randomized Algorithms are techniques that use randomization to solve problems.

### Amortized Analysis
Amortized Analysis is a technique to analyze the average performance of an algorithm over a sequence of operations.
    


## Data Structures 
Data structures are ways to store and organize data in a computer so that it can be used efficiently.


## It's Fundamental ?
Fundamental means reusable. That computational problems can be solved by


## Why MD?
Markdown is suitable for blogging. There are tools that convert md files to web pages.
Don't want to be bothered about HTML and CSS unless required.
Markdown is flexible - can include HTML, and CSS if required.


## References
[1] Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2001). Introduction to algorithms (3rd ed.). MIT Press.
