class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int m = times.length;
        k--;
        
        int[][] edges = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                edges[i][j] = -1;
            }
        }
        
        for(int i = 0; i < m; i++){
            int sv = times[i][0] - 1;
            int ev = times[i][1] - 1;
            int w = times[i][2];
            edges[sv][ev] = w;
        }
        
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        
        for(int i = 0; i < n; i++){
            if(i == k) continue;
            distance[i] = Integer.MAX_VALUE;
        }
        
        for(int j = 0; j < n; j++){
            
            int minNode = -1;
            int minDistance = Integer.MAX_VALUE;
            
            for(int i = 0; i < n; i++){
                if(!visited[i] && distance[i] < minDistance){
                    minDistance = distance[i];
                    minNode = i;
                }
            }
            
            if(minNode == -1) return -1;
            
            visited[minNode] = true;
            
            for(int i = 0; i < n; i++){
                if(!visited[i] && edges[minNode][i] > -1 && edges[minNode][i] + distance[minNode] < distance[i]){
                    distance[i] = edges[minNode][i] + distance[minNode];
                }
            }
            
        }
        
        int max = 0;
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, distance[i]);
        }
        
        return max == Integer.MAX_VALUE ? -1 : max;
        
        
    }
}
