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
    
    static int max=1;
    
    public static int func(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        int x=1;
        int l=0;
        int r=0;
        int flag=0;
        
        if(root.left!=null){
            l=func(root.left);
            if(root.left.val==root.val){
                flag++;
                x+=l;
            }
        }
        
        if(root.right!=null){
            r=func(root.right);
            if(root.right.val==root.val){
                flag++;
                x+=r;
            }
        }
        
        max=Math.max(max,x);
        if(flag==2){
            return Math.max(l,r)+1;
        }
        
        return x;
        
    }
    
    
    public int longestUnivaluePath(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        max=1;
        int s=func(root);
        return max-1;
        
    }
}
