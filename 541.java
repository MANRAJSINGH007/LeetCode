class Solution {
    public String reverseStr(String s, int k) {
        
        int n = s.length();
        if(n == 0) return s;
        char[] ch = s.toCharArray();
        
        if(n <= k){
            for(int i = 0; i < n/2; i++){
                char curr = ch[i];
                ch[i] = ch[n - 1 - i];
                ch[n - 1 - i] = curr;
            }
            
            return new String(ch);
        }
        
        int start = 0;
        int end = k;
        while(end < n){
            for(int j = start; j < (start + end)/2; j++){
                char curr = ch[j];
                ch[j] = ch[end - 1 - j + start];
                ch[end - 1 - j + start] = curr;
            }
            start = end;
            start += k;
            end = start + k;
        }
        
        if(start < n){
            for(int j = start; j < (start + n)/2; j++){
                char curr = ch[j];
                ch[j] = ch[n - 1 - j + start];
                ch[n - 1 - j + start] = curr;
            }
        }
        
        return new String(ch);
        
    }
}
