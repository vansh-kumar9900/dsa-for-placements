# Surrounded Regions (LeetCode 130)

This README explains the full logic behind solving **LeetCode 130 – Surrounded Regions** using **DFS from the borders**, with simple intuition, diagrams, dry runs, and complexities.

It is written so that you can revise it anytime from your GitHub repository.

---

# 🧠 Problem Summary

You are given a 2D board filled with `'X'` and `'O'`.

Your task:

* Convert all `'O'` regions that are **completely surrounded** by `'X'` into `'X'`.
* Any `'O'` that **touches the border** (directly or indirectly) should stay `'O'`.

Example:

```
X X X X
X O O X
X X O X
X O X X
```

Output:

```
X X X X
X X X X
X X X X
X O X X
```

The region at bottom (connected to border) is **NOT flipped**.
The region in the middle (not touching border) **IS flipped**.

---

# 💡 Core Intuition

There are only TWO types of `'O'`:

### 1️⃣ Border-connected `'O'` (should remain 'O')

* These `'O'` touch the border OR are connected to a border `'O'`.

### 2️⃣ Surrounded `'O'` (should become 'X')

* These `'O'` are fully enclosed inside and cannot reach the border.

### ⭐ So the trick is:

**Protect all border-connected O’s first.**
Then flip everything else.

---

# 🔥 Key Idea (DFS from Borders)

### Instead of searching from the inside, we search from the **edges**.

Steps:

1. Traverse all **border cells**.
2. When you find an `'O'`, run **DFS** to mark it as `'T'` (temporary safe).
3. After DFS:

   * All `'T'` are border-connected O’s → convert back to `'O'`.
   * All `'O'` left are fully surrounded → convert to `'X'`.

This avoids checking every region manually.

---

# 🌊 ASCII Visualization

Initial board:

```
X X X X
X O O X
X X O X
X O X X
```

Border O at (3,1):

```
X X X X
X O O X
X X O X
X T X X   ← T = Protected
```

DFS spreads to neighbors:

```
X X X X
X O O X
X X O X
X T X X
```

(No connected O’s except the bottom one)

Now flip:

* `'T'` → `'O'` (safe)
* `'O'` → `'X'` (surrounded)

Final:

```
X X X X
X X X X
X X X X
X O X X
```

---

# 🧪 Step-by-Step Dry Run

Board:

```
X X X X
X O O X
X X O X
X O X X
```

### Step 1: Scan top & bottom rows

* No O’s on top row
* Bottom row has `O` at (3,1)
* Run DFS → mark it as `T`

### Step 2: Scan left & right columns

* No border O’s except (3,1)

### Step 3: Flip phase

* All internal 'O' become 'X'
* All 'T' revert to 'O'

Final Answer matches expected.

---

# 🔧 Pseudocode (Super Simple)

```
For each cell on border:
    if board[i][j] == 'O':
        DFS to mark it as 'T'

For each cell in the board:
    if board[i][j] == 'T': convert to 'O'
    else if board[i][j] == 'O': convert to 'X'
```

DFS explores up, down, left, right.

---

# 🍀 Why DFS Works Perfectly

DFS helps us:

* Travel outward from border
* Mark all connected safe O’s
* Avoid touching surrounded O’s

Because DFS marks **connected components**, this matches the problem perfectly.

---

# ⏱ Time Complexity

```
O(m × n)
```

Because:

* Every cell is visited at most once.
* DFS only spreads through O’s.

---

# 💾 Space Complexity

```
O(m × n) worst case (DFS recursion stack)
```

Worst case: entire board is filled with O’s.

---

# 🎯 Summary (Revision Notes)

* Scan the **borders**, not the inside.
* DFS from border O’s → mark them `T` (safe).
* Flip:

  * `T` → `O`
  * `O` → `X`
* DFS ensures all border-connected O’s remain safe.
* Time: O(m×n)
* Space: O(m×n)

This is the cleanest and most accepted solution.

If you want, I can also create:

* BFS version
* Code template
* More dry runs
* Visual explanation with diagrams
