class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= (n/2) - 1; i++) {
            if(palindrome.charAt(i) - 'a' > 0) {
                sb.append('a');
                sb.append(palindrome.substring(i + 1, n));
                return sb.toString();
            } 
            sb.append('a');
        }
        for(int i = (n/2); i < n; i++) {
            if(i == n - 1) {
                sb.append('b');
                return sb.toString();
            }
            sb.append(palindrome.charAt(i));
        }
        return "";
    }
}
