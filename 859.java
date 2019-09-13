class Solution {
    public boolean buddyStrings(String A, String B) {
        
        int n = A.length();
        int m = B.length();
        
        if(n != m){
            return false;
        }
        
        int swaps = 0;
        char c1 = '.';
        char c2 = '/';
        
        int[] aux = new int[26];
        
        for(int i = 0; i < n; i++){
            
            if(A.charAt(i) != B.charAt(i)){
                
                if(swaps == 2) return false;
                
                if(swaps == 1){
                    if(A.charAt(i) != c2 || B.charAt(i) != c1){
                        return false;
                    }
                    
                    swaps = 2;
                }
                
                else{
                    
                    swaps = 1;
                    c1 = A.charAt(i);
                    c2 = B.charAt(i);
                }
            }
            
            else{
                aux[(int)A.charAt(i) - 97]++;
            }
            
        }
        
        if(swaps == 2) return true;
        
        for(int i = 0; i < 26; i++){
            if(aux[i] > 1){
                return true;
            }
        }
        
        return false;
    }
}
