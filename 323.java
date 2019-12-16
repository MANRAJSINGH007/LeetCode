class Solution {
    public static int parent(int[] par, int i){
        while(i != par[i]) i = par[i];
        return i;
    }
    public int countComponents(int n, int[][] edges) {
        
        if(n == 0) return 0;
        int m = edges.length;
        int[] par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        for(int i = 0; i < m; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int p1 = parent(par, v1);
            int p2 = parent(par, v2);
            if(p1 != p2) par[p1] = p2;
        }
        
        int count = 0;
        for(int i = 0; i < n; i++) if(par[i] == i) count++;
        return count;
    }
}
