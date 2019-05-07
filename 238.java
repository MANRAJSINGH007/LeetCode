class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n=nums.length;
        int output[]=new int[n];
        int left_prod=1;
        output[0]=1;
        for(int i=1;i<n;i++){
            left_prod*=nums[i-1];
            output[i]=left_prod;
        }
        
        int right_prod=nums[n-1];
        for(int i=n-2;i>=0;i--){
            output[i]*=right_prod;
            right_prod*=nums[i];
        }
        
        return output;
    }
}
