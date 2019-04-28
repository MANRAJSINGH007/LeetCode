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
    
    static List<List<Integer>> list=new ArrayList<>();
    
    public static void func(TreeNode root, int sum, List<Integer> curr){
        
        if(root==null){
            return ;
        }
        
        curr.add(root.val);
        sum-=root.val;
        
        if(root.left==null && root.right==null){
            if(sum==0){
                
                List<Integer> temp=new ArrayList<Integer>();
                for(int i=0;i<curr.size();i++){
                    temp.add(curr.get(i));
                }
                
                list.add(temp);
            }
            System.out.print(curr.get(0));
            curr.remove(curr.size()-1);
            return ;
        }
        
        func(root.left,sum,curr);
        func(root.right,sum,curr);
        curr.remove(curr.size()-1);
        return ;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        list=new ArrayList<>();
        
        if(root==null){
            return list;
        }
        
        List<Integer> curr=new ArrayList<>();
        
        func(root,sum,curr);
        
        return list;
        
    }
}
