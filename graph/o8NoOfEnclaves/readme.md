# Number of Enclaves (LeetCode 1020)

This README explains the full intuition and approach for solving **LeetCode 1020 – Number of Enclaves**, using **DFS from the boundary**, along with clear diagrams, dry run, and time & space complexity.

This is written in a simple, revision-friendly format.

---

# 🧠 Problem Summary

You're given a 2D grid of **0s (water)** and **1s (land)**.

A **land cell** is called an **enclave** if:

* It CANNOT walk off the boundary of the grid by moving up, down, left, or right.

Your task:
👉 Count how many land cells **cannot** reach the border.

---

# 💡 Intuition (SUPER SIMPLE)

There are exactly two types of land:

### 1️⃣ Boundary-connected land (NOT enclaves)

These land cells can walk to the boundary.
They should be **ignored**.

### 2️⃣ Land cells enclosed inside (enclaves)

These cannot reach the boundary.
They should be **counted**.

The trick:

### ✔ Eliminate all boundary-reachable land first.

### ✔ What remains = enclaves.

---

# 🔥 Key Idea – DFS From Boundaries

Instead of checking every land cell and seeing if it can reach border,
we do the opposite:

### ⭐ Step 1: Start from all boundary cells

If a boundary cell is `1`, run DFS and turn every reachable `1` into `-1`.

This marks all **non-enclave** land.

### ⭐ Step 2: Count remaining `1`s in the grid

These `1`s were NOT reachable from the edges → they are enclaves.

This approach is both efficient and simple.

---

# 🌊 ASCII Visualization

Consider:

```
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
```

Boundary land: (1,0)

```
-1 0 0 0
 1 0 1 0
 0 1 1 0
 0 0 0 0
```

DFS spreads and marks reachable land as -1.

Now the grid becomes:

```
-1 0 0 0
-1 0 1 0
 0 1 1 0
 0 0 0 0
```

Remaining `1`s:

```
1 1 1
```

These are enclaves.

---

# 🧪 Dry Run (Step-by-Step)

### Initial Grid

```
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
```

### Step 1: DFS from boundary

* Check top row
* Check bottom row
* Check left column
* Check right column

Only (1,0) is boundary land → DFS marks connected land.

### Step 2: Count unmarked land

All remaining `1`s are enclaves.

---

# 🔧 Pseudocode

```
For each boundary cell:
    if grid[i][j] == 1:
        dfs(i, j)  // mark reachable land as -1

enclaves = 0
For each cell:
    if grid[i][j] == 1:
        enclaves++
Return enclaves
```

DFS spreads only through 1s.

---

# 🛠 Code Logic Explanation

Your DFS:

* Marks visited land as `-1` (safe land)
* Explores only 4 directions (no diagonals)

Your main function:

* Calls DFS on **all borders**
* Counts all remaining 1s

This matches the intended logic of the problem.

---

# ⏱ Time Complexity

```
O(m × n)
```

Every cell gets visited at most once.

---

# 💾 Space Complexity

```
O(m × n) worst-case
```

DFS recursion stack may reach all cells if the grid is full of land.

---

# 🎯 Final Summary

* DFS from **boundaries first**
* Mark all reachable land as `-1`
* Remaining `1`s are enclaves
* Efficient: O(m×n)
* Simple and clean logic

This pattern is similar to:

* Surrounded Regions
* Number of Islands
* Connected Components

If you'd like, I can also create a BFS version or a common template for all DFS grid problems.
