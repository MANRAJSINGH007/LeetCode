class Solution {
    
    static int mod = (int)Math.pow(10, 9) + 7;
    
    public static int func(int n, int i, int[] roll, int[][][] dp, int curr, int curr_count){
        
        if(i == n) return 1;
        
        long currAns = 0;
        
        if(curr != - 1 && dp[i][curr][curr_count] != -1) return dp[i][curr][curr_count];
        
        for(int k = 0; k < 6; k++){
            if(curr == -1 || k != curr || curr_count < roll[k]){
                
                int temp_curr = k;
                int temp_count = 0;
                if(curr == - 1 || k != curr){
                    temp_count = 1;
                }
                else{
                    temp_count = curr_count + 1;
                }
                
                currAns = (currAns + func(n, i + 1, roll, dp, temp_curr, temp_count)) % mod;
            }
        }
        
        if(curr != -1)
            return dp[i][curr][curr_count] = (int)(currAns % mod);
        
        return (int)(currAns % mod);
        
    }
    
    public int dieSimulator(int n, int[] rollMax) {
        
        int[][][] dp = new int[n][6][16];
        for(int i = 0; i <n; i++){
            for(int j = 0; j < 6; j++){
                for(int k = 0; k < 16; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return func(n, 0, rollMax, dp, -1, 0);
        
    }
}
