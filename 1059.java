class Solution {
    static int dest;
    public static boolean dfs(List<List<Integer>> adj, int curr, int[] visited){
        if(visited[curr] == 1) return true;
        if(visited[curr] == 2) return false;
        visited[curr] = 1;
        int flag = 0;
        for(int i = 0; i < adj.get(curr).size(); i++){
            flag = 1;
            if(dfs(adj, adj.get(curr).get(i), visited)) return true;
        }
        visited[curr] = 2;
        if(curr == dest) return flag == 0 ? false : true;
        if(flag == 0) return curr != dest;
        return false;
    }
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        int m = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++) adj.get(edges[i][0]).add(edges[i][1]);
        int[] visited = new int[n];
        dest = destination;
        return !dfs(adj, source, visited);
    }
}
