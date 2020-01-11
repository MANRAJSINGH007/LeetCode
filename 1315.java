class Solution {
    static int sum;
    public static void dfs(TreeNode root, int grandParent, int parent) {
        if(root == null) return;
        if(grandParent % 2 == 0) sum += root.val;
        dfs(root.left, parent, root.val);
        dfs(root.right, parent, root.val);
    }
    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        dfs(root, -1, -1);
        return sum;
    }
}
