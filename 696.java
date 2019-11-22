class Solution {
    public int countBinarySubstrings(String s) {
        
        int n = s.length();
        if(n <= 1) return 0;
        int ans = 0;
        char curr = '0';
        int first = 0, second = 0;
        second ++;
        if(s.charAt(0) == '1') curr = '1';
        
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == curr) second ++;
            else{
                curr = s.charAt(i);
                ans += Math.min(first, second);
                first = second;
                second = 1;
            }
        }
        
        ans += Math.min(first, second);
        return ans;
        
    }
}
