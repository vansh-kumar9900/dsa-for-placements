package trees.o2InOrder;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class o2InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        solve(root, l);
        return l;
    }

    public void solve(TreeNode root, ArrayList<Integer> l) {
        if (root == null)
            return;
        solve(root.left, l);
        l.add(root.val);
        solve(root.right, l);
    }
}
