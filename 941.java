class Solution {
    public boolean validMountainArray(int[] A) {
        
        int n = A.length;
        if(n <= 1){
            return false;
        }
        
        boolean inc = false;
        boolean dec = false;
        
        for(int i = 1; i < n; i++){
            if(!inc && !dec){
                if(A[i] <= A[i - 1]){
                    return false;
                }
                inc = true;
            }
            
            else if(inc && !dec){
                if(A[i] > A[i - 1]){
                    
                }
                else if(A[i] == A[i - 1]){
                    return false;
                }
                else{
                    dec = true;
                }
            }
            
            else{
                if(A[i] >= A[i - 1]){
                    return false;
                }
            }
            
        }
        
        return (inc && dec);
        
    }
}
