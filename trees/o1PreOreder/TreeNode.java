package trees.o1PreOreder;
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
class o1PreOreder {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        solve(root,al);
        return al;
    }
    public void solve(TreeNode root, ArrayList<Integer> al){
        if(root == null) return;
        al.add(root.val);
        solve(root.left,al);
        solve(root.right,al);
    }
}