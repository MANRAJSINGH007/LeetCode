class Solution {
    static List<Integer> arr;
    public static void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);
    }
    public static TreeNode build(List<Integer> arr, int st, int end) {
        if(st > end) return null;
        if(st == end) return new TreeNode(arr.get(st));
        int mid = (st + end)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = build(arr, st, mid - 1);
        root.right = build(arr, mid + 1, end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        arr = new ArrayList<>();
        dfs(root);
        return build(arr, 0, arr.size() - 1);
    }
}
