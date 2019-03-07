class Solution {
    public int minPathSum(int[][] grid) {
        
        int rows=grid.length;
        int cols=grid[0].length;
        
        int dp[][]=new int[rows][cols];
        
        dp[rows-1][cols-1]=grid[rows-1][cols-1];
        
        for(int j=cols-2;j>=0;j--)
        {
            dp[rows-1][j]=grid[rows-1][j]+dp[rows-1][j+1];
        }
        
        for(int j=rows-2;j>=0;j--)
        {
            dp[j][cols-1]=grid[j][cols-1]+dp[j+1][cols-1];
        }
        
        for(int i=rows-2;i>=0;i--)
        {
            for(int j=cols-2;j>=0;j--)
            {
                if(dp[i][j+1]<dp[i+1][j])
                {
                    dp[i][j]=dp[i][j+1]+grid[i][j];
                }
                else
                {
                    dp[i][j]=dp[i+1][j]+grid[i][j];
                }
            }
        }
        
        
        return dp[0][0];
        
        
    }
}
