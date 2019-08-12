class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        int n=nums.length;
        int start=0;
        int end=0;
        int currSum=0;
        int min=n+1;
        
        while(end<n){
            
            while(end<n){
                currSum+=nums[end];
                if(currSum>=s){
                    min=Math.min(min,end-start+1);
                    break;
                }
                end++;
            }
            
            if(end==n){
                if(min==n+1)
                    return 0;
                
                return min;
            }
            
            while(start<=end && currSum>=s){
                min=Math.min(min,end-start+1);
                currSum-=nums[start];
                start++;
            }
            
            end++;
            
        }
        
        if(min==n+1){
            return 0;
        }
        
        return min;
        
    }
}
