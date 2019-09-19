class Solution {
    
    public static boolean check(int i, int j, int n, int m){
        
        if(i < 0 || i ==n || j < 0 || j == m) return true;
        
        return false;
        
    }
    
    public static int func(int[][] matrix, int n, int m, int i, int j, int[][] dp){
        
        if(dp[i][j] != 0) return dp[i][j];
        
        if(!check(i + 1, j, n, m) && matrix[i + 1][j] > matrix[i][j]){
            dp[i][j] = Math.max(func(matrix, n, m, i + 1, j, dp), dp[i][j]);
        }
        
        if(!check(i - 1, j, n, m) && matrix[i - 1][j] > matrix[i][j]){
            dp[i][j] = Math.max(func(matrix, n, m, i - 1, j, dp), dp[i][j]);
        }
        
        if(!check(i, j + 1, n, m) && matrix[i][j + 1] > matrix[i][j]){
            dp[i][j] = Math.max(func(matrix, n, m, i, j + 1, dp), dp[i][j]);
        }
        
        if(!check(i, j - 1, n, m) && matrix[i][j - 1] > matrix[i][j]){
            dp[i][j] = Math.max(func(matrix, n, m, i, j - 1, dp), dp[i][j]);
        }
        
        return ++dp[i][j];
        
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length; 
        if(n == 0) return 0;
        
        int m = matrix[0].length;
        
        int[][] dp = new int[n][m];
        
        int max = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                max = Math.max(max, func(matrix, n, m, i, j, dp));
            }
        }
        
        return max;
    }
}
