class Solution {
    public int countLetters(String s) {
        
        if(s == null){
            return 0;
        }
        
        int n = s.length();
        if(n == 1){
            return n;
        }
        
        int start = 0;
        int end = 0;
        int count = 0;
        char c = s.charAt(0);
        
        while(end < n){
            
            while(end < n && s.charAt(end) == c){
                count += (end - start + 1);
                end++;
            }
            
            if(end == n){
                return count;
            }
            
            start = end;
            c = s.charAt(end);
        }
        
        return count;
        
    }
}
