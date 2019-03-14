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
    static ArrayList<Integer> list=new ArrayList<Integer>();
    static int index=0;
    public static void leaf(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        leaf(root.left);
        if(root.left==null && root.right==null)
        {
            list.add(root.val);
        }
        leaf(root.right);
        
    }
    public static void check(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        check(root.left);
        if(root.left==null && root.right==null)
        {
            if(index>=list.size())
            {
                index =Integer.MAX_VALUE;
                return ;
            }
            if(root.val!=list.get(index))
            {
                return ;
            }
            
            index++;
            
        }
        check(root.right);
        return ;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        list.clear();
        index=0;
        leaf(root1);
        check(root2);
        if(index==list.size())
        {
            return true;
        }
        
        return false;
        
    }
}
