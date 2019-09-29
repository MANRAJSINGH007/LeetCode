class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        int n = arr.length;
        
        if(n == 1) return true;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                int count = map.get(arr[i]);
                count++;
                map.put(arr[i], count);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        Set<Integer> keys = map.keySet();
        
        for(Integer k : keys){
            if(set.contains(map.get(k))) return false;
            set.add(map.get(k));
        }
        
        return true;
        
    }
}
