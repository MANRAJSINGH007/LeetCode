class Pair {
    int x;
    int y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        if(n == 0) return 0;
        
        int[][] distance = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Pair[][] parent = new Pair[n][n];
        
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                distance[i][j] = Integer.MAX_VALUE;
                parent[i][j] = new Pair(-1, -1);
            }
        }
        
        distance[0][0] = 0;
        
        for(int i = 0; i < (int)Math.pow(n, 2); i++){
            
            int min = Integer.MAX_VALUE;
            int min_x = -1;
            int min_y = -1;
            
            for(int x = 0; x < n; x++){
                for(int y = 0; y < n; y++){
                    if(!visited[x][y] && distance[x][y] < min){
                        min = distance[x][y];
                        min_x = x;
                        min_y = y;
                    }
                }
            }
            
            if(min_x == -1) break;
            
            visited[min_x][min_y] = true;
            
            if(min_x + 1 < n && !visited[min_x + 1][min_y]){
                if(distance[min_x + 1][min_y] > Math.max(distance[min_x][min_y], grid[min_x + 1][min_y])){
                    distance[min_x + 1][min_y] = Math.max(distance[min_x][min_y], grid[min_x + 1][min_y]);
                    parent[min_x + 1][min_y].x = min_x;
                    parent[min_x + 1][min_y].y = min_y;
                }
            }
            
            if(min_y + 1 < n && !visited[min_x][min_y + 1]){
                if(distance[min_x][min_y + 1] > Math.max(distance[min_x][min_y], grid[min_x][min_y + 1])){
                    distance[min_x][min_y + 1] = Math.max(distance[min_x][min_y], grid[min_x][min_y + 1]);
                    parent[min_x][min_y + 1].x = min_x;
                    parent[min_x][min_y + 1].y = min_y;
                }
            }
            
            if(min_x - 1 >= 0 && !visited[min_x - 1][min_y]){
                if(distance[min_x - 1][min_y] > Math.max(distance[min_x][min_y], grid[min_x - 1][min_y])){
                    distance[min_x - 1][min_y] = Math.max(distance[min_x][min_y], grid[min_x - 1][min_y]);
                    parent[min_x - 1][min_y].x = min_x;
                    parent[min_x - 1][min_y].y = min_y;
                }
            }
            
            if(min_y - 1 > -1 && !visited[min_x][min_y - 1]){
                if(distance[min_x][min_y - 1] > Math.max(distance[min_x][min_y], grid[min_x][min_y - 1])){
                    distance[min_x][min_y - 1] = Math.max(distance[min_x][min_y], grid[min_x][min_y - 1]);
                    parent[min_x][min_y - 1].x = min_x;
                    parent[min_x][min_y - 1].y = min_y;
                }
            }
        }
        
        int max = Math.max(grid[0][0], grid[n - 1][n - 1]);
        Pair par = parent[n - 1][n - 1];
        int x = n - 1;
        int y = n - 1;
        while(x != 0 && y != 0){
            Pair curr = parent[x][y];
            x = curr.x;
            y = curr.y;
            max = Math.max(max, distance[x][y]);
        }
        
        return max;
    }
}
