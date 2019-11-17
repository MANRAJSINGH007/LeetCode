class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        int[][] edges = new int[n + 1][n + 1];
        for(int i = 0; i < dislikes.length; i++){
            edges[dislikes[i][0]][dislikes[i][1]] = 1;
            edges[dislikes[i][1]][dislikes[i][0]] = 1;
        }
        
        boolean[] visited = new boolean[n + 1];
        
        for(int i = 1; i < n + 1; i++){
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
                    for(int j = 1; j <= n; j++){
                        if(edges[index][j] == 0) continue;
                        if(s == 1 && set1.contains(j)) return false;
                        else if(s == 2 && set2.contains(j)) return false;
                        else if(s == 1) set2.add(j);
                        else if(s == 2) set1.add(j);
                        if(!visited[j]){
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        
        return true;
        
    }
}
