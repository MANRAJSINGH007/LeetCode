class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        if(m == 0){
            return new int[n][0];
        }
        
        int[][] ans = new int[n][m];   
        Queue<Pair> q = new LinkedList<>();
     
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                 ans[i][j] = -1;
                if(matrix[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }
        
        while(q.size() > 0){
            
            Pair p = q.remove();
            
            if(p.i + 1 < n && ans[p.i + 1][p.j] == -1){
                q.add(new Pair(p.i + 1, p.j));
                ans[p.i + 1][p.j] = 1 + ans[p.i][p.j];
            }
            
            if(p.i - 1 > -1 && ans[p.i - 1][p.j] == -1){
                q.add(new Pair(p.i - 1, p.j));
                ans[p.i - 1][p.j] = 1 + ans[p.i][p.j];
            }
            
            if(p.j + 1 < m && ans[p.i][p.j + 1] == -1){
                q.add(new Pair(p.i, p.j + 1));
                ans[p.i][p.j + 1] = 1 + ans[p.i][p.j];
            }
            
            if(p.j - 1 > -1 && ans[p.i][p.j - 1] == -1){
                q.add(new Pair(p.i, p.j - 1));
                ans[p.i][p.j - 1] = 1 + ans[p.i][p.j];
            }
        }
        
        return ans;
    }
}
