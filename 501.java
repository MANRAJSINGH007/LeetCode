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
    
    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    
    private int[] modes;
    
    public void handle(int val){
        
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
        
    }
    
    public void inorder(TreeNode root){
        
        if(root==null){
            return ;
        }
        
        inorder(root.left);
        handle(root.val);
        inorder(root.right);
        
        return ;
        
    }
    
    public int[] findMode(TreeNode root){
        
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
        
    }
}
