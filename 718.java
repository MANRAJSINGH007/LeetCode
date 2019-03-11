class Solution {
    
    public static int func(int[] arr, int[] brr, int n, int m, int i, int j, int[][] dp, int[][] dp2, int flag)
    {
        if(i==n || j==m)
        {
            return 0;
        }
        
        if(flag==0)
        {
            if(dp[i][j]!=-1)
            {
                return dp[i][j];
            }
            // can choose or cannot
            int m1=0;
            if(arr[i]==brr[j])
                m1=1+func(arr,brr,n,m,i+1,j+1,dp,dp2,1);
            
            
            int m2=func(arr,brr,n,m,i+1,j,dp,dp2,0);
            int m3=func(arr,brr,n,m,i,j+1,dp,dp2,0);
            if(m1>=m2 && m1>=m3)
            {
                return dp[i][j]=m1;
            }
            
            if(m2>=m3)
                return dp[i][j]=m2;
            
            return dp[i][j]=m3;
        }
        else
        {
            if(dp2[i][j]!=-1)
            {
                return dp2[i][j];
            }
            if(arr[i]==brr[j])
            {
                return dp2[i][j]=1+func(arr,brr,n,m,i+1,j+1,dp,dp2,1);
            }
            
            return dp2[i][j]=0;
        }
        
    }
    
    public int findLength(int[] arr, int[] brr) {
        
        int n=arr.length;
        int m=brr.length;
        int dp[][]=new int[n][m];
        int dp2[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
                dp2[i][j]=-1;
            }
        }
        
        return func(arr,brr,n,m,0,0,dp,dp2,0);
    }
}
