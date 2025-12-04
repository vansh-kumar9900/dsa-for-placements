Right Side View of Binary Tree (LeetCode 199) – Complete Explained Guide

This README explains what the right-side view is, why BFS works for it, and how the logic flows — all in a short, easy-to-revise manner.

🧠 1. What Is the Right Side View?

The Right Side View of a binary tree means:

⭐ “The set of nodes visible when you look at the tree from the right side.”

For every level of the tree, you only take the rightmost node.

Example:

      1
     / \
    2   3
     \
      5


Right side view:

[1, 3, 5]


Because at each level:

Level 0 → rightmost = 1

Level 1 → rightmost = 3

Level 2 → rightmost = 5

🚀 2. Intuition Behind the Approach

We perform a level order BFS, because BFS processes nodes level by level.

During BFS:

Collect all nodes of the current level

The last element of that list = the rightmost node

Add it to the result

This is the simplest and cleanest way to compute the right side view.

🌳 3. Code (Your Code, Cleaned for README)
class o6RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        solve(root, ans, q);
        return ans;
    }

    public void solve(TreeNode root, List<Integer> ans, Queue<TreeNode> q) {
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                al.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            // Rightmost element of this level
            ans.add(al.get(al.size() - 1));
        }
    }
}

🔍 4. How the Logic Works (Short Explanation)
✔ Step 1: Use a queue to perform BFS

We process the tree level by level.

✔ Step 2: For each level, extract all node values

Store them in al.

✔ Step 3: The last node of the level = rightmost node

al.get(al.size() - 1) is the only node visible from the right.

✔ Step 4: Add it to the answer

Repeat for every level.

📊 5. Time & Space Complexity (Explained)
⏱ Time Complexity → O(N)

Each node is pushed and popped from the queue once

Level processing is O(N) total

💾 Space Complexity → O(W)

Queue holds at most W nodes (max width of tree)

Output list is O(H) where H = height of tree

Worst case → O(N)

📝 6. When to Use Right Side View BFS?

Use this approach when:

You are asked for right view of a tree

You need one node per level

You want level-wise traversal with visibility constraints

You need the last node of every level

This is one of the most common tree interview patterns.

🗺 7. Visual Walkthrough

Tree:

    1
   / \
  2   3
   \
    5


Levels:

Level 0 → [1]     → take 1
Level 1 → [2,3]   → take 3
Level 2 → [5]     → take 5


Right side view = [1, 3, 5]