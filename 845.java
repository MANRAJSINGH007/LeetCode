class Solution {
    public int longestMountain(int[] A) {
               
        int n = A.length;
        
        if(n <= 2) return 0;
        
        int maxInc = 0;
        int maxDec = 0;
        
        int maxWidth = 0;
        
        int begin = 0;
        int end = 0;
        
        boolean inc = false;
        boolean dec = false;
        
        while(end < n){
            
            if(end == begin){
                inc = false;
                dec = false;
                maxInc = 1;
                maxDec = 0;
                end++;
            }
            
            else if(!inc && !dec || inc){
                if(A[end] > A[end - 1]){
                    inc = true;
                    maxInc += 1;
                    maxDec = 0;
                    end++;
                }
                
                else if(A[end] == A[end - 1]){
                    // end++;
                    inc = false;
                    dec = false;
                    maxInc = 0;
                    maxDec = 0;
                    begin = end;
                }
                
                else{
                    if(maxInc == 1){
                       begin = end;
                    }
                    else{
                        inc = false;
                        dec = true;
                        maxDec = 1;
                        if(maxInc != 0 && maxDec != 0){
                            maxWidth = Math.max(maxWidth, maxInc + maxDec);
                        }
                        
                        end++;
                    }
                    
                }
            }
            
            else if(dec){
                
                if(A[end] < A[end - 1]){
                    maxDec += 1;
                    if(maxInc != 0 && maxDec != 0){
                        maxWidth = Math.max(maxWidth, maxInc + maxDec);
                    }
                    end++;
                }
                
                else if(A[end] == A[end - 1]){
                    inc = false;
                    dec = false;
                    maxInc = 0;
                    maxDec = 0;
                    end++;
                    begin = end;
                }
                
                else{
                    inc = true;
                    dec = false;
                    maxInc = 2;
                    maxDec = 0;
                    begin = end;
                    end++;
                }
            }
            
        }
        
        // System.out.println(maxDec+" "+maxInc);
        
        return maxWidth;
        
    }
}
