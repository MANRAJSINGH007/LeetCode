class Solution {
    public static int func(int[][] arr, int n, int i, int j, int[][] dp)
    {
        if(j<0 || j==n)
        {
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        if(i==n-1)
        {
            return arr[i][j];
        }
        
        int m1=func(arr,n,i+1,j+1,dp);
        int m2=func(arr,n,i+1,j-1,dp);
        int m3=func(arr,n,i+1,j,dp);
        
        if(m1<=m2 && m1<=m3)
        {
            return dp[i][j]=arr[i][j]+m1;
        }
        if(m2<=m3)
        {
            return dp[i][j]=arr[i][j]+m2;
        }
        
        return dp[i][j]=arr[i][j]+m3;
        
    }
    public int minFallingPathSum(int[][] arr) {
        
        int n=arr.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<n;k++)
            {
                dp[i][k]=-1;
            }
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int val=func(arr,n,0,i,dp);
            if(val<min)
            {
                min=val;
            }
        }

        return min;
        
    }
}
