# 📘 LeetCode 111 — Minimum Depth of Binary Tree

This README explains the **intuition**, **correct logic**, **corrected code**, **why your first approach fails**, and **time + space complexity** for the “Minimum Depth of Binary Tree” problem.

This explanation is written to be simple enough so you can revise it later and instantly understand everything.

---

# 🧠 Problem Summary

You are given the root of a binary tree.

**Minimum depth** = the number of nodes in the shortest path from the root **to the nearest leaf**.

A **leaf** means:

```
a node with NO left child and NO right child
```

Example tree:

```
      3
     / \
    9  20
       / \
      15  7
```

Minimum depth = 2 (3 → 9)

---

# 🚨 Why Your First Approach Was Wrong

You wrote:

```java
return 1 + Math.min(left, right);
```

This looks correct… BUT it fails in cases like:

```
     2
      \
       3
        \
         4
```

Here:

* left subtree = null → depth = 0
* right subtree = depth = 3

`Math.min(0,3)` = 0
So result = `1 + 0 = 1` ❌ WRONG.

The **minimum depth cannot consider a missing child**.

Because missing child (null) is NOT a path.

So we must handle this carefully.

---

# ✅ Correct Intuition

When computing minimum depth:

### ✔ If one child is NULL, we MUST take the depth of the other child.

Because the null path does not reach a leaf.

**Rule:**

* If left is null → min depth = 1 + right
* If right is null → min depth = 1 + left
* If both exist → min depth = 1 + min(left, right)

This is the only correct way.

---

# ⭐ Correct Code

```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // leaf node
        if (root.left == null && root.right == null)
            return 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // if one child is null, take the non-null child depth
        if (root.left == null) return 1 + right;
        if (root.right == null) return 1 + left;

        // if both children exist
        return 1 + Math.min(left, right);
    }
}
```

---

# 🔍 Step-by-Step Logic

### ✔ Case 1: `root == null`

No tree → depth = 0.

### ✔ Case 2: Leaf node (no children)

A leaf itself has depth 1.

### ✔ Case 3: Only one child exists

You cannot take the minimum of something and 0.
You must take the **existing child**.

### ✔ Case 4: Both children exist

Normal `min(left, right)` applies.

---

# 🧪 Example Dry Run

Tree:

```
      1
       \
        2
         \
          3
```

minDepth(3) = 1
minDepth(2) = 1 + 1 = 2
minDepth(1) = 1 + 2 = 3

Correct.

---

# 📊 Time Complexity

```
O(n)
```

Because:

* You visit each node once.
* Each node does constant work.

Where `n` = total number of nodes.

---

# 💾 Space Complexity

```
O(h)
```

Where `h` = height of the tree.

Worst case (skewed tree): `O(n)`
Best case (balanced tree): `O(log n)`

Space is from recursion call stack.

---

# 🎯 Final Summary

* Minimum depth means shortest path to any leaf.
* Missing child CANNOT be used in min comparison.
* Handle null child cases separately.
* Time: O(n), Space: O(h)

You now fully understand why the original solution fails and how the correct logic works.
