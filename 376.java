class Solution {
    
    public static int func(int[] nums, int n, int i, int state, int prev, int[][][] dp){
        
        if(i == n){
            return 0;
        }
        
        if(state == -1){
            int x1 = func(nums, n, i + 1, state, prev, dp);
            int x2 = 1 + func(nums, n, i + 1, 0, i, dp);
            
            return Math.max(x1, x2);
        }
        
        if(dp[i][prev][state] != -1){
            return dp[i][prev][state];
        }
        
        if(state == 0){
            
            int x1 = func(nums, n, i + 1, state, prev, dp);
            
            if(nums[i] > nums[prev]){
                state = 2;
            }
            
            else if(nums[i] < nums[prev]){
                state = 1;
            }
            
            int x2 = 0;
            
            if(state != 0){
                x2 = 1 + func(nums, n, i + 1, state, i, dp);
            }
            
            return dp[i][prev][0] = Math.max(x1, x2);
            
        }
        
        if(state == 1){
            int x1 = func(nums, n, i + 1, state, prev, dp);
            int x2 = 0;
            if(nums[i] > nums[prev]){
                state = 2;
                x2 = 1 + func(nums, n, i + 1, state, i, dp);
            }
            
            return dp[i][prev][1] = Math.max(x1, x2);
        }
        
        if(state == 2){
            int x1 = func(nums, n, i + 1, state, prev, dp);
            int x2 = 0;
            if(nums[i] < nums[prev]){
                state = 1;
                x2 = 1 + func(nums, n, i + 1, state, i, dp);
            }
            
            return dp[i][prev][2] = Math.max(x1, x2);
        }
        
        return 0;
        
    }
    
    
    public int wiggleMaxLength(int[] nums) {
        
        int n = nums.length;
        
        int[][][] dp = new int[n][n][3];
        
        for(int  i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
                dp[i][j][2] = -1;
            }
        }
        
        return func(nums, n, 0, -1, -1, dp);
        
    }
}
