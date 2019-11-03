class RandomizedCollection {
    
    static Random rand;
    static ArrayList<Integer> list;
    static HashMap<Integer, HashSet<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        rand = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(!map.containsKey(val)) map.put(val, new HashSet<>());
        HashSet<Integer> set = map.get(val);
        set.add(list.size());
        list.add(val);
        return set.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        if(!map.containsKey(val)) return false;
        HashSet<Integer> t = map.get(val);
        
        if(list.size() == 1){
            list = new ArrayList<>();
            map = new HashMap<>();
            return true;
        }
        
        Iterator<Integer> it = t.iterator();
        int index = -1;
        while(it.hasNext()){
            index = it.next();
            break;
        }
        
        t.remove(index);
        
        if(t.size() == 0) map.remove(val);
        
        if(index == list.size() - 1){
            list.remove(list.size() - 1);
            return true;
        }
        
        int lastElement = list.get(list.size() - 1);
        HashSet<Integer> last = map.get(lastElement);
        last.remove(list.size() - 1);
        last.add(index);
        list.remove(list.size() - 1);
        list.set(index, lastElement);
        return true;
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
