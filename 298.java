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
    static int max = 1;
    public static int func(TreeNode root){
        if(root == null) return 0;
        int l = func(root.left);
        int r = func(root.right);
        if(l == 0 && r == 0) return 1;
        int curr = 1;
        if(l != 0 && root.left.val == root.val + 1) curr = Math.max(curr, l + 1);
        if(r != 0 && root.right.val == root.val + 1) curr = Math.max(curr, r + 1);
        max = Math.max(max, curr);
        return curr;
    }
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        max = 1;
        func(root);
        return max;
    }
}
