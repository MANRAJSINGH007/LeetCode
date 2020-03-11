class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int ans = Math.max(0, nums[0] - nums[1] + 1);
        int ans2 = 0;
        for(int i = 2; i < n - 1; i = i + 2) {
            ans += Math.max(0, nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
        }
        if(n % 2 == 1) ans += Math.max(0, nums[n - 1] - (nums[n - 2] - 1));
        for(int i = 1; i < n - 1; i = i + 2) {
            ans2 += Math.max(0, nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
        }
        if(n % 2 == 0) ans2 += Math.max(0, nums[n - 1] - (nums[n - 2] - 1));
        return Math.min(ans, ans2);
    }
}
