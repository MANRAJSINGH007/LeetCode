class Solution {
    
    static int mod = (int)Math.pow(10, 9) + 7;
    
    public static int func(int n, int i, int absent, int prev, int[][][] dp){
        
        if(i == n) return 1;
        
        if(dp[i][absent][prev] != -1) return dp[i][absent][prev];
        
        long ans = 0;
        
        if(absent == 1){
            ans = (ans + func(n, i + 1, 1, 0, dp)) % mod;
            if(prev != 2)
                ans = (ans + func(n, i + 1, 1, prev + 1, dp)) % mod;
            return dp[i][absent][prev] = (int)ans;
        }
        
        ans = (ans + func(n, i + 1, 1, 0, dp)) % mod;
        ans = (ans + func(n, i + 1, 0, 0, dp)) % mod;
        if(prev != 2)
            ans = (ans + func(n, i + 1, 0, prev + 1, dp)) % mod;
        
        return dp[i][absent][prev] = (int)ans;
        
    }
    
    public int checkRecord(int n) {
        
        int[][][] dp = new int[n][2][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                for(int t = 0; t < 3; t++) dp[i][j][t] = -1;
            }
        }
        
        return func(n, 0, 0, 0, dp);
    }
}
