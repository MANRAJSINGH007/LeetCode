class Pair{
    int sum;
    int num;
    Pair(int sum, int num){
        this.sum = sum;
        this.num = num;
    }
}
class Solution {
    static double max = 0;
    public static Pair func(TreeNode root){
        if(root == null) return new Pair(0, 0);
        if(root.left == null && root.right == null) max = Math.max(max, (double)root.val);
        Pair l = func(root.left);
        Pair r = func(root.right);
        int num = 1 + l.num + r.num;
        int sum = root.val + l.sum + r.sum;
        max = Math.max(max, (1.0 * sum)/num);
        return new Pair(sum, num);
    }
    public double maximumAverageSubtree(TreeNode root) {
        max = 0;
        Pair obj = func(root);
        return max;
    }
}
