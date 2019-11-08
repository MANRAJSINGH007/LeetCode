class Solution {
    public int lastStoneWeight(int[] stones) {
        
        int n = stones.length;
        if(n == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) pq.add(stones[i]);
        
        while(pq.size() > 0){
            int y = pq.poll();
            if(pq.size() == 0) return y;
            int x = pq.poll();
            if(x != y) pq.add(y - x);
        }
        
        return 0;
    }
}
