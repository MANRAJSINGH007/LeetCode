class Solution {
    
    static int max = 0;
    
    public static int func(HashMap<Integer, ArrayList<Integer>> g, int n, boolean[] visited, int curr){
        
        visited[curr] = true;
        int max1 = 0;
        int max2 = 0;
        
        if(!g.containsKey(curr)) return 0;
        
        ArrayList<Integer> temp = g.get(curr);
        
        for(int i = 0; i < temp.size(); i++){
            if(!visited[temp.get(i)]){
                int t = 1 + func(g, n, visited, temp.get(i));
                if(t >= max1){
                    max2 = max1;
                    max1 = t;
                }
                else if(t > max2) max2 = t;
            }
        }
        
        max = Math.max(max, max1 + max2);
        
        return max1;
        
    }
    
    public int treeDiameter(int[][] edges) {
        
        int n = edges.length;
        max = 0;
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int sv = edges[i][0];
            int ev = edges[i][1];
            if(!g.containsKey(sv)) g.put(sv, new ArrayList<>());
            if(!g.containsKey(ev)) g.put(ev, new ArrayList<>());
            g.get(sv).add(ev);
            g.get(ev).add(sv);
        }
        
        boolean[] visited = new boolean[n + 1];
        
        for(int i = 0; i <= n; i++){
            if(!visited[i]){
                int d = func(g, n, visited, i);
            }
        }
        
        return max;
        
        
    }
}
