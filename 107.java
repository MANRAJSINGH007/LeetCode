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
    
    static int max=0;
    
    public static void func(TreeNode root, int level, HashMap<Integer,List<Integer>> map){
        
        if(root==null){
            return ;
        }
        
        max=Math.max(max,level);
        
        if(map.containsKey(level)){
            List<Integer> curr=map.get(level);
            curr.add(root.val);
        }
        
        else{
            List<Integer> curr=new ArrayList<>();
            curr.add(root.val);
            map.put(level,curr);
        }
        
        func(root.left,level+1,map);
        func(root.right,level+1,map);
    }
    
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        max=0;
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        func(root,0,map);
        for(int i=max;i>=0;i--){
            list.add(map.get(i));
        }
        
        return list;
        
    }
}
