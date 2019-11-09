class MedianFinder {

    static PriorityQueue<Integer> min;
    static PriorityQueue<Integer> max;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.size() == 0){
            max.add(num);
            return ;
        }
        
        if(max.size() == min.size()){
            
            if(min.peek() < num){
                max.add(min.poll());
                min.add(num);
                return ;
            }
            
            max.add(num);
            return ;
        }
        
        if(max.peek() > num){
            min.add(max.poll());
            max.add(num);
            return ;
        }
        
        min.add(num);
        return ;
        
    }
    
    public double findMedian() {
        if(max.size() == min.size()) return (1.0 * max.peek() + 1.0 * min.peek())/2;
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
