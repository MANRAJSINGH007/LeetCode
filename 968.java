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
    private Map<TreeNode, Integer> mustMap, coveredMap, notMap;
    
    public int minCameraCover(TreeNode root) {
        mustMap = new HashMap<>();
        coveredMap = new HashMap<>();
        notMap = new HashMap<>();
        return getCount(root, false, false);
    }
    
    private int getCount(TreeNode node, boolean must, boolean covered) {
        if (node == null) {
            return 0;
        }
        if (must) {
            if (mustMap.containsKey(node)) {
                return mustMap.get(node);
            }
            
            int count = getCount(node.left, false, true) + getCount(node.right, false, true) + 1;
            mustMap.put(node, count);
            return count;
        } else {
            
            if (covered) {
                if (coveredMap.containsKey(node)) {
                    return coveredMap.get(node);
                }
                int count = Math.min(getCount(node.left, false, true) + getCount(node.right, false, true) + 1, 
                                getCount(node.left, false, false) + getCount(node.right, false, false));
                coveredMap.put(node, count);
                return count;
            } else {
                if (notMap.containsKey(node)) {
                    return notMap.get(node);
                }
                int count = getCount(node.left, false, true) + getCount(node.right, false, true) + 1;
                if (node.left != null) {
                    count = Math.min(count, getCount(node.left, true, false) + getCount(node.right, false, false));
                }
                if (node.right != null) {
                    count = Math.min(count, getCount(node.right, true, false) + getCount(node.left, false, false));
                }
                notMap.put(node, count);
                return count;
            }
        }
    }
}
