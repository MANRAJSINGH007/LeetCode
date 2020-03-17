class Solution {
    public static TreeNode dfs(TreeNode root, int d, int v, int left) {
        if(d == 1) {
            TreeNode r = new TreeNode(v);
            if(left == 1) r.left = root;
            else r.right = root;
            return r;
        }
        if(root == null) return null;
        root.left = dfs(root.left, d - 1, v, 1);
        root.right = dfs(root.right, d - 1, v, 0);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode r = new TreeNode(v);
            r.left = root;
            return r;   
        }
        root.left = dfs(root.left, d - 1, v, 1);
        root.right = dfs(root.right, d - 1, v, 0);
        return root;
    }
}
