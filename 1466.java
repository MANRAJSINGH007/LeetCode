class Solution {
    public static int dfs(List<List<Integer>> g, int curr, boolean[] visited) {
        visited[curr] = true;
        List<Integer> adj = g.get(curr);
        int ans = 0;
        for(int i = 0; i < adj.size(); i++) if(!visited[adj.get(i)]) ans += 1 + dfs(g, adj.get(i), visited);
        return ans;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) g.add(new ArrayList<>());
        int m = connections.length;
        for(int i = 0; i < m; i++) {
            int sv = connections[i][0], ev = connections[i][1];
            g.get(sv).add(ev);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++) if(!visited[i]) ans += dfs(g, i, visited);
        return ans;
    }
}
