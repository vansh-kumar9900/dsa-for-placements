Preorder Traversal (LeetCode 144) – The Ultimate Thinking Guide

This README teaches you exactly how to think about preorder traversal in binary trees.
It is written in the clearest possible way so that when you revisit it later, everything makes sense instantly.

🧠 1. What Is Preorder Traversal Really?

Preorder traversal is one of the fundamental DFS (Depth-First Search) techniques for trees.

But instead of thinking of it as “visit root first,” think of it as:

⭐ A systematic DFS where

you process a node the moment you arrive at it.

Traversal order:

Root → Left → Right


This makes preorder perfect for:

Serializing a tree

Creating a clone of a tree

Generating prefix expressions

Any problem where ROOT should be handled first

🚀 2. The Core Pattern You Must Recognize

Preorder is part of this pattern:

⭐ “DFS where work is done before recursion calls”

Whenever a problem says:

Process root first

Build something top-down

Generate prefix/parent-first structure

→ Immediately think preorder.

🌳 3. How Preorder Actually Works (Visual Understanding)

Consider this tree:

      1
     / \
    2   3
   / \
  4   5


Preorder visits nodes in the exact sequence:

1 → 2 → 4 → 5 → 3


Because:

Start at root → 1

Go to left subtree

Then right subtree

At every node, the pattern is:

Process node  
Go left  
Go right

🧩 4. Preorder Traversal – Clean Java Code
public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> al = new ArrayList<>();
    solve(root, al);
    return al;
}

public void solve(TreeNode root, ArrayList<Integer> al) {
    if (root == null) return;
    al.add(root.val);      // Process Root
    solve(root.left, al);  // Go Left
    solve(root.right, al); // Go Right
}


This is the simplest, cleanest recursive DFS.

🔁 5. Why Recursion Works So Well?

Because recursion itself forms a natural DFS:

Before recursive calls → process root

During recursion → visit children

Preorder aligns perfectly with recursive stack behavior.

🔎 6. Step-by-Step Thinking Process

Whenever you see a tree traversal question:

✔ Step 1: “Is this DFS?”

If yes → proceed.

✔ Step 2: “Do I need to process the root first?”

If yes → preorder.

✔ Step 3: “What do I do at each node?”

Add value → al.add(root.val)

✔ Step 4: “Then where do I go?”

Left → Right

✔ Step 5: “Stop when node is null.”

This template applies to EVERY preorder problem.

📊 7. Time & Space Complexity

Let N = number of nodes

⏱ Time: O(n)

Every node is visited once.

💾 Space:

Auxiliary (recursion depth) → O(h)

Balanced tree: O(log n)

Skewed tree: O(n)

Output list → O(n)

⭐ Final Space: O(n)
📝 8. Use Cases of Preorder (Where It Helps in Real Problems)

Tree → array conversion

Serialization + Deserialization

Copying a tree

Constructing prefix expressions

Any top-down building problem

Recognizing when preorder is required saves huge time in interviews.

🗺 9. Visualization of Preorder DFS
      1
     / \
    2   3
   / \
  4   5


Preorder path:

1 → 2 → 4 → 5 → 3


Graph-like DFS flow:

1
↓
2
↓
4 (dead end)
↑
5 (dead end)
↑
3 (dead end)


Every branch is explored root-first.