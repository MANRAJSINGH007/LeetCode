class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++) ans += (s.charAt(i) - 'A' + 1) * (int)Math.pow(26, n - i - 1);
        return ans;
    }
}
