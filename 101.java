/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public static boolean func(TreeNode r1, TreeNode r2){
        
        if(r1==null && r2==null){
            return true;
        }
        
        if(r1==null || r2==null){
            return false;
        }
        
        return r1.val==r2.val && func(r1.left,r2.right) && func(r1.right,r2.left);
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        
        return func(root,root);
    }
}
