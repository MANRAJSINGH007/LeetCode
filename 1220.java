class Solution {
    
    static int mod = (int)Math.pow(10, 9) + 7;
    
    public static int countPermutations(int n, int i, int state, int[][] dp){
        
        if(i == n) return 1;
        
        long count = 0;
        
        if(state == -1){
            count = (count + countPermutations(n, i + 1, 0, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 1, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 2, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 3, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 4, dp)) % mod;
            
            return (int)(count % mod);
        }
        
        if(dp[i][state] != -1) return dp[i][state];
        
        else if(state == 0){
            return dp[i][state] = countPermutations(n, i + 1, 1, dp);
        }
        
        else if(state == 1){
            count = (count + countPermutations(n, i + 1, 0, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 2, dp)) % mod;
            
            return dp[i][state] = (int)(count % mod);
        }
        
        else if(state == 2){
            count = (count + countPermutations(n, i + 1, 0, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 1, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 3, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 4, dp)) % mod;
            return dp[i][state] = (int)(count % mod);
        }
        
        else if(state == 3){
            count = (count + countPermutations(n, i + 1, 2, dp)) % mod;
            count = (count + countPermutations(n, i + 1, 4, dp)) % mod;
            return dp[i][state] = (int)(count % mod);
        }
        
        return dp[i][state] = countPermutations(n, i + 1, 0, dp);
        
    }
    
    public int countVowelPermutation(int n) {
        
        int[][] dp = new int[n][5];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 5; j++){
                dp[i][j] = -1;
            }
        }
        
        return countPermutations(n, 0, -1, dp);
        
    }
}
