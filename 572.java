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
    
    public static String func(TreeNode root){
        
        if(root==null){
            return "";
        }
        
        String ans=func(root.left);
        ans+=Integer.toString(root.val);
        ans+=func(root.right);
        
        return ans;
    }
    
    public static String preorder(TreeNode root){
        
        if(root==null){
            return "";
        }
        
        String ans=Integer.toString(root.val);
        ans+=preorder(root.left);
        ans+=preorder(root.right);
        
        return ans;
    }
    
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        String s1=func(s);
        String s2=func(t);
        
        String s3=preorder(s);
        String s4=preorder(t);
        
        if(s1.indexOf(s2)==-1){
            return false;
        }
        
        if(s3.indexOf(s4)==-1){
            return false;
        }
        
        return true;
        
    }
}
