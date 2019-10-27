class Solution {
    
    public static void dfs(char[][] board, int n, int m, int i, int j){
        
        if(i < 0 || j < 0 || i == n || j == m || board[i][j] == 'X' || board[i][j] == '.') return;
        
        board[i][j] = '.';
        dfs(board, n, m, i + 1, j);
        dfs(board, n, m, i - 1, j);
        dfs(board, n, m, i, j + 1);
        dfs(board, n, m, i, j - 1);
        
        return ;
        
    }
    
    public void solve(char[][] board) {
        
        if(board == null) return;
        
        int n = board.length;
        if(n == 0) return;
        
        int m = board[0].length;
        if(m == 0) return;
        
        for(int i = 0; i <n ; i++){
            dfs(board, n, m, i, 0);
            dfs(board, n, m, i, m - 1);
        }
        
        for(int i = 0; i <m ; i++){
            dfs(board, n, m, 0, i);
            dfs(board, n, m, n - 1, i);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '.') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        
        return ;
        
    }
}
