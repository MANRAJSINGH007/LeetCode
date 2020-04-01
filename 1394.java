class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])) map.put(arr[i], 1);
            else map.put(arr[i], map.get(arr[i]) + 1);
        }
        int max = -1;
        int freq = 0;
        Set<Integer> keys = map.keySet();
        for(Integer k : keys) {
            if(map.get(k) == k && (map.get(k) > freq || map.get(k) == freq && max < k)) {
                max = k;
                freq = map.get(k);
            }
        }
        return max;
    }
}
