class Solution {
    
    public static int findParent(int[] parent, int i){
        
        if(parent[i] == i) return i;
        
        return findParent(parent, parent[i]);
        
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        
        int[] parent = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            int sv = edges[i][0];
            int ev = edges[i][1];
            int p1 = findParent(parent, sv);
            int p2 = findParent(parent, ev);
            
            if(p1 == p2){
                int[] ans = new int[2];
                ans[0] = sv;
                ans[1] = ev;
                return ans;
            }
            
            parent[p1] = p2;
        }
        
        int[] ans = new int[2];
        
        return ans;
        
    }
}
