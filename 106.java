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
    
    public static TreeNode func(int[] in, int[] post, int s1, int e1, int s2, int e2){
        
        if(s1>e1){
            return null;
        }
        
        int element=post[e2];
        TreeNode root=new TreeNode(element);
        int index=-1;
        for(int i=s1;i<=e1;i++){
            if(in[i]==element){
                index=i;
                break;
            }
        }
        
        int c1=index-s1;
        root.left=func(in,post,s1,index-1,s2,s2+c1-1);
        root.right=func(in,post,index+1,e1,s2+c1,e2-1);
        return root;
        
    }
    
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n=inorder.length;
        return func(inorder,postorder,0,n-1,0,n-1);
    }
}
