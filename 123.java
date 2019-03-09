class Solution {
    
    public static int func(int[] prices, int n, int i, int flag, int count, int[][][] dp)
    {
        if(count==2 || i==n)
        {
            return 0;
        }
        if(dp[i][flag][count]!=-1)
        {
            return dp[i][flag][count];
        }
        if(flag==0)
        {
            int m1=-prices[i]+func(prices,n,i+1,1,count,dp);
            int m2=func(prices,n,i+1,0,count,dp);
            return dp[i][flag][count]=Math.max(m1,m2);
        }
        else
        {
            int m1=prices[i]+func(prices,n,i+1,0,count+1,dp);
            int m2=func(prices,n,i+1,1,count,dp);
            return dp[i][flag][count]=Math.max(m1,m2);
        }
        
        
    }
    
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        int dp[][][]=new int[n][2][3];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<3;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        return func(prices,n,0,0,0,dp);
        
        
    }
}
