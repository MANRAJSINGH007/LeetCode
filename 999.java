class Solution {
    public int numRookCaptures(char[][] arr) {
        
        int x=-1;
        int y=-1;
        
        l:for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(arr[i][j]=='R'){
                    x=i;
                    y=j;
                    break l;
                }
            }
        }
        if(x==-1){
            return 0;
        }
        int k=x-1;
        int count=0;
        
        while(k>0 && arr[k][y]=='.'){
            k--;
        }
        
        if(k>=0){
            if(arr[k][y]=='p'){
                count++;
            }
        }
        
        k=x+1;
        
        while(k<8 && arr[k][y]=='.'){
            k++;
        }
        
        if(k<8){
            if(arr[k][y]=='p'){
                count++;
            }
        }
        
        k=y-1;
        
        while(k>0 && arr[x][k]=='.'){
            k--;
        }
        
        if(k>=0){
            if(arr[x][k]=='p'){
                count++;
            }
        }
        
        k=y+1;
        
        while(k<8 && arr[x][k]=='.'){
            k++;
        }
        
        if(k<8){
            if(arr[x][k]=='p'){
                count++;
            }
        }
        
        return count;
        
    }
}
