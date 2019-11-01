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
    
    static int uid = 0;
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<Integer, TreeNode> trees = new HashMap<>();
    
    public static int look(TreeNode root){
        
        if(root == null) return 0;
        String curr = Integer.toString(root.val) + "," + Integer.toString(look(root.left)) + "," + Integer.toString(look(root.right));
        int currUid = -1;
        if(map.containsKey(curr)){
            currUid = map.get(curr);
            trees.put(currUid, root);
        }
        else currUid = ++ uid;
        map.put(curr, currUid);
        return currUid;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        uid = 0;
        map = new HashMap<>();
        trees = new HashMap<>();
        
        List<TreeNode> ans = new ArrayList<>();
        
        int id = look(root);
        Set<Integer> keys = trees.keySet();
        for(Integer i : keys){
            ans.add(trees.get(i));
        }
        
        return ans;
    }
}
