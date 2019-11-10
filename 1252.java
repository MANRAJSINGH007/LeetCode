class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        
        int k = indices.length;
        if(k == 0) return 0;
        int[][] grid = new int[n][m];
        for(int i = 0; i < k; i++){
            int r = indices[i][0];
            int c = indices[i][1];
            for(int j = 0; j < m; j++) grid[r][j] ++;
            for(int j = 0; j < n; j++) grid[j][c] ++;
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) if(grid[i][j] % 2 == 1) count ++;
        }
        
        return count;
    }
}
