/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        
        if(head == null) return 0;
        
        int n = G.length;
        if(n == 0 || n == 1) return n;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            set.add(G[i]);
        }
        
        ListNode prev = head;
        ListNode curr = head;
        
        int num_components = 0;
        
        while(curr != null){
            if(!set.contains(prev.val)){
                prev = prev.next;
                curr = prev;
            }
            else if(!set.contains(curr.val)){
                curr = curr.next;
                prev = curr;
            }
            else if(set.contains(curr.val)){
                if(prev == curr){
                    num_components++;
                    curr = curr.next;
                }
                else{
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        
        return num_components;
        
    }
}
