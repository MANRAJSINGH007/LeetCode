class Solution {
    static int n = 0;
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode t = head;
        while(t != null) {
            n++;
            ListNode temp = t.next;
            t.next = prev;
            prev = t;
            t = temp;
        }
        return prev;
    }
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) return new int[0];
        head = reverse(head);
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        ans[--n] = 0;
        ListNode t = head.next;
        stack.push(head.val);
        while(t != null) {
            while(stack.size() > 0 && stack.peek() <= t.val) stack.pop();
            if(stack.size() > 0) ans[--n] = stack.peek();
            else ans[--n] = 0;
            stack.push(t.val);
            t = t.next;
        }
        return ans;
    }
}
