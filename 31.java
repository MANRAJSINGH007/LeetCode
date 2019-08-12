class Solution {
    public void nextPermutation(int[] nums) {
        
        int n=nums.length;
        int flag=0;
        int index=-1;
        
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                flag=1;
                index=i;
                break;
            }
        }
        
        if(flag==0){
            
            for(int i=0;i<n/2;i++){
                int swap=nums[i];
                nums[i]=nums[n-1-i];
                nums[n-1-i]=swap;
            }
        }
        
        else{
            
            for(int j=n-1;j>=index;j--){
                if(nums[j]>nums[index-1]){
                    int x1=nums[index-1];
                    nums[index-1]=nums[j];
                    nums[j]=x1;
                    break;
                }
            }
            
            int count=n-index+1;
            
            for(int j=index;j<index+count/2;j++){
                int swap=nums[j];
                nums[j]=nums[n-j-1+index];
                nums[n-j-1+index]=swap;
            }
        }
        
        return ;
        
        
    }
}
