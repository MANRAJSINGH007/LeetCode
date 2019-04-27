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
    
    static int sum=0;
    
    public static int func(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        int l_sum=func(root.left);
        int r_sum=func(root.right);
        sum+=Math.abs(l_sum-r_sum);
        return root.val+l_sum+r_sum;
        
    }
    
    public int findTilt(TreeNode root) {
        
        sum=0;
        int t=func(root);
        return sum;
        
    }
}
