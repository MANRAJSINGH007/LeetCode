class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n=nums.length;
        if(n==0){
            return 0;
        }
        
        Arrays.sort(nums);
        
        int min=Integer.MAX_VALUE;
        int ans=0;
        
        for(int i=0;i<n-2;i++){
            
            int start=i+1;
            int end=n-1;
            
            while(start<end){
                
                int sum=nums[i]+nums[start]+nums[end];
                
                if(Math.abs(sum-target)<min){
                    ans=sum;
                    min=Math.abs(target-sum);
                }
                
                if(sum==target){
                    return target;
                }
                
                else if(sum<target){
                    start++;
                }
                
                else{
                    end--;
                }
                
            }
            
        }
        
        return ans;
        
    }
}
