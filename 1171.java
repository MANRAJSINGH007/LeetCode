/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        
        if(head==null){
            return head;
        }
        
        if(head.next==null){
            if(head.val==0){
                return null;
            }
            
            return head;
        }
        
        Stack<ListNode> stack=new Stack<>();
        
        HashMap<Integer,ListNode> map=new HashMap<>();
        
        int sum=0;
        
        ListNode t=head;
        
        while(t!=null){
            int curr=t.val;
            sum+=curr;
            
            if(sum==0){
                head=t.next;
                while(!stack.isEmpty()){
                    stack.pop();
                }
                map=new HashMap<>();
            }
            
            else if(map.containsKey(sum)){
                
                ListNode temp=map.get(sum);
                
                int temp_sum=sum-t.val;
                
                while(stack.peek()!=temp){
                    ListNode removed=stack.pop();
                    map.remove(temp_sum);
                    temp_sum-=removed.val;
                }
                
                temp.next=t.next;
            }
            
            else{
                stack.push(t);
                map.put(sum,t);
            }
            
            t=t.next;
        }
        
        return head;
        
    }
}
