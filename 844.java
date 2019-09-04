class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        int n = S.length();
        int m = T.length();
        
        int i = n - 1;
        int j = m - 1;
        
        int count1 = 0;
        int count2 = 0;
        
        while(true){
            
            char c1 = '.';
            char c2 = '.';
            
            while(i >= 0){
                
                while(i >= 0 && S.charAt(i) == '#'){
                    count1++;
                    i--;
                }
                
                while(i >= 0 && count1 > 0 && S.charAt(i) != '#'){
                    count1--;
                    i--;
                }
                
                if(count1 == 0){
                    break;
                }
                
            }
            
            while(j >= 0){
                
                while(j >= 0 && T.charAt(j) == '#'){
                    count2++;
                    j--;
                }
                
                while(j >= 0 && count2 > 0 && T.charAt(j) != '#'){
                    count2--;
                    j--;
                }
                
                if(count2 == 0){
                    break;
                }
                
            }
            
            if(i < 0 && j < 0){
                return true;
            }
            
            if(i < 0){
                c2 = T.charAt(j);
                if(c2 != '#'){
                    return false;
                }
            }
            
            if(j < 0){
                c1 = S.charAt(i);
                if(c1 != '#'){
                    return false;
                }
            }
            
            if(i >= 0 && j>= 0){
                c1 = S.charAt(i);
                c2 = T.charAt(j);
                if(c1 != '#' && c2 != '#' && c1 != c2){
                    return false;
                }
                
                if(c1 != '#' && c2 != '#'){
                    i--;
                    j--;
                }
            }
            
        }
        
        
    }
}
