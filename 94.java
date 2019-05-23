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
    static ArrayList<Integer> list=new ArrayList<Integer>();
    public static void inorder(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
        list.clear();
        inorder(root);
        return list;
        
    }
}
