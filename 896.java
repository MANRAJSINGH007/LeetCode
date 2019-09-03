class Solution {
    public boolean isMonotonic(int[] A) {
        
        int n = A.length;
        
        if(n <= 1){
            return true;
        }
        
        int flag = 0;
        
        for(int i = 1; i < n; i++){
            
            if(A[i] == A[i - 1]){
                
            }
            
            else if(A[i] < A[i - 1]){
                if(flag == 0){
                    flag = 1;
                }
                else if(flag == 1){
                    
                }
                else{
                    return false;
                }
            }
            
            else{
                if(flag == 0){
                    flag = 2;
                }
                else if(flag == 1){
                    return false;
                }
                else{
                    
                }
            }
            
        }
        
        return true;
        
    }
}
