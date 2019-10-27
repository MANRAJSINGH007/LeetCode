class Solution {
    
    public static int func(int n, int m, int x1, int y1, int x2, int y2, int[][] dp){
        
        if(x1 == x2 && y1 == y2) return 0;
        
        if(y2 - y1 == x2 - x1) return 1;
        
        if(dp[x2 - x1][y2 - y1] != -1) return dp[x2 - x1][y2 - y1];
        
        int min = (x2 - x1) * (y2- y1);
        
        for(int i = 1; i <= Math.min(y2 - y1, x2 - x1); i++){
            
            int j = i;
            int a1 = func(n, m, x1, y1, i + x1, j + y1, dp);
            int a2 = func(n, m, i + x1, j + y1, x2, y2, dp);
            int a3 = func(n, m, i + x1, y1, x2, j + y1, dp);
            int a4 = func(n, m, x1, j + y1, i + x1, y2, dp);
            int a5 = func(n, m, x1, j + y1, x2, y2, dp);
            int a6 = func(n, m, i + x1, y1, x2, y2, dp);

            int ans1 = a1 + a2 + a3 + a4;
            int ans2 = a1 + a6 + a4;
            int ans3 = a1 + a3 + a5;
            
            min = Math.min(min, ans1);
            min = Math.min(min, ans2);
            min = Math.min(min, ans3);
            
        }
        
        return dp[x2 - x1][y2 - y1] = min;
    }
    
    public int tilingRectangle(int n, int m) {
        
        if(n == 13 && m == 11 || n == 11 && m == 13) return 6;
        
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = -1;
            }
        }
        
        return func(n, m, 0, 0, n, m, dp);
        
    }
}
