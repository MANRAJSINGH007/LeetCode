class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int start = 0, end = 0, ans = 0, count = 0;
        while(end < n) {
            while(end < n) {
                if(nums[end] == 0) count++;
                if(count == 2) break;
                ans = Math.max(ans, end - start);
                end++;
            }
            if(end == n) break;
            while(start <= end) {
                if(nums[start] == 0) {
                    count--;
                    start++;
                    break;
                }
                start++;
            }
            ans = Math.max(ans, end - start);
            end++;
        }
        return ans;
    }
}
