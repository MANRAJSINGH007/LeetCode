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
    
    public static boolean func(TreeNode root, int sum, HashSet<Integer> set){
        
        if(root==null){
            return false;
        }
        
        if(set.contains(sum-root.val)){
            return true;
        }
        
        set.add(root.val);
        return func(root.left,sum,set) || func(root.right,sum,set);
        
    }
    
    public boolean findTarget(TreeNode root, int k) {
        
        return func(root,k,new HashSet<Integer>());
        
    }
}
