class Solution {
    
    public static int func(String[] words, int curr, HashMap<String, Integer> map,  HashMap<String, Integer> dp){
        
        String s = words[curr];
        if(dp.containsKey(s)) return dp.get(s);
        
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            String temp = s.substring(0, i) + s.substring(i + 1, s.length());
            if(map.containsKey(temp)) max = Math.max(max, func(words, map.get(temp), map, dp));
        }
        
        dp.put(s, max + 1);
        return max + 1;
        
    }
    
    public int longestStrChain(String[] words) {
        
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> dp = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(words[i], i);
        int max = 0;
        for(int i = 0; i < n; i++) max = Math.max(max, func(words, i, map, dp));
        return max;
    }
}
