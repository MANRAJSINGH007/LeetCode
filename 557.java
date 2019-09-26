class Solution {
    public String reverseWords(String s) {
        
        int n = s.length();
        if(n == 0) return s;
        
        char[] ch = s.toCharArray();
        
        int prev = 0;
        
        for(int i = 1; i < n; i++){
            char curr = ch[i];
            if(ch[i] == ' '){
                
                for(int j = prev; j < (prev + i)/2; j++){
                    char t = ch[j];
                    ch[j] = ch[i - 1 - j + prev];
                    ch[i - 1 - j + prev] = t;
                }
                
                prev = i + 1;
            }
        }
    
        for(int j = prev; j < (prev + n)/2; j++){
            char t = ch[j];
            ch[j] = ch[n - 1 - j + prev];
            ch[n - 1 - j + prev] = t;
        }
        
        return new String(ch);
    }
}
