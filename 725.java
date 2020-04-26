class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int c = 0;
        ListNode t = root;
        while(t != null) {
            t = t.next;
            c++;
        }
        int d = c % k == 0 ? c / k : c / k + 1;
        ListNode[] ans = new ListNode[k];
        int it = 0, size = d, total = c;
        t = root;
        while(t != null) {
            int count = 0;
            ListNode prev = null, curr = t;
            while(t != null && count < size) {
                prev = t;
                t = t.next;
                count++;
            }
            if(prev != null) prev.next = null;
            ans[it++] = curr;
            total -= size;
            k--;
            if(k > 0 && total % k == 0) size = total / k;
        }
        return ans;
    }
}
