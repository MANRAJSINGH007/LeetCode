class Solution {
    public int numSteps(String s) {
        int ans = 0;
        while(s.length() > 1) {
            ans++;
            if(s.charAt(s.length() - 1) == '0') s = s.substring(0, s.length() - 1);
            else {
                char[] ch = s.toCharArray();
                int curr = s.length() - 1;
                while(curr >= 0 && ch[curr] == '1') {
                    ch[curr--] = '0';
                }
                if(curr >= 0) {
                    ch[curr] = '1';
                    s = new String(ch);
                } else s = '1' + new String(ch);
            }
        }
        return ans;
    }
}
