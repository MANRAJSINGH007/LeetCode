class Solution {
    public static int findParent(int[] par, int i) {
        while(i != par[i]) i = par[i];
        return i;
    }
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> g = new ArrayList<>();
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            parent[i] = i;
        }
        int m = connections.length;
        int components = 0;
        int extraEdge = 0;
        for(int i = 0; i < m; i++) {
            g.get(connections[i][0]).add(connections[i][1]);
            int p1 = findParent(parent, connections[i][0]);
            int p2 = findParent(parent, connections[i][1]);
            if(p1 == p2) extraEdge++;
            else parent[p1] = p2;
        }
        for(int i = 0; i < n; i++) if(parent[i] == i) components++;
        return (extraEdge >= components - 1) ? components - 1 : -1;
    }
}
