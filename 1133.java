class Solution {
    public int largestUniqueNumber(int[] A) {
        int n = A.length;
        if(n == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int count = 1;
            if(map.containsKey(A[i])) count += map.get(A[i]);
            map.put(A[i], count);
        }
        
        int max = -1;
        Set<Integer> keys = map.keySet();
        for(Integer k : keys) if(map.get(k) == 1) max = Math.max(max, k);
        return max;
    }
}
