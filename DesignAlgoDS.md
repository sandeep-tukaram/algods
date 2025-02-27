# Designing Algorithms

The first few times I read a textbook on algorithms, it appeared magic. Some genius had an eureka moment. I believe thats the same for most of us. Just can't wrap our heads around algorithms. Eventually we tend to rely heavily on our capability to remember algorithms. That is a bad sign. Designing should employ techniques that aid understanding and application and not just memory. 

The task is cut out. To re-read and to think costs time, perceivably an unaffordable asset. The perception or maya of the current day and age seeds a belief of falling behind others and that there is no catching up - a rat race. To deal with it is painful. One has to make a choice between perceived reality and fascination. This page is a result of putting in time to re-read and think through thousands of pages of reading materials - textbooks, Google Scholar, blogs etc. The risk is real though, one may fall behind. But I have made peace with that. Personally, this is a way for me hopefully to carve a path out of rat race even if it's intermittent. I confess, my priority is biased by my fascination for the subject. The few intial reading has grabbed my attention. I believe it will be worth pursuing.

--- 

I simplify things, sometimes oversimplify. Bear with me. The quest is to identify techniques, understand it and apply it for simple and complex usecases including some leetcode problem solving.

## Simplfied View
An algorithm is a set of instructions operating upon stored data. I don't think I can simplify this much futher. To illustrate consider a simple instruction of adding to variables. 

```
    v1 = 2
    v2 = 4
    v1 + v2   ->   add (v1, v2) is a add instruction on variables v1 and v2.
```

### Simplfied Computer Model
To look at how this simple instruction is executed on a computer we assume a simple [RAM model](RAM.md).


### Simplfied Language
Using a made up simple assembly language the sequence of instruction would look like 

```
    load v1 -> v0       
    add v2, v0 -> v0
    store v0 -> v3
```

Think of v0, v1, v2  and v3 as memory locations. CPU can access any of these. Remember, this is a made up assembly language. The actual instructions differ based on computer architectures.

The CPU loads v1 and v2 from the memory. It then exectues ADD operation on v1 and v2. Stores the result in v3 back into the memory. So, in our simplified model two things happen. 
+ data/memory access operations  -> load v1, v2 ;store v3
+ instruction/compute operations -> v1 + v2

Assuming this simple a setup, there are only two major operations data access and compute. To craft and optimize an algorithm to solve a problem hence involves working with two set of operations only. We need techniques to structure our data access and to structure our compute operations. Firstly the structure should yield in correct solutions and second the strucure should be efficient to be practical. First use techniques come up with a correct solution. Once it's established that a solution exists, use techniques to refine the solution to optimize on instructions and data access.

To sum up, the design techniques to craft and optimize algorithms involves structuring: 
+ [Instructions](instructiondesign/InstructionDesign.md)  instruction optimization, and
+ [Data access](datastructure/README.md)   data/memory access optimization.


--- 

Extending above model to IO, and network additional involes additonal techniques structuring :
+ IO -> ex. filesystems.
+ Network/Remote calls  -> ex. distributed computing

This currently is beyong the scope of this blog. Will stick to the simple RAM model - CPU and in-memory only.