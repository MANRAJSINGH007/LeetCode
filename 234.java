/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    static ListNode n_head=null;
    
    public static void reverse(ListNode head, ListNode prev){
        
        if(head==null){
            n_head=prev;
            return ;
        }
        
        reverse(head.next,head);
        head.next=prev;
        return ;
        
    }
    
    public boolean isPalindrome(ListNode head) {
        
        n_head=null;
        if(head==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        reverse(slow.next,null);
        slow.next=null;
        
        ListNode t1=head;
        ListNode t2=n_head;
        while(t2!=null){
            if(t1.val!=t2.val){
                return false;
            }
            t1=t1.next;
            t2=t2.next;
        }

        return true;
    }
}
