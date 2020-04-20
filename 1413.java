class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum < 0) ans = Math.max(ans, -sum + 1);
        }
        return ans;
    }
}
