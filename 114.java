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
    
    static TreeNode curr=null;
    
    public static void func(TreeNode root){
        
        if(root==null){
            return ;
        }
        
        TreeNode l=root.left;
        TreeNode r=root.right;
        
        if(curr!=null){
            curr.right=root;
        }
        curr=root;
        func(l);
        root.left=null;
        func(r);
        
    }
    
    public void flatten(TreeNode root) {
        
        curr=null;
        func(root);
    }
}
