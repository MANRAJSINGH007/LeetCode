class Solution {
    
    static int size = 0;
    
    public static int func(int[] arr, int n, int i, int flag, int[][] dp){
        
        if(i == n){
            return 0;
        }
        
        if(dp[i][flag] != Integer.MIN_VALUE){
            return dp[i][flag];
        }
        
        if(flag == 0){
            int s1 = func(arr, n, i + 1, 1, dp);
            int s2 = func(arr, n, i + 1, 0, dp) + arr[i];
            
            if(s2 >= s1){
                size = 1;
            }
            
            return dp[i][flag] = Math.max(s1, s2);
        }
        
        else{
            int x = func(arr, n, i + 1, 1, dp) + arr[i];
            if(x >= 0){
                size = 1;
            }
            return dp[i][flag] = Math.max(0, x);
        }
        
    }
    
    public static int[] preprocess(int[] arr, int n){
        
        int[] sum = new int[n];
        
        sum[n - 1] = arr[n - 1];
        
        for(int i = n - 2; i >= 0; i--){
            sum[i] = Math.max(sum[i + 1] + arr[i], arr[i]);
        }
        
        return sum;
        
        
    }
    
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        
        size = 0;
        
        // int[] sum = preprocess(arr, n);
        
        int[][] dp = new int[n][2];
        
        for(int i = 0; i < n; i++){
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = Integer.MIN_VALUE;
        }
        
        int max = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, func(arr, n, i, 0, dp));
            maxElement = Math.max(maxElement, arr[i]);
        }
        
        if(size == 0){
            max = maxElement;
        }
        
        return max;
    }
}
