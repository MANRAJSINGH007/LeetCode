class Solution {
    
    static int c = 0;
    
    public static int func(int[][] grid, int n, int m, int i, int j, int count){
        
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == -1) return 0;
        if(grid[i][j] == 2) return count == c ? 1 : 0;
        int curr = grid[i][j];
        grid[i][j] = -1;
        if(curr == 0) count ++;
        int x1 = func(grid, n, m, i + 1, j, count);
        int x2 = func(grid, n, m, i - 1, j, count);
        int x3 = func(grid, n, m, i, j + 1, count);
        int x4 = func(grid, n, m, i, j - 1, count);
        grid[i][j] = curr;
        return x1 + x2 + x3 + x4;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int x = 0, y = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
                else if(grid[i][j] == 0) count ++;
                
            }
        }
        
        c = count;
        return func(grid, n, m, x, y, 0);
    }
}
