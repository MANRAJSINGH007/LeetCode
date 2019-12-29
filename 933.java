class RecentCounter {

    static Deque<Integer> q;
    static int count = 0;
    public RecentCounter() {
        q = new LinkedList<>();
        count = 0;
    }
    
    public int ping(int t) {
        while(q.size() > 0 && q.peekFirst() < t - 3000){
            q.removeFirst();
            count --;
        }
        q.addLast(t);
        return ++count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
