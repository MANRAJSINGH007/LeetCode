/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head==null || head.next==null){
            return false;
        }
        
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        if(fast==null){
            return false;
        }
        while(slow!=fast){
            
            slow=slow.next;
            if(fast.next==null || fast.next.next==null){
                return false;
            }
            
            fast=fast.next.next;
            
        }
        
        return true;
        
    }
}
