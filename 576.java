class Solution {
    
    static int mod = (int)Math.pow(10, 9) + 7;
    
    public static int func(int m, int n, int max, int i, int j, int[][][] dp){
        
        if(i < 0 || i == m || j < 0 || j == n){
            return 1;
        }
        
        if(max == 0){
            return 0;
        }
        
        if(dp[i][j][max] != -1){
            return dp[i][j][max];
        }
        
        long count = 0;
        
        int m1 = func(m, n, max - 1, i + 1, j, dp);
        int m2 = func(m, n, max - 1, i, j - 1, dp);
        int m3 = func(m, n, max - 1, i - 1, j, dp);
        int m4 = func(m, n, max - 1, i, j + 1, dp);
        
        count = (long)m1 + (long)m2 + (long)m3 + (long)m4;
        
        
        return dp[i][j][max] = (int)(count % mod);
        
    }
    
    public int findPaths(int m, int n, int max, int i, int j) {
        
        int[][][] dp = new int[m][n][max + 1];
        
        for(int p = 0; p < m; p++){
            for(int k = 0; k < n; k++){
                for(int l = 0; l <= max; l++){
                    dp[p][k][l] = -1;
                }
            }
        }
        
        return func(m, n, max, i, j, dp);
    }
}
