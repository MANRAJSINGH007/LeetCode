class Solution {
    
    public static int func(int[][] edges, int n, int src, int dest, int k, int[][] dp){
        
        if(src == dest) return k >= 0 ? 0 : Integer.MAX_VALUE;
        
        if(k == 0) return Integer.MAX_VALUE;
        
        if(dp[src][k] != -1) return dp[src][k];
        
        int[] adj = edges[src];
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < adj.length; i++){
            if(adj[i] != 0){
                int currCost = func(edges, n, i, dest, k - 1, dp);
                if(currCost != Integer.MAX_VALUE){
                    min = Math.min(min, currCost + adj[i]);
                }
            }
        }
        
        return dp[src][k] = min;
        
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int m = flights.length;
        if(m == 0) return src == dst ? 0 : -1;
        int[][] edges = new int[n][n];
        for(int i = 0; i < m; i++) edges[flights[i][0]][flights[i][1]] = flights[i][2];
        k ++;
        
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k + 1; j++) dp[i][j] = -1;
        }
        
        int ans = func(edges, n, src, dst, k, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}
