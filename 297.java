/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "#";
        
        return Integer.toString(root.val) + "," + serialize(root.left) + serialize(root.right);
        
    }

    // Decodes your encoded data to tree.
    
    static int i = -1;
    static int n = 0;
    
    public static TreeNode helper(String data){
        
        i ++;
        if(data.charAt(i) == ',') i++;
        if(data.charAt(i) == '#') return null;
        
        String str = "" + data.charAt(i);
        while(i + 1 < n && data.charAt(i + 1) != '#' && data.charAt(i + 1) != ','){
            i ++;
            str += data.charAt(i);
        }
        
        if(data.charAt(i) == ',') i ++;
        
        TreeNode curr = new TreeNode(Integer.parseInt(str));
        curr.left = helper(data);
        curr.right = helper(data);
        return curr;
        
    }
    
    public TreeNode deserialize(String data) {
        
        i = -1;
        n = data.length();
        System.out.println(data);
        return helper(data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
