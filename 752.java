class Pair {
    String s;
    int ans;
    Pair(String s, int ans) {
        this.s = s;
        this.ans = ans;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(int i = 0; i < deadends.length; i++) set.add(deadends[i]);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("0000", 0));
        visited.add("0000");
        while(q.size() > 0) {
            Pair p = q.remove();
            if(set.contains(p.s)) continue;
            for(int i = 0; i < 4; i++) {
                String temp1 = "", temp2 = "";
                for(int j = 0; j < 4; j++) {
                    if(j != i) {
                        temp1 += p.s.charAt(j);
                        temp2 += p.s.charAt(j);
                    } else {
                        char ch = p.s.charAt(j);
                        if(ch == '0') {
                            temp1 += '1';
                            temp2 += '9';
                        } else if(ch == '9') {
                            temp1 += '0';
                            temp2 += '8';
                        } else {
                            temp1 += (char)(49 + (ch - '0'));
                            temp2 += (char)(47 + (ch - '0'));
                        }
                    }
                }
                if(!visited.contains(temp1)) {
                    if(temp1.equals(target)) return p.ans + 1;
                    visited.add(temp1);
                    q.add(new Pair(temp1, p.ans + 1));
                }
                if(!visited.contains(temp2)) {
                    if(temp2.equals(target)) return p.ans + 1;
                    visited.add(temp2);
                    q.add(new Pair(temp2, p.ans + 1));
                }
            }
        }
        return -1;
    }
}
