class Solution {   
    
    public static void func(char[][] grid, int n, int m, int i, int j){
        
        if(i<0 || j<0 || i==n || j==m || grid[i][j]=='0'){
            return;
        }
        
        grid[i][j]='0';
        func(grid,n,m,i+1,j);
        func(grid,n,m,i-1,j);
        func(grid,n,m,i,j+1);
        func(grid,n,m,i,j-1);
        
        return ;
    }
    
    
    public int numIslands(char[][] grid) {
        
       if(grid==null){
           return 0;
       }
        int count=0;
        int n=grid.length;
        if(n==0){
            return 0;
        }
        int m=grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    func(grid,n,m,i,j);   
                }
            }
        }
        
        return count;
        
    }
}
