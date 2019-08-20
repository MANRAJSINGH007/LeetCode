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
    
    static int max_depth=-1;
    static TreeNode t1=null;
    static TreeNode t2=null;
    
    public static void function(TreeNode root, int depth){
        
        if(root==null){
            return ;
        }
        
        if(root.left==null && root.right==null){
            
            if(depth>max_depth){
                max_depth=depth;
                t1=root;
                t2=null;
            }
            
            else if(depth==max_depth){
                t2=root;
            }
            
        }
        
        function(root.left,depth+1);
        function(root.right,depth+1);
        
        return ;
        
    }
    
    public static TreeNode lca(TreeNode root){
        
        if(root==null){
            return null;
        }
        
        if(root==t1 || root==t2){
            return root;
        }
        
        TreeNode l=lca(root.left);
        TreeNode r=lca(root.right);
        
        if(l!=null && r!=null){
            return root;
        }
        
        if(l!=null){
            return l;
        }
        
        return r;
        
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
         max_depth=-1;
         t1=null;
         t2=null;
        
         function(root,0);
         if(t2==null || t1==t2){
             return t1;
         }
        
         return lca(root);
        
    }
}
