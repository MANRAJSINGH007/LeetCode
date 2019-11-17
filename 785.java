class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                HashSet<Integer> set1 = new HashSet<>();
                HashSet<Integer> set2 = new HashSet<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                set1.add(i);
                
                while(q.size() > 0){
                    int index = q.remove();
                    int s = 2;
                    if(set1.contains(index)) s = 1;
                    for(int j = 0; j < graph[index].length; j++){
                        int vertex = graph[index][j];
                        if(s == 1 && set1.contains(vertex)) return false;
                        else if(s == 2 && set2.contains(vertex)) return false;
                        else if(s == 1) set2.add(vertex);
                        else if(s == 2) set1.add(vertex);
                        if(!visited[vertex]){
                            visited[vertex] = true;
                            q.add(vertex);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
