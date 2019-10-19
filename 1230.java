class Solution {
    
    public static double func(double[] prob, int n, int i, int target, double[][] dp){
        
        if(target == -1) return (double)0;
        
        if(i == n){
            if(target == 0) return (double)1;
            return (double)0;
        }
        
        if(dp[i][target] != -1) return dp[i][target];
        
        double x1 = prob[i] * func(prob, n, i + 1, target - 1, dp);
        double x2 = (1 - prob[i]) * func(prob, n, i + 1, target, dp);
        
        return dp[i][target] = x1 + x2;
        
    }
    
    public double probabilityOfHeads(double[] prob, int target) {
        
        int n = prob.length;
        
        double[][] dp = new double[n][target + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = (double)(-1);
            }
        }
        
        return func(prob, n, 0, target, dp);
        
    }
}
