class Pair {
    int ans;
    int count;
    Pair(int ans, int count) {
        this.ans = ans;
        this.count = count;
    }
}
class UndergroundSystem {
    static HashMap<String, HashMap<String, Pair>> map;
    static HashMap<Integer, Integer> time;
    static HashMap<Integer, String> prev;
    public UndergroundSystem() {
        map = new HashMap<>();
        time = new HashMap<>();
        prev = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        time.put(id, t);
        prev.put(id, stationName);
        if(!map.containsKey(stationName)) map.put(stationName, new HashMap<>());
    }
    
    public void checkOut(int id, String stationName, int t) {
        int diff = t - time.get(id);
        HashMap<String, Pair> curr = map.get(prev.get(id));
        if(!curr.containsKey(stationName)) curr.put(stationName, new Pair(diff, 1));
        else {
            Pair p = curr.get(stationName);
            curr.put(stationName, new Pair(p.ans + diff, p.count + 1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double ans = 0;
        double count = 0;
        if(map.containsKey(startStation) && map.get(startStation).containsKey(endStation)) {
            Pair p = map.get(startStation).get(endStation);
            return ((double)(p.ans)) / ((double)(p.count));
        }
        return 0;
    }
}
