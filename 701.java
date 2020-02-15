class Solution {
    public TreeNode insertIntoBST(TreeNode root, int x) {
        
        TreeNode y=root;
        TreeNode p=root;
        TreeNode m=new TreeNode(x);
        while(y!=null)
        {
            p=y;
            if(x<y.val)
            {
                y=y.left;
            }
            else
            {
                y=y.right;
            }
        }
        if(x>p.val)
        {
            p.right=m;return root;
        }
        p.left=m;
        return root;
        
    }
}
