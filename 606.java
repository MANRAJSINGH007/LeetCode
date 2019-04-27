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
        
        String ans=Integer.toString(root.val);
        if(root.left!=null && root.right!=null){
            ans+="(";
            ans+=func(root.left);
            ans+=")";
            ans+="(";
            ans+=func(root.right);
            ans+=")";
            return ans;
        }
        
        if(root.left==null && root.right==null){
            return ans;
        }
        
        if(root.right==null){
            return ans+"("+func(root.left)+")";
        }
        
        return ans+"("+")"+"("+func(root.right)+")";
        
    }
    
    
    public String tree2str(TreeNode root) {
        
        return func(root);
        
    }
}
