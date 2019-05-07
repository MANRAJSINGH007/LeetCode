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
    
    public static TreeNode findMinimum(TreeNode root){
        
        while(root.left!=null){
            root=root.left;
        }
        
        return root;
        
    }
    
    public static TreeNode delete(TreeNode root, int key){
        
        if(root==null){
            return null;
        }
        
        if(root.val==key){
            if(root.left==null && root.right==null){
                return null;
            }
            
            if(root.left==null){
                return root.right;
            }
            
            if(root.right==null){
                return root.left;
            }
            
            TreeNode temp=findMinimum(root.right);
            TreeNode dummy=delete(root.right,temp.val);
            temp.left=root.left;
            temp.right=dummy;
            return temp;
        }
        
        if(root.val<key){
            root.right=delete(root.right,key);
        }
        
        else{
            root.left=delete(root.left,key);
        }
        
        return root;
        
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
}
