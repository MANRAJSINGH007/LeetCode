class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(s2.size() > 0) s1.push(s2.pop());
        s1.push(x);
        while(s1.size() > 0) s2.push(s1.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s2.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
