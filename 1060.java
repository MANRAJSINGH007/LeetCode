class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return k + nums[0];
        int count = 0;
        int i = 1;
        while(i < n && count < k){
            int temp = nums[i] - nums[i - 1] - 1;
            if(temp + count == k) return nums[i] - 1;
            if(temp + count > k) return nums[i - 1] + k - count;
            count += temp;
            i++;
        }
        
        return nums[n - 1] + k - count;
    }
}
