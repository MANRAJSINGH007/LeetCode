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
    
    static int count = 0;
    
    public static boolean func(TreeNode root){
        
        boolean b = true;
        boolean b1 = true, b2 = true;
        
        if(root.left != null){
            b1 = func(root.left);
            b = b && (b1 && root.val == root.left.val);
        }
        
        if(root.right != null){
            b2 = func(root.right);
            b = b && (b2 && root.val == root.right.val);
        }
        
        if(b) count++;
        return b;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        if(root == null) return 0;
        boolean dummy = func(root);
        return count;
    }
}
