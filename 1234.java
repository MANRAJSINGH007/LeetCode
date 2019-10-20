class Solution {
    
    public static boolean check(int n, int[] cnt) {
        
        for(int i = 0; i < 4; i++)
            if(cnt[i] > n / 4)
                return false;
        return true;
    }
    
    public int balancedString(String s) {
        
        int n = s.length();
        if(n == 0) return 0;
        
        int[] cnt = new int[4];
        
        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(curr == 'Q') cnt[0]++;
            else if(curr == 'W') cnt[1]++;
            else if(curr == 'E') cnt[2]++;
            else if(curr == 'R') cnt[3]++;
        }
        
        if(cnt[0] == n/4 && cnt[1] == n/4 && cnt[2] == n/4 && cnt[3] == n/4) return 0;
        
        int min = n;
        int j = 0;
        
        for(int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            while(j < n && !check(n, cnt)){
                char c = s.charAt(j);
                if(c == 'Q') cnt[0]--;
                else if(c == 'W') cnt[1]--;
                else if(c == 'E') cnt[2]--;
                else if(c == 'R') cnt[3]--;
                j++;
            }
            
            if(check(n, cnt)) min = Math.min(min, j - i);
            if(curr == 'Q') cnt[0]++;
            else if(curr == 'W') cnt[1]++;
            else if(curr == 'E') cnt[2]++;
            else if(curr == 'R') cnt[3]++;
        }
        
        return min;
        
    }
}
