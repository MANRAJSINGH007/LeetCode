class Solution {
    public int thirdMax(int[] nums) {
        
        int n = nums.length;
        
        if(n == 0) return - 1;
        
        long max1 = (long)nums[0];
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        
        for(int i = 1; i < n; i++){
            if((long)nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = (long)nums[i];
            }
            else if((long)nums[i] > max2 && (long)nums[i] != max1){
                max3 = max2;
                max2 = (long)nums[i];
            }
            else if((long)nums[i] > max3 && (long)nums[i] != max2 && (long)nums[i] != max1){
                max3 = (long)nums[i];
            }
        }
        
        if(max3 == Long.MIN_VALUE) return (int)max1;
        
        return (int)max3;
        
    }
}
