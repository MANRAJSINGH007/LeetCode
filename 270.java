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
    static double min = Double.MAX_VALUE;
    static int value = -1;
    public static void func(TreeNode root, double target){
        if(root == null) return ;
        if(min > Math.abs((double)root.val - target)){
            min = Math.abs((double)root.val - target);
            value = root.val;
        }
        if((double)root.val <= target) func(root.right, target);
        else func(root.left, target);
    }
    public int closestValue(TreeNode root, double target) {
        min = Double.MAX_VALUE;
        value = -1;
        func(root, target);
        return value;
    }
}
