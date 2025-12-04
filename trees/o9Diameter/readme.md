# 🌳 Diameter of Binary Tree (LeetCode 543)

This README explains the **intuition**, **correct logic**, **code breakdown**, **dry run**, and **time–space complexities** for the classic binary tree problem: **Diameter of Binary Tree**.

It is written in a simple, revision-friendly format so you can easily understand it later.

---

# 🧠 Problem Summary

You are given the `root` of a binary tree.

You must return the **diameter** of the tree.

**Definition:**

> The diameter is the **longest path between any two nodes** in the tree.

This path **may or may not pass through the root**.

Example tree:

```
      1
     / \
    2   3
   / \    
  4   5
```

Diameter = `4 → 2 → 1 → 3` (length = 3 edges)

---

# 🌟 Key Insight

The diameter at ANY node is:

```
height(left subtree) + height(right subtree)
```

So for every node:

* Find the height of its left subtree
* Find the height of its right subtree
* The sum is a possible diameter

We take the **maximum** of all such possible values.

---

# ⭐ Correct Code

```java
class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);  // compute heights and update diameter
        return diameter;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
```

---

# 🔍 Step-by-Step Logic

### ✔ Case 1: Empty Node

```
height = 0
```

### ✔ Case 2: For any node

* Compute left height
* Compute right height
* Update diameter using formula:

```
diameter = max(diameter, left + right)
```

* Return height of current node:

```
1 + max(leftHeight, rightHeight)
```

### Why this works?

Because the **height function returns the maximum depth** of a subtree, and while doing so, we naturally check every node for its possible diameter.

Height recursion already touches every node → perfect place to compute diameter.

---

# 🧪 Dry Run Example

Tree:

```
      1
     / \
    2   3
   / \    
  4   5
```

### Step-by-step heights:

* height(4) = 1
* height(5) = 1
* height(2) = 1 + max(1,1) = 2
* height(3) = 1
* height(1) = 1 + max(2,1) = 3

### Step-by-step diameters:

* At node 4 → 0 + 0 = 0
* At node 5 → 0 + 0 = 0
* At node 2 → 1 + 1 = 2
* At node 3 → 0 + 0 = 0
* At node 1 → 2 + 1 = 3

Final diameter = **3**.

---

# 📊 Time Complexity

```
O(n)
```

Where `n` = number of nodes.

Why?

* Each node is visited once.
* Height calculation + diameter update is constant work.

---

# 💾 Space Complexity

```
O(h)
```

Where `h` = height of tree.

Due to recursion stack:

* Worst case (skewed tree): `O(n)`
* Best case (balanced tree): `O(log n)`

---

# 🎯 Final Summary

* Diameter = longest path between any 2 nodes.
* Compute heights while calculating diameter.
* Use recursion: diameter = max(diameter, left + right).
* Time: O(n)
* Space: O(h)

This is one of the most elegant binary tree problems, and the pattern is used in many tree diameter-style question
