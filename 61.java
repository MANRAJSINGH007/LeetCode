/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null){
            return head;
        }
        
        int c=0;
        ListNode t1=head;
        
        while(t1!=null){
            t1=t1.next;
            c++;
        }
        
        k=k%c;
        if(k==0){
            return head;
        }
        
        c=0;
        t1=head;
        ListNode t2=head;
        while(c!=k){
            c++;
            t2=t2.next;
        }
        
        ListNode p1=null;
        ListNode p2=null;
        while(t2!=null){
            p1=t1;
            t1=t1.next;
            p2=t2;
            t2=t2.next;
        }
        
        p1.next=null;
        p2.next=head;
        return t1;
        
    }
}
