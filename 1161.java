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
    public int maxLevelSum(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int max=root.val;
        int level=1;
        
        q.add(null);
        
        int temp=0;
        int i=1;
        
        while(q.size()!=1){
            
            TreeNode p=q.remove();
        
            if(p==null){
                q.add(null);
                if(temp>max){
                    max=temp;
                    level=i;
                }
                temp=0;
                i++;
            }
            
            else{
                temp+=p.val;
                
                if(p.left!=null){
                    q.add(p.left);
                }
                
                if(p.right!=null){
                    q.add(p.right);
                }
            }
            
        }
        
        return level;
        
    }
}
