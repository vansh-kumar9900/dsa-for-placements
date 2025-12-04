ZigZag Level Order Traversal (LeetCode 103) – Complete Explained Guide

This README explains what ZigZag traversal is, how it works, why we use it, and how the logic flows internally — all in a simple, clean way.

🧠 1. What Is ZigZag Level Order Traversal?

ZigZag traversal is a variation of Level Order BFS where the direction of traversal changes at every level.

Level 0 → Left to Right

Level 1 → Right to Left

Level 2 → Left to Right

and so on…

It creates an S-shaped or spiral traversal pattern.

Why this is useful?

Some tree problems require alternate ordering (e.g., UI tree views, layered printing, special BFS variations).

🌳 2. Intuition Behind ZigZag Traversal

Start BFS normally.
But after collecting all nodes at a level:

If level is even → keep as it is

If level is odd → reverse the collected list

This reversal gives the ZigZag pattern.

Example tree:

     1
    / \
   2   3


ZigZag Output:

[ [1], [3,2] ]


Explanation:
Level 0 → [1] (normal)
Level 1 → [2,3] → reversed → [3,2]

🚀 3. Code (Your Code, Structured Cleanly)
class o5ZigZagOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        solve(root, ans, q);
        return ans;
    }

    public void solve(TreeNode root, List<List<Integer>> ans, Queue<TreeNode> q) {
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                al.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(level % 2 == 0) {
                ans.add(al);
            } else {
                Collections.reverse(al);
                ans.add(al);
            }
            level++;
        }
    }
}

🔍 4. How the Logic Works (Short Explanation)
✔ Step 1: Use a Queue for BFS

Level order uses FIFO structure to process nodes layer by layer.

✔ Step 2: Track level number

level % 2 == 0 → normal
level % 2 != 0 → reverse

✔ Step 3: Process size nodes (the entire current level)

This ensures each level is handled separately.

✔ Step 4: Add children to queue

This builds the next level.

✔ Step 5: Reverse alternate levels

This creates the ZigZag pattern.

📊 5. Time & Space Complexity (Explained)
⏱ Time Complexity → O(N)

Each node is processed once (poll)

Each node is added once (offer)

Reversing each level still adds up to at most N operations

Total → O(N)

💾 Space Complexity → O(N)

Queue stores at most W nodes (width of the tree) → O(W)

Level list stores up to W values → O(W)

Final result stores all N nodes → O(N)

Worst case → O(N)

📝 6. When You Should Use ZigZag Traversal

Use this approach when:

The problem asks for zigzag/spiral/S-shaped traversal

You need left-to-right and right-to-left alternation

You want flexible level processing with direction control

It is widely used in interview questions to test BFS + list manipulation skills.

🗺 7. Visual Walkthrough

For this tree:

      1
     / \
    2   3
   / \
  4   5


ZigZag:

Level 0: [1]
Level 1: [3, 2]
Level 2: [4, 5]


Pattern:

Left → Right
Right → Left
Left → Right