class Solution {
    
    public boolean canJump(int[] nums) {
        
        int n=nums.length;
        int i=0;
        
        while(i<n){
            
            if(i==n-1){
                return true;
            }
            
            int jump=nums[i];
            int max_index=i;
            int index=-1;
            
            for(int j=i+1;j<=Math.min(n-1,i+jump);j++){
                
                if(j==n-1){
                    return true;
                }
                
                if(max_index<j+nums[j]){
                    max_index=j+nums[j];
                    index=j;
                }
                
            }
            
            if(max_index==i){
                return false;
            }
            
            i=index;
            
        }
        
        return false;
        
    }
}
