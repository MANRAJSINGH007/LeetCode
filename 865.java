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
    
    static int max = 0;
    static TreeNode ans = null;
    static int count = 0;
    
    public static void traverse(TreeNode root, int level){
        
        if(root == null) return ;
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
        if(level > max){
            max = level;
            ans = root;
            count = 1;
        } else if(level == max){
            count++;
        }
        
        return ;
    }
    
    public static int findDeepest(TreeNode root, int level){
        
        if(root == null) return 0;
        if(level == max) return 1;
        
        int left = findDeepest(root.left, level + 1);
        int right = findDeepest(root.right, level + 1);
        if(ans == null && left + right == count) ans = root;
        return left + right;
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        if(root == null) return root;
        if(root.left == null && root.right == null) return root;
        max = 0;
        count = 0;
        ans = null;
        traverse(root, 0);
        if(count == 1) return ans;
        ans = null;
        int cnt = findDeepest(root, 0);
        return ans;
    }
}
