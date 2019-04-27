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
    
    int min;
    int max;
    
    Pair(int min, int max){
        this.min=min;
        this.max=max;
    }
    
}


class Solution {
    
    static int diff=Integer.MAX_VALUE;
    
    public static Pair func(TreeNode root){
        
        if(root==null){
            return null;
        }
        
        Pair l=func(root.left);
        Pair r=func(root.right);
        
        if(l==null && r==null){
            return new Pair(root.val,root.val);
        }
        
        if(l==null){
            diff=Math.min(diff,r.min-root.val);
            return new Pair(root.val,r.max);
        }
        
        if(r==null){
            diff=Math.min(diff,root.val-l.max);
            return new Pair(l.min,root.val);
        }
        
        diff=Math.min(diff,Math.min(root.val-l.max,r.min-root.val));
        return new Pair(l.min,r.max);
        
    }
    
    public int getMinimumDifference(TreeNode root) {
        
        diff=Integer.MAX_VALUE;
        Pair x=func(root);
        return diff;
        
    }
}
