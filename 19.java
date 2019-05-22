/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head==null){
            return head;
        }
        
        if(head.next==null && n==1){
            return null;
        }
        
        ListNode t1=head;
        ListNode p=null;
        ListNode t2=head;
        int c=0;
        
        while(c!=n){
            c++;
            t2=t2.next;
        }
        
        while(t2!=null){
            p=t1;
            t1=t1.next;
            t2=t2.next;
        }
        
        if(p==null){
            return head.next;
        }
        
        p.next=t1.next;
        return head;
        
    }
}
