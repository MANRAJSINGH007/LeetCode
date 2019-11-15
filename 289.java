class Solution {
    
    public static int func(int[][] grid, int n, int m, int i, int j){
        
        if(i < 0 || j < 0 || i == n || j == m) return 0;
        if(grid[i][j] == -2 || grid[i][j] == -6) return 0;
        if(grid[i][j] == -1 || grid[i][j] == -5) return 1;
        
        if(grid[i][j] == 0){
            grid[i][j] = -6;
            int x1 = func(grid, n, m, i + 1, j);
            int x2 = func(grid, n, m, i - 1, j);
            int x3 = func(grid, n, m, i + 1, j + 1);
            int x4 = func(grid, n, m, i - 1, j - 1);
            int x5 = func(grid, n, m, i, j + 1);
            int x6 = func(grid, n, m, i, j - 1);
            int x7 = func(grid, n, m, i + 1, j - 1);
            int x8 = func(grid, n, m, i - 1, j + 1);
            int count = x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8;
            if(count == 3) grid[i][j] = -2;
            return 0;
        }
        else{
            grid[i][j] = -5;
            int x1 = func(grid, n, m, i + 1, j);
            int x2 = func(grid, n, m, i - 1, j);
            int x3 = func(grid, n, m, i + 1, j + 1);
            int x4 = func(grid, n, m, i - 1, j - 1);
            int x5 = func(grid, n, m, i, j + 1);
            int x6 = func(grid, n, m, i, j - 1);
            int x7 = func(grid, n, m, i + 1, j - 1);
            int x8 = func(grid, n, m, i - 1, j + 1);
            int count = x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8;
            if(count < 2 || count > 3) grid[i][j] = -1;
            return 1;
        }
        
    }
    
    public void gameOfLife(int[][] grid) {
        int n = grid.length;
        if(n == 0) return ;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 || grid[i][j] == 1){
                    int d = func(grid, n, m, i, j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == -6 || grid[i][j] == -1) grid[i][j] = 0;
                else if(grid[i][j] == -5 || grid[i][j] == -2) grid[i][j] = 1;
            }
        }
        
        return ;
    }
}
