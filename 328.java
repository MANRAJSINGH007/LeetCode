/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }
        
        ListNode t=head;
        ListNode t_parent=null;
        ListNode p=null;
        ListNode even=null;
        
        while(t.next!=null){
            
            if(p==null){
                even=t.next;
                p=t.next;
                t.next=t.next.next;
                p.next=null;
            }
            else{
                p.next=t.next;
                p=p.next;
                t.next=t.next.next;
                p.next=null;
            }
            
            t_parent=t;
            t=t.next;
            if(t==null){
                break;
            }
        }
        
        if(t==null)
            t_parent.next=even;
        else
            t.next=even;
        return head;
    }
}
