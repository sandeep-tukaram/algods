Go to [Sorting](sorting/README.md)

# algods
Repository contains notes, code etc related to algo and ds. Purpose is mostly self serving - to better understand the space. Hopefully it helps others as well.

## AlgoDS is fundamental ?
Something fundamental is reusable. While copy-paste is often criticized, I believe it's a valuable form of reuse that helps prioritize learning. The key isn't whether to copy-paste, but rather deciding what to copy-paste versus what to deeply understand. This decision helps focus our learning efforts where they matter most.

There are two aspects of AlgoDS that are fundamental (reusable). 
+ Algorithm design techniques
+ Datastructures

Will try to solve problems using these two fundamental perspectives. The repository will contain code. Again, the intent and style is personal. Hope it helps larger audience.

--- 
## Problems

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

--- 
### Algorithm Solutions

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

--- 
## Design techniques
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
Two techniques is what I have come across till now. [1]
+ Greedy approach - optimize every step, leads to globally optimal solution. Proving correctness is a challenge.
+ Dynamic programming - overlapping subproblems

### Randomized algorithm
+ Randomized quicksort -> uses randomization to increase the probably of balanced partition.

---
## Data Structures 
Data structure is a way to recognize relations between the elements in a input and take advantage of it. It involves a tradeoff, achieving time efficiency for some of the operations while inefficiency for some of the other operations.

there are plenty of data structures 
+ linear - array, linked list, stack, queue
+ hierarchical - heap, tree variants 
+ dictionaries - hashtable, kv maps 
+ graphs 
etc.



## Why MD?
Markdown is suitable for blogging. There are tools that convert md files to web pages.
Don't want to be bothered about HTML and CSS unless required.
Markdown is flexible - can include HTML, and CSS if required.


## References
[1] Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2001). Introduction to algorithms (3rd ed.). MIT Press.
