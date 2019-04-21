class Solution {
    
    public static int func(int[][] costs, int n, int i, int c1, int c2, int[][] dp){
        
        if(i==n){
            if(c1==n/2){
                return 0;
            }
            
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][c1]!=-1){
            return dp[i][c1];
        }
        
        int m1=func(costs,n,i+1,c1+1,c2,dp);
        int m2=func(costs,n,i+1,c1,c2+1,dp);
        
        if(m1!=Integer.MAX_VALUE){
            m1+=costs[i][0];
        }
        
        if(m2!=Integer.MAX_VALUE){
            m2+=costs[i][1];
        }
        
        return dp[i][c1]=Math.min(m1,m2);
        
    }
    
    public int twoCitySchedCost(int[][] costs) {
        
        int n=costs.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        
        return func(costs,n,0,0,0,dp);
        
    }
}
