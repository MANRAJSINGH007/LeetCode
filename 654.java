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
    
    public static TreeNode func(int[] nums, int start, int end){
        
        if(start>end){
            return null;
        }
        
        int max=nums[start];
        int index=start;
        for(int i=start+1;i<=end;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        
        TreeNode root=new TreeNode(nums[index]);
        root.left=func(nums,start,index-1);
        root.right=func(nums,index+1,end);
        return root;
    }
    
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return func(nums,0,nums.length-1);
    }
}
