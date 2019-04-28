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
    
    public static boolean func(TreeNode root1, TreeNode root2){
        
        if(root1==null && root2==null){
            return true;
        }
        
        if(root1==null || root2==null || root1.val!=root2.val){
            return false;
        }
        
        return (func(root1.left,root2.left) && func(root1.right,root2.right)) || (func(root1.left,root2.right) && func(root1.right,root2.left));
        
    }
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return func(root1,root2);
    }
}
