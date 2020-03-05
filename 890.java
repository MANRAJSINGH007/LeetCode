class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        outer : for(int i = 0 ; i < n; i++) {
            String curr = words[i];
            HashMap<Character, Character> map1 = new HashMap<>();
            HashMap<Character, Character> map2 = new HashMap<>();
            for(int j = 0; j < curr.length(); j++) {
                char c1 = curr.charAt(j), c2 = pattern.charAt(j);
                if(map1.containsKey(c1) && map1.get(c1) != c2) continue outer;
                if(map2.containsKey(c2) && map2.get(c2) != c1) continue outer;
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
            ans.add(curr);
        }
        return ans;
    }
}
