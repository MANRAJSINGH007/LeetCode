class Solution {
    
    public static int func(int start, int end, String s, int n, int[][] dp)
    {
        if(start>end)
        {
            return 0;
        }
        if(start==end)
        {
            return 1;
        }
        if(dp[start][end]!=-1)
        {
            return dp[start][end];
        }
        if(s.charAt(start)==s.charAt(end))
        {
            return dp[start][end]=2+func(start+1,end-1,s,n,dp);
        }
        
        int m1=func(start+1,end,s,n,dp);
        int m2=func(start,end-1,s,n,dp);
        if(m1>=m2)
        {
            return dp[start][end]=m1;
        }
        
        return dp[start][end]=m2;
    }
    
    public int longestPalindromeSubseq(String s) {
        
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return func(0,n-1,s,n,dp);
        
    }
}
