class Pair{
    int timeStamp;
    String val;
    Pair(int timeStamp, String val){
        this.timeStamp = timeStamp;
        this.val = val;
    }
}
class TimeMap {

    /** Initialize your data structure here. */
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> l = map.get(key);
        int start = 0;
        int end = l.size() - 1;
        String ans = "";
        while(start <= end){
            int mid = (start + end)/2;
            if(l.get(mid).timeStamp == timestamp) return l.get(mid).val;
            else if(l.get(mid).timeStamp > timestamp) end = mid - 1;
            else{
                ans = l.get(mid).val;
                start = mid + 1;
            }
        }
        
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
