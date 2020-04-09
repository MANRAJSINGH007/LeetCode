class Pair{
    int x;
    int y;
    int time;
    Pair(int x, int y, int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
    
}


class Solution {
    public int orangesRotting(int[][] arr) {
        
        int n=arr.length;
        int m=arr[0].length;
        
        boolean visited[][]=new boolean[n][m];
        
        int max=0;
        
        Queue<Pair> q=new LinkedList<Pair>();
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(arr[i][j]==2){
                    
                    visited[i][j]=true;
                    q.add(new Pair(i,j,0));
                    
                }
                
            }
            
        }
        
        while(!q.isEmpty()){
            
            Pair obj=q.remove();
            
            int currTime=obj.time;
            
            if(currTime>max){
                
                max=currTime;
            }
            
            if(obj.x>0){
                
                if(arr[obj.x-1][obj.y]==1 && !visited[obj.x-1][obj.y]){
                    
                    visited[obj.x-1][obj.y]=true;
                    q.add(new Pair(obj.x-1,obj.y,currTime+1));
                    
                }
                
                
            } 
            if(obj.x<n-1){
                
                if(arr[obj.x+1][obj.y]==1 && !visited[obj.x+1][obj.y]){
                    
                    visited[obj.x+1][obj.y]=true;
                    q.add(new Pair(obj.x+1,obj.y,currTime+1));
                    
                }
                
                
            } 
            if(obj.y>0){
                
                if(arr[obj.x][obj.y-1]==1 && !visited[obj.x][obj.y-1]){
                    
                    visited[obj.x][obj.y-1]=true;
                    q.add(new Pair(obj.x,obj.y-1,currTime+1));
                    
                }
                
                
            } 
            if(obj.y<m-1){
                
                if(arr[obj.x][obj.y+1]==1 && !visited[obj.x][obj.y+1]){
                    
                    visited[obj.x][obj.y+1]=true;
                    q.add(new Pair(obj.x,obj.y+1,currTime+1));
                    
                }
                
                
            }
            
            
        }
        
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(arr[i][j]==1 && !visited[i][j]){
                    
                    return -1;          
                }
                
            }
            
        }
        
        return max;
        
        
    }
}
