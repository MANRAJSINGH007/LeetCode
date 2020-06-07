class Solution {
    public static int func(int[] houses, int n, int i, int target, int[][] cost, int m, int currColor, int[][][] dp) {
        if(i == m) return target == 0 ? 0 : Integer.MAX_VALUE;
        if(target == -1) return Integer.MAX_VALUE;
        if(dp[i][target][currColor] != -1) return dp[i][target][currColor];
        int temp = target;
        if(i == 0 && houses[i] != 0 || (i > 0 && houses[i] != currColor && houses[i] != 0)) temp--;
        if(houses[i] != 0) return dp[i][target][currColor] = func(houses, n, i + 1, temp, cost, m, houses[i], dp);
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < n; k++) {
            int t = houses[i];
            houses[i] = k + 1;
            int tar = target;
            if(currColor == k + 1) tar = target;
            else tar = target - 1;
            int small = func(houses, n, i + 1, tar, cost, m, k + 1, dp);
            houses[i] = t;
            if(small != Integer.MAX_VALUE) min = Math.min(small + cost[i][k], min);
        }
        return dp[i][target][currColor] = min;
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][target + 1][n + 2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <= target; j++) {
                for(int k = 0; k < n + 2; k++) dp[i][j][k] = -1;
            }
        }
        int ans = func(houses, n, 0, target, cost, m, n + 1, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
