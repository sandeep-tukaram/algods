Benchmarked for mergesort and mergesort2 on personal machine. 

Drastic improvement in the time for the best case. While its near same for randomly and reverse sorted test cases.

```
 // Improved runtime. 
***** Testing for generated sorted array *****
Array size: 1000
MergeSort time: 1.53 ms
MergeSort2 time: 0.57 ms
--------------------
Array size: 10000
MergeSort time: 2.53 ms
MergeSort2 time: 0.10 ms
--------------------
Array size: 100000
MergeSort time: 29.71 ms
MergeSort2 time: 1.51 ms
--------------------
Array size: 1000000
MergeSort time: 125.41 ms
MergeSort2 time: 13.72 ms
--------------------


// Similar runtime
***** Testing for randomly generated array *****
Array size: 1000
MergeSort time: 0.45 ms
MergeSort2 time: 0.39 ms
--------------------
Array size: 10000
MergeSort time: 1.39 ms
MergeSort2 time: 1.33 ms
--------------------
Array size: 100000
MergeSort time: 38.74 ms
MergeSort2 time: 34.86 ms
--------------------
Array size: 1000000
MergeSort time: 145.27 ms
MergeSort2 time: 146.50 ms
--------------------


// Similar runtime
***** Testing for generated reverse sorted array *****
Array size: 1000
MergeSort time: 0.03 ms
MergeSort2 time: 0.03 ms
--------------------
Array size: 10000
MergeSort time: 0.23 ms
MergeSort2 time: 0.37 ms
--------------------
Array size: 100000
MergeSort time: 2.78 ms
MergeSort2 time: 4.22 ms
--------------------
Array size: 1000000
MergeSort time: 130.43 ms
MergeSort2 time: 102.52 ms
--------------------
```