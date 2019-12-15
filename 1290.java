/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        
        ListNode t = head;
        int ans = 0;
        while(t != null){
            ans *= 2;
            ans += t.val;
            t = t.next;
        }
        
        return ans;
    }
}
