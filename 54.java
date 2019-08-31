class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n=matrix.length;
        if(n==0){
            return new ArrayList<>();
        }
        int m=matrix[0].length;
        
        ArrayList<Integer> list=new ArrayList<>();
        
        int r1=0;
        int c1=0;
        int r2=n-1;
        int c2=m-1;
        
        int i=c1;
        
        while(r1<=r2 && c1<=c2){
            
            i=c1;
            while(r1<=r2 && c1<=c2 && i<=c2){
                list.add(matrix[r1][i]);
                i++;
            }
            
            r1++;
            i=r1;
            
            while(r1<=r2 && c1<=c2 && i<=r2){
                list.add(matrix[i][c2]);
                i++;
            }
            
            c2--;
            i=c2;
            while(r1<=r2 && c1<=c2 && i>=c1){
                list.add(matrix[r2][i]);
                i--;
            }
            
            r2--;
            i=r2;
            while(r1<=r2 && c1<=c2 && i>=r1){
                list.add(matrix[i][c1]);
                i--;
            }
            c1++;
            
        }
        
        return list;
        
    }
}
