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
        
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode t=head.next;
        ListNode p=head;
        
        while(true){
            
            while(t!=null && t.val==p.val){
                t=t.next;
            }
            
            if(t==null){
                p.next=null;
                return head;
            }
            p.next=t;
            p=t;
            t=t.next;
        }
        
        // return head;
    }
}
