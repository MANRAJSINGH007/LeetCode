class Solution {
    static int mod = (int)Math.pow(10, 9) + 7;
    public static int color(int n, int i, int j, int prev1, int prev2, int prev3, int[][][][][] dp) {
        if(i == n) return 1;
        if(dp[i][j][prev1][prev2][prev3] != -1) return dp[i][j][prev1][prev2][prev3];
        long ans = 0;
        for(int k = 0; k < 3; k++) {
            if(j == 0 && k != prev1) ans = (ans + color(n, i, j + 1, k, prev2, prev3, dp)) % mod;
            if(j == 1 && k != prev1 && k != prev2) ans = (ans + color(n, i, j + 1, prev1, k, prev3, dp)) % mod;
            if(j == 2 && k != prev3 && k != prev2) ans = (ans + color(n, i + 1, 0, prev1, prev2, k, dp)) % mod;
        }
        return dp[i][j][prev1][prev2][prev3] = (int)ans;
    }
    public int numOfWays(int n) {
        int[][][][][] dp = new int[n][3][4][4][4];
        for(int i1 = 0; i1 < n; i1++) {
            for(int i2 = 0; i2 < 3; i2++) {
                for(int i3 = 0; i3 < 4; i3++) {
                    for(int i4 = 0; i4 < 4; i4++) {
                        for(int i5 = 0; i5 < 4; i5++) dp[i1][i2][i3][i4][i5] = -1;
                    }
                }
            }
        }
        return color(n, 0, 0, 3, 3, 3, dp);
    }
}
