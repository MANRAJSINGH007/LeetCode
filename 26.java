class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n=nums.length;
        if(n==0 || n==1){
            return n;
        }
        
        int i=1;
        int j=0;
        
        while(i<n){
            
            while(i<n && nums[i]==nums[j]){
                i++;
            }
            
            j++;
            
            if(i==n){
                return j;
            }
            
            nums[j]=nums[i];
            i++;
            
        }
        
        return j+1;
    }
}
