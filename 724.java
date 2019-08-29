class Solution {
    public int pivotIndex(int[] nums) {
        
        int n=nums.length;
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        
        int s=0;
        
        for(int i=0;i<n;i++){
            sum-=nums[i];
            if(s==sum){
                return i;
            }
            s+=nums[i];
        }
        
        return -1;
        
    }
}
