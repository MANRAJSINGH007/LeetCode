class Solution {
    
    static int cnt = 0;
    static int color = 2;
    
    public static void dfs(int[][] grid, int n, int m, int i, int j){
        
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] != 1) return ;
        
        cnt ++;
        grid[i][j] = -1;
        dfs(grid, n, m, i + 1, j);
        dfs(grid, n, m, i - 1, j);
        dfs(grid, n, m, i, j + 1);
        dfs(grid, n, m, i, j - 1);
        
    }
    
    public static void dfsColor(int[][] grid, int n, int m, int i, int j, int[][] ans){
        
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] != -1) return ;
        
        grid[i][j] = color;
        ans[i][j] = cnt;
        dfsColor(grid, n, m, i + 1, j, ans);
        dfsColor(grid, n, m, i - 1, j, ans);
        dfsColor(grid, n, m, i, j + 1, ans);
        dfsColor(grid, n, m, i, j - 1, ans);
        
    }
    
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        if(m == 0) return 0;
        color = 2;
        
        int[][] ans = new int[n][m];
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    cnt = 0;
                    dfs(grid, n, m, i, j);
                    max = Math.max(max, cnt);
                    dfsColor(grid, n, m, i, j, ans);
                    color++;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    
                    HashMap<Integer, Integer> map = new HashMap<>();
                    
                    if(i - 1 > -1){
                        if(!map.containsKey(grid[i - 1][j]) || map.get(grid[i - 1][j]) < ans[i - 1][j]){
                            map.put(grid[i - 1][j], ans[i - 1][j]);
                        }
                    }
                    
                    if(j - 1 > -1){
                        if(!map.containsKey(grid[i][j - 1]) || map.get(grid[i][j - 1]) < ans[i][j - 1]){
                            map.put(grid[i][j - 1], ans[i][j - 1]);
                        }
                    }
                    
                    if(i + 1 < n){
                        if(!map.containsKey(grid[i + 1][j]) || map.get(grid[i + 1][j]) < ans[i + 1][j]){
                            map.put(grid[i + 1][j], ans[i + 1][j]);
                        }
                    }
                    
                    if(j + 1 < m){
                        if(!map.containsKey(grid[i][j + 1]) || map.get(grid[i][j + 1]) < ans[i][j + 1]){
                            map.put(grid[i][j + 1], ans[i][j + 1]);
                        }
                    }
                    
                    int currMax = 1;
                    Set<Integer> keys = map.keySet();
                    for(Integer k : keys) currMax += map.get(k);
                    max = Math.max(max, currMax);
                }
            }
        }
        
        
        return max;
        
    }
}
