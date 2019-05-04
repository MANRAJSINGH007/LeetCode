/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if(head==null){
            return head;
        }
        
        ListNode t=head;
        ListNode p=null;
        
        while(t!=null){
            
            if(head.val==val){
                head=head.next;
                t=head;
                p=head;
            }
            else if(t.val==val){
                p.next=t.next;
                t=t.next;
            }
            else{
                p=t;
                t=t.next;
            }
            
        }
        
        return head;
        
    }
}
