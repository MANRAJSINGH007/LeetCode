class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        head = null;
        tail = null;
    }
    
    public int get(int index) {
        int count = 0;
        ListNode t = head;
        while(t != null && count < index) {
            count++;
            t = t.next;
        }
        if(count == index && t != null) return t.val;
        return -1;
    }
    
    public void addAtHead(int val) {
        if(head == null) {
            head = new ListNode(val);
            tail = head;
        } else {
            ListNode t = new ListNode(val);
            t.next = head;
            head.prev = t;
            head = t;
        }
    }
    
    public void addAtTail(int val) {
        ListNode t = new ListNode(val);
        if(tail == null) {
            head = t;
            tail = t;
        } else {
            tail.next = t;
            t.prev = tail;
            tail = t;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0) {
           addAtHead(val);
            return;
        }
        int count = 0;
        ListNode t = head;
        while(t != null && count < index - 1) {
            count++;
            t = t.next;
        }
        ListNode x = new ListNode(val);
        ListNode temp = t.next;
        t.next = x;
        x.prev = t;
        x.next = temp;
        if(temp != null) temp.prev = x;
        else tail = x;
        return;
    }
    
    public void deleteAtIndex(int index) {
        if(index == 0) {
            head = head.next;
            if(head != null) head.prev = null;
            if(head == null) tail = null;
            return;
        }
        int count = 0;
        ListNode t = head;
        ListNode p = null;
        while(t != null && count < index) {
            count++;
            p = t;
            t = t.next;
        }
        if(t == null) return;
        p.next = t.next;
        if(p.next != null) p.next.prev = p;
        else tail = p;
    }
}
