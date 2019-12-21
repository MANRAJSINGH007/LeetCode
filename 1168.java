class Solution {
    
    public int findParent(int[] par, int p){
        while(p != par[p]) p = par[p];
        return p;
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int m = pipes.length;
        int w = wells.length;
        int[][] edges = new int[m + w][3];
        
        for(int i = 0; i < m; i++){
            edges[i][0] = pipes[i][0];
            edges[i][1] = pipes[i][1];
            edges[i][2] = pipes[i][2];
        }
        
        for(int i = m; i < m + w; i++){
            edges[i][0] = i - m + 1;
            edges[i][1] = 0;
            edges[i][2] = wells[i - m];
        }
        
        Arrays.sort(edges, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2){
                return (e1[2] <= e2[2]) ? -1 : 1;
            }
        });
        
        int[] par = new int[n + 1];
        for(int i = 0; i <= n; i++) par[i] = i;
        
        int index = 0;
        int count = 0;
        int cost = 0;
        
        while(count <= n && index < m + w){
            int[] currEdge = edges[index];
            int v1 = currEdge[0];
            int v2 = currEdge[1];
            int p1 = findParent(par, v1);
            int p2 = findParent(par, v2);
            if(p1 != p2){
                count++;
                par[p1] = p2;
                cost += currEdge[2];
            }
            
            index++;
        }
        
        return cost;
    }
}
