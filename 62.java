class Solution {
    
    public static int ways(int i, int j, int m, int n, int[][] dp)
    {
        if(i>=m || j>=n)
        {
            return 0;
        }
        
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        
        int count=0;
        count+=ways(i+1,j,m,n,dp);
        count+=ways(i,j+1,m,n,dp);
        
        return dp[i][j]=count;
    }
    
    public int uniquePaths(int m, int n) {
        
        
        int dp[][]=new int[m][n];
        return ways(0,0,m,n,dp);
        
    }
}
