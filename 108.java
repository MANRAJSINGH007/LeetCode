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
        
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(arr[mid]);
        
        root.left=func(arr,start,mid-1);
        root.right=func(arr,mid+1,end);
        return root;
    }
    
    
    public TreeNode sortedArrayToBST(int[] arr) {
        
        int n=arr.length;
        return func(arr,0,n-1);
    }
}
