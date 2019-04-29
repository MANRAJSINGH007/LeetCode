/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null){
            return l2;
        }
        
        if(l2==null){
            return l1;
        }
        
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode p1=null;
        ListNode p2=null;

        if(l1.val<=l2.val){
            
            while(t1!=null && t2!=null){
                
                if(t1.val<=t2.val){
                    p1=t1;
                    t1=t1.next;
                }
                else{
                    p1.next=t2;
                    t2=t2.next;
                    p1.next.next=t1;
                    p1=p1.next;
                }
            }
            
            if(t2!=null){
                p1.next=t2;
            }
            
            return l1;
            
        }
        
        else{
            
            while(t1!=null && t2!=null){
                
                if(t2.val<=t1.val){
                    p2=t2;
                    t2=t2.next;
                }
                else{
                    p2.next=t1;
                    t1=t1.next;
                    p2.next.next=t2;
                    p2=p2.next;
                }
            }
            
            if(t1!=null){
                p2.next=t1;
            }
            
            return l2;
            
        }
        
    }
}
