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
    static TreeNode successor = null;
    public static void findMin(TreeNode root, int x){
        while(root.left != null) root = root.left;
        successor = root;
        return ;
    }
    public static void func(TreeNode root, TreeNode p){
        if(root == null) return;
        if(root == p){
            if(root.right != null) findMin(root.right, p.val);
            return ;
        }
        if(root.val > p.val) successor = root;
        if(p.val >= root.val) func(root.right, p);
        else func(root.left, p);
        return ;
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        successor = null;
        func(root, p);
        if(successor == null || successor.val <= p.val) return null;
        return successor;
    }
}
