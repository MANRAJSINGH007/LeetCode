class Solution {
    
    public static int func(String s1, String s2, String s3, int n, int m, int t, int i, int j, int k, int[][] dp)
    {
        if(k==t)
        {
            if(i==n && j==m)
                return 1;
        }
        
        if(i==n && j==m)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        int b1=0;
        int b2=0;
        
        if(i<n && s1.charAt(i)==s3.charAt(k))
        {
            b1=func(s1,s2,s3,n,m,t,i+1,j,k+1,dp);
            if(b1==1)
            {
                return dp[i][j]=1;
            }
        }
        
        if(j<m && s2.charAt(j)==s3.charAt(k))
        {
            b2=func(s1,s2,s3,n,m,t,i,j+1,k+1,dp);
            if(b2==1)
            {
                return dp[i][j]=1;
            }
        }
        
        return dp[i][j]=0;
        
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n=s1.length();
        int m=s2.length();
        int t=s3.length();
        if(t!=n+m)
        {
            return false;
        }
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                dp[i][j]=-1;
            }
        }
        if(func(s1,s2,s3,n,m,t,0,0,0,dp)==1)
        {
            return true;
        }
        
        return false;
                  
    }
}
