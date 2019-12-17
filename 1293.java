class Solution {
    
    public static int func(int[][] grid, int n, int m, int i, int j, int[][][] dp, boolean[][] visited, int k){
        if(i < 0 || j < 0 || i == n || j == m || visited[i][j]) return Integer.MAX_VALUE;
        if(i == n - 1 && j == m - 1) return 0;
        if(dp[i][j][k] != -1) return dp[i][j][k];
        int newK = k;
        if(grid[i][j] == 1) newK--;
        if(newK < 0) return Integer.MAX_VALUE;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        visited[i][j] = true;
        int min = Integer.MAX_VALUE;
        for(int p = 0; p < 4; p++){
            int small = func(grid, n, m, i + dx[p], j + dy[p], dp, visited, newK);
            if(small != Integer.MAX_VALUE) min = Math.min(min, small + 1);
        }
        
        visited[i][j] = false;
        return dp[i][j][k] = min;
    }
    
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int t = 0; t < k + 1; t++) dp[i][j][t] = -1;
            }
        }
        boolean[][] visited = new boolean[n][m];
        int ans = func(grid, n, m, 0, 0, dp, visited, k);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
