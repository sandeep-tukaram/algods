# Structure -> Behavior (Systems Thinking)
--- 
## Structure

a. Components:
  1. elements
      * uniform datatype -> all elements of an array have the same data type.
      * empty -> positions can be unfilled.
    

  2. memory/position/location
      * memory is allocated/reserved.
      * contiguous block of memory.
      * fixed/varying size array.

b. Relations:
  1. array as a datastructure doesn't employ relations between elements to position them.

c. Function/API:
  1. get(i), A[i]
  2. set(e, i), A[i] = e. Overrides if any at i.

---

## Behavior - performance (time and space), error
Behavior is latent in the structure. In other words, the structure implies behavior, which may or may not be triggered by events. 
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
    * error
      + insufficient memory - heap memory is insufficient/array is too large. OutOfMemoryError (java).
      + index out of bound - if the position of the array is beyond the allocated contiguous memory blocks. i < 0 or i >= n

4. due to relations:
    * performance ->
       + scan O(n) - the only way to find an element is to scan or linear search the array. (TODO - code)
    * there can be duplicates.

5. due to functions/api:
    * to insert an element at i, all the valid elements at i and beyond will have to shift right.  (TODO - code)
      + insert(e, i) -> O(n) worst case (at start).
      + insert(e) -> O(1) best case (at tail). tail < n.
    * to delete an element at i, all the valid elements at i and beyond will have to shift left. (TODO - code)
      + delete(e, i) -> O(n) worst case (at start).
      + delete(e) -> O(1) best case (at tail), delete(e, tail). tail < n
    * insert/delete implementation can vary depending on how one wants to treat a empty element.
    * error
      + overflow -> when insert(e), tail >= n
      + underflow -> when delete(e), tail <=0
