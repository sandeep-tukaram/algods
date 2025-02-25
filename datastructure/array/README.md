# Structure -> Behavior (Systems Thinking)
--- 
## Structure

a. Components:
  An array has two components, one is the elements that are placed in the array the other is the memory itself where an element gets placed. Its key to understand that these two are different concepts. Sometimes the value of the element matches the position, doesn't mean they are same things.
  1. elements
      * uniform datatype -> all elements of an array have the same data type.
      * empty -> positions can be unfilled.
    

  2. memory/position/location
      * memory is allocated/reserved.
      * contiguous block of memory.
      * bounded bock of memory. [start, end]. Usually start is represented as 0, so in a n sized array position n-1 holds the nth element. A[0, n), A[0..n), 
      A[0, n-1], A[1, n] etc are some valid notaions used to represent an Array A of size n.

b. Relations:
  1. array as a datastructure doesn't employ relations between elements to position them.
  2. memory is contiguous.

c. Function/Goals:
  The fundamental goal of array is random access. Which means, store and retrieve an element directly without having to go through elements before/after it in the structure. 

  Ramdom access translates into following operations.
  1. get(i), A[i]
  2. set(i, e), A[i] = e. Overrides previous element at i.
  
  Both get() and set() are O(1). Arrays are optimized for getting the element and setting the element by position.

---

## Behavior - operation performance (time and space) and error
Behavior is latent in the structure. Events suppress or release the latent behavior.
A simple framework to understand behavior in algo/DS is to look at the correctness (or error) and the performance (time and space).

1. due to element:
    * error
      + Incompatible data type error - when adding an element with a dataype not compatible with array datatype declaration.
    * performance
      + Fragmentation - Empty positions may lead to fragmented array. 
          Compaction optimizes the performance. (TODO - code)

3. due to memory:
    * performance -> when does memory allocation happen 
      + compile-time(static ?) - shouldn't apply for interprented languages. (TODO - explore)
      + runtime(dynamic)- languagues such as Java and C provision runtime allocation. Java compiles to bytecode which is then interpreted.
    * varying size array - langauges such as Java do not provide inbuilt varying size array. These will have to be custom built.
      + shadowing or copy-on-write -> copy an array to a bigger sized array. (TODO - code)
      + linking multiple fixed size array -> similar to block linked list. (TODO - code)
      + in either case, the scheduling of the new array (allocation) is an optimization/tuning problem.
    * contiguous memory
      + next(i, k) -> returns element at i+k position. O(1)
      + previous(i, k) - > returns elemnt i-k position. O(1)
    * error
      + insufficient memory - heap memory is insufficient/array is too large. OutOfMemoryError (java).
      + index out of bound - if the position of the array is beyond the allocated contiguous memory blocks. i < 0 or i >= n

4. due to relations:
    * performance ->
       + scan O(n) - the only way to find an element is to scan or linear search the array. (TODO - code)
    * there can be duplicates.

5. due to functions/api:
    * insert(e, i) {
      // shift right all elements starting at i. start from the end.
      for (k: n->i) set(k+1) = get(k) 
      set(e, i);
    }
    * delete(e,i) {
      shift left all elements starting at i + 1.  
      for(k: i-> n) set(i) = get(i+1);
    }
    * both insert and delete are O(n) operations. Arrays not optimal for insert and delete when compared to get/set. LinkedList is one the datastructure that does a O(1) 
    * fragmentation -> occurs when there are empty spaces interspersed. 
    * compaction -> optimization to consolidate all non-empty spaces together. Refer to the code.
    * error
      + overflow -> when insert(e), tail >= n
      + underflow -> when delete(e), tail <=0
