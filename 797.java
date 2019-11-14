class Solution {
    
    public static List<List<Integer>> func(int[][] graph, int n, int curr, boolean[] visited){
        
        if(curr == n - 1){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            ans.get(0).add(curr);
            return ans;
        }
        
        visited[curr] = true;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < graph[curr].length; i++){
            if(!visited[graph[curr][i]]){
                List<List<Integer>> temp = func(graph, n, graph[curr][i], visited);
                if(temp.size() != 0){
                    List<List<Integer>> t = new ArrayList<>(temp);
                    for(int k = 0; k < t.size(); k++){
                        t.get(k).add(0, curr);
                        ans.add(t.get(k));
                    }
                }
            }
        }
        
        visited[curr] = false;
        return ans;
        
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;
        return func(graph, n, 0, new boolean[n]);
        
    }
}
