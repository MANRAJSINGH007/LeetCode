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
    static List<List<Integer>> ans;
    public static int func(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            if(ans.size() == 0) ans.add(new ArrayList<>());
            ans.get(0).add(root.val);
            return 1;
        }
        int leftLength = func(root.left);
        int rightLength = func(root.right);
        int max = Math.max(leftLength, rightLength);
        if(ans.size() <= max) ans.add(new ArrayList<>());
        ans.get(max).add(root.val);
        return max + 1;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        int dummy = func(root);
        return ans;
    }
}
