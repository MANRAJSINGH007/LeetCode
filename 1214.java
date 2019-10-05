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
    
    public static void scan(TreeNode root, HashSet<Integer> set){
        
        if(root == null) return;
        
        set.add(root.val);
        scan(root.left, set);
        scan(root.right, set);
        return ;
        
    }
    
    public static boolean search(TreeNode root, HashSet<Integer> set, int target){
        
        if(root == null) return false;
        
        if(set.contains(target - root.val)) return true;
        
        return search(root.left, set, target) || search(root.right, set, target);
        
    }
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        
        HashSet<Integer> set = new HashSet<>();
        scan(root1, set);
        
        return search(root2, set, target);
        
    }
}
