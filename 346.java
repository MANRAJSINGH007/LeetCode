class MovingAverage {

    /** Initialize your data structure here. */
    static Deque<Integer> q;
    static int sum;
    static int n;
    public MovingAverage(int size) {
        q = new LinkedList<>();
        sum = 0;
        n = size;
    }
    
    public double next(int val) {
        if(q.size() == n) sum -= q.pop();
        q.addLast(val);
        sum += val;
        return (1.0 * sum)/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
