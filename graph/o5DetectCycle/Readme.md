# Cycle Detection in Undirected Graph (BFS + DFS)

This README explains **cycle detection in an undirected graph** using **BFS** and **DFS**, with deep intuition, diagrams, and step-by-step thought process. It is written so you can revise anytime—even months later—and instantly understand the logic.

---

# 🧠 **1. What is a Cycle in an Undirected Graph?**

A **cycle** exists when you can start from a node, travel through edges, and reach the same node again **without retracing edges**.

### Example Graph:

```
0 --- 1
|     |
3 --- 2
```

Here, the cycle is:
**0 → 1 → 2 → 3 → 0**

### Why is cycle detection tricky in undirected graphs?

Because every edge is stored twice:

```
0 → 1
1 → 0
```

If we are at node `0` and go to `1`, then from `1` we again see `0`.
This *looks* like a cycle but is NOT.

So we track **parent** to ignore the edge that takes us back.

---

# 🧩 **2. Why Do We Need the `parent` Concept?**

In an undirected graph, each edge appears in both directions. Example:

```
0 -- 1
```

Stored as:

```
0 → 1  
1 → 0
```

If you go from 0 to 1, and then see 0 again, that’s not a real cycle—it’s just the reverse direction.

So a cycle is confirmed only when:

```
A visited node is found  
AND  
that node is NOT the parent
```

---

# ------------------------------------------------------------

# 🚀 **3. BFS Approach (Breadth-First Search) — Step-by-Step**

# ------------------------------------------------------------

BFS works **level by level** using a *queue*.
We push `(node, parent)` pairs.

## 📌 **BFS Intuition (Very Easy)**

1. Start from a node.
2. Visit all neighbours.
3. If a neighbour:

   * is **unvisited → push to queue**
   * is **visited AND not parent → cycle found**

This means someone else reached that node through a different path.

---

## 🎥 **BFS Working Example**

Consider:

```
0 -- 1 -- 2
|         |
4 --------3
```

Start BFS at 0:

```
Queue: (0,-1)
Visited: [0]
```

Pick 0:

* Neighbors: 1,4
* Both unvisited, push:

```
Queue: (1,0), (4,0)
```

Pick 1:

* Neighbors: 0 (parent), 2 (unvisited)
* Push 2

```
Queue: (4,0), (2,1)
```

Pick 4:

* Neighbors: 0 (parent), 3 (unvisited)

```
Queue: (2,1), (3,4)
```

Pick 2:

* Neighbors: 1 (parent), 3 (visited but NOT parent!) → ❗CYCLE

Cycle found.

---

## ⭐ **BFS Cycle Condition (Important)**

```
if (visited[neighbor] == 1 AND neighbor != parent)
    → cycle exists
```

---

# -------------------------------------------------------------------

# 🚀 **4. DFS Approach (Depth-First Search) — Step-by-Step**

# -------------------------------------------------------------------

DFS goes **deep into one path** using recursion.

When DFS from a node goes deeper:

* If neighbor is **unvisited → go into DFS**
* If neighbor is **visited but not parent → cycle exists**

---

## 🎯 **DFS Intuition in One Line:**

**Go deep until stuck. If you ever land on a visited node that is not your parent → cycle.**

---

## 🎥 **DFS Working Example**

Graph:

```
0 -- 1 -- 2
|         |
4 --------3
```

Start at `0`:

```
dfs(0, -1)
```

0 → go to 1:

```
dfs(1, 0)
```

1 → go to 2:

```
dfs(2, 1)
```

2 → go to 3:

```
dfs(3, 2)
```

3 → sees neighbor 4:

```
dfs(4, 3)
```

4 → sees neighbor 0 (visited AND not parent!) → ❗CYCLE

Return **true** all the way up:

```
dfs(4) → true  
dfs(3) → true  
dfs(2) → true  
dfs(1) → true  
dfs(0) → true
```

This is called **bubbling up the result**.

---

# 🧠 **5. Why DFS Has This Line**

```
if (dfs(it, node, visited, adj)) return true;
```

Because:

* If any child call finds a cycle → it returns true
* The parent must **immediately stop** and return true
* Finally `isCycle()` also gets true

DFS = "If ANY path has a cycle, stop everything immediately."

---

# --------------------------------------------------

# 📊 **6. BFS vs DFS (Full Comparison Table)**

# --------------------------------------------------

| Feature                   | BFS                  | DFS                    |
| ------------------------- | -------------------- | ---------------------- |
| Data Structure            | Queue                | Recursion / Stack      |
| Exploration               | Level-wise           | Depth-wise             |
| Parent Tracking           | Required             | Required               |
| Cycle Found When          | visited & not parent | visited & not parent   |
| Stops Searching           | Immediately          | Immediately            |
| Implementation Difficulty | Easy                 | Slightly more thinking |

---

# --------------------------------------------------

# ⏱ **7. Time & Space Complexity (Easy Terms)**

# --------------------------------------------------

Let:

* V = number of nodes
* E = number of edges

---

## ⭐ **Time Complexity (BFS & DFS same)**

```
O(V + E)
```

Because:

* Every node is visited once
* Every edge is checked once

This is the fastest possible for graph traversal.

---

## ⭐ **Space Complexity**

### BFS:

```
O(V)
```

Components:

* visited[] → O(V)
* queue → can hold up to O(V)

### DFS:

```
O(V)
```

Components:

* visited[] → O(V)
* recursion stack → can go up to O(V)

Both have same overall space.

---

# --------------------------------------------------

# 🎯 **8. Summary for Quick Revision (Very Important)**

# --------------------------------------------------

* An undirected graph stores each edge twice.
* Use **parent** to avoid false cycle detection.
* BFS uses a **queue**.
* DFS uses **recursion**.
* Cycle condition:

```
visited[node] == 1 AND node != parent
```

* BFS: checks level-wise.
* DFS: checks depth-wise.
* Time: O(V + E)
* Space: O(V)

Both methods are correct. Use whichever you're comfortable with.

---

If you want, I can also add:

* ✔ Dry run diagrams as images
* ✔ Pseudocode sections for BFS & DFS
* ✔ Visual explanation of parent concept
* ✔ Example questions from LeetCode & GFG

Just tell me!
