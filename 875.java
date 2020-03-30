class Solution {
    public static boolean check(int[] piles, int K, int H) {
        int n = piles.length;
        int hours = 0;
        for(int i = 0; i < n; i++) {
            hours += Math.ceil((1.0 * piles[i]) / (1.0 * K));
            if(hours > H) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int H) {
        int n = piles.length;
        int max = 0;
        for(int i = 0; i < n; i++) max = Math.max(max, piles[i]);
        int ans = max;
        int start = 0;
        int end = max;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(check(piles, mid, H)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
}
