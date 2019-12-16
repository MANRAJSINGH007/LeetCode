class Solution {
    public static int func(int[][] costs, int n, int i, int prev, int[][] dp){
    if(i == n) return 0;
    int k = costs[0].length;
    if(prev == -1){
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++) min = Math.min(min, func(costs, n, i + 1, j, dp) + costs[0][j]);
        return min;
    }

    if(dp[i][prev] != -1) return dp[i][prev];
    int min = Integer.MAX_VALUE;
    for(int j = 0; j < k; j++){
        if(j == prev) continue;
        min = Math.min(min, func(costs, n, i + 1, j, dp) + costs[i][j]);
    }
    return dp[i][prev] = min;
            
    }
    
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++) dp[i][j] = -1;
        }
        return func(costs, n, 0, -1, dp);
    }
}
