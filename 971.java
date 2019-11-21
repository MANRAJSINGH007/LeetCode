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
    
    static int i = -1;
    static List<Integer> list;
    
    public static boolean preOrder(TreeNode root, int[] voyage){
        
        i ++;
        if(root.val != voyage[i]) return false;
        if(root.left == null && root.right == null) return true;
        if(root.left == null) return preOrder(root.right, voyage);
        if(root.right == null) return preOrder(root.left, voyage);
        int currIndex = i;
        boolean b = preOrder(root.left, voyage) && preOrder(root.right, voyage);
        if(b) return true;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        list.add(root.val);
        i = currIndex;
        return preOrder(root.left, voyage) && preOrder(root.right, voyage);
    }
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        
        list = new ArrayList<>();
        i = -1;
        boolean b = preOrder(root, voyage);
        if(!b){
            list = new ArrayList<>();
            list.add(-1);
        }
        return list;
    }
}
