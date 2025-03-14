# Data Structures 
I'm really not sure whether there is a standard definition for datastructure. I take a system's view and employ first principles thinking.

--- 
## System's View - Structure and Behavior

Every system has a structure which gives rise to a latent behavior. Events supress or releases the latent behavior.
+ structure
+ behavior
+ event

For each datastructure, I will study the structure. From the structure I will try and understand the behavior of the datastructure. There is generic framework we can work with to examine structure and behavior. 

## Structure 
In system's thining struture is made up of components, relations between the components, and goals intended. 

### Components
A datastructure stores elements in memory locations. Take the most simplest of this arrangement - a variable. A variable stores a value. In pseudocode notation, x is the variable and value1 is the value that x stores. This is for illustraion purposes only not representative of any programming language. 

```
    x = value1

```

To think in terms of a RAM model, x is the handle to memory location which stores value1. For an instruction to operate on this memory location using the handle x. For example, below instruction increments the value of x. We will assume the incremented value is written back to the same memory location to which x was earlier pointing to, it doesn't matter for the purpose of this discussion.

```
    x++;

```

Variable is useful for a single element. Imagine if we had to store a collection of elements. We definitely need a set of memory locations. And we assume each memory location can store a single element. The question that arise then is which element goes where? It can be random or have a scheme.  If we want to use a scheme, we need to think for what purpose and on what basis do we structure the scheme. These are fundamental questions one can think of when dealing with a problem to store a collection of elements. 

To sum up two components make up the structure 
1. memory locations
2. elements

### Relations
Going back to system's thinking, we ask, is/are there Relations between the components? Since we have only two components when it comes to datastructure, the exhausitve list of relations include, with examples
+ relation between memory locations -> contiguous, links
+ relation between elements -> order relation
+ relation between element and memory locations -> placement scheme.


### Relations between Memory locations
We need a set of memory locations to store a collection of elements. We have already made an assumption that each memory location stores a single element only. Is there a relation between the memory locations ? Two variants of relations one usually finds 
+ contiguous locations
+ linked locations


Datastructures incorporate relation when organizing elements.


### Function/Goal
In the context of programming, the goal of a program is to perform a computational task correct and efficient. Designing correct imply error handling. Efficiency in time and space technically translate to CPU(time) and Memory(space) usage. Datastructures are modelled as objects with operations. The goal in the context of datastructure is to provide optimial operations to performan computationl task efficiently and correctly. It is not possible to optimize all operations required by a program. There is trade-off usually. As a developer these tradeoff are important when it comes to select the right datastructure for a program. 

---

## Behavior - performance & error
Behavior is latent. Meaning it's induced by the structure. Events suppress or release the behavior. Think of events as API/method calls to the datastructure object. We can look at each structural apsect discussed above and derive a general framework to discuss behavior. 

### Elements & Memory Locations - Error (correctness behavior)
A datastructure controls the data type of an element that it allows to be stored in the memory locations. The datatype can uniform or varied. Python array and tuples are examples respectively. Java works with a fixed/compatible data type concept. 

+ Whenever a client stores an element in a datastructure it checks for the datatype constraints and throws/returns appropriate error if any. 
+ There may be a situation, especially with dynamic datastructures, when memory is exhausted. In programming languages like java, there is stack and heap either of which can run out of space. The datastructure which would invoke the system calls would pass on the error messages to the client.

### Relations 

#### Element relations - Performance
Datastructure use or discard relations between elements. One of the prominent relation encountered in the  datastructre textbooks is the order relation. Most of the linear datastructures discard element relations. While many of the hierarchical datastructures incorporate the elemental relations in their structures. When I say incorporate I mean that the position of the element is determined by the order relation among elements. I'm not aware of other kinds of relations. Will include and expand on them in future when I find one. 

When datastructures discard element relations, the memory location cannot be effectively used to quickly access the required element(s). In other words, query operations like search(key) etc are not optimized. 

#### Memory relations - Performance and Error
Linear and hierarchical datastructures is already mentioned above. It's not be confused with the memory location however. The memoray locations can be contiguous or linked. Though they appear synonyms to linear and hierarchical, its different.  Heap is a hierarchical datastructure but can be store in an array with contiguous memory. Its the hardware part of the datastructure. How are the locations allocated. Two that I'm aware of are contiguous or block memory and links or nodes. A block is efficient because CPU can do something called prefecting, its also referred to as localization. Links however are discrete memory locations which will require backand forth between CPU register and main memory as when the links are resolved to a memory location. Because the memory can be discrete, CPU prefetching may not be very effective and in fact be counterproductive as the cache memory could have been used to store other variables. 

While block is performant there is an aspect of memory issue that one has be careful. First the block memory is bounded. An array, for example, has a bounded memory. Datastructure throws error when client code accesses memory outside the bounds. This is not universal when it comes to implementation, I have seen arguments/code where a client is expected to be careful since the bounds are already made explicit. But usually the datastructure as system throws an erorr when such an event occurs. 

The hardware aspect is true for both block and links. When exhausted the system throws error. The datastructure passes back the error message to the client.

### Memory Element relations - performance
To make this relation explicit is kind of probably overdoing. However, I wanted to distinguish between order relation and hashing. Ordering relation also maps an elements to a location in memory, however the mapping function is derived from the elemental relation. In a hashing situation, the elemental relation is not a bigger play, I may be wrong. Its the hashing function that determines where an element ends up. For example, in a simple modular hashing the elements may have a ID field which implies ordering however, its modular function that actually determines where the elements ends up stored.  

As mentioned above, elements are accessed by memory location. The quicker we can derive the memory location the faster the access. Hashing is probably the quickest in that sense, the memory location is directly calculated based on a hashing function. Above, in the element ordering a shortest path is taken from say a root node. This is also true when it comes to store a data - direct memory location calculation in hashing vs shortest path in ordered elements.


### Functions/Goals - performance
While there can be many operations that can be performed on a datastructure, the functional api's captures the operations that the datastructure is optimized for. The non-functional operations usually suffer because of trade-offs that occur because of the structuring.


--- 

Datastructure Index 
+ linear - [array](array/README.md), linked list, stack (LIFO), queue (FIFO)
+ hierarchical - heap, tree variants
+ dictionaries - hashtable, kv maps
+ graphs
etc.
