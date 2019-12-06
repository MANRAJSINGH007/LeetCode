class Pair{
    int start;
    int end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int maxRepOpt1(String s) {
        
        int n = s.length();
        if(n == 1) return 1;
        ArrayList<ArrayList<Pair>> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++) ans.add(new ArrayList<>());
        int max = 0;
        
        int st = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == s.charAt(i - 1)) continue;
            else{
                ans.get(s.charAt(i - 1) - 'a').add(new Pair(st, i - 1));
                st = i;
                max = Math.max(max, i - 1 - st + 1);
            }
        }
        
        ans.get(s.charAt(n - 1) - 'a').add(new Pair(st, n - 1));
        max = Math.max(max, n - 1 - st + 1);
        
        for(int i = 0; i < 26; i++){
            if(ans.get(i).size() <= 1) continue;
            ArrayList<Pair> p = ans.get(i);
            max = Math.max(p.get(0).end - p.get(0).start + 1 + 1, max);
            for(int j = 1; j < p.size(); j++){
                Pair p2 = p.get(j);
                Pair p1 = p.get(j - 1);
                if(p2.start == p1.end + 2) max = Math.max(max, p1.end - p1.start + 1 + p2.end - p2.start + 1);
                if(p2.start == p1.end + 2 && p.size() >= 3) max = Math.max(max, p1.end - p1.start + 1 + p2.end - p2.start + 1 + 1);
                max = Math.max(p2.end - p2.start + 1 + 1, max);
            }
        }
        
        return max;

    }
}
