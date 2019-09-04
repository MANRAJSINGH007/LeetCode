class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int  n = nums.length;
        
        boolean check = false;
        
        for(int i = 1; i < n; i++){
            
            if(nums[i] < nums[i - 1]){
                
                if(check){
                    return false;
                }
                
                check = true;
                
                if(i == n-1){
                    return true;
                }
                
                if(nums[i - 1] <= nums[i + 1]){
                    nums[i] = nums[i - 1];
                }
                
                else{
                    if(i - 1 == 0){
                        nums[i - 1] = nums[i] - 1;
                    }
                    
                    else{
                        if(nums[i - 2] <= nums[i]){
                            nums[i - 1] = nums[i];
                        }
                        else{
                            return false;
                        }
                    }
                }
                
            }
            
        }
        
        return true;
    }
}
