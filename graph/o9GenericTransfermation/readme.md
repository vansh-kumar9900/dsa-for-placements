# Word Ladder (LeetCode 127) – The Ultimate Thinking Guide

This README is designed to teach you **exactly how to think** when solving Word Ladder and all similar transformation problems.
It is written in the clearest possible way so that when you revisit it later, everything will instantly make sense.

---

# 🧠 1. What Is Word Ladder Really?

At first, Word Ladder looks like a string problem.

But it is NOT a string problem.

It is actually:

### ⭐ A **shortest path problem** in a **graph that is NOT given explicitly**.

Each word is a **node**.
There is an **edge** between two words if they differ by **exactly one letter**.

Example:

```
hit → hot
hot → dot
hot → hat
```

This creates a graph, but the edges are HIDDEN.
You must generate them.

This idea is called an **implicit graph**.

---

# 🚀 2. The Core Pattern You Must Recognize

Word Ladder is part of a powerful pattern:

# ⭐ “BFS on an Implicit Graph Using Generic/Pattern Transformations”

This pattern appears whenever:

* You need **minimum steps / shortest path**
* You transform **one state into another**
* Each transformation makes a **small change** (like 1 character)
* You are NOT given edges → you must **create neighbors** using logic

Once you recognize this pattern → the solution becomes obvious.

---

# 🎯 3. When Should You Immediately Think of Word Ladder BFS?

Look for these 4 signals:

### 🔥 Signal 1: You transform one string/state into another

Examples:

* hit → cog
* lock “0000” → “0202”
* genes AAAA → AGTA

### 🔥 Signal 2: Only small local changes allowed

Examples:

* change ONE letter
* rotate ONE wheel
* mutate ONE gene
* flip ONE bit

### 🔥 Signal 3: You need SHORTEST path

If the question says:

* shortest transformation
* minimum steps
* fewest moves
* minimum operations

90% chance → BFS.

### 🔥 Signal 4: Graph not given → must be built by transformation rules

This is the KEY.
If neighbors are NOT listed, but you can **generate** them → Word-Ladder-style BFS.

---

# 🌉 4. How Word Ladder Graph Is Built (Implicit Graph)

Each word produces many possible neighbors by replacing each character with 'a'–'z'.

Example word:

```
hot
```

Possible generic forms:

```
h*t
*ot
ho*
```

Possible transformations:

```
hat, hit, hot, hog, hop, dot, cot...
```

Every valid dictionary word among these becomes a **neighbor node**.

This is how edges are generated.

---

# 🔁 5. Why BFS? (The Heart of the Problem)

BFS guarantees the **shortest path** because it explores layer by layer:

```
Level 1: hit
Level 2: hot
Level 3: dot, lot
Level 4: dog, log
Level 5: cog
```

The first time you reach the `endWord` = shortest number of steps.

DFS cannot guarantee this.
Dijkstra is not needed because all edges have equal weight.

---

# 🧩 6. The BFS Template for Word Ladder

1. Put `beginWord` into queue with level 1
2. Use a set/hash to store all valid words
3. While queue not empty:

   * Pop word + its level
   * If word == endWord → return level
   * Generate all possible 1-letter transformations
   * If transformation exists in set:

     * Remove it from set (mark visited)
     * Push it into queue with level+1
4. If BFS ends → return 0

This ALWAYS works.

---

# 🔥 7. Super Simple Dry Run

```
beginWord = hit
endWord   = cog
wordList  = [hot, dot, dog, lot, log, cog]
```

Start BFS:

```
hit (level 1)
```

Neighbors:

```
hot (level 2)
```

Neighbors of hot:

```
dot, lot (level 3)
```

Neighbors of dot / lot:

```
dog, log (level 4)
```

Neighbors:

```
cog (level 5) → Found! Return 5
```

This is BFS shortest path.

---

# 🔎 8. How to Think Step-by-Step (Your Mindset Guide)

When you see a problem like this, follow this thinking sequence:

### ✔ Step 1: "Is this a shortest path problem?"

If yes → think BFS.

### ✔ Step 2: "Where are the nodes and edges?"

Even though the problem doesn't show a graph, you create it.
Nodes = words
Edges = 1-letter transformations

### ✔ Step 3: "How do I generate neighbors?"

By replacing each character with a–z.

### ✔ Step 4: "How do I avoid revisiting?"

Use a HashSet and remove visited words.

### ✔ Step 5: "Return when I reach endWord."

First time → shortest path guaranteed.

---

# 🧠 9. Problems That Use the *Exact Same Pattern*

These are all Word Ladder family:

### 🔐 Open the Lock (LeetCode 752)

Each move rotates a wheel → 1-step transformation.

### 🧬 Minimum Genetic Mutation (LeetCode 433)

Change 1 gene at a time.

### 🧩 Sliding Puzzle (LeetCode 773)

Move blank tile → generate neighbors.

### 🔄 Rotting Oranges (LeetCode 994)

Multi-source BFS (similar level expansion).

### 🌊 01 Matrix (LeetCode 542)

Pattern-based BFS from all zeros.

### 🏁 Shortest Path in Binary Matrix (LeetCode 1091)

Implicit graph + multi-direction BFS.

All of these use the Word Ladder thinking.

---

# 📊 Time & Space Complexity

Let:

* N = number of words in list
* L = length of each word

### Time: **O(N × L × 26)**

Because for each word, you try 26 letters for each position.

### Space: **O(N × L)**

Queue + HashSet + intermediate strings.

---

# 🎯 Final Memory Notes

Whenever you see:

* shortest transformation
* one step change
* single character replace
* find minimum number of moves
* neighbors must be generated

Immediately think:

# ⭐ BFS on implicit graph

# ⭐ Generate neighbors with small edits

# ⭐ Use HashSet to track valid states

This alone will help you instantly solve dozens of problems.

---

If you want, I can also add:

* full clean Java code
* multiple dry runs
* common mistakes
* template for all transformation BFS problems

---

# 🌉 10. Graph Visualization (How Word Ladder Looks as a Graph)

To clearly understand Word Ladder, visualize each word as a **node** and each valid one-letter transformation as an **edge**.

Let’s take a small example:

```
beginWord = hit
endWord   = cog
wordList  = [hot, dot, dog, lot, log, cog]
```

## 🔵 Step 1: Represent Each Word as a Node

```
 hit   hot   dot   dog   lot   log   cog
```

## 🔵 Step 2: Connect Words That Differ by ONE LETTER

We draw an edge between two words if they differ by exactly one character.

```
 hit
  |
 hot
 /  \
dot  lot
 |     |
 dog   log
    \ /
    cog
```

### ✔ What this graph means:

* `hit → hot` (change i → o)
* `hot → dot` (change h → d)
* `hot → lot` (change h → l)
* `dot → dog` (change t → g)
* `lot → log` (change t → g)
* `dog → cog` (change d → c)
* `log → cog` (change l → c)

This is the **hidden graph** behind the Word Ladder problem.

---

# 🔍 11. BFS Visualization on the Graph

To understand BFS layering, visualize levels:

## Level 1

```
 hit
```

## Level 2

```
 hit
  |
 hot
```

## Level 3

```
       dot
      /
 hit - hot
      \
       lot
```

## Level 4

```
         dog
       /
 hit - hot - dot
       \
         lot - log
```

## Level 5 (Found endWord)

```
           cog
         /     \
     dog         log
       \         /
 hit - hot - dot
       \
         lot
```

The moment BFS reaches `cog` (level 5), we stop.

### 💡 This is why BFS guarantees shortest transformation.

---
