class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int start = 0, end = n - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return 2;
            start++;
            end--;
        }
        return 1;
    }
}
