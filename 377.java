class Solution {
    
    public static int func(int[] coins, int n, int amount, int[] dp)
    {
        if(amount==0)
        {
            return 1;
        }
        
        if(dp[amount]!=-1)
        {
            return dp[amount];
        }
        
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(amount>=coins[i])
                count+=func(coins,n,amount-coins[i],dp);
        }
        return dp[amount]=count;
    }
    
    
    public int combinationSum4(int[] coins, int amount) {
        
        int n=coins.length;
        int dp[]=new int[amount+1];
        for(int i=0;i<=amount;i++)
        {
            dp[i]=-1;
        }
        return func(coins,n,amount,dp);
        
    }
}
