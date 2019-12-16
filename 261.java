class Solution {
    
    public static boolean func(int[][] adj, int curr, int[] visited, int n){
        if(visited[curr] == 1) return true;
        if(visited[curr] == 2) return false;
        visited[curr] = 1;
        for(int i = 0; i < n; i++){
            if(adj[curr][i] == 1){
                adj[i][curr] = 0;
                if(func(adj, i, visited, n)) return true;
            }
        }
        visited[curr] = 2;
        return false;
    }
    
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        if(m >= n) return false;
        int[][] adj = new int[n][n];
        for(int i = 0; i < m; i++){
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }
        
        int[] visited = new int[n];
        if(func(adj, 0, visited, n)) return false;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0) return false;
        }
        return true;
    }
}
