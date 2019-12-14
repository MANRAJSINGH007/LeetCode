class Solution {
    
    public static int func(int[][] arr, int n, int m, int i, int k, int[][] dp){
        if(i == n) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            if(j == k) continue;
            min = Math.min(min, func(arr, n, m, i + 1, j, dp));
        }
        if(min != Integer.MAX_VALUE) min += arr[i][k];
        return dp[i][k] = min;
    }
    
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) dp[i][j] = -1;
        }
        
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            min = Math.min(min, func(arr, n, m, 0, j, dp));
        }
        
        return min;
    }
}
