class Solution {
    public static int func(String s1, String s2, int n, int m, int i, int j, int[][] dp)
    {
        if(i==n)
        {
            return m-j;
        }
        if(j==m)
        {
          return n-i;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        // if(s1.equals(s2))
        // {
        //     return 0;
        // }
        if(s1.charAt(i)==s2.charAt(j))
        {
            int cost=func(s1,s2,n,m,i+1,j+1,dp);
            return dp[i][j]=cost;
        }
        else
        {
            int cost1=1+func(s1,s2,n,m,i+1,j,dp);
            int cost2=1+func(s1,s2,n,m,i,j+1,dp);
            if(cost1<=cost2)
            {
                return dp[i][j]=cost1;
            }
            
            return dp[i][j]=cost2;
        }
    }
    public int minDistance(String s1, String s2) {
        
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        return func(s1,s2,n,m,0,0,dp);
        
    }
}
