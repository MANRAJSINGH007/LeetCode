class Solution {
    
    public static void dfs(List<List<Integer>> rooms, int n, int curr, boolean[] visited){
        
        visited[curr] = true;
        
        List<Integer> keys = rooms.get(curr);
        
        for(int i = 0; i < keys.size(); i++){
            int other_room = keys.get(i);
            if(!visited[other_room]){
                dfs(rooms, n, other_room, visited);
            }
        }
        
        return ;
        
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        
        boolean[] visited = new boolean[n];
        
        dfs(rooms, n, 0, visited);
        
        for(int i = 1; i < n; i++){
            if(!visited[i]) return false;
        }
        
        return true;
        
    }
}
