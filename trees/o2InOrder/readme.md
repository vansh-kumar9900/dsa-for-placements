Inorder Traversal (LeetCode 94) – The Ultimate Thinking Guide

This README teaches you exactly how to think about inorder traversal.
It is written in a clear, crisp format so you instantly understand and remember how it works.

🧠 1. What Is Inorder Traversal Really?

Inorder traversal is a DFS (Depth-First Search) technique for binary trees.

But here’s the real intuition:

⭐ It explores the tree from left → root → right,

making it perfect for retrieving values in sorted order for BSTs.

Traversal order:

Left → Root → Right


This makes inorder the most important traversal for BST-related questions.

🚀 2. The Core Pattern You Must Recognize

Inorder belongs to this pattern:

⭐ “DFS where the LEFT subtree must be processed before ROOT”

Use inorder when the problem wants:

Sorted representation of a BST

Range queries

Kth smallest/largest element

Validate BST

Flatten BST to array/list

Whenever order matters → think inorder.

🌳 3. How Inorder Works (Visual Understanding)

Example tree:

      4
     / \
    2   6
   / \
  1   3


Inorder visits nodes in:

1 → 2 → 3 → 4 → 6


It processes the entire left subtree before visiting root, ensuring sorted output (for BSTs).

🧩 4. Inorder Traversal – Clean Java Code
class o2InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        solve(root, l);
        return l;
    }

    public void solve(TreeNode root, ArrayList<Integer> l) {
        if (root == null)
            return;
        solve(root.left, l); // Left
        l.add(root.val);     // Root
        solve(root.right, l); // Right
    }
}


This is the purest, simplest DFS inorder implementation.

🔁 5. Why Recursion Fits Inorder Perfectly?

Because the recursive structure naturally enforces:

Go to left subtree

Visit root

Go to right subtree

Exactly the order required.

The recursion stack mimics the DFS path with zero effort.

🔎 6. Step-by-Step Thinking Process

Whenever you see an inorder problem, follow this mindset:

✔ Step 1: “Does left come first?”

If yes → this is inorder.

✔ Step 2: “Do I need sorted tree output?”

If yes → MUST use inorder.

✔ Step 3: “Process left → root → right.”

Order is crucial.

✔ Step 4: “Return values in a list.”
✔ Step 5: “Stop recursion at null nodes.”

This simple thinking solves 90% of tree traversal problems.

📊 7. Time & Space Complexity

Let N = number of nodes

⏱ Time: O(n)

Each node is visited once.

💾 Space:

Auxiliary (recursion stack) → O(h)

Balanced tree: O(log n)

Skewed tree: O(n)

Output list → O(n)

⭐ Final Overall Space Complexity: O(n)
📝 8. When To Use Inorder in Real Problems?

Use inorder if the problem involves:

Getting values from a BST in sorted order

Kth smallest or largest element

Validate if a tree is a BST

Recover a corrupted BST

Convert BST → array/list

Transform BST → greater sum tree

These are all pure inorder problems.

🗺 9. Inorder Traversal Visualization

Tree:

    4
   / \
  2   5
 / \
1   3


Inorder path:

1 → 2 → 3 → 4 → 5


DFS visualization:

Go left until null
Process node
Go right


This generates a clean left-to-right order.