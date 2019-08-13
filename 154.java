class Solution {
    public int findMin(int[] nums) {
        
        int n=nums.length;
        if(n==0){
            return 0;
        }
        
        if(n==1){
            return nums[0];
        }
        
        int min=nums[0];
        int start=0;
        int end=n-1;
        
        int mid=(start+end)/2;
        
        while(start<=end){
            
            mid=(start+end)/2;
            
            min=Math.min(min,nums[mid]);
            
            if(nums[mid]>nums[end]){
                start=mid+1;
            }
            
            else if(nums[mid]==nums[start] && nums[mid]==nums[end]){
                start++;
                end--;
            }
            
            else{
                end=mid-1;
            }
            
        }
        
        return min;
        
    }
}
