class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        
        int n = A.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            
            sum += A[i];
            
            if(map.containsKey(sum - S)){
                count += map.get(sum - S);
            }
            
            if(map.containsKey(sum)){
                int c = map.get(sum);
                c++;
                map.put(sum, c);
            }
            else{
                map.put(sum, 1);
            }
        }
        
        return count;
        
    }
}
