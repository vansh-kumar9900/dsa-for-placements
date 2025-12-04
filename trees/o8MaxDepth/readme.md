# 🌳 Maximum Depth of Binary Tree (LeetCode 104)

This README explains the **intuition**, **code logic**, **dry run**, and **time–space complexity** for the classic binary tree question: **Maximum Depth of Binary Tree**.

It is written in a simple, revision‑friendly format so you can easily understand and remember it later.

---

# 🧠 Problem Summary

You are given the `root` of a binary tree.

You must return the **maximum depth**, also known as the height of the tree.

**Definition:**

> Maximum depth = number of nodes along the longest path from the root to any leaf node.

Example tree:

```
      3
     / \
    9  20
       / \
      15  7
```

Maximum depth = 3 (3 → 20 → 7)

---

# 💡 Intuition

This problem is the easiest form of tree recursion.

To find maximum depth:

* Ask the left subtree for its max depth
* Ask the right subtree for its max depth
* Take the maximum of the two
* Add 1 for the current node

Visual idea:

```
Depth(root) = 1 + max(depth(left), depth(right))
```

If the tree is empty (root == null), depth = 0.

---

# ⭐ Correct Code

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
```

This is the cleanest and most optimal solution.

---

# 🔍 Step-by-Step Logic

### ✔ Case 1: Tree is empty

```
root == null → depth = 0
```

### ✔ Case 2: For any node

We recursively explore:

* maximum depth of left subtree
* maximum depth of right subtree

Then:

```
depth = 1 + max(leftDepth, rightDepth)
```

This ensures we get the longest root–to–leaf path.

---

# 🧪 Dry Run Example

Consider this tree:

```
      1
     / \
    2   3
       /
      4
```

### Recursion steps:

* maxDepth(4) = 1
* maxDepth(3) = 1 + max(1 , 0) = 2
* maxDepth(2) = 1
* maxDepth(1) = 1 + max(1 , 2) = 3

Answer = **3**

---

# 📊 Time Complexity

```
O(n)
```

Where `n` = number of nodes.

Each node is visited exactly once.

---

# 💾 Space Complexity

```
O(h)
```

Where `h` = height of the tree.

Why?

* The recursion call stack grows according to the tree height.
* Worst case (skewed tree): h = n → O(n)
* Best case (balanced tree): h = log n → O(log n)

---

# 🎯 Final Summary

* Max depth = longest path from root to any leaf.
* Use recursion: 1 + max(left, right).
* Time: O(n)
* Space: O(h)
* Very common pattern used in MANY binary tree problems.

You can now easily revise and reuse this logic anywhere.
