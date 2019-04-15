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
    
    public static int robbery(TreeNode root, int flag, HashMap<TreeNode,Integer> map1, HashMap<TreeNode,Integer> map2)
    {
        if(root==null)
        {
            return 0;
        }
        if(flag==0)
        {
            if(map1.containsKey(root))
            {
                return map1.get(root);
            }
            int m1=root.val+robbery(root.left,1,map1,map2)+robbery(root.right,1,map1,map2);
            
            int m2=robbery(root.left,0,map1,map2)+robbery(root.right,0,map1,map2);
            
            if(m1>=m2)
            {
                map1.put(root,m1);
                return m1;
            }
            map1.put(root,m2);
            return m2;
        }
        else
        {
            if(map2.containsKey(root))
            {
                return map2.get(root);
            }
            int m2=robbery(root.left,0,map1,map2)+robbery(root.right,0,map1,map2);
            
            map2.put(root,m2);
            return m2;
        }
    }
    public int rob(TreeNode root) {
        
        HashMap<TreeNode,Integer> map1=new HashMap<>();
        HashMap<TreeNode,Integer> map2=new HashMap<>();
        
        return robbery(root,0,map1,map2);
        
    }
}
