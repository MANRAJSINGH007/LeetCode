class Pair{
    int x;
    int y;
    int ans;
    Pair(int x, int y, int ans){
        this.x = x;
        this.y = y;
        this.ans = ans;
    }
}

class Solution {
    
    static int color = 2;
    public static void dfs(int[][] grid, int n, int m, int i, int j){
        
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == 0 || grid[i][j] == color) return ;
        grid[i][j] = color;
        dfs(grid, n, m, i + 1, j);
        dfs(grid, n, m, i - 1, j);
        dfs(grid, n, m, i, j + 1);
        dfs(grid, n, m, i, j - 1);
        return ;
        
    }
    
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int x = 0, y = 0;
        color = 2;
        
        outer : for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    x = i;
                    y = j; 
                    break outer;
                }
            }
        }
        
        dfs(grid, n, m, x, y);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) System.out.print(grid[i][j] + " ");
            System.out.println();
        }
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        while(q.size() > 0){
            Pair curr = q.remove();
            if(grid[curr.x][curr.y] == 1) min = Math.min(min, curr.ans - 1);
            
            if(curr.x + 1 < n && ! visited[curr.x + 1][curr.y]){
                visited[curr.x + 1][curr.y] = true;
                q.add(new Pair(curr.x + 1, curr.y, curr.ans + 1));
            }
            
            if(curr.x - 1 > -1 && ! visited[curr.x - 1][curr.y]){
                visited[curr.x - 1][curr.y] = true;
                q.add(new Pair(curr.x - 1, curr.y, curr.ans + 1));
            }
            
            if(curr.y + 1 < m && ! visited[curr.x][curr.y + 1]){
                visited[curr.x][curr.y + 1] = true;
                q.add(new Pair(curr.x, curr.y + 1, curr.ans + 1));
            }
            
            if(curr.y - 1 > -1 && ! visited[curr.x][curr.y - 1]){
                visited[curr.x][curr.y - 1] = true;
                q.add(new Pair(curr.x, curr.y - 1, curr.ans + 1));
            }
        }
        
        return min;
        
    }
}
