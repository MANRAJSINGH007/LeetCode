class Solution {

    public static int func2(int cost[], int n)
    {
        int dp[]=new int[n];
        dp[n-1]=cost[n-1];
        dp[n-2]=cost[n-2];
        
        for(int i=n-3;i>=0;i--)
        {
            if(dp[i+1]<dp[i+2])
            {
                dp[i]=dp[i+1]+cost[i];
            }
            else
            {
                dp[i]=dp[i+2]+cost[i];
            }
        }
        
        if(dp[0]<dp[1])
        {
            return dp[0];
        }
        
        return dp[1];
    }
    public int minCostClimbingStairs(int[] cost) {
        
        int n=cost.length;
        
        return func2(cost,n);
        
    }
}
