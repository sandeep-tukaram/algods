# Structure -> Behavior (Systems Thinking)
## Structure

a. Components:
  1. elements
      * uniform datatype -> all elements of an array have the same data type.
      * empty -> positions can be unfilled.
    

  2. memory/position/location
      * memory is allocation/reserved.
      * contiguous block of memory.

b. Relations:
  1. array as a datastructure doesn't employ relations between elements to position them.

c. Function/API:
  1. get(i), A[i]
  2. set(e, i), A[i] = e. Overrides if any at i.

---

## Behavior - performance (time/space), error

1. due to element:
    * error
      + Incompatible data type error -> when adding an element with a dataype not compatible with array datatype declaration.
    * performance
      + Fragmentation -> Empty positions may lead to fragmented array. 
          Compaction optimizes the performance. (code)

3. due to memory:
    * when does memory allocation happen
      + compile-time(static ?) -> TODO. shouldn't apply for interprented languages.
      + runtime(dynamic)-> languagues such as Java and C provision runtime allocation. Java compiles to bytecode which is then interpreted.
    * error
      + insufficient memory -> the size of the contiguous block for array is an input parameter for memory allocation.
      + The system throws error if memory is insufficient or array is too large. OutOfMemoryError (java).

4. due to relations:
    * the only way to find an element is to scan or linear search the array. O(n)
    * there can be duplicates.

5. due to functions/api:
    * to insert an element at i, all the valid elements at i and beyond will have to shift right.
      + insert(e, i) -> O(n) worst case (at start).
      + insert(e) -> O(1) best case (at tail). tail < n.
    * to delete an element at i, all the valid elements at i and beyond will have to shift left.
      + delete(e, i) -> O(n) worst case (at start).
      + delete(e) -> O(1) best case (at tail), delete(e, tail). tail < n
    * insert/delete implementation can vary depending on how one wants to treat a empty element.
    * error
      + overflow -> when insert(e), tail >= n
      + underflow -> when delete(e), tail <=0
