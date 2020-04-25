class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int inf = Integer.MAX_VALUE;
        int a = inf, b = inf, c = inf;
        for(int i = 0; i < n; i++) {
            if(a == inf) {
                a = nums[i];
                continue;
            } else if(b == inf) {
                if(nums[i] <= a) a = nums[i];
                else b = nums[i];
            } else if(c == inf) {
                if(nums[i] > b) return true;
                else if(nums[i] > a && nums[i] <= b) b = nums[i];
                else a = nums[i];
            }
        }
        return false;
    }
}
