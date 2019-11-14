class Solution {
    public int minAddToMakeValid(String S) {
        
        int n = S.length();
        int open = 0;
        int close = 0;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            
            if(S.charAt(i) == '('){
                open ++;
            }
            
            else{
                close ++;
                if(open < close){
                    ans += close - open;
                    close = 0;
                    open = 0;
                }
            }
            
            if(open == close){
                open = 0;
                close = 0;
            }
        }
        
        return ans += open - close;
    }
}
