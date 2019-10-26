class Solution {
    
    public static void func(int[][] A, int n, int m, int i, int j){
        
        if(i < 0 || j < 0 || i == n || j == m || A[i][j] != 1) return;
        
        A[i][j] = -1;
        func(A, n, m, i + 1, j);
        func(A, n, m, i - 1, j);
        func(A, n, m, i, j + 1);
        func(A, n, m, i, j - 1);
        
        return ;
        
    }
    
    public int numEnclaves(int[][] A) {
        
        int n = A.length;
        if(n == 0) return n;
        int m = A[0].length;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            func(A, n, m, i, 0);
            func(A, n, m, i, m - 1);
        }
        
        for(int i = 0; i < m; i++){
            func(A, n, m, 0, i);
            func(A, n, m, n - 1, i);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(A[i][j] == 1) count++;
            }
        }
        
        return count;
    }
}
