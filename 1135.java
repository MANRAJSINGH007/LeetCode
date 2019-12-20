class Solution {
    
    public static int findParent(int[] par, int i){
        while(i != par[i]) i =par[i];
        return i;
    }
    
    public int minimumCost(int n, int[][] connections) {
        int m = connections.length;
        Arrays.sort(connections, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2){
                return e1[2] <= e2[2] ? -1 : 1;
            }
        });
        
        int[] par = new int[n + 1];
        for(int i = 1; i <= n; i++) par[i] = i;
        
        int edges = 0;
        int index = 0;
        int cost = 0;
        while(edges < n - 1 && index < m){
            int v1 = connections[index][0];
            int v2 = connections[index][1];
            int p1 = findParent(par, v1);
            int p2 = findParent(par, v2);
            if(p1 != p2){
                par[p1] = p2;
                edges++;
                cost += connections[index][2];
            }
            index++;
        }
        
        return edges == n - 1 ? cost : -1;
    }
}
