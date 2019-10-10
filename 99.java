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
    
    static TreeNode first = null;
    static TreeNode second = null;
    
    static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public static void func(TreeNode root){
        
        if(root == null) return ;
        
        func(root.left);
        
        if(root.val < prev.val){
            if(first == null){
                first = prev;
                second = root;
            }
            else{
                second = root;
            }
        }
        
        prev = root;
        func(root.right);
        
        return ;
        
    }
    
    public void recoverTree(TreeNode root) {
        
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        func(root);
        
        int k = first.val;
        first.val = second.val;
        second.val = k;
        
        return ;
        
    }
}
