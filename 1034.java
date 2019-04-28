class Solution {
    
    static int color=-1;
    
    public static void func(int[][] grid, int[][] arr, int n, int m, int i, int j, boolean[][] visited, int cd){
        
        if(i<0 || j<0 || i==n || j==m || visited[i][j] || grid[i][j]!=cd){
            return ;
        }
        
        visited[i][j]=true;
        
        if(i>0){
            if(grid[i-1][j]!=grid[i][j]){
                arr[i][j]=color;
            }
        }
        
        if(j>0){
            if(grid[i][j-1]!=grid[i][j]){
                arr[i][j]=color;
            }
        }
        
        if(i<n-1){
            if(grid[i+1][j]!=grid[i][j]){
                arr[i][j]=color;
            }
        }
        
        if(j<m-1){
            if(grid[i][j+1]!=grid[i][j]){
                arr[i][j]=color;
            }
        }
        
        if(i==0 || i==n-1){
            arr[i][j]=color;
        }
        
        if(j==0 || j==m-1){
            arr[i][j]=color;
        }
        
        func(grid,arr,n,m,i+1,j,visited,cd);
        func(grid,arr,n,m,i-1,j,visited,cd);
        func(grid,arr,n,m,i,j+1,visited,cd);
        func(grid,arr,n,m,i,j-1,visited,cd);
        
        visited[i][j]=false;
        
    }
    
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int c) {
        
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        color=c;
        
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=grid[i][j];
            }
        }
        
        func(grid,arr,n,m,r0,c0,visited,grid[r0][c0]);
        return arr;
    }
}
