class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        k = k % (n * m);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) ans.add(new ArrayList<>());
        
        int i1 = 0;
        
        if(k == 0){
            for(int a = 0; a < n; a++){
                for(int b = 0; b < m; b++){
                    if(ans.get(i1).size() == m) i1++;
                    ans.get(i1).add(grid[a][b]);
                }
            }
            
            return ans;
        }
        
        int i = n - 1;
        int j = m - 1;
        int count = 1;
        while(count < k){
            count++;
            j--;
            if(j == -1){
                j = m - 1;
                i--;
            }
        }
        
        
        for(int a = i; a < n; a++){
            int st = 0;
            if(a == i) st = j;
            for(int b = st; b < m; b++){
                if(ans.get(i1).size() == m) i1++;
                ans.get(i1).add(grid[a][b]);
            }
        }
        
        for(int a = 0; a < n; a++){
            for(int b = 0; b < m; b++){
                if(a == i && b == j) return ans;
                if(ans.get(i1).size() == m) i1++;
                ans.get(i1).add(grid[a][b]);
            }
        }
        
        return ans;
        
    }
}
