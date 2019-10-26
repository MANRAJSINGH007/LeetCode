class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        int n = pattern.length();
        int m = str.length();
        
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        
        int j = 0;
        
        for(int i = 0; i < n; i++){
            char curr = pattern.charAt(i);
            String temp = "";
            if(j >= m) return false;
            while(j < m && str.charAt(j) != ' ') temp += str.charAt(j++);
            if(map.containsKey(curr) && !map.get(curr).equals(temp)) return false;
            if(map2.containsKey(temp) && map2.get(temp) != curr) return false;
            map.put(curr, temp);
            map2.put(temp, curr);
            j++;
        }
        
        return j >= m;
    }
}
