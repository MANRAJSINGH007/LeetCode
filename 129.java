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
    
    static int sum=0;
    
    public static void func(TreeNode root, int x){
        
        if(root==null){
            return ;
        }
        
        
        if(root.left==null && root.right==null){
            sum+=10*x+root.val;
        }
        
        func(root.left,x*10+root.val);
        func(root.right,x*10+root.val);
        
        return ;
        
    }
    
    public int sumNumbers(TreeNode root) {
        
        sum=0;
        func(root,0);
        return sum;
    }
}
