class KthLargest {
    
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int K, int[] nums) {
        k = K;
        pq = new PriorityQueue<>();
        if(k > nums.length){
            for(int i : nums) pq.add(i);
        } else{
            int n = nums.length;
            for(int i = 0; i < k; i++) pq.add(nums[i]);
            
            for(int i = k; i < n; i++){
                if(pq.peek() < nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        
        if(pq.size() < k){
            pq.add(val);
            return pq.peek();
        } else{
            if(pq.peek() < val){
                pq.poll();
                pq.add(val);
            }
            
            return pq.peek();
        }
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
