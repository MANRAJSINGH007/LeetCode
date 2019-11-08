class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {
        
        int n = g.length;
        List<HashSet<Integer>> graph = new ArrayList<>();
        List<HashSet<Integer>> parent = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<>());
            parent.add(new HashSet<>());
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(g[i].length == 0) q.add(i);
            for(int j : g[i]){
                graph.get(i).add(j);
                parent.get(j).add(i);
            }
        }
        
        boolean[] safe = new boolean[n];
        
        while(!q.isEmpty()){
            int j = q.remove();
            safe[j] = true;
            for(int i : parent.get(j)){
                graph.get(i).remove(j);
                if(graph.get(i).size() == 0) q.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) if(safe[i]) ans.add(i);
        return ans;
    }
}
