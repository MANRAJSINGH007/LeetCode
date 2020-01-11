class Solution {
    static int[] dx = {1, -1, 1, -1, 2, -2, 2, -2};
    static int[] dy = {2, 2, -2, -2, 1, -1, -1, 1};
    public static double prob(int n, int i, int j, int k, double[][][] dp) {
        if(i < 0 || j < 0 || i >= n || j >= n) return 0;
        if(k == 0) return 1;
        if(dp[i][j][k] != -1) return dp[i][j][k];
        double p = 0;
        for(int a = 0; a < 8; a++) {
            p += (1.0) * prob(n, i + dx[a], j + dy[a], k - 1, dp) / 8;
        }
        return dp[i][j][k] = p;
    }
    public double knightProbability(int n, int k, int r, int c) {
        double[][][] dp = new double[n][n][k + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int p = 0; p < k + 1; p++) dp[i][j][p] = -1;
            }
        }
        return prob(n, r, c, k, dp);
    }
}
