class Solution {
    public boolean rotateString(String A, String B) {
        
        int n = A.length();
        if(B.length() != n) return false;
        if(n == 0) return true;
        
        for(int i = 0; i < n; i++){
            
            int index = i;
            int j = 0;
            while(index < n && j < n && A.charAt(index) == B.charAt(j)){
                index ++;
                j ++;
            }
            
            if(index == n){
                index = 0;
                while(index < i && j < n && A.charAt(index) == B.charAt(j)){
                    index ++;
                    j ++;
                }
                
                if(index == i) return true;
            }
        }
        
        return false;
        
    }
}
