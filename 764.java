class Pair{
    int up;
    int down;
    int left;
    int right;
    Pair(int up, int down, int left, int right){
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        Pair[][] dp = new Pair[n][n];
        int m = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) dp[i][j] = new Pair(1, 1, 1, 1);
        }
        
        for(int i = 0; i < mines.length; i++) dp[mines[i][0]][mines[i][1]] = null;
        
        int max = 0;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dp[i][j] != null){
                    dp[i][j].up = 1;
                    if(dp[i - 1][j] != null) dp[i][j].up += dp[i - 1][j].up; 
                }
            }
        }
        
        for(int j = 1; j < m; j++){
            for(int i = 0; i < n; i++){
                if(dp[i][j] != null){
                    dp[i][j].left = 1;
                    if(dp[i][j - 1] != null) dp[i][j].left += dp[i][j - 1].left; 
                }
            }
        }
        
        for(int i =  n - 2; i >= 0; i--){
            for(int j = 0; j < m; j++){
                if(dp[i][j] != null){
                    dp[i][j].down = 1;
                    if(dp[i + 1][j] != null) dp[i][j].down += dp[i + 1][j].down; 
                }
            }
        }
        
        for(int j = m - 2; j >= 0; j--){
            for(int i = 0; i < n; i++){
                if(dp[i][j] != null){
                    dp[i][j].right = 1;
                    if(dp[i][j + 1] != null) dp[i][j].right += dp[i][j + 1].right; 
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dp[i][j] != null){
                    max = Math.max(max, Math.min(dp[i][j].up, Math.min(dp[i][j].down, Math.min(dp[i][j].left, dp[i][j].right))));
                }
            }
        }
       
        return max;
        
    }
}
