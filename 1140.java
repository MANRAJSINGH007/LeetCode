class Solution {
    
    public static int func(int[] piles, int n, int i, int m, int state, int[][][] dp){
        
        if(i == n) return 0;
        
        if(dp[i][m][state] != -1) return dp[i][m][state];
        
        if(state == 0){
            int stones = 0;
            int max = 0;
            for(int j = i; j < Math.min(n, i + 2 * m); j++){
                stones += piles[j];
                max = Math.max(max, stones + func(piles, n, j + 1, Math.max(j - i + 1, m), 1, dp));
            }
            
            return dp[i][m][0] = max;
        }
        
        else{
            int min = Integer.MAX_VALUE;
            for(int j = i; j < Math.min(n, i + 2 * m); j++){
                min = Math.min(min, func(piles, n, j + 1, Math.max(j - i + 1, m), 0, dp));
            }
            
            return dp[i][m][1] = min;
        }
        
        
    }
    
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        
        return func(piles, n, 0, 1, 0, dp);
        
    }
}
