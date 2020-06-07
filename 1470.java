class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        int i = 0, j = n;
        for(int k = 0; k < 2 * n; ) {
            ans[k++] = nums[i++];
            ans[k++] = nums[j++];
        }
        return ans;
    }
}
