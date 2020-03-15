class Solution {
    public static double func(HashSet<Integer> visited, int curr, int[][] g, int target, int time, int t) {
        if(time == t) return curr == target ? 1 : 0;
        visited.add(curr);
        double prob = 0;
        boolean flag = false;
        int c = 0;
        for(int i = 1; i < g.length; i++) if(g[curr][i] == 1 && !visited.contains(i)) c++;
        for(int i = 1; i < g.length; i++) {
            if(g[curr][i] == 1 && !visited.contains(i)) {
                flag = true;
                prob += (func(visited, i, g, target, time + 1, t) / c);
            }
        }
        if(!flag) return curr == target ? 1 : 0;
        visited.remove(curr);
        return prob;
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        int[][] g = new int[n + 1][n + 1];
        for(int i = 0; i < edges.length; i++) {
            int sv = edges[i][0], ev = edges[i][1];
            g[sv][ev] = 1;
            g[ev][sv] = 1;
        }
        return func(new HashSet<>(), 1, g, target, 0, t);
    }
}
