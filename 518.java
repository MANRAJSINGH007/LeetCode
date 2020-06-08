class Solution {
    public static int func(int[] coins, int n, int i, int amount, int[][] dp) {
        if(amount == 0) return 1;
        if(i == n) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int ans = 0, curr = 0;
        while(curr <= amount) {
            ans += func(coins, n, i + 1, amount - curr, dp);
            curr += coins[i];
        }
        return dp[i][amount] = ans;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= amount; j++) dp[i][j] = -1;
        }
        return func(coins, n, 0, amount, dp);
    }
}
