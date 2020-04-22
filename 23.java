class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for(int i = 0; i < lists.length; i++) if(lists[i] != null) pq.add(lists[i]);
        ListNode head = new ListNode(0);
        ListNode t = head;
        while(pq.size() > 0) {
            ListNode l = pq.remove();
            ListNode temp = l.next;
            l.next = null;
            t.next = l;
            t = l;
            if(temp != null) pq.add(temp);
        }
        return head.next;
    }
}
