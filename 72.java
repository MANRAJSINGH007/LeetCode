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
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=func(s1,s2,n,m,i+1,j+1,dp);
        }
        else
        {
            int m1=1+func(s1,s2,n,m,i+1,j+1,dp);
            int m2=1+func(s1,s2,n,m,i+1,j,dp);
            int m3=1+func(s1,s2,n,m,i,j+1,dp);
            if(m1<=m2 && m1<=m3)
            {
                return dp[i][j]=m1;
            }
            if(m2<=m3)
            {
                return dp[i][j]=m2;
            }
            
            return dp[i][j]=m3;
        }
    }
    public int minDistance(String word1, String word2) {
        
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        
        return func(word1,word2,n,m,0,0,dp);
        
    }
}
