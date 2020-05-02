class Solution {
    static int mod = (int)Math.pow(10, 9) + 7;
    public static int func(int n, int i, int m, int k, int max, int[][][] dp) {
        if(i == n) return k == 0 ? 1 : 0;
        if(k < 0) return 0;
        if(dp[i][max][k] != -1) return dp[i][max][k];
        long ans = 0;
        for(int j = 1; j <= m; j++) {
            if(j > max) ans = (ans + func(n, i + 1, m, k - 1, j, dp)) % mod;
            else ans = (ans + func(n, i + 1, m, k, max, dp)) % mod;
        }
        return dp[i][max][k] = (int)ans;
    }
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[n][m + 1][k + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m + 1; j++) {
                for(int t = 0; t < k + 1; t++) dp[i][j][t] = -1;
            }
        }
        return func(n, 0, m, k, 0, dp);
    }
}
