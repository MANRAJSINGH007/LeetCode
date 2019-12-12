class Solution {
    
    public static int findNumberOfSwaps(int[] A, int[] B, int i, int n, int swapped, int[][] dp){
        
        if(i == n) return 0;
        
        if(dp[i][swapped] != -1) return dp[i][swapped];
        
        if(i == 0){
            int p1 = findNumberOfSwaps(A, B, i + 1, n, 1, dp);
            if(p1 != Integer.MAX_VALUE) p1++;
            int p2 = findNumberOfSwaps(A, B, i + 1, n, 0, dp);
            return Math.min(p1, p2);
        }
        
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        
        if(swapped == 0){
            if(A[i] > A[i - 1] && B[i] > B[i - 1]) p1 = findNumberOfSwaps(A, B, i + 1, n, 0, dp);
            if(B[i] > A[i - 1] && A[i] > B[i - 1]){
                p2 = findNumberOfSwaps(A, B, i + 1, n, 1, dp);
                if(p2 != Integer.MAX_VALUE) p2++;
            }
        } else{
            if(A[i] > B[i - 1] && B[i] > A[i - 1]) p1 = findNumberOfSwaps(A, B, i + 1, n, 0, dp);
            if(B[i] > B[i - 1] && A[i] > A[i - 1]){
                p2 = findNumberOfSwaps(A, B, i + 1, n, 1, dp);
                if(p2 != Integer.MAX_VALUE) p2++;
            }
        }
        
        return dp[i][swapped] = Math.min(p1, p2);
        
    }
    
    public int minSwap(int[] A, int[] B) {
        
        int n = A.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) dp[i][0] = dp[i][1] = -1;
        
        return findNumberOfSwaps(A, B, 0, n, 0, dp);
        
    }
}
