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
    
    public static void func(TreeNode root){
        
        if(root==null){
            return ;
        }
        
        func(root.right);
        root.val+=sum;
        sum=root.val;
        func(root.left);
        return ;
        
    }
    
    
    public TreeNode convertBST(TreeNode root) {
        
        sum=0;
        func(root);
        return root;
    }
}
