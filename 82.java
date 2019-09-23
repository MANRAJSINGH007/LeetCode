/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode t1 = head;
        ListNode t2 = head.next;
        
        ListNode prev = newHead;
        
        while(t1 != null){
            
            int flag = 0;
            
            while(t2 != null && t1.val == t2.val){
                t2 = t2.next;
                flag = 1;
            }
            
            if(flag == 1){
                prev.next = t2;
                t1 = t2;
                if(t1 == null) return newHead.next;
                t2 = t2.next;
            }
            else{
                if(t2 == null) return newHead.next;
                prev = t1;
                t1 = t2;
                t2 = t2.next;
            }
            
        }
        
        return newHead.next;
        
    }
}
