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
    
    public static TreeNode func(TreeNode root, TreeNode p, TreeNode q){
        
        if(root==null){
            return root;
        }
        
        if(root==p || root==q){
            return root;
        }
        
        TreeNode curr1=func(root.left,p,q);
        TreeNode curr2=func(root.right,p,q);
        
        if(curr1==null){
            return curr2;
        }
        
        if(curr2==null){
            return curr1;
        }
        
        return root;
        
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return func(root,p,q);
    }
}
