# Array
--- 
## Structure

a. Components:
  As with any datastructure there two things to consider when it comes to components -
  1. memory.
  2. elements

b. Relations:
  1. memory is contiguous and bounded. 
  2. array as a datastructure doesn't employ relations between elements to position them.


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
    * direct access - a position in array is a direct access to the corresponding word (other memory unit) in memory. This is usually referred to as direct access.  
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
