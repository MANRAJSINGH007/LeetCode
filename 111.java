class Solution {
    public int minDepth(TreeNode root) {
        
        if(root==null)
        {
            return 0;
        }
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        int l=1000000;
        if(root.left!=null)
        {
            l=minDepth(root.left)+1;
        }
        int r=1000000;
        if(root.right!=null)
        {
            r=minDepth(root.right)+1;
        }
        
        if(l<r)
        {
            return l;
        }
        else
        {
            return r;
        }
    }
}
