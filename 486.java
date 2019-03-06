class Solution {
    
    public static int func(int[] piles, int start, int end, int flag, int[][] dp1, int[][] dp2)
    {
        if(start>end)
        {
            return 0;
        }
        
        if(flag==0)
        {
            if(dp1[start][end]!=Integer.MIN_VALUE)
            {
                return dp1[start][end];
            }
            int m1=piles[start]+func(piles,start+1,end,1,dp1,dp2);
            int m2=piles[end]+func(piles,start,end-1,1,dp1,dp2);
            if(m1>=m2)
            {
                return dp1[start][end]=m1;
            }
            
            return dp1[start][end]=m2;
        }
        else
        {
            if(dp2[start][end]!=Integer.MIN_VALUE)
            {
                return dp2[start][end];
            }
            int m1=-piles[start]+func(piles,start+1,end,0,dp1,dp2);
            int m2=-piles[end]+func(piles,start,end-1,0,dp1,dp2);
            if(m1<=m2)
            {
                return dp2[start][end]=m1;
            }
            
            return dp2[start][end]=m2;
        }
        
    }
    
    public boolean PredictTheWinner(int[] piles) {
        
        int n=piles.length;
        
        if(n%2==0 || n==1)
        {
            return true;
        }
        
        int dp1[][]=new int[n][n];
        int dp2[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<n;k++)
            {
                dp1[i][k]=Integer.MIN_VALUE;
                dp2[i][k]=Integer.MIN_VALUE;
                
            }
        }
        
        int ans=func(piles,0,n-1,0,dp1,dp2);
        if(ans<=0)
        {
            return false;
        }
        
        return true;
        
    }
}
