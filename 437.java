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
    
    public static int func(TreeNode root, int curr, int target, HashMap<Integer,Integer> map){
        
        if(root==null){
            return 0;
        }
        
        curr+=root.val;
        int ans=0;
        if(map.containsKey(curr-target)){
            ans+=map.get(curr-target);
        }
        int c=0;
        if(map.containsKey(curr)){
            c=map.get(curr);
            c++;
            map.put(curr,c);
        }
        else{
            map.put(curr,1);
        }
        ans+=func(root.left,curr,target,map)+func(root.right,curr,target,map);
        c=map.get(curr);
        c--;
        map.put(curr,c);
        
        return ans;
        
    }
    
    public int pathSum(TreeNode root, int sum) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        return func(root,0,sum,map);
    }
}
