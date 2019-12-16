class Solution {
    
    public static int func(int[][] costs, int n, int i, int prev, int[][] dp){
        if(i == n) return 0;
        if(prev == -1) return Math.min(costs[0][0] + func(costs, n, i + 1, 0, dp), Math.min(costs[0][1] + func(costs, n, i + 1, 1, dp), costs[0][2] + func(costs, n, i + 1, 2, dp)));
        
        if(dp[i][prev] != -1) return dp[i][prev];
        
        if(prev == 0) return dp[i][prev] = Math.min(costs[i][1] + func(costs, n, i + 1, 1, dp), costs[i][2] + func(costs, n, i + 1, 2, dp));
        if(prev == 1) return dp[i][prev] = Math.min(costs[i][2] + func(costs, n, i + 1, 2, dp), costs[i][0] + func(costs, n, i + 1, 0, dp));
        if(prev == 2) return dp[i][prev] = Math.min(costs[i][0] + func(costs, n, i + 1, 0, dp), costs[i][1] + func(costs, n, i + 1, 1, dp));
        return 0;
    }
    
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++) dp[i][j] = -1;
        }
        return func(costs, n, 0, -1, dp);
    }
}
