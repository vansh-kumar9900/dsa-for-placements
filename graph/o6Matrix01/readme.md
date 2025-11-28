# LeetCode 542 – 01 Matrix

This README explains the entire approach for solving **LeetCode 542: 01 Matrix** using **Multi-Source BFS**, with simple intuition, diagrams, dry run, and complexities.

This explanation is written so that you can revise it anytime from your GitHub repository.

---

# 🧠 Problem Summary

You are given a matrix of **0s and 1s**.
Your task:
For every cell containing **1**, find the **distance to the nearest 0**.

Distance is measured in **number of steps** (up, down, left, right).

Example:

```
Input:
1 1 1
1 0 1
1 1 1

Output:
2 1 2
1 0 1
2 1 2
```

---

# 💡 Why BFS? Why Not DFS?

We need the **shortest distance** to any zero.

### BFS is perfect because:

* BFS explores in **waves/layers**
* First time you reach a cell → **shortest distance**
* No overwriting required

DFS goes deep first → **not guaranteed shortest distance**.

---

# 🚀 Multi-Source BFS (Main Idea)

Instead of running BFS from each **1**, we:

### 👉 Push **all 0s** into the queue first.

Each zero says:

> "I am 0. My distance = 0."

From these zeros, BFS expands outward in waves.

The **first time** BFS reaches a 1 → that is the correct shortest distance.

This is called **multi-source BFS**, one of the most powerful BFS patterns.

---

# 🌊 BFS Wave Visualization (ASCII Diagram)

Imagine the matrix:

```
0 1 1
1 1 1
1 1 0
```

### Wave 0 (initial zeros)

```
0 ? ?
? ? ?
? ? 0
```

### Wave 1

```
0 1 ?
1 ? 1
? 1 0
```

### Wave 2

```
0 1 2
1 2 1
2 1 0
```

Each wave expands distance by **+1**.

---

# 🔐 BFS Invariant (Most Important Rule)

### 🔥 Mark a cell as visited **when you push** it into the queue.

Never mark it when popping.

If you delay marking visited:

* multiple BFS waves reach the same cell
* it gets added to queue many times
* performance drops → **TLE**

So the rule is:

```
if cell is unvisited:
    mark it visited immediately
    push into queue
```

This ensures **each cell is processed only once**.

---

# 🧪 Dry Run (Step-by-Step)

Take input:

```
0 1 1
1 1 1
1 1 0
```

### Step 1: Add all zeros to queue

Queue:

```
(0,0,0), (2,2,0)
```

Visited matrix:

```
0 -1 -1
-1 -1 -1
-1 -1 0
```

### Step 2: BFS spreads level by level

After Wave 1:

```
0 1 -1
1 -1 1
-1 1 0
```

After Wave 2:

```
0 1 2
1 2 1
2 1 0
```

This is the final output.

---

# 🔧 Pseudocode (Easy to Remember)

```
Push all 0s into queue
Mark their distance = 0
Mark all 1s as unvisited (-1)

While queue not empty:
    pop cell
    for each of 4 directions:
        if neighbour inside grid AND unvisited:
            distance = parent distance + 1
            push neighbour

Return distance matrix
```

---

# ⏱ Time Complexity

```
O(m × n)
```

Because:

* Each cell goes into queue **at most once**
* BFS checks 4 directions per cell

---

# 💾 Space Complexity

```
O(m × n)
```

Because:

* distance/visited matrix uses O(m×n)
* queue may hold many cells

---

# 🎉 Final Summary (Revision Notes)

* This question uses **multi-source BFS**
* Start BFS from **all zeros** simultaneously
* BFS spreads in waves → shortest distance
* Update distances when pushing
* Each cell processed once → O(m×n)

This is one of the foundational BFS grid problems.
