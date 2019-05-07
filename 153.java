class Solution {
    public int findMin(int[] nums) {
        
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int start=0;
        int end=n-1;
        int min=nums[0];
        int mid=(start+end)/2;
        
        while(start<=end){
            
            min=Math.min(min,nums[mid]);
           
            if(nums[mid]>nums[end]){
                start=mid+1;
            }
            
            else{
                end=mid-1;
            }
            
            mid=(start+end)/2;
            
        }
        
        return min;
        
    }
}
