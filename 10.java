class Solution {
    
    public static int func(String s, String p, int n, int m, int i, int j, int[][] dp){
        
        if(i == n){
            if(j == m) return 1;
            
            if(p.charAt(m - 1) != '*') return 0;
            
            for(int k = j; k < m - 1; k++){
                if(p.charAt(k) != '*' && p.charAt(k + 1) != '*') return 0;
            }
            
            return 1;
        }
        
        if(j == m) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(p.charAt(j) != '.' && p.charAt(j) != '*' && p.charAt(j) != s.charAt(i) && (j == m - 1 || p.charAt(j + 1) != '*')) return 0;
        
        else if(p.charAt(j) != '.' && p.charAt(j) != '*'){
            
            if(s.charAt(i) != p.charAt(j) && j < m - 1 && p.charAt(j + 1) == '*'){
                return dp[i][j] = func(s, p, n, m, i, j + 2, dp);
            }

            int index = i;
            char curr = s.charAt(index);

            while(index < n && s.charAt(index) == curr && j < m - 1 && p.charAt(j + 1) == '*'){
                if(func(s, p, n, m, index + 1, j + 2, dp) == 1) return dp[i][j] = 1;
                index++;
            }
            
            if(j == m - 1){
                if(i == n - 1) return dp[i][j] = 1;
                return dp[i][j] = 0;
            }

            if(j < m - 1 && p.charAt(j + 1) == '*'){
                if(func(s, p, n, m, i, j + 2, dp) == 1) return dp[i][j] = 1;
            }

            return dp[i][j] = func(s, p, n, m, i + 1, j + 1, dp);
            
        }
        
        else if(p.charAt(j) == '.'){
            
            if(j == m - 1 || p.charAt(j + 1) != '*') return dp[i][j] = func(s, p, n, m, i + 1, j + 1, dp);
            
            if(func(s, p, n, m, i, j + 2, dp) == 1) return dp[i][j] = 1;
            
            int index = i;

            while(index < n){
                if(func(s, p, n, m, index + 1, j + 2, dp) == 1) return dp[i][j] = 1;
                index++;
            }

            return dp[i][j] = 0;
        }
        
        
        return dp[i][j] = func(s, p, n, m, i, j + 1, dp);
        
        
    }
    
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        
        if(func(s, p, n, m, 0, 0, dp) == 1) return true;
        
        return false;
       
    }
}
