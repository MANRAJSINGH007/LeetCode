class Solution {
    
    static int mod = (int)Math.pow(10, 9) + 7;
    static int maxSize;
    static int minProfit;
    
    public static int func(int[] profit, int[] group, int n, int i, int g, int p, int[][][] dp){
        
        if(i == n) return (p >= minProfit) ? 1 : 0;
        
        if(dp[i][g][p] != -1) return dp[i][g][p];
        
        int count1 = 0;
        long ans = 0;
        if(g + group[i] <= maxSize){
            count1 = func(profit, group, n, i + 1, g + group[i], Math.min(minProfit, p + profit[i]), dp);
        }
        
        ans = (long)func(profit, group, n, i + 1, g, p, dp);
        ans = (ans + count1) % mod;
        
        return dp[i][g][p] = (int)ans;
        
    }
    
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        
        int n = profit.length;
        maxSize = G;
        minProfit = P;
        int[][][] dp = new int[n][G + 1][P + 1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < G + 1; j++){
                for(int k = 0; k < P + 1; k++) dp[i][j][k] = -1;
            }
        }
        
        return func(profit, group, n, 0, 0, 0, dp);
        
    }
}
