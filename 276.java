class Solution {
    public static int func(int n, int flag, int[][] dp, int k){
        
        if(n == 0) return 1;
        if(dp[n][flag] != -1) return dp[n][flag];
        if(flag == 1){
            int ans = (k - 1) * func(n - 1, 0, dp, k);
            return dp[n][flag] = ans;
        }
        
        int ans = (k - 1) * func(n - 1, 0, dp, k);
        ans = ans + func(n - 1, 1, dp, k);
        return dp[n][flag] = ans;
    }
    
    public int numWays(int n, int k) {
       
        if(n == 0 || k == 0) return 0;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int t = 0; t < 2; t++) dp[i][t] = -1;
        }

        return k * func(n - 1, 0, dp, k);
    }
}
