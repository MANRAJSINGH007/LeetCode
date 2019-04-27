/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Pair{
    
    int h;
    boolean b;
    Pair(int h, boolean b){
        this.h=h;
        this.b=b;
    }
    
}

class Solution {
    
    public static Pair func(TreeNode root){
        
        if(root==null){
            return new Pair(0,true);
        }
        
        Pair l=func(root.left);
        Pair r=func(root.right);
        if(!l.b || !r.b){
            return new Pair(0,false);
        }
        
        if(Math.abs(l.h-r.h)>1){
            return new Pair(0,false);
        }
        
        return new Pair(1+Math.max(l.h,r.h),true);
        
    }
    
    public boolean isBalanced(TreeNode root) {
        
        return func(root).b;
        
    }
}
