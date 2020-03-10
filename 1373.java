class Pair {
    int max;
    int min;
    int sum;
    boolean flag;
    Pair(int max, int min, int sum, boolean flag) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.flag = flag;
    }
}
class Solution {
    static int m = 0;
    public static Pair dfs(TreeNode root) {
        if(root == null) return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
        Pair l = dfs(root.left);
        Pair r = dfs(root.right);
        if(l.max >= root.val || r.min <= root.val) return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        int t = l.sum + r.sum + root.val;
        if(!l.flag && !r.flag) m = Math.max(m, t);
        r.max = Math.max(r.max, root.val);
        l.min = Math.min(l.min, root.val);
        return new Pair(r.max, l.min, t, false);
    }
    public int maxSumBST(TreeNode root) {
        m = 0;
        Pair x = dfs(root);
        return m;
    }
}
