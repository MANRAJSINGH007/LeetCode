class Solution {
    
    public static int func(List<List<Integer>> triangle, int i, int j, int n, int[][] dp)
    {
        if(i==n-1)
        {
            return triangle.get(i).get(j);
        }
        
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        
        int c1=triangle.get(i).get(j)+func(triangle,i+1,j,n,dp);
        
        int c2=triangle.get(i).get(j)+func(triangle,i+1,j+1,n,dp);
        
        if(c1<=c2)
        {
            return dp[i][j]=c1;
        }
        
        return dp[i][j]=c2;
        
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n=triangle.size();
        int dp[][]=new int[n][];
        for(int i=0;i<n;i++)
        {
            int s=triangle.get(i).size();
            dp[i]=new int[s];
        }
        return func(triangle,0,0,n,dp);
    }
}
