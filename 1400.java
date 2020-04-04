class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(k > n) return false;
        if(k == n) return true;
        int[] arr = new int[26];
        for(int i = 0; i < n; i++) arr[s.charAt(i) - 'a']++;
        int singles = 0;
        for(int i = 0; i < 26; i++) {
            if(arr[i] % 2 != 0) singles++;
        }
        return singles <= k;
    }
}
