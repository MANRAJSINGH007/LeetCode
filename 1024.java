class Solution {
    public static int func(int[][] clips, int n, int i, int end, int T, int[][] dp) {
        if(end >= T) return 0;
        if(i == n) return Integer.MAX_VALUE;
        if(dp[i][end] != -1) return dp[i][end];
        int p1 = func(clips, n, i + 1, end, T, dp);
        int p2 = Integer.MAX_VALUE;
        if(end < clips[i][1] && clips[i][0] <= end) {
            p2 = Math.min(p2, func(clips, n, i + 1, clips[i][1], T, dp));
            if(p2 != Integer.MAX_VALUE) p2 ++;
        }
        return dp[i][end] = Math.min(p1, p2);
    } 
    public int videoStitching(int[][] clips, int T) {
        int n = clips.length;
        Arrays.sort(clips, new Comparator<int[]>(){
            public int compare(int[] t1, int[] t2) {
                if(t1[0] != t2[0]) return t1[0] - t2[0];
                return t2[1] - t1[1];
            }
        });
        if(clips[0][0] != 0) return -1;
        int[][] dp = new int[n][T];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < T; j++) dp[i][j] = -1;
        }
        int ans = func(clips, n, 0, 0, T, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
