class Pair{
    int x;
    int y;
    int ans;
    
    Pair(int x, int y, int ans){
        this.x=x;
        this.y=y;
        this.ans=ans;
    }
}

class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n=grid.length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,0));
        boolean visited[][]=new boolean[n][n];
        visited[0][0]=true;
        if(grid[0][0]==1){
            return -1;
        }
        
        while(!q.isEmpty()){
            Pair obj=q.remove();
            int i=obj.x;
            int j=obj.y;
            int curr_ans=obj.ans;
            if(i==n-1 && j==n-1){
                return curr_ans+1;
            }
            
            if(i<n && j<n-1 && !visited[i][j+1] && grid[i][j+1]!=1){
                
                visited[i][j+1]=true;
                q.add(new Pair(i,j+1,curr_ans+1));
                
            }
            if(i<n && j>0 && !visited[i][j-1] && grid[i][j-1]!=1){
                visited[i][j-1]=true;
                q.add(new Pair(i,j-1,curr_ans+1));
            }
            if(i>0 && j>0 && !visited[i-1][j-1] && grid[i-1][j-1]!=1){
                visited[i-1][j-1]=true;
                q.add(new Pair(i-1,j-1,curr_ans+1));
            }
            if(i>0 && !visited[i-1][j] && grid[i-1][j]!=1){
                visited[i-1][j]=true;
                q.add(new Pair(i-1,j,curr_ans+1));
            }
            if(i>0 && j<n-1 && !visited[i-1][j+1] && grid[i-1][j+1]!=1){
                visited[i-1][j+1]=true;
                q.add(new Pair(i-1,j+1,curr_ans+1));
            }
            if(i<n-1 && j>0 && !visited[i+1][j-1] && grid[i+1][j-1]!=1){
                visited[i+1][j-1]=true;
                q.add(new Pair(i+1,j-1,curr_ans+1));
            }
            if(i<n-1 && !visited[i+1][j] && grid[i+1][j]!=1){
                visited[i+1][j]=true;
                q.add(new Pair(i+1,j,curr_ans+1));
            }
            if(i<n-1 && j<n-1 && !visited[i+1][j+1] && grid[i+1][j+1]!=1){
                visited[i+1][j+1]=true;
                q.add(new Pair(i+1,j+1,curr_ans+1));
            }
            
        }
        
        return -1;
        
    }
}
