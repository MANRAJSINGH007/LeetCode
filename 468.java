class Solution {
    public String validIPAddress(String s) {
        int n = s.length();
        if(n == 0) return "Neither";
        String temp = "";
        List<String> aux = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '.') {
                aux.add(temp);
                temp = "";
            }
            else temp += s.charAt(i);
        }
        if(temp.length() > 0) aux.add(temp);
        String[] a = new String[aux.size()];
        for(int i = 0; i < aux.size(); i++) a[i] = aux.get(i);
        String[] b = s.split(":");
        boolean flag = false;
        char[] l = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        HashSet<Character> se = new HashSet<>();
        for(int i = 0; i < l.length; i++) se.add(l[i]);
        outer : for(int i = 0; i < a.length; i++) {
            String curr = a[i];
            int num = 0;
            if(curr.length() > 3) {
                flag = true;
                break;
            }
            for(int j = 0; j < curr.length(); j++) {
                if(!se.contains(curr.charAt(j))) {
                    flag = true;
                    break outer;
                }
                num *= 10;
                num += curr.charAt(j) - '0';
            }
            if(num == 0 && curr.length() == 1) continue;
            if(curr.length() == 0 || num > 255 || 1 + Math.floor(Math.log10(num)) < curr.length()) {
                flag = true;
                break;
            }
        }
        if(s.charAt(0) != '.' && s.charAt(n - 1) != '.' && !flag && a.length == 4) return "IPv4";
        if(b.length != 8 || s.charAt(0) == ':' || s.charAt(n - 1) == ':') return "Neither";
        char[] list = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'};
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < list.length; i++) set.add(list[i]);
        for(int i = 0; i < b.length; i++) {
            String curr = b[i];
            if(curr.length() == 0 || curr.length() > 4) return "Neither";
            for(int j = 0; j < curr.length(); j++) {
                char c = curr.charAt(j);
                if(!set.contains(c)) return "Neither";
            }
        }
        return "IPv6";
    }
}
