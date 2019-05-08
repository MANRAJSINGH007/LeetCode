class Solution {
    
    public static int searchit(int[] nums, int n, int x, int min_index){
        
        int min=nums[min_index];
        int start=0;
        int end=n-1;
        if(min_index==0 || (x>=nums[min_index] && x<=nums[n-1])){
            start=min_index;
            end=n-1;
        }
        else{
            start=0;
            end=min_index-1;
        }
        
        int mid=(start+end)/2;
        while(start<=end){
            
            if(nums[mid]==x){
                return mid;
            }
            
            if(nums[mid]>x){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            
            mid=(start+end)/2;
            
        }
        
        return -1;
        
    }
    
    public int search(int[] nums, int x) {
        
        int n=nums.length;
        if(n==0){
            return -1;
        }
        int start=0;
        int end=n-1;
        int min=nums[0];
        int min_index=0;
        int mid=(start+end)/2;
        
        while(start<=end){
            
            if(nums[mid]<min){
                min=nums[mid];
                min_index=mid;
            }
           
            if(nums[mid]>nums[end]){
                start=mid+1;
            }
            
            else{
                end=mid-1;
            }
            
            mid=(start+end)/2;
            
        }
        
        return searchit(nums,n,x,min_index);
        
    }
}
