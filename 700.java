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
    public TreeNode searchBST(TreeNode root, int x) {
        
        if(root==null)
        {
            return null;
        }
        if(root.val==x)
        {
            return root;
        }
        if(x<root.val)
        {
            return searchBST(root.left,x);
            
        }
        
        return searchBST(root.right,x);
        
    }
}
