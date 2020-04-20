class Solution {
    public static int func(String s, String t, int n, int m, int i, int j, int[][] dp) {
        if(j == m) return 1;
        if(i == n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = func(s, t, n, m, i + 1, j, dp);
        if(s.charAt(i) == t.charAt(j)) ans += func(s, t, n, m, i + 1, j + 1, dp);
        return dp[i][j] = ans;
    }
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) dp[i][j] = -1;
        }
        return func(s, t, n, m, 0, 0, dp);
    }
}
