class Solution {
    
    public static int[] func(int[] nums, int index, int target){
        
        int left=index;
        int n=nums.length;
        
        int start=0;
        int end=index-1;
        
        int mid=(start+end)/2;
        
        int ans[]=new int[2];
        
        while(start<=end){
            
            mid=(start+end)/2;
            if(nums[mid]==target){
                left=Math.min(left,mid);
                end=mid-1;
            }
            
            else if(nums[mid]>target){
                end=mid-1;
            }
            
            else{
                start=mid+1;
            }
            
        }
        
        ans[0]=left;
        
        int right=index;
        
        start=index+1;
        end=n-1;
        
        while(start<=end){
            
            mid=(start+end)/2;
            if(nums[mid]==target){
                right=Math.max(right,mid);
                start=mid+1;
            }
            
            else if(nums[mid]>target){
                end=mid-1;
            }
            
            else{
                start=mid+1;
            }
        }
        
        ans[1]=right;
        
        return ans;
        
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        
        int n=nums.length;
        
        int start=0;
        int end=n-1;
        int mid=(start+end)/2;
        
        int ans[]=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int flag=0;
        
        while(start<=end){
            
            mid=(start+end)/2;
            
            if(nums[mid]==target){
                ans[0]=mid;
                ans[1]=mid;
                flag=1;
                break;
            }
            
            else if(nums[mid]>target){
                end=mid-1;
            }
            
            else{
                start=mid+1;
            }
            
        }
        
        if(flag==0){
            return ans;
        }
        
        else{
            return func(nums,mid,target);
        }
    }
}
