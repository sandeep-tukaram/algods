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
In a simple sentence: an algorithm is just a set of steps working with data solving a problem specification. That's it! Let's look at a super simple example:

```
v1 = 2              # Step 1: Store the value 2 in memory location v1
v2 = 4              # Step 2: Store the value 4 in memory location v2
v1 + v2             # Step 3: Add values from memory locations v1 and v2
```

See what we did there? Even in this tiny example, we can spot our two main parts:
1. Data storage: We're using v1 and v2 to keep our values somewhere
2. Instructions: We're doing things with those values (storing them and adding them)

This same pattern shows up everywhere - whether you're adding two numbers or building a complex search algorithm. Pretty neat, right? I call it two-part theme. Let's explore. 

### 3.2 Computer Model and Basic Operations
Let's understand how computers work using something familiar - a reading room! And guess what? This perfectly shows our two-part theme in action: we've got a place to store stuff (data storage) and a place to work with it (instructions).

Imagine you're in a reading room with:
1. A desk (this is like the CPU - where we follow instructions)
2. A magical bookshelf (this is like Memory - where we store data)

#### The Magical Bookshelf (Memory)
Think of memory like a bookshelf where:
- Each shelf spot has a name (like "v1" or "temp")
- Each spot holds one book with just one number
- You can instantly grab any book you want
- You never run out of shelf space

You can do two things with this storage space:
```
READ:   Look at the number in a book
WRITE:  Put a new number in a book
```

Pretty simple, right? It's just like having an endless bookshelf where you can grab or store books super quickly! This is our first main part - data storage in action.

#### Your Desk (CPU)
This is where you do all your work - it's the instructions part of our two-part theme:
- You can only work with numbers from books you've taken from the shelf
- All basic calculations take the same time
- You can do simple math and comparisons:
```
MATH:      +, -, ×, ÷
COMPARE:   Is A bigger than B?
DECIDE:    If something is true/false
```

Think of it as your personal workspace - but remember, you can only work with what you've grabbed from the shelf! See how our two parts work together? We store data in books on the shelf and process it at the desk.

#### Example: Adding Two Numbers
Let's see how both parts come together to add two numbers:
```
1. Get book from v1    # Data storage: reading from memory
2. Get book from v2    # Data storage: reading again
3. Add the numbers     # Instructions: processing the data
   at your desk
4. Write result in     # Data storage: writing back to memory
   a new book at v3
```

That's really all there is to it! Every computer program, like the reading room above, is just these two parts working together:
1. Getting books from the shelf (Memory - data storage)
2. Working with their numbers at the desk (CPU - instructions)

This simple model (cpu + memory) is called the RAM model. But hey, don't get hung up on the name - if it helps think reading room! It's that straightforward. And remember, everything we do with computers comes down to these two parts: storing our data (in books on the bookshelf) and processing it (at the desk).

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