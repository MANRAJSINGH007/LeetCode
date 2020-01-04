class Solution {
    static Node head;
    static Node temp;
    public static void dfs(Node root) {
        if(root == null) return;
        dfs(root.left);
        if(head == null) head = root;
        else {
            temp.right = root;
            root.left = temp;
        }
        temp = root;
        dfs(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        head = null;
        temp = null;
        dfs(root);
        head.left = temp;
        temp.right = head;
        return head;
    }
}
