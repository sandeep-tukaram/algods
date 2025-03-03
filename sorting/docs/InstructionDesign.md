## Design Techniques for Sorting. 

### Subproblem split approach. 
I specifically use the term split, cause it makes using the technique and various ways of splitting intuitivie. Intuitively one can split things in few ways.
+ incrementally or differentially:  n ->  (n - k)   +  k
+ divide:  n -> n/m; does't have to be equal sized subproblems.
+ partition: n ->  k - 1 + 1 +  (n - k). its not intuitive, but hold patience!

We explore all these ways of splitting for the sorting problem intuitively. 

### Split incrementally or differentially - insertion sorting.
One obvious way to arrive at a subproblem is to reduce the size of a problem differentially. In simple terms, n-k is a smaller problem compared to 
n.  k is obviously a positive integer not greater than n. The question is can reuse the solution to n-k problem to sort array of size n. 

Put in pseudocode the question is ... 
1. Assume sort(n-k) solves the n-k problem.
2. Can we sort(n) using sort(n-k) ? 
3. Take k = 1. sort(n-1) is sorts A[0..n-1], from assumption 1. 
```
        A[0] <= A[2] <= ... <= A[n-1]   
```
4. And to place A[n] in its correct position, simply scan the (n-1) sorted elements. 
```
    place(A, n):    
        key = A[n]  // key is the nth element we want to place in the sorted A[0 .. n-1]
        i = n-1;
        while (i >= 0 && A[i] > key) {
            A[i+1] = A[i];      // shift right all larger elements.  Make place for the key. 
        }
        A[i + 1] = key  // place key in the right position. 
```
5. Sorting the original problem
``` 
    sort(A, n) : 
        sort(A, n-1)        // sort the subproblem 
        place (A, n)        // place the n'th element in the solved subproblem.
``` 
    This is a recursion. T(n) = T(n-1) + O(n) = O(n^2). 


### Split by fraction or dividing - merge sorting.
While incremental splittling creates subproblems of differential sizes, what if we divide the problem into (two) parts. Solve the parts and combine them.
This is what is called Divide and Conquer.

Approach is similar. 
1. We divide A[0 .. n] into A[0 .. n/2] and A[n/2+1 .. n] equal parts. 
2. We assume sort(A[0 .. n/2]) and sort(A[n/2+1 .. n])
```
            A[0] <= ... <= A[n/2]   
            A[n/2 + 1] <= ... <= A[n-1]   
```
3. Question is can we sort(A[0 .. n]) using the above two solutions. 
4. Using two pointer technique,   merge()
```
        pointer a -> A[0]
        pointer b -> A[n/2 + 1] 
```
    we can iteratively choose the minimum of the two elements and move the correponding pointer right. 
5. Above is the famous merge(A, B) two sorted arrays subroutine. Its O(n). 
6. consolidating everything above 
```
    sort(A, 0, n): 
        sort (A, 0, n/2)
        sort (A, n/2 + 1, n)
        merge (A, 0, n/2, n)    // equivalent to merge ((A, 0, n/2), (A, n/2 + 1, n)) 
```
7. A recursion for above 
    T(n) = 2T(n/2) + O(n) = O(nlgn)

Split by division yields faster solution compared to splitting incrementally. 
 

### Split by partitioning - quick sort.
Assume you pick an element in the array A[0..n] and place it in the correct position k in a sorted array. By correct what is meant is that all the elements 
smaller than (or equal to)  A[k] are to its left and all the elements larger than A[k] are to its right. A[k] is referred to as pivot. It partitions array 
into three subproblem A[0 .. k-1], A[k], A[k + 1 .. n]. A[k] is already in its right position, that is what is assumed to start with. The problem, now, 
reduces to sorting A[0 .. k-1] and A [0 .. k+1] separately and we are done. 

pseducode 
1. The original problem
```
    sort (A, 0, n): 
        k = partition (A, 0, n);  
        sort(A, 0, k-1)
        sort(A, k+1, n)
```
2. partition(A, 0, n) is the famous subroutine illustrated in textbooks [1]. It's simple scan operation and runs in O(n) time. 
3. Recursio for above 
    T(n) = O(n) + T(k-1) + T(n-k)
4. Choosing k becomes important.  
```
    if k = n/2, then  T(n) = O(n) + 2 T(n/2)  = O(nlgn)      // balanced partition, runtime similar to merge sort
    if k = 1, then T(n) = O(n) + T(n-1) + T(1) = O(n^2)     // unbalanced partition, runtime similar to insertion sort. 
``` 
5. Cormen [1] illusrates that the sorting is O(nlgn) for unbalanced split k = 9/10 n. Only for the extereme unlucky case one ends up with k = 1 for all partitions. 
6. Randomized partition reduces the probability of k = 1. 
7. guaranteed balanced partition can be obtained using median SELECT routine [1].


## Benchmarks 
The benchmarks are run on personal mac.

### mergesort O(nlgn) best case and mergesort2 O(n) best case.
Most of the numbers are as expected. The improvement when input is already sorted is order of magnitude better in line with theoretical O(n) over O(nlgn). 


#### Anomoly - expected vs actual
There is an anomoly I can't explain. I have run the benchmarks repeatedly but find the same pattern. 

1. Reverse array time for all sizes are better, especially for mergesort algo, compared to random or sorted array input. 
At this moment, I can't explain this. My expecation was that the reverse sorted array should have clocked worse. 


#### Actuals

```
***** Testing for generated sorted array *****
Array size: 1000
MergeSort time: 0.95 ms
MergeSort2 time: 0.28 ms
quicksort time: 0.02 ms
--------------------
Array size: 10000
MergeSort time: 2.33 ms
MergeSort2 time: 0.10 ms
quicksort time: 0.08 ms
--------------------
Array size: 100000
MergeSort time: 30.82 ms
MergeSort2 time: 0.29 ms
quicksort time: 0.30 ms
--------------------
Array size: 1000000
MergeSort time: 118.86 ms
MergeSort2 time: 9.67 ms
quicksort time: 11.30 ms
--------------------


***** Testing for randomly generated array *****
Array size: 1000
MergeSort time: 0.41 ms
MergeSort2 time: 0.22 ms
quicksort time: 0.13 ms
--------------------
Array size: 10000
MergeSort time: 1.75 ms
MergeSort2 time: 1.58 ms
quicksort time: 1.36 ms
--------------------
Array size: 100000
MergeSort time: 44.42 ms
MergeSort2 time: 33.44 ms
quicksort time: 9.08 ms
--------------------
Array size: 1000000
MergeSort time: 144.86 ms
MergeSort2 time: 150.98 ms
quicksort time: 153.59 ms
--------------------


***** Testing for generated reverse sorted array *****
Array size: 1000
MergeSort time: 0.03 ms
MergeSort2 time: 0.04 ms
quicksort time: 0.04 ms
--------------------
Array size: 10000
MergeSort time: 0.32 ms
MergeSort2 time: 0.44 ms
quicksort time: 0.44 ms
--------------------
Array size: 100000
MergeSort time: 4.20 ms
MergeSort2 time: 5.28 ms
quicksort time: 5.11 ms
--------------------
Array size: 1000000
MergeSort time: 139.40 ms
MergeSort2 time: 95.86 ms
quicksort time: 97.63 ms
--------------------
```