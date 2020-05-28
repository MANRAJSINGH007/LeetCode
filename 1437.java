class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        k++;
        int curr = - k - 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                if(i - curr < k) return false;
                curr = i;
            }
        }
        return true;
    }
}
