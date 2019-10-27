class Solution {
    
    public static int func(List<String> arr, int n, int i, String str, HashMap<String, Integer> map){
        
        if(i == n) return 0;
        
        if(map.containsKey(str)) return map.get(str);
        
        int[] ch = new int[26];
        
        for(int j = 0; j < str.length(); j++){
            if(str.charAt(j) == '1') ch[j] = 1;
        }
        
        int flag = 0;
        int x1 = func(arr, n, i + 1, str, map);
        int x2 = 0;
        String curr = arr.get(i);
        
        for(int j = 0; j < curr.length(); j++){
            char c = curr.charAt(j);
            if(ch[(int)c - 97] == 1){
                flag = 1;
                break;
            }
            
            ch[(int)c - 97] = 1;
        }
        
        if(flag == 0){
            
            String t = "";
            
            for(int j = 0; j < 26; j++){
                if(ch[j] == 1) t += '1';
                else t += '0';
            }
            
            x2 = curr.length() + func(arr, n, i + 1, t, map);
        }
        
        int ans = Math.max(x1, x2);
        map.put(str, ans);
        return ans;
        
    }
    
    public int maxLength(List<String> arr) {
        
        int n = arr.size();
        return func(arr, n, 0, "", new HashMap<String, Integer>());
    }
}
