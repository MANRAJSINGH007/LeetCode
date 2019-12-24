class Solution {
    public static boolean func(String s, String t, int i, int j, int flag){
        if(i == s.length() && j == t.length()) return flag == 1;
        if(i == s.length() || j == t.length()) return flag == 0;
        if(flag == 1) return s.charAt(i) != t.charAt(j) ? false : func(s, t, i + 1, j + 1, 1);
        if(s.charAt(i) == t.charAt(j)) return func(s, t, i + 1, j + 1, 0);
        return func(s, t, i + 1, j, 1) || func(s, t, i, j + 1, 1) || func(s, t, i + 1, j + 1, 1);
    } 
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;
        return func(s, t, 0, 0, 0);
    }
}
