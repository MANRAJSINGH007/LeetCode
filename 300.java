class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        int dp[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            dp[i]=1;
        }
        
        int max=1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]=dp[j]+1;
                        
                    }
                }
            }
            if(dp[i]>max)
            {
                max=dp[i];
            }
        }
        
        return max;
        
    }
}
