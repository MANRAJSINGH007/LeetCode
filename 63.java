class Solution {
    public static int func(int[][] obstaclesGrid, int m, int n, int i, int j, int[][] dp)
    {
         if(i>=m || j>=n)
        {
            return 0;
        }
        if(obstaclesGrid[i][j]==1)
        {
            return dp[i][j]=0;
        }
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        int m1=func(obstaclesGrid,m,n,i+1,j,dp);
        int m2=func(obstaclesGrid,m,n,i,j+1,dp);
        
        return dp[i][j]=m1+m2;
    }
    public int uniquePathsWithObstacles(int[][] obstaclesGrid) {
        
        
        int m=obstaclesGrid.length;
        int n=obstaclesGrid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int k=0;k<n;k++)
            {
                dp[i][k]=-1;
            }
        }
        return func(obstaclesGrid,m,n,0,0,dp);
        
    }
}
