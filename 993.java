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
    
    static int lev=-1;
    static TreeNode parent=null;
    
    public static boolean search(TreeNode root, TreeNode par, int level, int key){
        
        if(root==null){
            
            return false;
            
        }
        
        if(root.val==key){
            
            lev=level;
            parent=par;
            return true;
            
        }
        
        if(search(root.left,root,level+1,key)){
            
            return true;
            
        }
        
        return search(root.right,root,level+1,key);
        
    }
    
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        
        if(root.val==x || root.val==y){
            
            return false;
        }
        
        lev=-1;
        parent=null;
        
        search(root,null,0,x);
        
        int lev1=lev;
        TreeNode par1=parent;
        
        search(root,null,0,y);
        
        if(lev1==lev && parent!=par1){
            
            return true;
            
        }
        
        return false;
        
    }
}
