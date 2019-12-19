class Solution {
    public int connectSticks(int[] sticks) {
        int n = sticks.length;
        if(n <= 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) pq.add(sticks[i]);
        int cost = 0;
        while(pq.size() > 1){
            int mergeCost = pq.poll() + pq.poll();
            cost += mergeCost;
            pq.add(mergeCost);
        }
        return cost;
    }
}
