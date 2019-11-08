class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        int n = dominoes.length;
        if(n == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int curr = dominoes[i][0] * 10 + dominoes[i][1];
            int other = dominoes[i][1] * 10 + dominoes[i][0];
            if(dominoes[i][0] != dominoes[i][1] && map.containsKey(other)) ans += map.get(other);
            int c = 0;
            if(map.containsKey(curr)) c = map.get(curr);
            ans += c;
            map.put(curr, ++ c);
        }
        
        return ans;
        
    }
}
