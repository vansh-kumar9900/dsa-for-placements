package trees.o3PosOrder;
import java.util.*;
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
class o3PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        solve(root,al);
        return al;
    }
    public void solve(TreeNode root, ArrayList<Integer> al){
        if(root == null) return;
        solve(root.left,al);
        solve(root.right,al);
        al.add(root.val);
    }
}