class Solution {
    
    public static boolean func(char[][] arr, int r, int c, int row, int col, String word, int i, int n){
        
        if(i==n){
            return true;
        }
        
        if(row<0 || row==r || col<0 || col==c || arr[row][col]=='.'){
            return false;
        }
        
        if(arr[row][col]==word.charAt(i)){
            
            arr[row][col]='.';
            boolean b1=func(arr,r,c,row+1,col,word,i+1,n);
            if(b1){
                return true;
            }
            boolean b2=func(arr,r,c,row,col+1,word,i+1,n);
            if(b2){
                return true;
            }
            boolean b3=func(arr,r,c,row,col-1,word,i+1,n);
            if(b3){
                return true;
            }
            boolean b4=func(arr,r,c,row-1,col,word,i+1,n);
            if(b4){
                return true;
            }
            
            arr[row][col]=word.charAt(i);
        }
        
        return false;
        
    }
    
    
    public boolean exist(char[][] arr, String word) {
        
        int n=word.length();
        if(n==0){
            return true;
        }
        
        int r=arr.length;
        int c=arr[0].length;
        
        char ch=word.charAt(0);
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(arr[i][j]==ch)
                {
                    boolean b=func(arr,r,c,i,j,word,0,n);
                    if(b){
                        return b;
                    }
                }
            }
        }
        
        return false;
    }
}
