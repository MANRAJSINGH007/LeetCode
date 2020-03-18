class CustomStack {
    static int i;
    static int n;
    static int[] marker;
    static Stack<Integer> stack;
    public CustomStack(int maxSize) {
        i = 0;
        n = maxSize;
        marker = new int[n];
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(i == n) return;
        stack.push(x);
        i++;
    }
    
    public int pop() {
        if(i == 0) return - 1;
        i--;
        int actual = stack.pop() + marker[i];
        marker[i] = 0;
        return actual;
    }
    
    public void increment(int k, int val) {
        for(int j = 0; j < Math.min(i, k); j++) marker[j] += val;
    }
}
