class Solution {
    public int maxScore(String s) {
        int n = s.length(), max = -n - 1, zeroCount = 0, oneCount = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') zeroCount++;
            else oneCount++;
            if(i < n - 1) max = Math.max(zeroCount - oneCount, max);
        }
        return max + oneCount;
    }
}
