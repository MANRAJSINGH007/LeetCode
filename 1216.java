class Solution {
    
    public static int func(String s, int n, int start, int end, int[][] dp){
        
        if(start >= end) return 0;
        
        if(dp[start][end] != -1) return dp[start][end];
        
        if(s.charAt(start) == s.charAt(end)) return dp[start][end] = func(s, n, start + 1, end - 1, dp);
        
        int ans = Math.min(func(s, n, start, end - 1, dp), func(s, n, start + 1, end, dp));
        if(ans != Integer.MAX_VALUE) ans++;
        
        return dp[start][end] = ans;
        
    }
    
    public boolean isValidPalindrome(String s, int k) {
        
        int n = s.length();
        
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        
        if(func(s, n, 0, n - 1, dp) <= k) return true;
        
        return false;
        
    }
}
