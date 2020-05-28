class Solution {
    public static int func(TreeNode root, int[] count) {
        if(root == null) return 0;
        count[root.val]++;
        if(root.left == null && root.right == null) {
            boolean flag = false;
            for(int i = 0; i < 10; i++) {
                if(flag && count[i] % 2 == 1) {
                    count[root.val]--;
                    return 0;
                }
                if(count[i] % 2 == 1) flag = true;
            }
            count[root.val]--;
            return 1;
        }
        int leftCount = func(root.left, count);
        int rightCount = func(root.right, count);
        count[root.val]--;
        return leftCount + rightCount;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        return func(root, new int[10]);
    }
}
