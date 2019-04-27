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
    
    public static TreeNode func(TreeNode root, int L, int R){
        
        if(root==null){
            return null;
        }
        
        if(root.val<L){
            return func(root.right,L,R);
        }
        
        if(root.val>R){
            return func(root.left,L,R);
        }
        
        root.left=func(root.left,L,R);
        root.right=func(root.right,L,R);
        
        return root;
        
    }
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        
        return func(root,L,R);
        
    }
}
