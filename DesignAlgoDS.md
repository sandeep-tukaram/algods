# Designing Algorithms: Data Storage & Instructions

## 1. Introduction
You know that feeling when you first look at an algorithm textbook? Everything seems like magic, right? Like some genius just had an "aha!" moment and came up with these brilliant solutions. I've been there too, and I bet most of us have. The trouble is, we often end up just memorizing algorithms instead of really understanding the craft behind the design. That's not great.

Look, I get it - taking time to really understand algorithms feels tough. There's this constant pressure to keep up, this feeling that everyone else is racing ahead while you're trying to figure things out. It's that classic rat race mentality, and it's not fun.

But here's the thing: I decided to take a different path. I spent time diving deep into textbooks, research papers, and blogs. Sure, there's a risk of "falling behind," but I've made peace with that. This is my way of breaking free from that rat race, even if just a bit. I'll be honest - I'm totally fascinated by this stuff, and I think it's worth the time to really get it.

I hope I can encourage you to do the same while saving lot of time and effort.

## 2. Approach
Let's keep this simple and straightforward! We're going to break everything down into manageable pieces. And here's the key thing to remember: every algorithm - and I mean every single one - comes down to just two parts: how we store our data, and the operations we perform on it. Let's see how this plays out, starting with the basics and working our way up to tougher problems.

## 3. Core Concepts

### 3.1 Simplified View
Want to know the simplest way to think about algorithms? Here it is: an algorithm is just a set of steps working with data solving a problem specification. That's it! Let's look at a super simple example:

```
v1 = 2              # Step 1: Store the value 2 in memory location v1
v2 = 4              # Step 2: Store the value 4 in memory location v2
v1 + v2             # Step 3: Add values from memory locations v1 and v2
```

See what we did there? Even in this tiny example, we can spot our two main parts:
1. Data storage: We're using v1 and v2 to keep our values somewhere
2. Instructions: We're doing things with those values (storing them and adding them)

This same pattern shows up everywhere - whether you're adding two numbers or building a complex search algorithm. Pretty neat, right?

### 3.2 Computer Model and Basic Operations
Think of a computer like your own reading corner. You have:
- A comfy chair
- A magical bookshelf
- Lots of tiny books (each with just one number inside!)

Here's how it works:

a. Your Magical Bookshelf (This is Memory):
   - Need a book? Just think of it, and it's in your hand!
   - Each book has a simple label like "v1" or "v2"
   - Each book holds just one number
   - Your shelf never gets full
   
   You can do two things with books:
   ```
   read:  peek inside to see the number
   write: put a new number inside
   ```

b. Your Brain (This is the CPU):
   - You're sitting in your chair, doing mental math
   - Each math problem takes the same time to solve
   - Simple rule: you can only work with numbers from books you're reading
   
   Your brain can:
   ```
   do math:     add, subtract, multiply, divide
   think:       yes/no questions
   compare:     which number is bigger?
   ```

c. Problem - adding two numbers:
```
load v1 -> v0       # Grab book v1, check its number
add v2, v0 -> v0    # Grab book v2, add its number to the first one
store v0 -> v3      # Write your answer in a new book v3
```

That's it! This is how computers work at their core: Memory holds our data (just like that magical bookshelf), while the CPU follows our instructions to process it. Every program, no matter how complex, is just a dance between these two parts: storing values in memory and processing them with the CPU. And there you have it - our two key parts in action: data storage (Memory) and instructions (CPU).

## 4. Design Techniques
When we're designing algorithms, we're always thinking about our two key parts:
1. How can we make our instructions more efficient?
2. What's the best way to organize our data?

Let's look at how we can make each one better:

1. Instructions: Making Our Steps Smarter

   This is all about how we handle our operations - making them more efficient and clever. Want to learn more about crafting better instructions? 

2. Data Organization: Choosing the Right Structure

   This is where we get strategic about how we store and access our data. Different problems need different approaches! 

Usually we tackle problems in two steps:
1. First, figure out how to solve it (get those instructions right!)
2. Then, make it better (smarter instructions, better data organization)

Again: every algorithm improvement comes from either making our instructions more efficient or organizing our data more cleverly - or both!

Both the parts are discussed in details 
+ [Instructions](instructiondesign/InstructionDesign.md)
+ [Data access](datastructure/README.md)

## 5. Scope Note
Just so you know - there's more to computing than just CPU and memory. Things like reading files or making network calls add extra complexity. But for now, let's stick to our simple model focusing on our two core parts: data storage and instructions.

## 6. Summary
After all we've covered, it really boils down to just two key things. Every algorithm - from the simplest to the most complex - is just playing with these two parts:

1. Data Storage
   Hey, this is just about where we put our stuff! Think about:
   - Where do we keep our values?
   - How do we organize everything?
   - How do we find what we need when we need it?

2. Instructions
   This is the "what do we actually do?" part:
   - What steps do we take?
   - How do we work with our stored data?
   - What order do we do things in?

Here's the cool thing: once you start seeing algorithms this way, a lot of things get clearer. Working on a tough problem? Break it down into these two parts. Ask yourself:
- How am I storing my data? Could I organize it better?
- What am I doing with that data? Could these steps be more efficient?

That's really all there is to it! No matter how complicated an algorithm might look at first, remember - it's just some instructions working with stored data. Keep this in mind, and you'll start seeing patterns everywhere.