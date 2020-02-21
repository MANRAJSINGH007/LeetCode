class Pair{
    String curr;
    int ans;
    Pair(String curr, int ans){
        this.curr = curr;
        this.ans = ans;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        if(n == 0) return 0;
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Pair(beginWord, 1));
        visited.add(beginWord);
        
        while(q.size() > 0){
            Pair p = q.remove();
            String str = p.curr;
            
            for(int j = 0; j < str.length(); j++){
                for(int c = 0; c < 26; c++){
                    String t = str.substring(0, j) + (char)(c + 97) + str.substring(j + 1, str.length());
                    if(visited.contains(t) || !set.contains(t)) continue;
                    visited.add(t);
                    q.add(new Pair(t, p.ans + 1));
                    if(t.equals(endWord)) return p.ans + 1;
                }
            }
        }
        
        return 0;
        
    }
}
