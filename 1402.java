class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        int ans = 0;
        Arrays.sort(satisfaction);
        for(int i = 0; i < n; i++) {
            int k = 1, curr = 0;
            for(int j = i; j < n; j++) curr += satisfaction[j] * (k++);
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
