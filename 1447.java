class Solution {
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static void func(int den, int n, List<String> list) {
        if(den == n + 1) return;
        for(int i = 1; i <= den - 1; i++) {
            if(gcd(i, den) == 1) list.add("" + Integer.toString(i) + "/" + Integer.toString(den));
        }
        func(den + 1, n, list);
        return;
    }
    public List<String> simplifiedFractions(int n) {
        if(n == 1) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        func(2, n, list);
        return list;
    }
}
