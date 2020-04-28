class Solution {
    static int mod = (int)Math.pow(10, 9) + 7;
    public static int func(String s, int n, int i, int k, int[] dp) {
        if(i == n) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        String curr = "";
        long ans = 0;
        for(int j = i; j < n; j++) {
            curr += s.charAt(j);
            if(j - i + 1 > 10 || Long.parseLong(curr) > (long)k) break;
            ans = (ans + func(s, n, j + 1, k, dp)) % mod;
        }
        return dp[i] = (int)ans;
    }
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = -1;
        return func(s, n, 0, k, dp);
    }
}
