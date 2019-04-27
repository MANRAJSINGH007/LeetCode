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
        
        TreeNode l=func(root.left,p,q);
        TreeNode r=func(root.right,p,q);
        
        if(l==null){
            return r;
        }
        
        if(r==null){
            return l;
        }
        
        return root;
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return func(root,p,q);
    }
}
