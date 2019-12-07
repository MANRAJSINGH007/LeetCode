class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = A[i] + B[j];
                int c = 0;
                if(map.containsKey(sum)) c = map.get(sum);
                map.put(sum, c + 1);
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = C[i] + D[j];
                if(map.containsKey(-sum)) count += map.get(-sum);
            }
        }
        
        return count;
        
    }
}
