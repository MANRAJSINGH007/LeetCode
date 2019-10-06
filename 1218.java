class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int n = arr.length;
        
        if(n == 0) return 0;
        
        int max = 1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            
            int curr = arr[i];
            
            int currLength = 0;
            
            if(map.containsKey(curr - difference)){
                currLength = map.get(curr - difference);
            }
            
            currLength++;
            max = Math.max(max, currLength);
            if(!map.containsKey(curr) || map.get(curr) < currLength) map.put(curr, currLength);
            
        }
        
        return max;
        
    }
}
