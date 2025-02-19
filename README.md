Go to [Sorting](sorting/docs/README.md)

# algods
Repository contains notes, code etc related to algo and ds. Purpose is mostly self serving - to better understand the space. Hopefully it helps others as well.

## AlgoDS is fundamental ?
I will try to stick to one principle - Keep it Simple and Intuitive (KISI)

Based on that principle, I reduce fundamental to mean reusable. It's crude, but simple. Reusable, reapplicable etc is a tangible concept as a developer.

Two fundamental (reusable) aspects of AlgoDS are: 
+ Design techniques
+ Datastructures

Will structure problem solving based on these fundamentals.

--- 
## Problems

Problem specifies the provided input and the expected output relation in general terms.

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

Using a programming language algorithms are implemented and compiled into an executable which is run on a computer. The computer provides the resources - CPU, Memory etc.

                            Algorithm (Program)
    Input  --->     ------------------------------------               --->  Output
                        Computer (CPU, Memory, etc.)


### Efficiency
Algorithm's efficiency is measured in time and space. Less usage of CPU  and memory more efficient the algorithm. Each problem can have multiple algorithm solutions. For example, sorting can be done by bubble sort, selection sort, insertion sort, merge sort, quick sort, heap sort, etc. For a given instance, some algorithms are more efficient than others, meaning their usage of CPU and Memory is lesser.

Interestingly one wants to know what's the lower (best case) bound and what's the upper (worst case) bound of resource usage. These are mathematically denoted as \(\Omega\) and \(O\) respectively. \(\Theta\) indicates both upper and lower bounds.

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
