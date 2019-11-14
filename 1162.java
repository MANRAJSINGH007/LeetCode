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
    
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        if(n == 0) return -1;
        
        boolean[][] visited = new boolean[n][n];
        
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count ++;
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        if(count == 0 || count == n * n) return -1;
        
        int max = 1;
        
        while(q.size() > 0){
            Pair curr = q.remove();
            int i = curr.x;
            int j = curr.y;
            
            if(i + 1 < n && !visited[i + 1][j]){
                visited[i + 1][j] = true;
                q.add(new Pair(i + 1, j, curr.ans + 1));
                max = Math.max(max, curr.ans + 1);
            }
            
            if(j + 1 < n && !visited[i][j + 1]){
                visited[i][j + 1] = true;
                q.add(new Pair(i, j + 1, curr.ans + 1));
                max = Math.max(max, curr.ans + 1);
            }
            
            if(i - 1 >= 0 && !visited[i - 1][j]){
                visited[i - 1][j] = true;
                q.add(new Pair(i - 1, j, curr.ans + 1));
                max = Math.max(max, curr.ans + 1);
            }
            
            if(j - 1 >= 0 && !visited[i][j - 1]){
                visited[i][j - 1] = true;
                q.add(new Pair(i, j - 1, curr.ans + 1));
                max = Math.max(max, curr.ans + 1);
            }
        }
        
        return max;
        
    }
}
