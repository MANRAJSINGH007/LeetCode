class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int n = nums.length;
        
        if(n <= 1){
            return n;
        }
        
        int currLength = 1;
        int maxLength = 1;
        
        for(int i = 1; i < n; i++){
            
            if(nums[i] > nums[i - 1]){
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            }
            
            else{
                currLength = 1;
            }
            
        }
        
        return maxLength;
        
    }
}
