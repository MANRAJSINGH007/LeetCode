class Solution {
    static int max = 0;
    public static void dfs(TreeNode root, int prev, int curr) {
        max = Math.max(max, curr);
        if(root == null) return;
        if(prev == 1) {
            dfs(root.left, -1, curr + 1);
            dfs(root.right, 1, 0);
            return;
        } else if(prev == 0) {
            dfs(root.left, -1, 0);
            dfs(root.right, 1, 0);
            return;
        } else {
            dfs(root.left, -1, 0);
            dfs(root.right, 1, curr + 1);
            return;
        }
    }
    public int longestZigZag(TreeNode root) {
        max = 0;
        dfs(root, 0, 0);
        return max;
    }
}
