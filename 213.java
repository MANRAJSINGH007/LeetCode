class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return nums[0];
        }
        if(n==2)
        {
            if(nums[0]>nums[1])
            {
                return nums[0];
            }
            
            return nums[1];
        }
        
        int dp[]=new int[n];
        dp[0]=0;
        dp[1]=nums[1];
        for(int i=2;i<n;i++)
        {
            if(dp[i-2]+nums[i]>dp[i-1])
            {
                dp[i]=dp[i-2]+nums[i];
            }
            else
            {
                dp[i]=dp[i-1];
            }
        }
        
        int temp=dp[n-1];
        dp[0]=nums[0];
        dp[1]=nums[0];
        if(nums[1]>nums[0])
        {
            dp[1]=nums[1];
        }
        
        for(int i=2;i<n-1;i++)
        {
            if(dp[i-2]+nums[i]>dp[i-1])
            {
                dp[i]=dp[i-2]+nums[i];
            }
            else
            {
                dp[i]=dp[i-1];
            } 
        }
        
        if(dp[n-2]>temp)
        {
            return dp[n-2];
        }
        
        return temp;
        
        
    }
}
