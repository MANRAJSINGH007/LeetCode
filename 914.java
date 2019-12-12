class Solution {
    
    public static int gcd(int a, int b){
        if(b == 0) return a;
        if(a < b) return gcd(b, a);
        return gcd(b, a % b);
    }
    
    public boolean hasGroupsSizeX(int[] deck) {
        
        int n = deck.length;
        if(n <= 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            int c = 1;
            if(map.containsKey(deck[i])) c += map.get(deck[i]);
            map.put(deck[i], c);
        }
        
        Set<Integer> keys = map.keySet();
        for(Integer k : keys) min = Math.min(min, map.get(k));
        int ans = min;
        for(Integer k : keys) ans = gcd(map.get(k), ans);
        return ans != 1;
        
    }
}
