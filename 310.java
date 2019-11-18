class Pair {
    int node;
    int ans;
    Pair(int node, int ans){
        this.node = node;
        this.ans = ans;
    }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n == 0) return new ArrayList<>();
        if(n == 1){
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        
        int[] deg = new int[n];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        
        for(int i = 0; i < edges.length; i++){
            int sv = edges[i][0];
            int ev = edges[i][1];
            graph.get(sv).add(ev);
            graph.get(ev).add(sv);
            deg[sv] ++;
            deg[ev] ++;
        }
        
        boolean[] visited = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        List<Integer> center = new ArrayList<>();
        for(int i = 0; i < n; i++){
             if(deg[i] == 1){
                 q.add(new Pair(i, 0));
                 visited[i] = true;
                 center.add(i);
                 deg[i]--;
             }
        }
        
        int max = 0;
        
        while(q.size() > 0){
            Pair p = q.remove();
            ArrayList<Integer> adj = graph.get(p.node);
            for(int k = 0; k < adj.size(); k++){
                int j = adj.get(k);
                if(!visited[j]){
                    deg[j]--;
                    if(deg[j] > 1) continue;
                    visited[j] = true;
                    q.add(new Pair(j, p.ans + 1));
                    if(max == p.ans + 1){
                        center.add(j);
                    }
                    else if(p.ans + 1 > max){
                        max = p.ans + 1;
                        center = new ArrayList<>();
                        center.add(j);
                    }
                }
            }
        }
        
        return center;
        
    }
}
