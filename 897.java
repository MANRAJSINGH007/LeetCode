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
    
    TreeNode curr;
    TreeNode bottom;
    
    Pair(TreeNode curr, TreeNode bottom){
        this.curr=curr;
        this.bottom=bottom;
    }
    
}

class Solution {
    
    public static Pair func(TreeNode root){
        
        if(root==null){
            return new Pair(null,null);
        }
        
        Pair l=func(root.left);
        Pair r=func(root.right);
        
        if(l.curr==null && r.curr==null){
            return new Pair(root,root);
        }
        
        if(l.curr==null){
            
            root.right=r.curr;
            return new Pair(root,r.bottom);
        }
        
        if(r.curr==null){
            l.bottom.right=root;
            root.left=null;
            return new Pair(l.curr,root);
        }
        
        l.bottom.right=root;
        root.left=null;
        root.right=r.curr;
        return new Pair(l.curr,r.bottom);
        
        
    }
    
    
    public TreeNode increasingBST(TreeNode root) {
        
        return func(root).curr;
        
    }
}
