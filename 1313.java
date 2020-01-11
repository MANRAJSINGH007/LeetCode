class Solution {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i += 2) count += nums[i];
        int[] ans = new int[count];
        int k = 0;
        for(int i = 0; i < n; i += 2) {
            for(int j = 0; j < nums[i]; j++) ans[k++] = nums[i + 1];
        }
        return ans;
    }
}
