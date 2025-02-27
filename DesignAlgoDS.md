# Designing Algorithms

The first few times I read a textbook on algorithms, it appeared magic. Some genius had an eureka moment. I believe thats the same for most of us. Just can't wrap our heads around algorithms. Eventually we tend to rely heavily on our capability to remember algorithms. That is a bad sign. Designing should employ techniques that aid understanding and application and not just memory. 

My task was cut out. The only way I know, is to re-read and think. In this day and age, to re-read and more so to think costs time, perceivably a non-affordable asset. World is competitive and it's a rat race. The perception or what is called maya of the current day and age seeds a belief that one may fall behind and there is no catching. I had to deal with the same thoughts. Its painful. One has to make a choice between peceived reality and fasination. This blog is a result to put in time to re-read and think through 1000s of pages of reading materials - textbooks, google scholar, blogs etc. The risk is real though, one may fall behind. But I have made peace with that. Personally, this is a top priority for few months at least. My priority is biased, because of my fascination for the subject. The few re-reading I have already done has left me satisfying and that is what I will persue.

--- 

I will blog about my understanding of the subject. One of my prominent style is simplify things, may be oversimplify sometimes. Bear or deal with it. The quest is to identify techniques discovered, understand it and apply it for simple and complex cases. 

So to simplify, an algorithm is a set of instructions and a space of data upon which the instructions operate.

    Instruction operates on data (operand)

For example, 
    v1 = 2
    v2 = 4
    v1 + v2   ->   add (v1, v2) is a add instruction on variables v1 and v2.

On a computer, the instructions are executed by a CPU and the data (variable values) is stored on a memory. We assume a simple RAM model the instructions are executed sequentially and the memory is not hierarchical. 

So, a made up assembly language the sequence of instruction would look like 

    load v1        
    load v2 
    add v1, v2

If we think carefully, two things happen 
+ data/memory access -> load v1, v2
+ instruction/compute -> v1 + v2

Hence, the design techniques to craft and optimize algorithms involves structuring 
+ [Instructions](instructiondesign/InstructionDesign.md)  instruction optimization
+ [Data](datastructure/README.md)   data/memory access optimization.


--- 

Extending above model to IO, and network additional involes additonal techniques structuring :
+ IO -> ex. filesystems.
+ Network/Remote calls  -> ex. distributed computing

This currently is beyong the scope of this blog. Will stick to the simple RAM model - CPU and in-memory only.