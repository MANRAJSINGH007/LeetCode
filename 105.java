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
    
    public static TreeNode func(int[] pre, int[] in, int s1, int e1, int s2, int e2){
        
        if(s1>e1){
            return null;
        }
        
        TreeNode root=new TreeNode(pre[s1]);
        
        int index=-1;
        for(int k=s2;k<=e2;k++){
            if(in[k]==pre[s1]){
                index=k;
                break;
            }
        }
        
        int count=index-s2;
        
        root.left=func(pre,in,s1+1,s1+count,s2,index-1);
        root.right=func(pre,in,s1+count+1,e1,index+1,e2);
        return root;
        
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return func(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
}
