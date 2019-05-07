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
    
   static long min=Long.MIN_VALUE;
    
   public static boolean func(TreeNode root){
       
       if(root==null){
           return true;
       }
       
       if(!func(root.left)){
           return false;
       }
       if(root.val<=min){
           return false;
       }
       
       min=root.val;
       return func(root.right);
       
    }
    
    public boolean isValidBST(TreeNode root) {
        
        long min=Long.MIN_VALUE;
        return func(root);
    }
}
