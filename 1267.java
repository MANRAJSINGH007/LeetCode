class Solution {
    
    public int countServers(int[][] grid) {
        
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        
        int count = 0;
        HashMap<Integer, Integer> rowCount = new HashMap<>();
        HashMap<Integer, Integer> columnCount = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count++;
                    if(!rowCount.containsKey(i)) rowCount.put(i, 1);
                    else rowCount.put(i, rowCount.get(i) + 1);
                    if(!columnCount.containsKey(j)) columnCount.put(j, 1);
                    else columnCount.put(j, columnCount.get(j) + 1);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    if(rowCount.get(i) == 1 && columnCount.get(j) == 1) count--;
                }
            }
        }
        
        return count;
        
    }
}
