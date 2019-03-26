class Solution {
    
    public static int func(int[] prices, int fee, int flag, int i, int n, int[][] dp)
    {
        if(i==n)
        {
            return 0;
        }
        
        if(flag==0)
        {
            
            if(dp[i][0]!=-1)
            {
                return dp[i][0];
            }
            // not bought stock till now.
            
            // he doesn't buy now.
            int m1=func(prices,fee,0,i+1,n,dp);
            
            // he buys now.
            int m2=-prices[i]-fee+func(prices,fee,1,i+1,n,dp);
            
            if(m1>=m2)
            {
                return dp[i][0]=m1;
            }
            
            return dp[i][0]=m2;
        }
        else
        {   
            if(dp[i][1]!=-1)
            {
                return dp[i][1];
            }
            
            // he can;t buy , he can sell or not sell.
            
                // he sells
            int m3=prices[i]+func(prices,fee,0,i+1,n,dp);


            // he doesn't sell.
            int m4=func(prices,fee,1,i+1,n,dp);

            if(m3>=m4)
            {   

                return dp[i][1]=m3;
            }

            return dp[i][1]=m4;
            
        }
        
    }
    
    public int maxProfit(int[] prices, int fee) {
        
        int n=prices.length;
        
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<2;k++)
            {
                dp[i][k]=-1;
            }
        }
        
        return func(prices,fee,0,0,n,dp);
    }
}
