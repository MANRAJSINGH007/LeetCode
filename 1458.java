class Solution {
    static boolean chosen;
    public static int func(int[] nums1, int[] nums2, int i, int j, int n, int m, int[][] dp) {
        if(i == n || j == m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = func(nums1, nums2, i + 1, j, n, m, dp);
        for(int k = j; k < m; k++) {
            int temp = nums1[i] * nums2[k] + func(nums1, nums2, i + 1, k + 1, n, m, dp);
            if(temp >= max) {
                chosen = true;
                max = temp;
            }
        }
        return dp[i][j] = max;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        chosen = false;
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = -1;
                max = Math.max(max, nums1[i] * nums2[j]);
            }
        }
        int ans = func(nums1, nums2, 0, 0, n, m, dp);
        return chosen ? ans : max;
    }
}
