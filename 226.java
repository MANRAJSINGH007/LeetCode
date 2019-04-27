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
    
    public static TreeNode func(TreeNode root){
        
        if(root==null){
            return root;
        }
        
        TreeNode old_left=root.left;
        root.left=func(root.right);
        root.right=func(old_left);
        
        return root;
    }
    
    
    public TreeNode invertTree(TreeNode root) {
        
        return func(root);
        
    }
}
