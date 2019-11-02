class Leaderboard {
    
    static HashMap<Integer, Integer> map;
    static PriorityQueue<Integer> pq;

    public Leaderboard() {
        
        map = new HashMap<>();
        pq = new PriorityQueue<>();
    }
    
    public void addScore(int playerId, int score) {
        
        if(!map.containsKey(playerId)) map.put(playerId, 0);
        map.put(playerId, map.get(playerId) + score);
        
    }
    
    public int top(int k) {
        
        pq = new PriorityQueue<>();
        Set<Integer> keys = map.keySet();
        int sum = 0;
        for(Integer key : keys){
            if(pq.size() < k) {
                sum += map.get(key);
                pq.add(map.get(key));
            }
            else if(pq.peek() < map.get(key)){
                sum -= pq.poll();
                sum += map.get(key);
                pq.add(map.get(key));
            }
        }
        
        return sum;
        
    }
    
    public void reset(int playerId) {
        
        map.put(playerId, 0);
        
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
