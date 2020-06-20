class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode curr = head, prev = null, newHead = null;
        while(curr != null) {
            count++;
            if(count == m) {
                if(prev != null) prev.next = null;
                ListNode e = prev;
                ListNode j = curr;
                prev = null;
                while(count <= n) {
                    ListNode t = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = t;
                    count++;
                }
                if(e != null) e.next = prev;
                j.next = curr;
                if(m == 1) head = prev;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
