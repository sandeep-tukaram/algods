# Structure -> Behavior (Systems Thinking)
## Structure

### a. Components
  1. elements
  * datatype -> all elements of an array have the same data type.
  * empty -> positions can be unfilled.

  3. memory
     
    * memory is allocation/reserved.
    * contiguous block of memory.

### b. Relations -
  1. array as a datastructure doesn't employ relations between elements to position them.

### c. Function/API -
  1. get(i), A[i]
  2. set(e, i), A[i] = e. Overrides if any at i.


## Behavior - performance (time/space), error

due to element
a. Elements have a fixed datatype. Adding an element of incompatible datatype will produce an error.
b. Empty positions lead to fragmented array. Compaction (background process) will be required to optimize on the performance. (code)

due to memory
a. when does memory allocation happen
    compile-time(static ?) -> needs exploration. shouldn't apply for interprented languages.
    runtime(dynamic)-> languagues such as Java and C provision runtime allocation. Java compiles to bytecode which is then interpreted.
b. error
    insufficient memory -> the size of the contiguous block for array is an input parameter for memory allocation.
    The system throws error if memory is insufficient or array is too large. OutOfMemoryError (java).

due to relations
a. the only way to find an element is to scan or linear search the array. O(n)
b. there can be duplicates.

due to functions/api
a. to insert an element at i, all the valid elements at i and beyond will have to shift right.
  insert(e, i) -> O(n) worst case (at start).
  insert(e) -> O(1) best case (at tail). tail < n.
b. to delete an element at i, all the valid elements at i and beyond will have to shift left.
  delete(e, i) -> O(n) worst case (at start).
  delete(e) -> O(1) best case (at tail), delete(e, tail). tail < n
c. insert/delete implementation can vary depending on how one wants to treat a empty element.
d. error
    overflow -> when insert(e), tail >= n
    underflow -> when delete(e), tail <=0
