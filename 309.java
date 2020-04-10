class Solution {
    public static int func(int[] prices, int n, int i, int flag, int[][] dp) {
        if(i >= n) return 0;
        if(flag == 0) {
            if(dp[i][0] != -1) return dp[i][0];
            int m1 = -prices[i] + func(prices, n, i + 1, 1, dp);
            int m2 = func(prices, n, i + 1, 0, dp);
            if(m1 >= m2) return dp[i][0] = m1;
            return dp[i][0] = m2;
        }
        else {
            if(dp[i][1] != -1) return dp[i][1];
            int m1 = prices[i] + func(prices, n, i + 2, 0, dp);
            int m2 = func(prices, n, i + 1, 1, dp);
            if(m1 >= m2) return dp[i][1] = m1;
            return dp[i][1] = m2;
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return func(prices, n, 0, 0, dp);
    }
}
