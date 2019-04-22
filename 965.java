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
    static int x=-100;
    public static boolean func(TreeNode root)
    {
        if(root==null)
        {
            return true;
        }
        if(root.val!=x)
        {
            return false;
        }
        
        return func(root.left) && func(root.right);
    }
    public boolean isUnivalTree(TreeNode root) {
        
        if(root==null)
        {
            return true;
        }
        
        x=root.val;
        
        return func(root);
        
    }
}
