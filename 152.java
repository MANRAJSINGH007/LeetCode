class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);
            res = Math.max(max, res);
        }
        return res;
    }
}
