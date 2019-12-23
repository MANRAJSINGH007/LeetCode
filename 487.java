class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        int start = 0, end = 0, count = 0, max = 1;
        while(end < n){
            while(end < n && count < 2){
                if(nums[end] == 0) count++;
                if(count == 2) break;
                max = Math.max(max, end - start + 1);
                end++;
            }
            if(end == n) return max;
            while(start <= end){
                if(nums[start] == 0){
                    start++;
                    count--;
                    max = Math.max(max, end - start + 1);
                    break;
                }
                start++;
            }
            end++;
        }
        return max;
    }
}
