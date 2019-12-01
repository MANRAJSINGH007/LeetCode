class Solution {
    
    public static int check(String s, int start, int end){
        
        int count = 0;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) count ++;
            start ++;
            end --;
        }
        
        return count;
        
    }
    
    public static int f(String s, int k, int start, int end, int[][][] dp){
        
        if(dp[start][end][k] != -1) return dp[start][end][k];
        
        if(k == 1) return dp[start][end][k] = check(s, start, end);
        
        if(start == end){
            if(k <= 1) return dp[start][end][k] = k;
            return dp[start][end][k] = Integer.MAX_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = start; i < end; i++){
            int x1 = f(s, 1, start, i, dp);
            int x2 = f(s, k - 1, i + 1, end, dp);
            if(x1 != Integer.MAX_VALUE && x2 != Integer.MAX_VALUE) min = Math.min(x1 + x2, min);
        }
        
        return dp[start][end][k] = min;
        
    }
    
    public int palindromePartition(String s, int k) {
        
        int n = s.length();
        int[][][] dp = new int[n][n][k + 1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int p = 0; p < k + 1; p++) dp[i][j][p] = -1;
            }
        }
        
        return f(s, k, 0, n - 1, dp);
        
    }
}
