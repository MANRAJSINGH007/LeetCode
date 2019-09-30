class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        
        if(n == 1){
            return ;
        }
        
        k = k%n;
        
        for(int i = 0; i < (n - k)/2; i++){
            int temp = nums[i]; 
            nums[i] = nums[n - k - i -1];
            nums[n - i - k - 1] = temp;
        }
        
        for(int i = n - k; i < (n - k) + k/2; i++){
            int temp = nums[n - 1 - i + n - k];
            nums[n - 1 - i + n - k] = nums[i];
            nums[i] = temp;
        }
        
        for(int i = 0; i < n/2; i++){
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - i -1] = temp;
        }
        
        return ;
        
    }
}
