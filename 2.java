/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
//     static ListNode new_head=null;
//     public static void reverse(ListNode head, ListNode prev){
//         if(head==null){
//             new_head=prev;
//             return ;
//         }
        
//         reverse(head.next,head);
//         head.next=prev;
//         return ;
//     }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1==null){
            // reverse(l2,null);
            return l2;
        }
        
        if(l2==null){
            // reverse(l1,null);
            return l1;
        }
        
        int c1=0;
        int c2=0;
        ListNode t=l1;
        while(t!=null){
            t=t.next;
            c1++;
        }
        t=l2;
        while(t!=null){
            t=t.next;
            c2++;
        }
        
        if(c1>=c2){
            
            ListNode t1=l1;
            ListNode t2=l2;
            int carry=0;
            ListNode p=null;
            
            while(t2!=null){
                p=t1;
                int sum=carry+t1.val+t2.val;
                t1.val=sum%10;
                t1=t1.next;
                t2=t2.next;
                carry=sum/10;
            }
            
            if(carry==0){
                // reverse(l1,null);
                return l1;
            }
            
            while(carry==1 && t1!=null){
                p=t1;
                int sum=carry+t1.val;
                t1.val=sum%10;
                t1=t1.next;
                carry=sum/10;
            }
            
            if(carry==0){
                // reverse(l1,null);
                return l1;
            }
            
            p.next=new ListNode(1);
            // reverse(l1,null);
            return l1;
            
        }
        
        ListNode t1=l1;
        ListNode t2=l2;
        int carry=0;
        ListNode p=null;

        while(t1!=null){
            p=t2;
            int sum=carry+t1.val+t2.val;
            t2.val=sum%10;
            t2=t2.next;
            t1=t1.next;
            carry=sum/10;
        }

        if(carry==0){
            // reverse(l2,null);
            return l2;
        }

        while(carry==1 && t2!=null){
            p=t2;
            int sum=carry+t2.val;
            t2.val=sum%10;
            t2=t2.next;
            carry=sum/10;
        }

        if(carry==0){
            // reverse(l2,null);
            return l2;
        }

        p.next=new ListNode(1);
        // reverse(l2,null);
        return l2;
    }
}
