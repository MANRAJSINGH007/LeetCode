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
    
    public static int func(TreeNode root, int x, int y){
        
        if(root==null){
            return 0;
        }
        
        int sum=0;
        
        if(root.val>=x && root.val<=y){
            sum+=root.val;
            sum+=func(root.left,x,y);
            sum+=func(root.right,x,y);
            return sum;
        }
        
        if(root.val<x){
            return func(root.right,x,y);
        }
        
        return func(root.left,x,y);
        
    }
    
    
    
    public int rangeSumBST(TreeNode root, int x, int y) {
        
        return func(root,x,y);
        
    }
}
