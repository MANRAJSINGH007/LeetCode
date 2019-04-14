/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    static ListNode new_head=null;
    
    public static void func(ListNode head, ListNode prev){
        
        if(head==null){
            new_head=prev;
            return ;
        }
        
        func(head.next,head);
        head.next=prev;
        return ;
        
    }
    
    public ListNode reverseList(ListNode head) {
        
        new_head=null;
        func(head,null);
        return new_head;
        
    }
}
