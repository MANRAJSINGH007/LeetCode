class Solution {
    public static boolean check(int[] arr) {
        for(int i = 0; i < 26; i++) if(arr[i] != 0) return true;
        return false;
    }
    public String sortString(String s) {
        int n = s.length();
        int[] arr = new int[26];
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++) arr[s.charAt(i) - 'a']++;
        while(check(arr)) {
            for(int i = 0; i < 26; i++) {
                if(arr[i] > 0) {
                    arr[i]--;
                    res.append((char)(i + 97));
                } 
            }
            for(int i = 25; i > -1; i--) {
                if(arr[i] > 0) {
                    arr[i]--;
                    res.append((char)(i + 97));
                } 
            }
        }
        return res.toString();
    }
}
