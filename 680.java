class Solution {
    
    public static boolean check(String s, int start, int end){
        
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
        
    }
    
    public boolean validPalindrome(String s) {
        
        int n = s.length();
        
        if (n == 0){
            return true;
        }
        
        int start = 0;
        int end = n - 1;
        
        int flag = 0;
        
        while (start < end){
            
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            
            if (c1 == c2){
                start++;
                end--;
                
            } else {
                
                if(flag == 0){
                    flag++;
                    if(start == end - 1){
                        return true;
                    }
                    else if(s.charAt(start) == s.charAt(end - 1) && s.charAt(start + 1) != s.charAt(end)){
                        end--;
                    }
                    else if(s.charAt(start) != s.charAt(end - 1) && s.charAt(start + 1) == s.charAt(end)){
                        start++;
                    }
                    else{
                        return check(s, start, end - 1) || check(s, start + 1, end);
                    }
                } else {
                    return false;
                }
            }
            
        }
        
        return true;
        
    }
}
