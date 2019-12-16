class Solution {
    static int max = 0;
    public static int dfs(int[][] adj, int curr, int n, int[] visited, int[] ans, int c){
        if(visited[curr] == 1) return -1;
        if(visited[curr] == 2){
            max = Math.max(max, c + ans[curr]);
            return ans[curr];
        }
        visited[curr] = 1;
        int maxDepth = 0;
        for(int i = 1; i <= n; i++){
            if(adj[curr][i] == 1){
                int temp = dfs(adj, i, n, visited, ans, c + 1);
                if(temp == -1) return temp;
                maxDepth = Math.max(maxDepth, temp);
            }
        }
        visited[curr] = 2;
        return ans[curr] = maxDepth + 1;
    }
    public int minimumSemesters(int n, int[][] relations) {
        int m = relations.length;
        int[][] adj = new int[n + 1][n + 1];
        for(int i = 0; i < m; i++) adj[relations[i][0]][relations[i][1]] = 1;
        int[] visited = new int[n + 1];
        int[] ans = new int[n + 1];
        max = 0;
        for(int i = 1; i <= n; i++){
            if(visited[i] == 0){
                int currAns = dfs(adj, i, n, visited, ans, 0);
                if(currAns == -1) return currAns;
            }
        }
        for(int i = 1; i <= n; i++) max = Math.max(max, ans[i]);
        return max;
    }
}
