class Solution {
    
    public static int func(int[] nums, int left, int right, int[][] dp){
        
        if(right == left + 1) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        
        int ans = 0;
        
        for(int i = left + 1; i < right; i++){
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] + func(nums, left, i, dp) + func(nums, i, right, dp));
        }
        
        return dp[left][right] = ans;
        
    }
    
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        if(n == 0) return 0;
        int[] aux = new int[n + 2];
        for(int i = 0; i < n; i++) aux[i + 1] = nums[i];
        aux[0] = aux[n + 1] = 1;
        
        int[][] dp = new int[n + 2][n + 2];
        for(int i = 0; i <= n + 1; i++){
            for(int j = 0; j <= n + 1; j++){
                dp[i][j] = -1;
            }
        }
        
        return func(aux, 0, n + 1, dp);
    }
}
