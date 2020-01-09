class Solution {
    public int dominantIndex(int[] nums) {
        
        int n = nums.length;
        
        if(n == 0) return -1;
        
        int max = -1;
        int max_index = -1;
        boolean property = false;
        
        for(int i = 0; i < n; i++){
            if(nums[i] > max){
                if(nums[i] >= 2 * max){
                    property = true;
                }
                else{
                    property = false;
                }
                max_index = i;
                max = nums[i];
            }
            
            else if(max < 2 * nums[i]){
                property = false;
            }
        }
        
        if(property) return max_index;
        
        return -1;
    }
}
