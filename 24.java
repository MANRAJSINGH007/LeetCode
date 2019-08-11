/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public static ListNode swapNodes(ListNode head){
        
        ListNode t=head.next;
        ListNode temp=head.next.next;
        
        head.next=null;
        t.next=head;
        head=t;
        
        t=head.next;
        
        while(temp!=null && temp.next!=null){
            ListNode first=temp;
            ListNode second=temp.next;
            
            temp=temp.next.next;
            
            t.next=second;
            second.next=first;
            first.next=temp;
            t=first;
        }
        
        if(temp!=null && temp.next==null){
            t.next=temp;
        }
        
        return head;
        
    }
    
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }
        
        return swapNodes(head);
        
    }
}
