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
    public static TreeNode dfs(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        if(original.val == target.val) return cloned;
        TreeNode ans = dfs(original.left, cloned.left, target);
        return ans == null ? dfs(original.right, cloned.right, target) : ans;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }
}
