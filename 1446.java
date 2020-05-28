class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int start = 0, end = 0, max = 0;
        while(end < n) {
            while(end < n && s.charAt(end) == s.charAt(start)) {
                max = Math.max(max, end - start + 1);
                end++;
            }
            if(end == n) return max;
            start = end;
        }
        return max;
    }
}
