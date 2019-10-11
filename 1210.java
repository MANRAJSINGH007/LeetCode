class Pair{
    int i1;
    int i2;
    int i3;
    int i4;
    int ans;
    
    Pair(int i1, int i2, int i3, int i4, int ans){
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.ans = ans;
    }
}

class Solution {
    
    public int minimumMoves(int[][] grid) {
        
        int n = grid.length;
        
        if(grid[0][0] == 1 || grid[0][1] == 1) return -1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 1, 0, 0, 0));
        
        boolean[][][][] visited = new boolean[n][n][n][n];
        
        visited[0][1][0][0] = true;
        
        while(q.size() > 0){
            
            Pair p = q.remove();
            
            if(p.i1 == n - 1 && p.i2 == n - 1 && p.i3 == n - 1 && p.i4 == n -2) return p.ans;
            
            if(p.i1 == p.i3){
                
                if(p.i2 + 1 < n && grid[p.i1][p.i2 + 1] == 0 && grid[p.i3][p.i4 + 1] == 0 && !visited[p.i1][p.i2 + 1][p.i3][p.i4 + 1]){
                    visited[p.i1][p.i2 + 1][p.i3][p.i4 + 1] = true;
                    q.add(new Pair(p.i1, p.i2 + 1, p.i3, p.i4 + 1, p.ans + 1));
                }
                
                if(p.i1 + 1 < n && grid[p.i1 + 1][p.i2 - 1] == 0 && grid[p.i1 + 1][p.i2] ==0 && !visited[p.i1 + 1][p.i2 - 1][p.i3][p.i4]){
                    visited[p.i1 + 1][p.i2 - 1][p.i3][p.i4] = true;
                    q.add(new Pair(p.i1 + 1, p.i2 - 1, p.i3, p.i4, p.ans + 1));
                }
                
                if(p.i1 + 1 < n && grid[p.i1 + 1][p.i2] == 0 && grid[p.i3 + 1][p.i4] == 0 && !visited[p.i1 + 1][p.i2][p.i3 + 1][p.i4]){
                    visited[p.i1 + 1][p.i2][p.i3 + 1][p.i4] = true;
                    q.add(new Pair(p.i1 + 1, p.i2, p.i3 + 1, p.i4, p.ans + 1));
                }
                
            }
            
            if(p.i2 == p.i4){
                if(p.i1 + 1 < n && grid[p.i1 + 1][p.i2] == 0 && grid[p.i3 + 1][p.i4] == 0 && !visited[p.i1 + 1][p.i2][p.i3 + 1][p.i4]){
                    visited[p.i1 + 1][p.i2][p.i3 + 1][p.i4] = true;
                    q.add(new Pair(p.i1 + 1, p.i2, p.i3 + 1, p.i4, p.ans + 1));
                }
                
                if(p.i2 + 1 < n && grid[p.i1 - 1][p.i2 + 1] == 0 && grid[p.i1][p.i2 + 1] == 0 && !visited[p.i1 - 1][p.i2 + 1][p.i3][p.i4]){
                    visited[p.i1 - 1][p.i2 + 1][p.i3][p.i4] = true;
                    q.add(new Pair(p.i1 - 1, p.i2 + 1, p.i3, p.i4, p.ans + 1));
                }
                
                if(p.i2 + 1 < n && grid[p.i1][p.i2 + 1] == 0 && grid[p.i3][p.i4 + 1] == 0 && !visited[p.i1][p.i2 + 1][p.i3][p.i4 + 1]){
                    visited[p.i1][p.i2 + 1][p.i3][p.i4 + 1] = true;
                    q.add(new Pair(p.i1, p.i2 + 1, p.i3, p.i4 + 1, p.ans + 1));
                }
            }
            
        }
        
        return -1;
        
    }
}
