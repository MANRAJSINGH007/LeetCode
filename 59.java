class Solution {
    public int[][] generateMatrix(int n) {
        
        int matrix[][]=new int[n][n];
        
        int r1=0;
        int c1=0;
        int r2=n-1;
        int c2=n-1;
        int curr=1;
        
        int i=c1;
        
        while(r1<=r2 && c1<=c2){
            
            i=c1;
            while(r1<=r2 && c1<=c2 && i<=c2){
                matrix[r1][i]=curr;
                curr++;
                i++;
            }
            
            r1++;
            i=r1;
            
            while(r1<=r2 && c1<=c2 && i<=r2){
                matrix[i][c2]=curr;
                curr++;
                i++;
            }
            
            c2--;
            i=c2;
            while(r1<=r2 && c1<=c2 && i>=c1){
                matrix[r2][i]=curr;
                curr++;
                i--;
            }
            
            r2--;
            i=r2;
            while(r1<=r2 && c1<=c2 && i>=r1){
                matrix[i][c1]=curr;
                curr++;
                i--;
            }
            c1++;
            
        }
        
        return matrix;
        
    }
}
