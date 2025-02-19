Go to [Sorting](sorting/docs/README.md)

Repository contains notes, code etc related to algo and ds. Purpose is mostly self serving - to better understand the space. Hopefully it helps others as well.

## AlgoDS is fundamental ?
It helps to keep things simple and intuitive. What does fundamental mean in simple terms? Think reusables. It's crude, but simplifyies. As a developer, reusable is a everyday tangible concept.

Two reusable aspects of AlgoDS are: 
+ [Design techniques](techniques/DesignTechniques.md)
+ [Datastructures](ds/README.md)

Mostly every computational problem can be solved using these two reusables. Implicit is that the two constitute an exhaustive list. I would argue so. Think of a program in its basic - instructions and data. Design techniques optimize on reducing the number of instructions to solve a problem. Data structures optimize on access paths by organizing data/elements using the latent relations. 

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

Interestingly one wants to know what's the lower (best case) bound and what's the upper (worst case) bound of resource usage. These are mathematically denoted as Ω (Omega) and O (Big O) respectively. Θ (Theta) indicates both upper and lower bounds.

### Correctness
Correctness of algorithm has to be proven. This is usally done using mathematical tools and reasoning.

---

## Why MD?
Markdown is suitable for blogging. There are tools that convert md files to web pages.
Don't want to be bothered about HTML and CSS unless required.
Markdown is flexible - can include HTML, and CSS if required.

--- 
## References
[1] Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2001). Introduction to algorithms (3rd ed.). MIT Press.
