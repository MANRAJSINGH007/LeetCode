class Solution {
    public static boolean check(String s, int n, int i, int opening, int closing, HashSet<Integer> set) {
        if(i == n) return opening == closing;
        if(closing > opening) return false;
        if(set.contains(i * 10 + closing)) return false;
        if(s.charAt(i) == '(') return check(s, n, i + 1, opening + 1, closing, set);
        if(s.charAt(i) == ')') return check(s, n, i + 1, opening, closing + 1, set);
        boolean b1 = check(s, n, i + 1, opening, closing, set);
        if(b1) return true;
        boolean b2 = check(s, n, i + 1, opening + 1, closing, set);
        if(b2) return true;
        boolean b3 = check(s, n, i + 1, opening, closing + 1, set);
        if(b3) return true;
        set.add(i * 10 + closing);
        return false;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        HashSet<Integer> set = new HashSet<>();
        return check(s, n, 0, 0, 0, new HashSet<>());
    }
}
