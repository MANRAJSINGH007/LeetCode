class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return sum - min * n;
    }
}
