class Solution {
    
    public static boolean func(int[][] grid, int n, int m, int i, int j){
        
        // either you reached a boundary 0 or went out of the cell
        if(i == - 1 || j == -1 || i == n || j == m || grid[i][j] == -2) return false;
        
        // you landed at the same cell that was visited earlier or you landed on a water cell
        if(grid[i][j] == -1 || grid[i][j] == 1) return true;
        
        // mark current element with -1 so that you don't revisit it
        grid[i][j] = -1;
        
        return func(grid, n, m, i, j - 1) && func(grid, n, m, i, j + 1) && func(grid, n, m, i - 1, j) && func(grid, n, m, i + 1, j);
        
    }
    
    // do dfs for all the boundary cells with grid[i][j] == 0 and mark them.
    public static void dfs(int[][] grid, int n, int m, int i, int j){
        
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == -2 || grid[i][j] == 1) return;
        
        grid[i][j] = -2;
        // mark boundary 0s by -2
        
        dfs(grid, n, m, i + 1, j);
        dfs(grid, n, m, i - 1, j);
        dfs(grid, n, m, i, j - 1);
        dfs(grid, n, m, i, j + 1);
        return ;
        
    }
    
    public int closedIsland(int[][] grid) {
        
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        
        int count = 0;
        
        // mark all the boundary 0s
        for(int i = 0; i < n; i++) dfs(grid, n, m, i, 0);
        for(int i = 0; i < n; i++) dfs(grid, n, m, i, m - 1);
        for(int i = 0; i < m; i++) dfs(grid, n, m, 0, i);
        for(int i = 0; i < m; i++) dfs(grid, n, m, n - 1, i);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // perform dfs by calling func on only those 0s which weren't marked while dfs of boundary 0s.
                if(grid[i][j] == 0 && func(grid, n, m, i, j)) count ++;
            }
        }
        
        return count;
        
    }
}
