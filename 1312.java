class Solution {
    public static int func(String s, int start, int end, int[][] dp) {
        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        if(s.charAt(start) == s.charAt(end)) return dp[start][end] = func(s, start + 1, end - 1, dp);
        int x1 = func(s, start + 1, end, dp);
        int x2 = func(s, start, end - 1, dp);
        return dp[start][end] = 1 + Math.min(x1, x2);
    }
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) dp[i][j] = - 1;
        }
        return func(s, 0 , n - 1, dp);
    }
}
