/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    static Node successor = null;
    public static void findMin(Node root, int x){
        while(root.left != null) root = root.left;
        successor = root;
        return ;
    }
    public Node inorderSuccessor(Node x) {
        successor = null;
        if(x.right != null) findMin(x.right, x.val);
        Node t = x.parent;
        while(t != null){
            if(t.val > x.val){
                if(successor == null || t.val < successor.val) successor = t;
            }
            t = t.parent;
        }
        
        return successor;
    }
}
