# Designing Algorithms

## 1. Introduction
The first few times I read a textbook on algorithms, it appeared magic. Some genius had an eureka moment. I believe thats the same for most of us. Just can't wrap our heads around algorithms. Eventually we tend to rely heavily on our capability to remember algorithms. That is a bad sign. Designing should employ techniques that aid understanding and application and not just memory.

The task is cut out. To re-read and to think costs time, perceivably an unaffordable asset. The perception or maya of the current day and age seeds a belief of falling behind others and that there is no catching up - a rat race. To deal with it is painful. One has to make a choice between perceived reality and fascination.

This page is a result of putting in time to re-read and think through thousands of pages of reading materials - textbooks, Google Scholar, blogs etc. The risk is real though, one may fall behind. But I have made peace with that. Personally, this is a way for me hopefully to carve a path out of rat race even if it's intermittent. I confess, my priority is biased by my fascination for the subject. The few intial reading has grabbed my attention. I believe it will be worth pursuing.

## 2. Approach
I simplify things, sometimes oversimplify. Bear with me. The quest is to identify techniques, understand it and apply it for simple and complex usecases including some leetcode problem solving.

## 3. Core Concepts

### 3.1 Simplified View
An algorithm is a set of instructions operating upon stored data. I don't think I can simplify this much further. To illustrate consider a simple instruction of adding two values:

```
    v1 = 2
    v2 = 4
    v1 + v2   # Adding values stored in memory locations v1 and v2
```

### 3.2 Simplified Computer Model
To understand how instructions are executed, we use a simple [RAM model](RAM.md). This theoretical model assumes:
- Each basic operation takes exactly one time step
- Each memory access takes constant time
- Memory is unbounded and can be directly accessed
- There is no memory hierarchy (like registers or cache)

### 3.3 Basic Operations
In our RAM model, we have two fundamental types of operations:

1. Memory Access Operations:
```
    read value from memory location
    write value to memory location
```

2. Compute Operations:
```
    arithmetic operations (add, subtract, multiply, divide)
    logical operations (and, or, not)
    comparison operations (equal, less than, greater than)
```

For example, adding two numbers involves:
```
    load v1 -> v0       # Read first value
    add v2, v0 -> v0    # Perform addition
    store v0 -> v3      # Write result
```

### 3.4 Algorithm Design Focus
Given this simplified model, designing efficient algorithms involves optimizing two aspects:
1. Minimizing the number of operations (computational complexity)
2. Organizing data access patterns (data structure design)

The process typically follows two phases:
1. First, design a correct solution regardless of efficiency
2. Then, optimize the solution by improving both computational and data access patterns

This forms the foundation for studying algorithm design techniques and data structures.

## 4. Design Techniques
To sum up, the design techniques to craft and optimize algorithms involves structuring: 
+ [Instructions](instructiondesign/InstructionDesign.md)  instruction optimization, and
+ [Data access](datastructure/README.md)   data/memory access optimization.

## 5. Scope Note
Extending above model to IO, and network additional involes additonal techniques structuring:
+ IO -> ex. filesystems.
+ Network/Remote calls  -> ex. distributed computing

This currently is beyong the scope of this blog. Will stick to the simple RAM model - CPU and in-memory only.