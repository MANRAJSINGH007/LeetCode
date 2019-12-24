class TwoSum {

    static HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int count = 1;
        if(map.containsKey(number)) count += map.get(number);
        map.put(number, count);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Set<Integer> keys = map.keySet();
        for(Integer k : keys){
            int x1 = k;
            map.put(x1, map.get(x1) - 1);
            if(map.containsKey(value - x1) && map.get(value - x1) > 0){
                map.put(x1, map.get(x1) + 1);
                return true;
            }
            map.put(x1, map.get(x1) + 1);
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
