class Solution {
    static int time;
    public static int dfs(List<List<Integer>> g, int curr, int n, List<Boolean> hasApple, boolean[] visited) {
        if(visited[curr]) return 0;
        int count = hasApple.get(curr) ? 1 : 0;
        List<Integer> adj = g.get(curr);
        visited[curr] = true;
        for(int i = 0; i < adj.size(); i++) {
            time += 2;
            int apples = dfs(g, adj.get(i), n, hasApple, visited);
            if(apples == 0) time -= 2;
            count += apples;
        }
        return count;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int m = edges.length;
        time = 0;
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) g.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        int totalApples = dfs(g, 0, n, hasApple, visited);
        return time;
    }
}
