class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] sum = new int[n];
        int s = 0;
        for(int i = 0; i < n; i++) {
            s += cardPoints[i];
            sum[i] = s;
        }
        if(k == n) return s;
        int ans = s - sum[n - k - 1];
        ans = Math.max(ans, sum[k - 1]);
        for(int i = 1; i < k; i++) {
            int curr1 = sum[i - 1];
            int curr2 = sum[n - 1] - sum[n - (k - i) - 1];
            ans = Math.max(ans, curr1 + curr2);
        }
        return ans;
    }
}
