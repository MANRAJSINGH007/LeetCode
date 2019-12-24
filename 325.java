class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, sum = 0;
        map.put(0, -1);
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
