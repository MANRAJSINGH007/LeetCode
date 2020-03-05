class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] top = new int[n][m], left = new int[n][m];
        for(int i = 0; i < n; i++) left[i][0] = grid[i][0];
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(grid[i][j] == 0) left[i][j] = 0;
                else left[i][j] = left[i][j - 1] + 1;
            }
        }
        for(int i = 0; i < m; i++) top[0][i] = grid[0][i];
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(grid[j][i] == 0) top[j][i] = 0;
                else top[j][i] = top[j - 1][i] + 1;
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                int side = Math.min(left[i][j], top[i][j]);
                for(int k = side; k > 0; k--) {
                    int x1 = top[i][j - k + 1];
                    int x2 = left[i - k + 1][j];
                    if(x1 >= k && x2 >= k) {
                        max = Math.max(max, k);
                        break;
                    }
                }
            }
        }
        return max * max;
    }
}
