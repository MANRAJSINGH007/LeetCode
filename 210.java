class Solution {
    
    static int[] topologicalSort;
    static int k = 0;
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> edges, int curr, int[] visited){
        
        visited[curr] = 1;
        
        ArrayList<Integer> adj = edges.get(curr);
        
        for(int i = 0; i < adj.size(); i++){
            int vertex = adj.get(i);
            if(visited[vertex] == 2) continue;
            if(visited[vertex] == 1) return false;
            if(!dfs(edges, vertex, visited)) return false;
        }
        
        visited[curr] = 2;
        topologicalSort[k] = curr;
        k ++;
        return true;
    }
    
    public int[] findOrder(int n, int[][] prerequisites) {
        
        int m = prerequisites.length;
        topologicalSort = new int[n];
        k = 0;
        
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        
        for(int i = 0; i < n; i++) edges.add(new ArrayList<>());
        
        for(int i = 0; i < m; i++){
            int sv = prerequisites[i][0];
            int ev = prerequisites[i][1];
            edges.get(sv).add(ev);
            
        }
        
        int[] visited = new int[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(!dfs(edges, i, visited)) return new int[0];
                else continue;
            }
        }
        
        return topologicalSort;
        
    }
}
