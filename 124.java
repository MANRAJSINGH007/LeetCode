class Solution {
    
    static int max=Integer.MIN_VALUE;
    
    public static int func(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        int l=Math.max(func(root.left),0);
        int r=Math.max(func(root.right),0);
        
        max=Math.max(l+r+root.val,max);
        
        return Math.max(l,r)+root.val;
        
    }
    
    public int maxPathSum(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        max=Integer.MIN_VALUE;
        int x=func(root);
        return max;
    }
}
