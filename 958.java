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
    public boolean isCompleteTree(TreeNode root) {
        
        if(root==null){
            return true;
        }
        
        int flag=0;
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        TreeNode temp=null;
        q.add(root);
        q.add(temp);
        while(q.size()!=1){
            
            TreeNode p=q.remove();
            if(p==temp){
                q.add(temp);
                continue;
            }
            
            if(flag==1 && (p.left!=null || p.right!=null)){
                return false;
            }
            
            if(p.left==null && p.right==null){
                flag=1;
            }
            
            if(p.left==null && p.right!=null){
                return false;
            }
            
            if(p.left!=null && p.right==null){
                flag=1;
            }
            
            if(p.left!=null){
                q.add(p.left);
            }
            
            if(p.right!=null){
                q.add(p.right);
            }
            
        }
        
        return true;
        
        
    }
}
