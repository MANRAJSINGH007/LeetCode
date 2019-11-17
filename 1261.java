/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    
    static TreeNode r;

    public FindElements(TreeNode root) {
        r = root;
        r.val = 0;
        cleanTree(r, null, false);
    }
    
    public static void cleanTree(TreeNode root, TreeNode parent, boolean left){
        if(root == null) return ;
        
        if(parent != null){
            if(left == true) root.val = 2 * parent.val + 1;
            else root.val = 2 * parent.val + 2;
        }
        
        cleanTree(root.left, root, true);
        cleanTree(root.right, root, false);
        
        return ;
    }
    
    public static boolean searchTarget(TreeNode root, int target){
        
        if(root == null) return false;
        if(root.val == target) return true;
        return searchTarget(root.left, target) || searchTarget(root.right, target);
        
    }
    
    public boolean find(int target) {
        return searchTarget(r, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
