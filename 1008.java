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
    
    public static TreeNode func(int[] arr, int start, int end){
        
        if(start>end){
            return null;
        }
        
        TreeNode root=new TreeNode(arr[start]);
        if(start==end){
            return root;
        }
        
        int index1=-1;
        int index2=-1;
        for(int i=start+1;i<=end;i++){
            if(arr[i]<arr[start]){
                index1=i;
            }
            else{
                index2=i;
                break;
            }
        }
        if(index1!=-1)
            root.left=func(arr,start+1,index1);
        if(index2!=-1)
            root.right=func(arr,index2,end);
        return root;
        
    }
    
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return func(preorder,0,preorder.length-1);
    }
}
