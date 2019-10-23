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
    
    public static boolean func(TreeNode root, int currSum, int limit){
        
        if(root == null) return true;
        
        currSum += root.val;
        
        if(root.left == null && root.right == null){
            if(currSum < limit) return true;
            return false;
        }
        
        boolean l = func(root.left, currSum, limit);
        boolean r = func(root.right, currSum, limit);
        
        if(l && r) return true;
        if(l) root.left = null;
        if(r) root.right = null;
        
        return false;
        
    }
    
    
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        
        if(func(root, 0, limit)) return null;
        return root;
        
    }
}
