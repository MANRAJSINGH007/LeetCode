class Solution {
    static int mod = 1_000_00_00_07;
    public static int fact(int n) {
        long ans = 1;
        for(int i = 1; i <= n; i++) ans = (ans * i) % mod;
        return (int)ans;
    }
    public static int func(int pickup, int delivery, int n, int[][] dp) {
        if(delivery == n) return 1;
        if(dp[pickup][delivery] != -1) return dp[pickup][delivery];
        if(pickup == delivery) return dp[pickup][delivery] = (int)(((long)(n - pickup) * func(pickup + 1, delivery, n, dp)) % mod);
        if(pickup == n) return dp[pickup][delivery] = (int)((long)(n - delivery) * func(pickup, delivery + 1, n, dp) % mod);
        int x = (int)((long)(n - pickup) * func(pickup + 1, delivery, n, dp) % mod);
        int y = (int)((long)(pickup - delivery) * func(pickup, delivery + 1, n, dp) % mod);
        return dp[pickup][delivery] = (int)(((long)x + y) % mod);
    }
    public int countOrders(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) dp[i][j] = -1;
        }
        return func(0, 0, n, dp);
    }
}
