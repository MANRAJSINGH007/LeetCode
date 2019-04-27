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
    public List<Integer> largestValues(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        
        List<Integer> list=new ArrayList<Integer>();
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        q.add(null);
        int curr_max=Integer.MIN_VALUE;
        
        while(q.size()!=1){
            
            TreeNode p=q.remove();
            if(p==null){
                list.add(curr_max);
                q.add(p);
                curr_max=Integer.MIN_VALUE;
            }
            
            else{
                curr_max=Math.max(curr_max,p.val);
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
            }
            
        }
        
        list.add(curr_max);
        return list;
        
    }
}
