class Solution {
    public int numKLenSubstrNoRepeats(String S, int k) {
        
        int n = S.length();
        if(n < k) return 0;
        int[] last = new int[26];
        for(int i = 0; i < 26; i++) last[i] = -1;
        int start = 0, end = 0, count = 0;
        
        while(end < n){
            char curr = S.charAt(end);
            if(last[curr - 'a'] >= start) start = last[curr - 'a'] + 1;
            last[curr - 'a'] = end;
            if(end - start + 1 == k){
                count++;
                start++;
            }
            end++;
        }
        
        return count;
    }
}
