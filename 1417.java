class Solution {
    public String reformat(String s) {
        int n = s.length();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i = 0; i < n; i++) {
            if((int)s.charAt(i) >= 97) s1.push(s.charAt(i));
            else s2.push(s.charAt(i));
        }
        if(s1.size() > s2.size() + 1 || s2.size() > s1.size() + 1) return "";
        String ans = "";
        if(s1.size() > s2.size()) {
            ans += s1.pop();
            while(s1.size() > 0 && s2.size() > 0) {
                ans += s2.pop();
                ans += s1.pop();
            }
            if(s1.size() > 0) ans += s1.pop();
        } else if(s1.size() == s2.size()) {
            while(s1.size() > 0 && s2.size() > 0) {
                ans += s2.pop();
                ans += s1.pop();
            }
        }
        else {
            ans += s2.pop();
                while(s1.size() > 0 && s2.size() > 0) {
                ans += s1.pop();
                ans += s2.pop();
            }
            if(s2.size() > 0) ans += s2.pop();
        }
        return ans;
    }
}
