class Solution {
    
    static boolean b=false;
    
    public static int func(int[] piles, int n, int start, int end, int flag, int[][] dp1, int[][] dp2)
    {
        if(start>end)
        {
            return 0;
        }
        
        if(flag==0)
        {
            if(dp1[start][end]!=-1)
            {
                return dp1[start][end];
            }
            int m1=piles[start]+func(piles,n,start+1,end,1,dp1,dp2);
            int m2=piles[end]+func(piles,n,start,end-1,1,dp1,dp2);
            if(m1>=m2)
            {
                return dp1[start][end]=m1;
            }
            
            return dp1[start][end]=m2;
        }
        else
        {
            if(dp2[start][end]!=-1)
            {
                return dp2[start][end];
            }
            int m3=piles[start]+func(piles,n,start+1,end,0,dp1,dp2);
            int m4=piles[end]+func(piles,n,start,end-1,0,dp1,dp2);
            if(m3>=m4)
            {
                return dp2[start][end]=m3;
            }
            
            return dp2[start][end]=m4;
        }
        
        
    }
    public boolean stoneGame(int[] piles) {
        
        
        b=false;
        int n=piles.length;
        int dp1[][]=new int[n][n];
        int dp2[][]=new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<n;k++)
            {
                dp1[i][k]=-1;
                dp2[i][k]=-1;
            }
        }
        
        int val=func(piles,n,0,n-1,0,dp1,dp2);
        if(dp1[0][n-1]>dp2[1][n-1] && dp1[0][n-1]>dp2[0][n-2])
        {
            return true;
        }
        
        return false;
        
    }
}
