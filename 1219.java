class Solution {
    
    public static int dfs(int[][] grid, int i, int j, int n, int m){
        
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == 0) return 0;
        
        int currAns = grid[i][j];
        grid[i][j] = 0;
        
        int max = dfs(grid, i + 1, j, n, m);
        max = Math.max(max, dfs(grid, i - 1, j, n, m));
        max = Math.max(max, dfs(grid, i, j + 1, n, m));
        max = Math.max(max, dfs(grid, i, j - 1, n, m));
        
        grid[i][j] = currAns;
        
        return currAns + max;
        
    }
    
    public int getMaximumGold(int[][] grid) {
        
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    max = Math.max(max, dfs(grid, i, j, n, m));
                }
            }
        }
        
        return max;
    }
}
