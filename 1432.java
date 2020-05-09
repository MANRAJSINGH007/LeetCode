class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        char[] ch = s.toCharArray();
        int min = 0, max = 0;
        if(s.charAt(0) == '1') {
            char c1 = '.';
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) != '1' && s.charAt(i) != '0') {
                    c1 = s.charAt(i);
                    break;
                }
            }
            if(c1 != '.') {
                for(int i = 1; i < s.length(); i++) if(ch[i] == c1) ch[i] = '0';
                min = Integer.parseInt(new String(ch));
            } else {
                min = num;
            }
        } else {
            char c1 = s.charAt(0);
            for(int i = 0; i < s.length(); i++) if(ch[i] == c1) ch[i] = '1';
            min = Integer.parseInt(new String(ch));
        }
        ch = s.toCharArray();
        if(s.charAt(0) == '9') {
            char c1 = '.';
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) != '9') {
                    c1 = s.charAt(i);
                    break;
                }
            }
            if(c1 == '.') max = num;
            else {
                for(int i = 1; i < s.length(); i++) if(ch[i] == c1) ch[i] = '9';
                max = Integer.parseInt(new String(ch));
            }
        } else {
            char c1 = s.charAt(0);
            for(int i = 0; i < s.length(); i++) if(ch[i] == c1) ch[i] = '9';
            max = Integer.parseInt(new String(ch));
        }
        return max - min;
    }
}
