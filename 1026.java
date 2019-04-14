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
    
    static int max_val=0;
    
    public static void func(TreeNode root, int max, int min){
        
        if(root==null){
            return ;
        }
        
        max_val=Math.max(max_val,Math.abs(max-root.val));
        max_val=Math.max(max_val,Math.abs(min-root.val));
        
        if(root.val>max){
            max=root.val;
        }
        if(root.val<min){
            min=root.val;
        }
        
        func(root.left,max,min);
        func(root.right,max,min);
        
        return ;
        
    }
    
    public int maxAncestorDiff(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        max_val=0;
        func(root,root.val,root.val);
        
        return max_val;
        
    }
}
