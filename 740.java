class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int n=nums.length;
        int freq[]=new int[10001];
        
        for(int i=0;i<n;i++)
        {
            int num=nums[i];
            freq[num]++;
        }
        
        int dp[]=new int[10001];
        dp[0]=0;
        dp[1]=freq[1];
        for(int i=2;i<10001;i++)
        {
            if(freq[i]*i+dp[i-2]>dp[i-1])
            {
                dp[i]=freq[i]*i+dp[i-2];
            }
            else
            {
                dp[i]=dp[i-1];
            }
        }
        
        return dp[10000];
        
        
    }
}
