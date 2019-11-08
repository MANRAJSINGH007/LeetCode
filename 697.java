class Solution {
    public int findShortestSubArray(int[] nums) {
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int i = 0; i < n; i++){
            int count = 0;
            if(map.containsKey(nums[i])) count = map.get(nums[i]);
            map.put(nums[i], ++ count);
            max = Math.max(max, count);
        }
        
        HashMap<Integer, Integer> start = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();
        
        for(int i = 0; i < n; i++) end.put(nums[i], i);
        for(int i = n - 1; i >= 0; i--) start.put(nums[i], i);
        
        int minLength = n;
        
        for(int i = 0; i < n; i++){
            if(map.get(nums[i]) == max){
                minLength = Math.min(minLength, end.get(nums[i]) - start.get(nums[i]) + 1);
            }
        }
        
        return minLength;
    }
}
