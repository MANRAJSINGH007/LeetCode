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
    
    public static TreeNode func(TreeNode t1, TreeNode t2){
        
        if(t1==null){
            return t2;
        }
        
        if(t2==null){
            return t1;
        }
        
        t1.val+=t2.val;
        t1.left=func(t1.left,t2.left);
        t1.right=func(t1.right,t2.right);
        return t1;
    }
    
    
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        return func(t1,t2);
        
    }
}
