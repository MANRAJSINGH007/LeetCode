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
    
    public static boolean delete(TreeNode root, List<TreeNode> list, HashSet<Integer> set){
        
        if(root==null){
            return true;
        }
        
        boolean l=delete(root.left,list,set);
        boolean r=delete(root.right,list,set);
        
        if(!set.contains(root.val)){
            
            if(l){
                root.left=null;
            }
            
            if(r){
                root.right=null;
            }
            
            return false;
        }
        
        else{
            
            if(!l){
                list.add(root.left);
            }
            
            if(!r){
                list.add(root.right);
            }
            
            return true;
        }
        
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        HashSet<Integer> set=new HashSet<>();
        
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        
        List<TreeNode> list=new ArrayList<>();
        
        if(root==null){
            return list;
        }
        
        if(!set.contains(root.val)){
            list.add(root);
        }
        
        boolean x=delete(root,list,set);
        
        return list;
        
    }
}
