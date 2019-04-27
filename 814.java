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
    
    int sum;
    TreeNode node;
    Pair(int sum, TreeNode node){
        this.sum=sum;
        this.node=node;
    }
    
}

class Solution {
    
    public static Pair func(TreeNode root){
        
        if(root==null){
            return new Pair(0,null);
        }
        
        Pair l=func(root.left);
        Pair r=func(root.right);
        root.left=l.node;
        root.right=r.node;
        int s=0;
        
        if(l.node!=null){
            s+=l.sum;
        }
        if(r.node!=null){
            s+=r.sum;
        }
        
        s+=root.val;
        if(s==0){
            return new Pair(0,null);
        }
        
        return new Pair(s,root);
        
    }
    
    public TreeNode pruneTree(TreeNode root) {
        return func(root).node;
    }
}
