class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        int i1 = -1, i2 = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '6') {
                i1 = i;
                break;
            }
        }
        if(i1 == -1) return num;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ans *= 10;
            if(i == i1) ans += 9;
            else ans += (int)(s.charAt(i) - '0');
        }
        return ans;
    }
}
