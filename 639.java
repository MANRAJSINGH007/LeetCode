class Solution {
    
    static int mod = (int)Math.pow(10, 9) + 7;
    
    public static int func(String s, int i, int n, int[] dp){
        
        if(i == n) return 1;
        
        if(i == n - 1){
            if(s.charAt(i) == '*') return 9;
            if(s.charAt(i) == '0') return 0;
            return 1;
        }
        
        if(s.charAt(i) == '0') return 0;
        
        if(dp[i] != -1) return dp[i];
        
        if(s.charAt(i) == '*' && s.charAt(i + 1) == '*'){
            long t1 = (9 * (long)func(s, i + 1, n, dp)) % mod;
            long t2 = (15 * (long)func(s, i + 2, n, dp)) % mod;
            long curr = (t1 + t2) % mod;
            return dp[i] = (int)curr;
        }
        
        else if(s.charAt(i) == '*'){
            long t1 = (9 * (long)func(s, i + 1, n, dp)) % mod;
            long t2 = func(s, i + 2, n, dp);
            long t3 = 0;
            if(Integer.parseInt("" + s.charAt(i + 1)) <= 6){
                t3 = t2;
            }
            
            long curr = ((t1 % mod + t2 % mod) % mod + t3 % mod) % mod;
            return dp[i] = (int)curr;
        }
        
        else if(s.charAt(i + 1) == '*'){
            if(Integer.parseInt("" + s.charAt(i)) >=3){
                long curr = func(s, i + 1, n, dp);
                return dp[i] = (int)curr;
            }
            else if(s.charAt(i) == '1'){
                long t1 = func(s, i + 1, n, dp);
                long t2 = (9 * (long)func(s, i + 2, n, dp)) % mod;
                long curr = (t1 + t2) % mod;
                return dp[i] = (int)curr;
            }
            else{
                long t1 = func(s, i + 1, n, dp);
                long t2 = (6 * (long)func(s, i + 2, n, dp)) % mod;
                long curr = (t1 + t2) % mod;
                return dp[i] = (int)curr;
            }
        }
        
        long t1 = func(s, i + 1, n, dp);
        int num = Integer.parseInt("" + s.charAt(i) + s.charAt(i + 1));
        if(num >= 10 && num <= 26){
            t1 = (t1 + func(s, i + 2, n, dp)) % mod;
        }
        
        return dp[i] = (int)t1;
        
        
    }
    
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }
        
        return func(s, 0, n, dp);
    }
}
