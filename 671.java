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
    
    static long x1=Long.MAX_VALUE;
    static long x2=Long.MAX_VALUE;
    
    public static void func(TreeNode root){
        
        if(root==null){
            return ;
        }
        
        long curr=(long)root.val;
        
        if(curr<x1){
            x2=x1;
            x1=curr;
        }
        
        else if(curr<x2 && curr!=x1){
            x2=curr;
        }
        
        func(root.left);
        func(root.right);
        
        return ;
        
    }
    
    public int findSecondMinimumValue(TreeNode root) {
        
        if(root==null){
            return -1;
        }
        
        x1=Long.MAX_VALUE;
        x2=Long.MAX_VALUE;
        
        func(root);
        
        if(x1==Long.MAX_VALUE || x2==Long.MAX_VALUE){
            return -1;
        }
        
        return (int)x2;
        
    }
}
