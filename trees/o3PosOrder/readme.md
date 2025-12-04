Postorder Traversal (LeetCode 145) – The Ultimate Thinking Guide

This README teaches you exactly how to think about postorder traversal.
Kept clean, crisp, and easy to revise anytime — matching your previous traversal guides perfectly.

🧠 1. What Is Postorder Traversal Really?

Postorder traversal is a DFS (Depth-First Search) technique for binary trees.

The intuition is:

⭐ “Process children completely before processing the parent.”

Traversal order:

Left → Right → Root


This makes postorder ideal for problems where child results must be ready before handling the parent.

🚀 2. The Core Pattern You Must Recognize

Postorder belongs to this family:

⭐ “DFS where ROOT is processed last.”

Use postorder when the task requires:

Deleting nodes from bottom-up

Freeing memory or destroying a tree

Computing subtree properties

Evaluating expression trees

Any problem where children must be processed before the root

Whenever the parent depends on children → think postorder.

🌳 3. How Postorder Works (Visual Understanding)

Consider this tree:

      1
     / \
    2   3
   / \
  4   5


Postorder visits:

4 → 5 → 2 → 3 → 1


Why?

Finish left subtree

Finish right subtree

Then finally handle root

🧩 4. Postorder Traversal – Clean Java Code
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        solve(root, al);
        return al;
    }

    public void solve(TreeNode root, ArrayList<Integer> al) {
        if (root == null) return;
        solve(root.left, al);   // Left
        solve(root.right, al);  // Right
        al.add(root.val);       // Root
    }
}


The recursive structure perfectly enforces the desired Left → Right → Root order.

🔁 5. Why Recursion Matches Postorder Perfectly?

Because recursion naturally handles:

Go left

Go right

Do work after both children finish

This “after both sides” behavior is exactly what postorder needs.

🔎 6. Step-by-Step Thinking Process

Whenever you see a postorder-related problem, follow this mental checklist:

✔ Step 1: “Does the root depend on both children?”

If yes → Postorder.

✔ Step 2: “Do I need bottom-up computation?”

Sum of subtree, height, tilt, diameter, etc.

✔ Step 3: “Follow L → R → Root.”
✔ Step 4: “Use recursion to handle children first.”
✔ Step 5: “Work at the end of the function.”

This pattern solves 90% of bottom-up tree problems.

📊 7. Time & Space Complexity

Let N = number of nodes

⏱ Time: O(n)

Every node is visited exactly once.

💾 Space:

Auxiliary (recursive DFS stack) → O(h)

Balanced tree: O(log n)

Skewed tree: O(n)

Output list → O(n)

⭐ Final Overall Space Complexity: O(n)
📝 8. Real Problems Where Postorder Shines

Use postorder when the task requires:

Computing subtree values:

height of tree

sum of nodes in subtree

diameter

tilt of tree

Constructing or evaluating expression trees

Deleting or freeing trees

Solving problems bottom-up

If the root needs results from both children → always think postorder.

🗺 9. Postorder Traversal Visualization

Tree:

    1
   / \
  2   3
 / \
1   3


Postorder result:

4 → 5 → 2 → 3 → 1


DFS visualization:

Go left deeply
Go right deeply
Process node last


Postorder always ends at the root.