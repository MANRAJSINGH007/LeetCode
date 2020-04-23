class Solution {
    public static int func(int x) {
        int bit = -1;
        while(x > 0) {
            x = x>>1;
            bit++;
        }
        return bit;
    }
    public int rangeBitwiseAnd(int m, int n) {
        int ans = 0;
        while(m > 0 && n > 0) {
            int b1 = func(m);
            int b2 = func(n);
            if(b1 != b2) return ans;
            int temp = (int)Math.pow(2, b1);
            ans += temp;
            m -= temp;
            n -= temp;
        }
        return ans;
    }
}
