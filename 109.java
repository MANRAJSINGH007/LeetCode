/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    
    public static ListNode findMiddle(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode parent = null;
        
        while(fast.next != null && fast.next.next != null){
            parent = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(parent == null){
            return parent;
        }
        
        if(fast.next == null){
            return parent;
        }
        
        return slow;
    }
    
    public static TreeNode func(ListNode head){
        
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            return new TreeNode(head.val);
        }
        
        ListNode parent = findMiddle(head);
        
        if(parent == null){
            TreeNode curr = new TreeNode(head.val);
            curr.right = new TreeNode(head.next.val);
            return curr;
        }
        
        ListNode temp = parent.next;
        
        TreeNode root = new TreeNode(temp.val);
        parent.next = null;
        
        root.left = func(head);
        root.right = func(temp.next);
        
        return root;
        
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head == null){
            return null;
        }
        
        return func(head);
        
    }
}
