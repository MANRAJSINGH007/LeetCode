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
    
    static List<String> list=new ArrayList<>();
    
    public static void func(TreeNode root, String str){
        
        if(root==null){
            return ;
        }
        
        if(root.left==null && root.right==null){
            str+=Integer.toString(root.val);
            list.add(str);
            return ;
        }
        
        str+=Integer.toString(root.val);
        str+="->";
        
        func(root.left,str);
        func(root.right,str);
        return ;
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        list=new ArrayList<>();
        func(root,"");
        return list;
        
    }
}
