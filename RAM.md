# RAM model
RAM model is apparently the simplest model of computer and popular in textbooks. Few pointers on this model. 
## CPU
+ a single processor.
+ executes instructions sequentially, no concurrent execution.
+ all instructions take same amount of time.
+ arithmetic instructions - add, subtract, multiply, divide, modulo, floor, ceiling.
+ data movement instructions - load, store, copy.
+ control flow instructions - conditional branch, unconditional branch, function call, return.
    
## Memory
+ unlimited in-memory storage.
+ memory-hierarchy is not considered. No cache, no disk IO etc.

## to simplify, take it with a grain of salt.
+ all instructions take same amount of time.
+ all instructions are executed insequence. No parallelism or multithreading.
+ all memory accesses take same amount of time.
