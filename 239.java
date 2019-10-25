class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        if(n == 0) return new int[0];
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < k - 1; i++){
            
            int curr = nums[i];
            while(q.size() > 0 && nums[q.getLast()] <= curr) q.removeLast();
            q.addLast(i);
        }
        
        for(int i = k - 1; i < n; i++){
            int curr = nums[i];
            while(q.size() > 0 && nums[q.getLast()] <= curr) q.removeLast();
            q.addLast(i);
            while(q.size() > 0 && q.getFirst() <= i - k) q.removeFirst();
            ans[i - k + 1] = nums[q.peekFirst()];
        }
        
        return ans;
        
    }
}
