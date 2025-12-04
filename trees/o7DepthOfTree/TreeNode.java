package trees.o7DepthOfTree;
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
class o7DepthOfTree {
public int minDepth(TreeNode root) {
if (root == null) return 0;
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