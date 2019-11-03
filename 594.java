class Solution {
    public int findLHS(int[] nums) {
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
            if(map.containsKey(nums[i] - 1)) max = Math.max(max, map.get(nums[i]) + map.get(nums[i] - 1));
            if(map.containsKey(nums[i] + 1)) max = Math.max(max, map.get(nums[i]) + map.get(nums[i] + 1));
        }
        
        return max;
        
    }
}
