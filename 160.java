/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null){
            return null;
        }
        
        if(headB==null){
            return null;
        }
        
        ListNode t1=headA;
        ListNode t2=headB;
        
        int c1=0;
        int c2=0;
        
        while(t1!=null){
            c1++;
            t1=t1.next;
        }
        
        while(t2!=null){
            t2=t2.next;
            c2++;
        }
        
        if(c1>=c2){
            
            t1=headA;
            t2=headB;
            
            int diff=c1-c2;
            
            while(diff!=0){
                diff--;
                t1=t1.next;
            }
            
            while(t1!=null && t2!=null){
                if(t1==t2){
                    return t1;
                }
                
                t1=t1.next;
                t2=t2.next;
            }
            
            return null;
            
        }
        
        else{
            
            t1=headA;
            t2=headB;
            
            int diff=c2-c1;
            
            while(diff!=0){
                diff--;
                t2=t2.next;
            }
            
            while(t1!=null && t2!=null){
                if(t1==t2){
                    return t1;
                }
                
                t1=t1.next;
                t2=t2.next;
            }
            
            return null;
            
        }
        
    }
}
