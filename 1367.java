class Solution {
    public static boolean check(TreeNode root, ListNode head) {
        if(head == null) return true;
        if(root == null) return false;
        if(root.val != head.val) return false;
        return check(root.left, head.next) || check(root.right, head.next);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        return check(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
