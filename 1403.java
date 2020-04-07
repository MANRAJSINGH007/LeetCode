class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0, sum = 0;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) sum += nums[i];
        for(int i = n - 1; i >= 0; i--) {
            ans += nums[i];
            arr.add(nums[i]);
            if(ans > sum - ans) return arr;
        }
        return arr;
    }
}
