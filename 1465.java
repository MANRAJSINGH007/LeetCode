class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long m1 = 0, m2 = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        m1 = (long)horizontalCuts[0];
        for(int i = 0; i < horizontalCuts.length - 1; i++) m1 = Math.max(m1, (long)horizontalCuts[i + 1] - (long)horizontalCuts[i]);
        m1 = Math.max(m1, (long)h - (long)horizontalCuts[horizontalCuts.length - 1]);
        m2 = (long)verticalCuts[0];
        for(int i = 0; i < verticalCuts.length - 1; i++) m2 = Math.max(m2, (long)verticalCuts[i + 1] - (long)verticalCuts[i]);
        m2 = Math.max(m2, (long)w - (long)verticalCuts[verticalCuts.length - 1]);
        long ans = ((m1 % mod) * (m2 % mod)) % mod;
        return (int)ans;
    }
}
