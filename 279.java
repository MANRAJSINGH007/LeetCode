class Solution {
    
    public static int func(int n, int[] dp)
    {
        double root=Math.sqrt(n);
        if(Math.floor(root)==Math.ceil(root))
        {
            return 1;
        }
        if(dp[n]!=0)
        {
            return dp[n];
        }
        int min=Integer.MAX_VALUE;
        for(int i=(int)Math.sqrt(n);i>=1;i--)
        {
            int m1=func((int)Math.pow(i,2),dp);
            int m2=func(n-(int)Math.pow(i,2),dp);
            if(m1+m2<min)
            {
                min=m1+m2;
            }
        }
        
        return dp[n]=min;
        
    }
    
    public int numSquares(int n) {
        
        int dp[]=new int[n+1];
        
        return func(n,dp);
        
    }
}
