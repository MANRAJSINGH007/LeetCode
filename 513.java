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
    
    
    static int max_level=-1;
    static int ans=-1;
    
    public static void func(TreeNode root, int level){
        
        if(root==null){
            return ;
        }
        
        func(root.left,level+1);
        
        if(level>max_level){
            ans=root.val;
            max_level=level;
        }
        
        func(root.right,level+1);
        
        return ;
    }
    
    
    public int findBottomLeftValue(TreeNode root) {
        
        ans=-1;
        max_level=-1;
        func(root,0);
        return ans;
    }
}
