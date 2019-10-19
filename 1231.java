class Solution {
    
    public static int func(int[] arr, int n, int i, int[] sum, int k, int[][] dp){
        
        if(k == 1){
            if(i == 0) return sum[n - 1];
            return sum[n - 1] - sum[i - 1];
        }
        
        if(i == n) return Integer.MAX_VALUE;
        
        if(dp[i][k] != -1) return dp[i][k];
        
        int s = 0;
        int min = Integer.MIN_VALUE;
        
        for(int j = i; j < n; j++){
            s += arr[j];
            int temp = func(arr, n, j + 1, sum, k - 1, dp);
            if(temp != Integer.MAX_VALUE){
                int currMin = Math.min(temp, s);
                min = Math.max(min, currMin);
            }
        }
        
        return dp[i][k] = min;
        
    }
    
    public int maximizeSweetness(int[] arr, int k) {
        
        int n = arr.length;
        int[] sum = new int[n];
        int s = 0;
        k++;
        
        for(int i = 0; i < n; i++){
            s += arr[i];
            sum[i] = s;
        }
        
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= k; j++){
                dp[i][j] = -1;
            }
        }
        
        return func(arr, n, 0, sum, k, dp);
        
    }
}
