class Solution {
    
    public static int func(int[][] grid, int n, int m, int i, int j){
        
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == 0) return 0;
        
        grid[i][j] = 0;
        
        return 1 + func(grid, n, m, i + 1, j) + func(grid, n, m, i - 1, j) + func(grid, n, m, i, j + 1) + func(grid, n, m, i, j - 1);
        
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length;
        if(n == 0) return 0;
        
        int m = grid[0].length;
        
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                max = Math.max(max, func(grid, n, m, i, j));
            }
        }
        
        return max;
    }
}
