class Solution {
    static List<String> ans;
    public static void generate(char[] ch, int i, int j, HashMap<Character, Integer> arr){
        if(i > j){
            Set<Character> keys = arr.keySet();
            for(Character k : keys) if(arr.get(k) > 0) return;
            ans.add(new String(ch));
            return;
        }
        Set<Character> keys = arr.keySet();
        if(i == j){
            for(Character k : keys){
                if(arr.get(k) == 1){
                    ch[i] = (k);
                    arr.put(k, 0);
                    generate(ch, i + 1, j - 1, arr);
                    arr.put(k, 1);
                }
            }
            return;
        }
        for(Character k : keys){
            if(arr.get(k) >= 2){
                arr.put(k, arr.get(k) - 2);
                ch[i] = (k);
                ch[j] = (k);
                generate(ch, i + 1, j - 1, arr);
                arr.put(k, arr.get(k) + 2);
            }
        }
    }
    public List<String> generatePalindromes(String s) {
        int n = s.length();
        char[] ch = new char[n];
        ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int count = 1;
            if(map.containsKey(s.charAt(i))) count += map.get(s.charAt(i));
            map.put(s.charAt(i), count);
        }
        Set<Character> keys = map.keySet();
        int c = 0;
        for(Character k : keys) if(map.get(k) % 2 == 1) c++;
        if(c >= 2) return ans;
        generate(ch, 0, n - 1, map);
        return ans;
    }
}
