class Solution {
    public static TreeNode func(TreeNode root, int target) {
        if(root == null) return root;
        root.left = func(root.left, target);
        root.right = func(root.right, target);
        if(root.left == null && root.right == null && root.val == target) return null;
        return root;
    } 
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return func(root, target);
    }
}
