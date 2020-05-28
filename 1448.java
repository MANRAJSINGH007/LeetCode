class Solution {
    public static int func(TreeNode root, int max) {
        if(root == null) return 0;
        int count = 0;
        if(root.val >= max) count++;
        count += func(root.left, Math.max(max, root.val));
        count += func(root.right, Math.max(max, root.val));
        return count;
    }
    public int goodNodes(TreeNode root) {
        return func(root, -100000);
    }
}
