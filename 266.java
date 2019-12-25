class Solution {
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        int[] arr = new int[256];
        for(int i = 0; i < n; i++) arr[s.charAt(i)]++;
        int odd = 0;
        for(int i = 0; i < 256; i++){
            if(arr[i] % 2 == 1) odd++;
            if(odd == 2) return false;
        }
        return true;
    }
}
