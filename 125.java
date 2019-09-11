class Solution {
    public boolean isPalindrome(String s) {
        
        int n = s.length();
        
        int start = 0;
        int end = n - 1;
        
        while(start < end){
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            
            int i1 = (int)c1;
            int i2 = (int)c2;
            
            int flag = 0;
            if(i1 >= 65 && i1 <= 90){
                i1 += 32;
            }
            if(i2 >= 65 && i2 <= 90){
                i2 += 32;
            }
            
            if(i1 >= 48 && i1 <=57 || i1 >= 97 && i1 <= 122){
                
            } else {
                flag = 1;
                start++;
            } 
            
            if(i2 >= 48 && i2 <=57 || i2 >= 97 && i2 <= 122){
                
            } else {
                flag = 1;
                end--;
            }
            
            if(flag == 0){
                if(i1 != i2){
                    return false;
                }
                
                start++;
                end--;
            }
        }
        
        return true;
        
    }
}
