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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        
        while(q.size()!=1)
        {
            TreeNode p=q.remove();
            if(p==null)
            {
                list.add(curr);
                curr=new ArrayList<>();
                q.add(null);
            }
            else
            {
                curr.add(p.val);
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
            }
        }
        
        list.add(curr);
        return list;
        
        
    }
}
