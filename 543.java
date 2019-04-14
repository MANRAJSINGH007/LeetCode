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
    
    static int max_dia=0;
    
    public static int func(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        int left_height=func(root.left)+1;
        int right_height=func(root.right)+1;
        max_dia=Math.max(max_dia,left_height+right_height-2);
        return Math.max(left_height,right_height);
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        max_dia=0;
        int h=func(root);
        return max_dia;
        
    }
}
