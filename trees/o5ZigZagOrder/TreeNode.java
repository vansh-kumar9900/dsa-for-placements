package trees.o5ZigZagOrder;

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
class o5ZigZagOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        solve(root,ans,q);
        return ans;
    }
    public void solve(TreeNode root,List<List<Integer>> ans,Queue<TreeNode> q){
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                al.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(level % 2 == 0){
                ans.add(al);
            }else{
                Collections.reverse(al);
                ans.add(al);
            }
            level++;
        }
    }
}