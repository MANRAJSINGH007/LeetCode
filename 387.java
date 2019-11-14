class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        if(n == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
        }
        
        for(int i = 0; i < n; i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }
        
        return -1;
    }
}
