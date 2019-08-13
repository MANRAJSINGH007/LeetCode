class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n=nums.length;
        
        if(n<=1){
            return 0;
        }
        
        int left=-1;
        int right=-1;
        
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                left=i;
                break;
            }
        }
        
        if(left==-1){
            return 0;
        }
        
        for(int i=n-1;i>0;i--){
            if(nums[i]<nums[i-1]){
                right=i;
                break;
            }
        }
        
        int min=nums[left];
        int max=nums[left];
        
        for(int j=left;j<=right;j++){
            min=Math.min(min,nums[j]);
            max=Math.max(max,nums[j]);
        }
        
        for(int i=0;i<=left-1;i++){
            if(nums[i]>min){
                left=i;
                break;
            }
        }
        
        for(int i=n-1;i>right;i--){
            if(nums[i]<max){
                right=i;
                break;
            }
        }
        
        return right-left+1;
        
    }
}
