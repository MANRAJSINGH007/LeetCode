class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int ans = 0;
        int currCount = 0;
        
        map.put(0, 1);
        
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 1) currCount ++;
            if(map.containsKey(currCount - k)) ans += map.get(currCount - k);
            if(!map.containsKey(currCount)) map.put(currCount, 1);
            else map.put(currCount, 1 + map.get(currCount));
        }
        
        return ans;
        
    }
}
